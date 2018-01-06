package gui;

import javax.swing.JButton;
import javax.swing.JToolBar;

public class SideToolBar extends JToolBar {

    public SideToolBar initialise() {
        JButton addNodeBtn = new JButton("Add Node");
        add(addNodeBtn);
        return this;
    }

}
