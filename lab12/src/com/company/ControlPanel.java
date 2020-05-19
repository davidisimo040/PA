package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ControlPanel extends JPanel{
    MainFrame mainFrame;
    DesignPanel designPanel;
    JButton button = new JButton("Add Button");
    JTextField textField = new JTextField();
    JTextField component = new JTextField();

    public ControlPanel(MainFrame mainFrame, DesignPanel designPanel) {
        this.mainFrame=mainFrame;
        this.designPanel=designPanel;
        init();
    }

    private void init() {
        button.setBounds(0,0,80,40);
        textField.setBounds(100,20,80,40);
        textField.setPreferredSize(new Dimension(80,40));
        component.setBounds(210,20,80,40);
        component.setPreferredSize(new Dimension(80,40));
        button.addActionListener(this::action);

        this.add(button);
        this.add(component);
        this.add(textField);


        //this.add(button);
       // this.add(textField);

    }

    private void action(ActionEvent actionEvent) {
        designPanel.add(create());
        designPanel.revalidate();
        designPanel.updateUI();
    }

    private JComponent create() {

        String componenta = "javax.swing."+component.getText();
        try {
            Class clasa = Class.forName(componenta);
            JComponent jComponent = (JComponent) clasa.getConstructor().newInstance();
            setComponentText(clasa,jComponent);
            return jComponent;

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

    private void setComponentText(Class clasa, JComponent jComponent) {
        String text = textField.getText();
        try{
            Method method = clasa.getMethod("setText", String.class);
            method.invoke(jComponent,text);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


}
