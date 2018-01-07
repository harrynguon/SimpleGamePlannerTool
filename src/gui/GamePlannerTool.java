package gui;

import node.Node;
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
    private int nodeSeparationX = 100;
    private int nodeSeparationY = 100;
    private int defaultParentY = 50;

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
    public void addParentNode(String label) {
        nodes.add(new Node(nodeSeparationX, defaultParentY, label));
        nodeSeparationX += 100;
        drawPanel.repaint();
    }

    /**
     * Adds node to parent
     * @param parent
     * @param label
     */
    public void addChildNode(String parent, String label) {
        Optional<Node> rNode =  nodes.stream()
                .filter(node -> node.getName().equals(parent))
                .distinct()
                .findFirst();
        if (rNode.isPresent()) {
            Node parentNode = rNode.get();
            parentNode.addChild(parentNode.getX(), parentNode.getY() + 50, label);
        }
        drawPanel.repaint();
    }


    public List<Node> getNodes() {
        return nodes;
    }
}
