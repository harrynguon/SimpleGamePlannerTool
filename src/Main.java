import gui.GamePlannerTool;
import util.Constants;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new GamePlannerTool(Constants.TITLE).initialise());
    }

}
