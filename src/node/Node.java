package node;

import util.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Diagram Node Class
 */
public class Node {

    private int x;
    private int y;
    private int width;
    private int height;
    private int hierarchyLvl;
    private String label;
    private List<Node> children;
    private boolean active;
    private Optional<Node> parent;

    public Node(int x, int y, int hierarchyLvl, String label, Optional<Node> parent) {
        this.x = x;
        this.y = y;
        this.height = Constants.NODE_HEIGHT;
        this.hierarchyLvl = hierarchyLvl;
        this.label = label;
        this.children = new ArrayList<>();
        this.active = true;
        this.parent = parent;
    }

    public boolean contains(int x, int y) {
        if (x >= this.x
                && x <= this.x + this.width
                && y >= this.y
                && y <= this.y + this.height) {
            return true;
        }
        return false;
    }

    public void addChild(Node node) {
        if (children.size() > 0) {
            for (Node n : children) {
                n.setX(n.getX() - Constants.NODE_CHILD_SPACING_N);
            }
        }
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

    public int getHierarchyLvl() {
        return hierarchyLvl;
    }

    public Optional<Node> getParent() {
        return parent;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setX(int x) {
        this.x = x;
    }
}
