package ensemble.samples.layout.anchorpane;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * 锚窗格布局的简单示例。
 *
 * @sampleName AnchorPane
 * @preview preview.png
 * @docUrl http://docs.oracle.com/javase/8/javafx/layout-tutorial/index.html JavaFX Layouts
 * @see javafx.scene.control.Button
 * @see javafx.scene.control.Label
 * @see javafx.scene.layout.AnchorPane
 * @see javafx.scene.image.ImageView
 * @embedded
 *
 * @related /Layout/BorderPane
 * @related /Layout/FlowPane
 * @related /Layout/GridPane
 * @related /Layout/HBox
 * @related /Graphics 2d/Images/Image Creation
 * @related /Controls/Text/Simple Label
 * @related /Layout/StackPane
 * @related /Layout/TilePane
 * @related /Layout/VBox
 */
public class AnchorPaneApp extends Application {

    public Parent createContent() {
        AnchorPane anchorPane = new AnchorPane();
        Label label1 = new Label("我们都在锚固板上。");
        String IMAGE = "/ensemble/samples/shared-resources/icon-48x48.png";
        Image ICON_48 = new Image(getClass().getResourceAsStream(IMAGE));
        ImageView imageView = new ImageView(ICON_48);
        Button button1 = new Button("提交");
        anchorPane.getChildren().addAll(label1, imageView, button1);
        AnchorPane.setTopAnchor(label1, 2d);
        AnchorPane.setLeftAnchor(label1, 20d);
        AnchorPane.setTopAnchor(button1, 40d);
        AnchorPane.setLeftAnchor(button1, 20d);
        AnchorPane.setTopAnchor(imageView, 75d);
        AnchorPane.setLeftAnchor(imageView, 20d);
        return anchorPane;
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
