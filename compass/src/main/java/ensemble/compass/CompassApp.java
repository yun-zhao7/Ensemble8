package ensemble.compass;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author chenzejin
 * @date 2019/11/22
 */
public class CompassApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        HBox top = new HBox();
        MenuItem menu11 = new MenuItem("Connect to..");
        MenuItem menu12 = new MenuItem("DisConnect");
        SeparatorMenuItem separator = new SeparatorMenuItem();
        MenuItem menu13 = new MenuItem("Exit");
        Menu menu1 = new Menu("Connect");
        menu1.getItems().addAll(menu11, menu12, separator, menu13);
        Menu menu2 = new Menu("View");
        Menu menu3 = new Menu("Help");
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menu1, menu2, menu3);
        top.getChildren().addAll(menuBar);
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(top);
        AnchorPane.setTopAnchor(top, 2D);
        stage.setTitle("CompassApp-Connect");
        stage.setScene(new Scene(anchorPane));
        stage.setWidth(1278);
        stage.setHeight(838);
//        stage.widthProperty().addListener((observableValue, oldValue, newValue) -> System.out.println("width"+newValue));
//        stage.heightProperty().addListener((observableValue, oldValue, newValue) -> System.out.println("height"+newValue));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
