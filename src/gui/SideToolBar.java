package gui;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import java.awt.event.ActionEvent;

public class SideToolBar extends JToolBar {

    private GamePlannerTool instance;

    public SideToolBar(GamePlannerTool gamePlannerTool) {
        this.instance = gamePlannerTool;
    }

    public SideToolBar initialise() {
        JButton addNodeBtn = new JButton("Add Node");
        addNodeBtn.addActionListener(this::addParentNode);
        add(addNodeBtn);
        return this;
    }

    private void addParentNode(ActionEvent e) {
        String label = (String) JOptionPane.showInputDialog(
                instance,
                "What is the name of the node you want to create?",
                "Enter name",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                "enter name here");
        if (label != null && label.length() > 0) {
            instance.addParentNode(label);
        }
    }
}
