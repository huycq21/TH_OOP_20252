package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton radioPen;

    @FXML
    private RadioButton radioEraser;

    @FXML
    private ToggleGroup toolsToggleGroup;

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Color inkColor = Color.BLACK;
        double radius = 4.0;

        if (radioEraser.isSelected()) {
            inkColor = Color.WHITE;
            radius = 12.0;
        }

        Circle newCircle = new Circle(event.getX(), event.getY(), radius, inkColor);

        drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }
}