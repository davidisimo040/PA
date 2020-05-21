package app;

import com.company.GlobalLocales;
import java.util.Scanner;
import java.util.Locale;

public class LocaleExplore {

    public static void main(String[] args) {

        GlobalLocales globalLocales = new GlobalLocales();

        Locale enLocale = new Locale("en","US");
        Locale roLocale = new Locale("ro","RO");
        Locale deLocale = new Locale("de","DE");
        Locale itLocale = new Locale("it","IT");
        globalLocales.addLocale(enLocale);
        globalLocales.addLocale(roLocale);
        globalLocales.addLocale(deLocale);
        globalLocales.addLocale(itLocale);

        System.out.println("Aplicatia Locales_LAB13 a pornit:");
        Scanner keyboard=new Scanner(System.in);
        while(true)
        {
        String command=keyboard.nextLine();
        if (command.equals("exit")) return;
        globalLocales.prompt(command);
        }

    }
}
