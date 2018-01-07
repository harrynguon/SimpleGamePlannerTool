import gui.GamePlannerTool;
import visuals.DrawPanel;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new GamePlannerTool("Game Planner Tool v0.1 alpha").initialise());
    }

}
