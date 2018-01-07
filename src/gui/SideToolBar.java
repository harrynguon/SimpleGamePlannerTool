package gui;

import node.Node;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

public class SideToolBar extends JToolBar {

    private GamePlannerTool instance;

    public SideToolBar(GamePlannerTool gamePlannerTool) {
        super("Side Tool Bar", JToolBar.VERTICAL);
        this.instance = gamePlannerTool;
    }

    public SideToolBar initialise() {
        setFloatable(false);
        setRollover(true);
        setLayout(new GridLayout(16, 1));
        setOrientation(JToolBar.HORIZONTAL);
        JButton addNodeBtn = new JButton("Add Node");
        addNodeBtn.addActionListener(this::addParentNode);
        JButton deleteNodeBtn = new JButton("Delete Node");
        deleteNodeBtn.addActionListener(this::deleteNode);
        JButton infoBtn = new JButton("Info");
        infoBtn.addActionListener(this::info);
        add(addNodeBtn, BorderLayout.CENTER);
        add(deleteNodeBtn, BorderLayout.CENTER);
        add(infoBtn, BorderLayout.CENTER);
        return this;
    }

    private void addParentNode(ActionEvent e) {
        String label = (String) JOptionPane.showInputDialog(
                instance,
                "What is the name of the node you want to create?",
                "Enter name (min 3 characters)",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                "enter name here");
        if (label != null && label.length() >= 3) {
            instance.addNode(label);
        }
    }

    private void deleteNode(ActionEvent e) {
        if (instance.getNodeSelected().isPresent()) {
            Node toRemove = instance.getNodeSelected().get();
            toRemove.setActive(false);
            instance.getNodes().remove(toRemove);
            instance.update();
        }
    }

    private void info(ActionEvent e) {
        JOptionPane.showMessageDialog(instance,
                "Click on Add Node with nothing selected to add a new parent node.\n" +
                "Select on an existing node and click on the Add " +
                "Node button to add a child to a parent node.\nTo " +
                "delete a node, click on the desired node and click the Delete Node button.\n\n " +
                "Made by Harry Nguon",
                "Information",
                1);
    }

}
