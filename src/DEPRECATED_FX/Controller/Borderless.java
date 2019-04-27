/**package FX.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.Launch;

abstract class Borderless {
    @FXML
    private AnchorPane parent;
    @FXML
    private Button closeButton;

    private double xOffSet = 0;
    private double yOffSet = 0;

    void makeStageDragable() {
        parent.setOnMousePressed((event) -> {
            xOffSet = event.getSceneX();
            yOffSet = event.getSceneY();
        });
        parent.setOnMouseDragged((event) -> {
            Launch.stage.setX(event.getScreenX() - xOffSet);
            Launch.stage.setY(event.getScreenY() - yOffSet);
            Launch.stage.setOpacity(0.8f);
        });
        parent.setOnDragDone((event) -> Launch.stage.setOpacity(1.0f));
        parent.setOnMouseReleased((event) -> Launch.stage.setOpacity(1.0f));
    }

    @FXML
    private void closeButtonAction() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
*/