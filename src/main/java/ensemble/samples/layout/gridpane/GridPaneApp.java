/*
 * Copyright (c) 2008, 2016, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 *
 * This file is available and licensed under the following license:
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  - Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *  - Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the distribution.
 *  - Neither the name of Oracle Corporation nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package ensemble.samples.layout.gridpane;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * GridPane布局的一个示例。 使用GridPane有多种方法。代码可以指定哪些行和/或列应该包含内容。
 * 或者，代码可以更改行和/或列本身的约束，方法是指定首选的最小或最大高度或宽度，或者指定属于
 * 某些行或列的GridPane的百分比。请注意，可以使网格线可见以帮助调试。
 *
 * @sampleName GridPane
 * @preview preview.png
 * @docUrl http://docs.oracle.com/javase/8/javafx/layout-tutorial/index.html JavaFX Layouts
 * @see javafx.scene.control.Label
 * @see javafx.scene.layout.ColumnConstraints
 * @see javafx.scene.layout.GridPane
 * @see javafx.scene.layout.RowConstraints
 * @embedded
 *
 * @related /Layout/AnchorPane
 * @related /Layout/BorderPane
 * @related /Layout/FlowPane
 * @related /Layout/HBox
 * @related /Controls/Text/Simple Label
 * @related /Layout/StackPane
 * @related /Layout/TilePane
 * @related /Layout/VBox
 */
public class GridPaneApp extends Application {

    public Parent createContent() {
        VBox vbox = new VBox();

        String percent = "通过影响行和列的百分比来放置内容。";
        Label gridPerCaption = new Label(percent);
        gridPerCaption.setWrapText(true);
        GridPane gridPer = createGridPanePercentage();

        String them = "通过影响行和列本身来安排内容:";
        Label gridRCInfoCaption = new Label(them);
        gridRCInfoCaption.setWrapText(true);
        GridPane gridRCInfo = createGridPaneRCInfo();

        String specify = "通过指定行和列放置内容:";
        Label gridConstCaption = new Label(specify);
        gridConstCaption.setWrapText(true);
        GridPane gridConst = createGridPaneConst();

        vbox.getChildren().addAll(gridPerCaption, gridPer, new Separator());
        vbox.getChildren().addAll(gridRCInfoCaption, gridRCInfo, new Separator());
        vbox.getChildren().addAll(gridConstCaption, gridConst);
        return vbox;
    }

    //The resulting GridPane places the child by influencing the rows and columns
    //via GridRowInfo and GridColumnInfo. This grid uses the percentages
    private GridPane createGridPanePercentage() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(8, 8, 8, 8));
        RowConstraints rowinfo3 = new RowConstraints();
        rowinfo3.setPercentHeight(50);

        ColumnConstraints colInfo2 = new ColumnConstraints();
        colInfo2.setPercentWidth(25);

        ColumnConstraints colInfo3 = new ColumnConstraints();
        colInfo3.setPercentWidth(50);

        grid.getRowConstraints().add(rowinfo3);//2*50 percent
        grid.getRowConstraints().add(rowinfo3);

        grid.getColumnConstraints().add(colInfo2); //25 percent
        grid.getColumnConstraints().add(colInfo3); //50 percent
        grid.getColumnConstraints().add(colInfo2); //25 percent

        Label condLabel = new Label(" Member Name:");
        GridPane.setHalignment(condLabel, HPos.RIGHT);
        GridPane.setConstraints(condLabel, 0, 0);
        Label condValue = new Label("MyName");
        GridPane.setMargin(condValue, new Insets(0, 0, 0, 10));
        GridPane.setConstraints(condValue, 1, 0);

        Label acctLabel = new Label("Member Number:");
        GridPane.setHalignment(acctLabel, HPos.RIGHT);
        GridPane.setConstraints(acctLabel, 0, 1);
        TextField textBox = new TextField("Your number");
        GridPane.setMargin(textBox, new Insets(10, 10, 10, 10));
        GridPane.setConstraints(textBox, 1, 1);

        Button button = new Button("Help");
        GridPane.setConstraints(button, 2, 1);
        GridPane.setMargin(button, new Insets(10, 10, 10, 10));
        GridPane.setHalignment(button, HPos.CENTER);

        GridPane.setConstraints(condValue, 1, 0);
        grid.getChildren().addAll(condLabel, condValue, button, acctLabel, textBox);
        return grid;
    }

    // The resulting GridPane places the child by influencing the
    // rows and columns themselves
    // via GridRowInfo and GridColumnInfo. This grid uses the preferred
    // width/height and max/min width/height.
    private GridPane createGridPaneRCInfo() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(8, 8, 8, 8));

        RowConstraints rowinfo = new RowConstraints(40, 40, 40);
        ColumnConstraints colinfo = new ColumnConstraints(90, 90, 90);

        for (int i = 0; i <= 2; i++) {
            grid.getRowConstraints().add(rowinfo);
        }

        for (int j = 0; j <= 2; j++) {
            grid.getColumnConstraints().add(colinfo);
        }

        Label category = new Label("Category:");
        GridPane.setHalignment(category, HPos.RIGHT);
        Label categoryValue = new Label("Coffee");
        Label company = new Label("Type:");
        GridPane.setHalignment(company, HPos.RIGHT);
        Label companyValue = new Label("Kona");
        Label rating = new Label("Rating:");
        GridPane.setHalignment(rating, HPos.RIGHT);
        Label ratingValue = new Label("Excellent");

        String IMAGE = "/ensemble/samples/shared-resources/icon-48x48.png";
        Image ICON_48 = new Image(getClass().getResourceAsStream(IMAGE));
        ImageView imageView = new ImageView(ICON_48);
        GridPane.setHalignment(imageView, HPos.CENTER);

        //Place content
        GridPane.setConstraints(category, 0, 0);
        GridPane.setConstraints(categoryValue, 1, 0);
        GridPane.setConstraints(company, 0, 1);
        GridPane.setConstraints(companyValue, 1, 1);
        GridPane.setConstraints(imageView, 2, 1);
        GridPane.setConstraints(rating, 0, 2);
        GridPane.setConstraints(ratingValue, 1, 2);
        grid.getChildren().addAll(category, categoryValue, company,
                                  companyValue, imageView, rating, ratingValue);
        return grid;
    }

    // Places child by specifying rows & columns in GridPane.setConstraints()
    private GridPane createGridPaneConst() {
        GridPane grid = new GridPane();
        grid.setHgap(4);
        grid.setVgap(6);
        grid.setPadding(new Insets(8, 8, 8, 8));
        grid.setGridLinesVisible(true);

        ObservableList<Node> content = grid.getChildren();

        Label label = new Label("Name:");
        GridPane.setConstraints(label, 0, 0);
        GridPane.setHalignment(label, HPos.RIGHT);
        content.add(label);

        label = new Label("John Q. Public");
        GridPane.setConstraints(label, 1, 0, 2, 1);
        GridPane.setHalignment(label, HPos.LEFT);
        content.add(label);

        label = new Label("Address:");
        GridPane.setConstraints(label, 0, 1);
        GridPane.setHalignment(label, HPos.RIGHT);
        content.add(label);

        label = new Label("12345 Main Street, Some City, CA");
        GridPane.setConstraints(label, 1, 1, 5, 1);
        GridPane.setHalignment(label, HPos.LEFT);
        content.add(label);
        return grid;
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
