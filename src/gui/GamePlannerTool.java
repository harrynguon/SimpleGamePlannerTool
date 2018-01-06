package gui;

import visuals.DrawPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Controls the whole application
 */
public class GamePlannerTool extends JFrame {

    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;

    public GamePlannerTool(String title) throws HeadlessException {
        super(title);

    }

    /**
     * Sets initial parameters
     * @return self for method chaining
     */
    public GamePlannerTool initialise() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(new DrawPanel().initialise(), BorderLayout.CENTER);
        add(new SideToolBar().initialise(), BorderLayout.EAST);
        pack();
        setVisible(true);
        return this;
    }
}
