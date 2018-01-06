package gui;

import javax.swing.*;

public class SideToolBar extends JToolBar {

    public SideToolBar initialise() {
        JButton addNodeBtn = new JButton("Add Node");
        add(addNodeBtn);
        return this;
    }

}
