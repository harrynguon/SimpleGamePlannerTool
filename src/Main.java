import gui.GamePlannerTool;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new GamePlannerTool("Game Planner Tool v0.1 alpha").initialise());
    }

}
