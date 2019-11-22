package ensemble.samples.controls.accordion;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * An example of an accordion control. You can use accordion controls to define
 * individual panes and  display them one at a time.
 *
 * @sampleName Accordion
 * @preview preview.png
 * @docUrl http://www.oracle.com/pls/topic/lookup?ctx=javase80&id=JFXUI336 Using JavaFX UI Controls
 * @see javafx.scene.control.Accordion
 * @see javafx.scene.control.Button
 * @see javafx.scene.control.TitledPane
 * @see javafx.scene.shape.Rectangle
 * @embedded
 *
 * @related /Controls/Toggle Button
 * @related /Controls/Toolbar/Tool Bar
 */
public class AccordionApp extends Application {

    public Parent createContent() {
        Accordion accordion = new Accordion();
        accordion.getPanes().addAll(new TitledPane("Control",
                                                   new Button("Press")),
                                    new TitledPane("String",
                                                   new Text("Hello World.")),
                                    new TitledPane("Shape",
                                                   new Rectangle(120, 50,
                                                                 Color.RED)));
        accordion.setMinSize(100, 100);
        accordion.setPrefSize(100, 200);
        return accordion;
    }

    @Override public void start(Stage primaryStage) throws Exception {
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
