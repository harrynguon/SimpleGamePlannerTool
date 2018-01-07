package visuals;

import gui.GamePlannerTool;
import node.Node;
import util.Constants;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Optional;


/**
 * Nodes/etc will be drawn here
 */
public class DrawPanel extends JPanel {

    private GamePlannerTool instance;

    public DrawPanel(GamePlannerTool gamePlannerTool) {
        this.instance = gamePlannerTool;
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                instance.selectNode(e.getX(), e.getY());
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });
    }

    public DrawPanel initialise() {
        setPreferredSize(new Dimension(Constants.PANEL_WIDTH, Constants.PANEL_HEIGHT));
        JScrollBar scrollBar = new JScrollBar();
        scrollBar.setOrientation(JScrollBar.HORIZONTAL);
        add(scrollBar, BorderLayout.SOUTH);
        return this;
    }

    @Override
    public void paintComponent(Graphics _g) {
        super.paintComponent(_g);
        Graphics2D g = (Graphics2D) _g;
        iterateThroughChildren(g, instance.getNodes());
        Optional<Node> nodeSelected = instance.getNodeSelected();
        if (nodeSelected.isPresent()) {
            g.setColor(Color.RED);
            Node node = nodeSelected.get();
            draw(g, node.getX(), node.getY(), node.getWidth(), node.getName());
        }
    }

    private void iterateThroughChildren(Graphics2D g, List<Node> children) {
        for (Node node : children) {
            this.draw(g, node.getX(), node.getY(), node.getWidth(), node.getName());
            if (node.getParent().isPresent() && node.getParent().get().isActive()) {
                drawArrow(g, node.getParent().get(), node);
            }
        }
    }

    private void draw(Graphics2D g, int x, int y, int width, String label) {
        g.drawRect(x, y, width, Constants.NODE_HEIGHT);
        g.drawString(label, x + Constants.NODE_BOX_MARGIN, y + Constants.NODE_TEXT_Y_OFFSET);
    }

    private void drawArrow(Graphics g, Node parent, Node child) {
        int x1 = parent.getX() + parent.getWidth() / 2;
        int y1 = parent.getY() + parent.getHeight();
        int x2 = child.getX() + child.getWidth() / 2;
        int y2 = child.getY();
        g.drawLine(x1, y1, x2, y2);
    }

}
