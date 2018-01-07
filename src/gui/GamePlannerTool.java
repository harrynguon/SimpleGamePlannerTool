package gui;

import node.Node;
import util.Constants;
import visuals.DrawPanel;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Controls the whole application
 */
public class GamePlannerTool extends JFrame {

    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;

    private SideToolBar sideToolBar;
    private DrawPanel drawPanel;

    private List<Node> nodes;
    private int nodeSeparationX = 50;
    private int nodeSeparationY = 100;
    private final int nodeHeight = 35;
    private int defaultParentY = 50;
    private final int defaultSeparationX = 35;

    private Optional<Node> nodeSelected = Optional.empty();

    public GamePlannerTool(String title) throws HeadlessException {
        super(title);
        nodes = new ArrayList<>();
    }

    /**
     * Sets initial parameters
     * @return self for method chaining
     */
    public GamePlannerTool initialise() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        SideToolBar sideToolBar = new SideToolBar(this).initialise();
        DrawPanel drawPanel = new DrawPanel(this).initialise();
        this.sideToolBar = sideToolBar;
        this.drawPanel = drawPanel;
        add(sideToolBar, BorderLayout.EAST);
        add(drawPanel, BorderLayout.CENTER);
        pack();
        setVisible(true);
        return this;
    }

    /**
     * @param label @NonNull
     */
    public void addNode(String label) {
        int labelTextWidth = this.getGraphics().getFontMetrics().stringWidth(label);
        // add child node
        if (nodeSelected.isPresent()) {
            Node parentNode = nodeSelected.get();
            Node childNode = new Node(parentNode.getX(), parentNode.getY() + Constants.NODE_Y,
                    label);
            childNode.setWidth(labelTextWidth + Constants.NODE_BOX_MARGIN * 2);
            parentNode.addChild(childNode);
            nodes.add(childNode);
            nodeSelected = Optional.empty();
        }
        // else add parent node
        else {
            Node node = new Node(nodeSeparationX, defaultParentY, label);
            node.setWidth(labelTextWidth + Constants.NODE_BOX_MARGIN * 2);
            nodes.add(node);
            addNodeSeparationX(labelTextWidth);
        }
        drawPanel.repaint();
    }

    public void selectNode(int x, int y) {
        for (Node n : nodes) {
            if (n.contains(x, y)) {
                nodeSelected = Optional.of(n);
                drawPanel.repaint();
                return;
            }
        }
        nodeSelected = Optional.empty();
        drawPanel.repaint();
        return;
    }

    public void addNodeSeparationX(int labelWidth) {
        nodeSeparationX += labelWidth + defaultSeparationX;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public Optional<Node> getNodeSelected() {
        return nodeSelected;
    }
}
