package ensemble.samples.layout.tilepane;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

/**
 * An example of a TilePane layout.
 *
 * @sampleName TilePane
 * @preview preview.png
 * @docUrl http://docs.oracle.com/javase/8/javafx/layout-tutorial/index.html JavaFX Layouts
 * @embedded
 * @related /Layout/AnchorPane
 * @related /Layout/BorderPane
 * @related /Layout/FlowPane
 * @related /Layout/GridPane
 * @related /Layout/HBox
 * @related /Graphics 2d/Images/Image Creation
 * @related /Layout/StackPane
 * @related /Layout/VBox
 * @see javafx.scene.control.Button
 * @see javafx.scene.image.ImageView
 * @see javafx.scene.layout.TilePane
 */
public class TilePaneApp extends Application {

    public Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(245, 100);
        root.setMinSize(Pane.USE_PREF_SIZE, Pane.USE_PREF_SIZE);
        root.setMaxSize(Pane.USE_PREF_SIZE, Pane.USE_PREF_SIZE);
        TilePane tilePane = new TilePane();
        tilePane.setPrefColumns(2); //preferred columns
        tilePane.setAlignment(Pos.CENTER);
        String IMAGE = "/ensemble/samples/shared-resources/icon-48x48.png";
        Image ICON_48 = new Image(getClass().getResourceAsStream(IMAGE));
        Button[] buttons = new Button[6];
        for (int j = 0; j < buttons.length; j++) {
            buttons[j] = new Button("button" + (j + 1), new ImageView(ICON_48));
            tilePane.getChildren().add(buttons[j]);
        }
        root.getChildren().add(tilePane);
        return root;
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
