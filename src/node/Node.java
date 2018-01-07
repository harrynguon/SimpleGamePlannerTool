package node;

import java.util.ArrayList;
import java.util.List;

/**
 * Diagram Node Class
 */
public class Node {

    private int x;
    private int y;
    private String label;
    private List<Node> children;

    public Node(int x, int y, String label) {
        this.x = x;
        this.y = y;
        this.label = label;
        this.children = new ArrayList<>();
    }

    /**
     * Null Object Pattern
     */
    public Node() {
    }

    public void addChild(int x, int y, String label) {
        children.add(new Node(x, y, label));
    }

    public List<Node> getChildren() {
        return children;
    }

    public String getName() {
        return label;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
