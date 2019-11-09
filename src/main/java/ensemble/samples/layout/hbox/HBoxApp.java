package ensemble.samples.layout.hbox;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * A simple example of an HBox layout.
 *
 * @sampleName HBox
 * @preview preview.png
 * @docUrl http://docs.oracle.com/javase/8/javafx/layout-tutorial/index.html JavaFX Layouts
 * @see javafx.scene.control.Button
 * @see javafx.scene.control.Label
 * @see javafx.scene.control.TextField
 * @see javafx.scene.layout.HBox
 * @embedded
 *
 * @related /Layout/AnchorPane
 * @related /Layout/BorderPane
 * @related /Layout/FlowPane
 * @related /Layout/GridPane
 * @related /Layout/StackPane
 * @related /Controls/Text/Text Field
 * @related /Layout/TilePane
 * @related /Layout/VBox
 */
public class HBoxApp extends Application {

    public Parent createContent() {
        //Controls to be added to the HBox
        Label label = new Label("Test:");
        TextField tb = new TextField();
        Button button = new Button("Button");
        //HBox with spacing = 5
        HBox hbox = new HBox(5);
        hbox.getChildren().addAll(label, tb, button);
        hbox.setAlignment(Pos.CENTER);
        return hbox;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }

    /**
     * Java main for when running without JavaFX launcher
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
