package ensemble.samples.layout.borderpane;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * BorderPane布局的一个示例，其中将子元素放置在顶部、左侧、中间、右侧和底部位置。
 *
 * @sampleName BorderPane
 * @preview preview.png
 * @docUrl http://docs.oracle.com/javase/8/javafx/layout-tutorial/index.html JavaFX Layouts
 * @see javafx.scene.control.Button
 * @see javafx.scene.control.Label
 * @see javafx.scene.control.ToolBar
 * @see javafx.scene.image.ImageView
 * @see javafx.scene.layout.BorderPane
 * @embedded
 *
 * @related /Layout/AnchorPane
 * @related /Layout/FlowPane
 * @related /Layout/GridPane
 * @related /Layout/HBox
 * @related /Graphics 2d/Images/Image Creation
 * @related /Controls/Text/Simple Label
 * @related /Layout/StackPane
 * @related /Layout/TilePane
 * @related /Layout/VBox
 */
public class BorderPaneApp extends Application {

    public Parent createContent() {
         BorderPane borderPane = new BorderPane();
        //Top content
        ToolBar toolbar = new ToolBar();
        toolbar.getItems().add(new Button("Home"));
        toolbar.getItems().add(new Button("Options"));
        toolbar.getItems().add(new Button("Help"));
        borderPane.setTop(toolbar);
        //Left content
        Label label1 = new Label("Left hand");
        Button leftButton = new Button("left");
        VBox leftVbox = new VBox();
        leftVbox.getChildren().addAll(label1, leftButton);
        borderPane.setLeft(leftVbox);
        //Right content
        Label rightlabel1 = new Label("Right hand");
        Button rightButton = new Button("right");
        VBox rightVbox = new VBox();
        rightVbox.getChildren().addAll(rightlabel1, rightButton);
        borderPane.setRight(rightVbox);
        //Center content
        Label centerLabel = new Label("中心区域。");
        centerLabel.setWrapText(true);
        String IMAGE = "/ensemble/samples/shared-resources/icon-48x48.png";
        Image ICON_48 = new Image(getClass().getResourceAsStream(IMAGE));
        ImageView imageView = new ImageView(ICON_48);
        //仅使用锚定窗格将项目定位在中心
        AnchorPane centerAP = new AnchorPane();
        AnchorPane.setTopAnchor(centerLabel, 5d);
        AnchorPane.setLeftAnchor(centerLabel, 20d);
        AnchorPane.setTopAnchor(imageView, 40d);
        AnchorPane.setLeftAnchor(imageView, 30d);
        centerAP.getChildren().addAll(centerLabel, imageView);
        borderPane.setCenter(centerAP);
        //Bottom content
        Label bottomLabel = new Label("At the bottom.");
        borderPane.setBottom(bottomLabel);
        return borderPane;
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
