package ensemble.samples.layout.stackpane;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * A simple example of a StackPane layout.
 *
 * @sampleName StackPane
 * @preview preview.png
 * @docUrl http://docs.oracle.com/javase/8/javafx/layout-tutorial/index.html JavaFX Layouts
 * @embedded
 * @related /Layout/AnchorPane
 * @related /Layout/BorderPane
 * @related /Layout/FlowPane
 * @related /Layout/GridPane
 * @related /Layout/HBox
 * @related /Layout/TilePane
 * @related /Layout/VBox
 * @see javafx.scene.layout.StackPane
 * @see javafx.scene.shape.Ellipse
 * @see javafx.scene.shape.Rectangle
 */
public class StackPaneApp extends Application {

    public Parent createContent() {
        StackPane stackPane = new StackPane();
        Rectangle rectangle = new Rectangle(80, 100, Color.MIDNIGHTBLUE);
        rectangle.setStroke(Color.BLACK);
        Ellipse ellipse = new Ellipse(88, 45, 30, 45);
        ellipse.setFill(Color.MEDIUMBLUE);
        ellipse.setStroke(Color.LIGHTGREY);
        Text text = new Text("3");
        text.setFont(Font.font(null, 38));
        text.setFill(Color.WHITE);
        stackPane.getChildren().addAll(rectangle, ellipse, text);
        return stackPane;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }

    /**
     * Java main for when running without JavaFX launcher
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
