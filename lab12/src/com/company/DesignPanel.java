package com.company;

import javax.swing.*;
import java.awt.*;

public class DesignPanel extends JPanel {

    MainFrame mainFrame;
    public DesignPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.setLayout(new FlowLayout());
        init();
    }
    private void init(){
        setPreferredSize(new Dimension(1000,600));
    }

    @Override
    public void update(Graphics g) { }

}
