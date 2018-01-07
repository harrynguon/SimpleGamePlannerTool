package visuals;

import gui.GamePlannerTool;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;


/**
 * Nodes/etc will be drawn inside this
 */
public class DrawPanel extends JPanel {

    public static final int PANEL_WIDTH = 3000;
    public static final int PANEL_HEIGHT = GamePlannerTool.HEIGHT; // 720

    private GamePlannerTool instance;

    public DrawPanel(GamePlannerTool gamePlannerTool) {
        this.instance = gamePlannerTool;
    }

    public DrawPanel initialise() {
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        JScrollBar scrollBar = new JScrollBar();
        scrollBar.setOrientation(JScrollBar.HORIZONTAL);
        add(scrollBar, BorderLayout.SOUTH);
        return this;
    }

    @Override
    public void paintComponent(Graphics _g) {
        Graphics2D g = (Graphics2D) _g;
        instance.getNodes().stream()
                .forEach(node -> {
                   this.draw(g, node.getX(), node.getY(), node.getName());
                   node.getChildren().stream()
                           .forEach(childNode -> this.draw(g, childNode.getX(), childNode.getY(),
                                    childNode.getName()));
                });
    }

    private void draw(Graphics2D g, int x, int y, String label) {
        g.drawRect(x, y, 50, 50);
        g.drawString(label, x, y);
    }

}
