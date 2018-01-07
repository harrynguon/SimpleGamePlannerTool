package node;

import util.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Diagram Node Class
 */
public class Node {

    private int x;
    private int y;
    private int width;
    private int height = Constants.NODE_HEIGHT;
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

    public boolean contains(int x, int y) {
        if (x >= this.x && x <= this.x + this.width && y >= this.y && y <= this.y + this.height) {
            return true;
        }
        return false;
    }

    public void addChild(Node node) {
        children.add(node);
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public List<Node> getChildren() {
        return children;
    }

    public String getName() {
        return label;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
