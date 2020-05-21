package com.company;

import sun.util.locale.LocaleUtils;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

public class GlobalLocales {
    static List<Locale> locales = new ArrayList<>();
    static Locale currentLocale=null;
    static ResourceBundle messages;
    Locale roLocale = new Locale("ro","RO");
    Locale enLocale = new Locale("en","US");
    Locale elseLocale = roLocale;
    static Currency currentCurrency;
    public GlobalLocales()
    {

    }

    public static void addLocale(Locale aLocale) {
        locales.add(aLocale);
        currentLocale = aLocale;
        currentCurrency = Currency.getInstance(currentLocale);
        messages = ResourceBundle.getBundle("res.Messages",currentLocale);
    }



    public void DisplayLocales(){
        System.out.println(messages.getString("locales"));
        for( Locale local: locales)
        {
            messages = ResourceBundle.getBundle("res.Messages",local);
            System.out.println("Locale: "+local);
        }
    }
    public void Info()
    {

        //System.out.println(messages.getString("info")+ currentLocale + ":");
        String patternn = messages.getString("info");
        Object[] arguments = {currentLocale};
        String welcome = new MessageFormat(patternn).format(arguments);
        System.out.println(welcome);
        if(currentLocale.equals(enLocale)) elseLocale = roLocale;
        else elseLocale=enLocale;

        System.out.println("Language: "+currentLocale.getDisplayLanguage(currentLocale) + " ( "+ currentLocale.getDisplayLanguage(elseLocale)+" )");
        System.out.println("Country: "+currentLocale.getDisplayCountry(currentLocale) + " ( "+ currentLocale.getDisplayCountry(elseLocale)+" )");
        currentCurrency = Currency.getInstance(currentLocale);
        System.out.println("Currency: "+currentCurrency.getDisplayName(currentLocale) + " ( "+ currentCurrency.getDisplayName(elseLocale)+" )");

        DateFormatSymbols dfs1 = new DateFormatSymbols(currentLocale);

        DateFormatSymbols dfs2 = new DateFormatSymbols(elseLocale);
        String weekdays1[] = dfs1.getWeekdays() , weekdays2[] = dfs2.getWeekdays();
        String months1[] = dfs1.getMonths() , months2[] = dfs2.getMonths();
        System.out.println("Week days: ");
        for(int i=2;i<8;i++) System.out.println(weekdays1[i]+" ( "+ weekdays2[i]+" ) ");
        System.out.println(weekdays1[1]+" ( "+ weekdays2[1]+" )  ");

        System.out.println("Months: ");
        for(int i=0;i<12;i++) System.out.println(months1[i]+" ( "+ months2[i]+" ) ");


        //LocalDateTime today = LocalDateTime.now();
        //DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(currentLocale);
        //System.out.println("Date: " + today.format(formatter));
        DateFormat df1 = DateFormat.getDateInstance(DateFormat.SHORT, currentLocale);
        DateFormat df2 = DateFormat.getDateInstance(DateFormat.SHORT, elseLocale);

        String pattern = "EEEEE dd MMMMM yyyy HH:mm:ss";
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(pattern,currentLocale);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(pattern,elseLocale);
        String date1 = simpleDateFormat1.format(new Date());
        String date2 = simpleDateFormat2.format(new Date());
        System.out.println("Today: "+date1 + " ( "+ date2+" )");

    }
    public void Info(Locale locale)
    {
        String patternn = messages.getString("info");
        Object[] arguments = {locale};
        String welcome = new MessageFormat(patternn).format(arguments);
        System.out.println(welcome);
        if(locale.equals(enLocale)) elseLocale = roLocale;
        else elseLocale=enLocale;

        System.out.println("Language: "+locale.getDisplayLanguage(locale) + " ( "+ locale.getDisplayLanguage(elseLocale)+" )");
        System.out.println("Country: "+locale.getDisplayCountry(locale) + " ( "+ locale.getDisplayCountry(elseLocale)+" )");
        currentCurrency = Currency.getInstance(locale);
        System.out.println("Currency: "+currentCurrency.getDisplayName(locale) + " ( "+ currentCurrency.getDisplayName(elseLocale)+" )");

        DateFormatSymbols dfs1 = new DateFormatSymbols(locale);

        DateFormatSymbols dfs2 = new DateFormatSymbols(elseLocale);
        String weekdays1[] = dfs1.getWeekdays() , weekdays2[] = dfs2.getWeekdays();
        String months1[] = dfs1.getMonths() , months2[] = dfs2.getMonths();
        System.out.println("Week days: ");
        for(int i=2;i<8;i++) System.out.println(weekdays1[i]+" ( "+ weekdays2[i]+" ) ");
        System.out.println(weekdays1[1]+" ( "+ weekdays2[1]+" )  ");

        System.out.println("Months: ");
        for(int i=0;i<12;i++) System.out.println(months1[i]+" ( "+ months2[i]+" ) ");


        //LocalDateTime today = LocalDateTime.now();
        //DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(currentLocale);
        //System.out.println("Date: " + today.format(formatter));
        DateFormat df1 = DateFormat.getDateInstance(DateFormat.SHORT, locale);
        DateFormat df2 = DateFormat.getDateInstance(DateFormat.SHORT, elseLocale);

        String pattern = "EEEEE dd MMMMM yyyy HH:mm:ss";
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(pattern,locale);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(pattern,elseLocale);
        String date1 = simpleDateFormat1.format(new Date());
        String date2 = simpleDateFormat2.format(new Date());
        System.out.println("Today: "+date1 + " ( "+ date2+" )");


    }


    public void setLocale(Locale aLocale) {


        currentLocale = aLocale;
        messages = ResourceBundle.getBundle("res.Messages",currentLocale);
        String patternn = messages.getString("locale.set");
        Object[] arguments = {currentLocale};
        String welcome = new MessageFormat(patternn).format(arguments);
        System.out.println(welcome);

    }

    public static Locale toLocale(String str) {
        if (str == null) {
            return null;
        }
        int len = str.length();
        if (len != 2 && len != 5 && len < 7) {
            throw new IllegalArgumentException("Invalid locale format: " + str);
        }
        char ch0 = str.charAt(0);
        char ch1 = str.charAt(1);
        if (ch0 < 'a' || ch0 > 'z' || ch1 < 'a' || ch1 > 'z') {
            throw new IllegalArgumentException("Invalid locale format: " + str);
        }
        if (len == 2) {
            return new Locale(str, "");
        } else {
            if (str.charAt(2) != '_') {
                throw new IllegalArgumentException("Invalid locale format: " + str);
            }
            char ch3 = str.charAt(3);
            if (ch3 == '_') {
                return new Locale(str.substring(0, 2), "", str.substring(4));
            }
            char ch4 = str.charAt(4);
            if (ch3 < 'A' || ch3 > 'Z' || ch4 < 'A' || ch4 > 'Z') {
                throw new IllegalArgumentException("Invalid locale format: " + str);
            }
            if (len == 5) {
                return new Locale(str.substring(0, 2), str.substring(3, 5));
            } else {
                if (str.charAt(5) != '_') {
                    throw new IllegalArgumentException("Invalid locale format: " + str);
                }
                return new Locale(str.substring(0, 2), str.substring(3, 5), str.substring(6));
            }
        }
    }
    public void prompt(String command)
    {

        String patternn = messages.getString("prompt");
        Object[] arguments = {currentLocale};
        String welcome = new MessageFormat(patternn).format(arguments);
        System.out.println(welcome+ command);
        String delims = "[ ]+";
        String[] tokens = command.split(delims);

        patternn=messages.getString("invalid");
        String bye = new MessageFormat(patternn).format(arguments);

        if(tokens.length>2) System.out.println(bye);
        else if(tokens.length==1 && command.equals("DisplayLocales")) this.DisplayLocales();
        else if(tokens.length==1 &&  command.equals("Info")) this.Info();
        else if(tokens[0].equals("Info")) this.Info(this.toLocale(tokens[1]));
        else if(tokens[0].equals("locale.set")) this.setLocale(this.toLocale(tokens[1]));
        else if(tokens[0].equals("add")) {this.addLocale(this.toLocale(tokens[1]));System.out.println("Locale "+tokens[1]+" added!");}
        else System.out.println(bye);

    }
}
