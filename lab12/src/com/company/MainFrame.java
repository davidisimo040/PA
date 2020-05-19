package com.company;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    ControlPanel controlPanel;
    DesignPanel designPanel;

    public MainFrame()
    {
        super("Drawing...");
        init();
    }

    private void init() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        designPanel = new DesignPanel(this);
        controlPanel = new ControlPanel(this,this.designPanel);
        this.add(designPanel, BorderLayout.NORTH);
        this.add(controlPanel,BorderLayout.CENTER);
        pack();
    }


    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
    }
}
