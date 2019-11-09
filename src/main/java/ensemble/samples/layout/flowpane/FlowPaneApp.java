package ensemble.samples.layout.flowpane;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * 一个简单的FlowPane布局示例。
 *
 * @sampleName FlowPane
 * @preview preview.png
 * @docUrl http://docs.oracle.com/javase/8/javafx/layout-tutorial/index.html JavaFX Layouts
 * @embedded
 * @related /Layout/AnchorPane
 * @related /Layout/BorderPane
 * @related /Layout/GridPane
 * @related /Layout/HBox
 * @related /Graphics 2d/Images/Image Creation
 * @related /Layout/StackPane
 * @related /Layout/TilePane
 * @related /Layout/VBox
 * @see javafx.scene.image.ImageView
 * @see javafx.scene.layout.FlowPane
 */
public class FlowPaneApp extends Application {

    public Parent createContent() {
        final int ITEMS = 3;
        String IMAGE_48 = "/ensemble/samples/shared-resources/icon-48x48.png";
        String IMAGE_68 = "/ensemble/samples/shared-resources/icon-68x68.png";
        String IMAGE_88 = "/ensemble/samples/shared-resources/icon-88x88.png";
        Image ICON_48 = new Image(getClass().getResourceAsStream(IMAGE_48));
        Image ICON_68 = new Image(getClass().getResourceAsStream(IMAGE_68));
        Image ICON_88 = new Image(getClass().getResourceAsStream(IMAGE_88));
        FlowPane flowPane = new FlowPane(Orientation.HORIZONTAL, 4, 2);
        flowPane.setPrefWrapLength(240); //preferred wraplength
        ImageView[] imageViews48 = new ImageView[ITEMS];
        ImageView[] imageViews68 = new ImageView[ITEMS];
        ImageView[] imageViews88 = new ImageView[ITEMS];
        for (int i = 0; i < ITEMS; i++) {
            imageViews48[i] = new ImageView(ICON_48);
            imageViews68[i] = new ImageView(ICON_68);
            imageViews88[i] = new ImageView(ICON_88);
            flowPane.getChildren().addAll(
                    imageViews48[i],
                    imageViews68[i],
                    imageViews88[i]
            );
        }
        return flowPane;
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
