package visuals;

import gui.GamePlannerTool;

import javax.swing.*;
import java.awt.*;

/**
 * Nodes/etc will be drawn inside this
 */
public class DrawPanel extends JPanel {

    public static final int WIDTH = 3000;
    public static final int HEIGHT = GamePlannerTool.HEIGHT; // 720


    public DrawPanel initialise() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        JScrollBar scrollBar = new JScrollBar();
        int y = 700;
        scrollBar.setOrientation(JScrollBar.HORIZONTAL);
        add(scrollBar, BorderLayout.SOUTH);
        return this;
    }

}
