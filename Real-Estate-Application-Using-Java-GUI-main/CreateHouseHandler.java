package com.example.realestatesystem;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.Objects;

class CreateHouseHandler implements EventHandler<ActionEvent>, varr {
    Stage primaryStage = new Stage();

    protected CreateHouseHandler() {
        //default no-arg constructor
    }

    protected CreateHouseHandler(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void handle(ActionEvent actionEvent) {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        final TextField StreetAddress = new TextField();
        gridPane.add(new Label("Street Address:"), 0, 0);
        gridPane.add(StreetAddress, 1, 0);

        final TextField City = new TextField();
        gridPane.add(new Label("City:"), 0, 1);
        gridPane.add(City, 1, 1);

        final TextField nobed = new TextField();
        gridPane.add(new Label("Number of bedrooms:"), 0, 2);
        gridPane.add(nobed, 1, 2);

        final TextField nobath = new TextField();
        gridPane.add(new Label("Number of bathrooms:"), 0, 3);
        gridPane.add(nobath, 1, 3);

        final TextField PurchasePrice = new TextField();
        gridPane.add(new Label("Purchase Price:"), 0, 4);
        gridPane.add(PurchasePrice, 1, 4);

        final TextField tax = new TextField();
        gridPane.add(new Label("Annual Tax:"), 0, 5);
        gridPane.add(tax, 1, 5);

        gridPane.setAlignment(Pos.CENTER);
        StreetAddress.setAlignment(Pos.BOTTOM_RIGHT);
        City.setAlignment(Pos.BOTTOM_RIGHT);
        nobed.setAlignment(Pos.BOTTOM_RIGHT);
        nobath.setAlignment(Pos.BOTTOM_RIGHT);
        PurchasePrice.setAlignment(Pos.BOTTOM_RIGHT);
        tax.setAlignment(Pos.BOTTOM_RIGHT);

        Label lb1 = new Label("- please enter alphabets only");
        lb1.setTextFill(Color.RED);
        gridPane.add(lb1, 2, 0);
        lb1.setVisible(false);
        Label lb2 = new Label("- please enter alphabets only");
        lb2.setTextFill(Color.RED);
        gridPane.add(lb2, 2, 1);
        lb2.setVisible(false);
        Label lb3 = new Label("- please enter numbers only");
        lb3.setTextFill(Color.RED);
        gridPane.add(lb3, 2, 2);
        lb3.setVisible(false);
        Label lb4 = new Label("- please enter numbers only");
        lb4.setTextFill(Color.RED);
        gridPane.add(lb4, 2, 3);
        lb4.setVisible(false);
        Label lb5 = new Label("- please enter numbers only");
        lb5.setTextFill(Color.RED);
        gridPane.add(lb5, 2, 4);
        lb5.setVisible(false);
        Label lb6 = new Label("- please enter numbers only");
        lb6.setTextFill(Color.RED);
        gridPane.add(lb6, 2, 5);
        lb6.setVisible(false);

        Button Okay = new Button("Submit");
        gridPane.add(Okay, 1, 6);
        Okay.setMinWidth(200);

        Label lb7 = new Label("- please enter any value");
        lb7.setTextFill(Color.RED);
        gridPane.add(lb7, 2, 0);
        lb7.setVisible(false);
        Label lb8 = new Label("- please enter any value");
        lb8.setTextFill(Color.RED);
        gridPane.add(lb8, 2, 1);
        lb8.setVisible(false);
        Label lb9 = new Label("- please enter any value");
        lb9.setTextFill(Color.RED);
        gridPane.add(lb9, 2, 2);
        lb9.setVisible(false);
        Label lb10 = new Label("- please enter any value");
        lb10.setTextFill(Color.RED);
        gridPane.add(lb10, 2, 3);
        lb10.setVisible(false);
        Label lb11 = new Label("- please enter any value");
        lb11.setTextFill(Color.RED);
        gridPane.add(lb11, 2, 4);
        lb11.setVisible(false);
        Label lb12 = new Label("- please enter any value");
        lb12.setTextFill(Color.RED);
        gridPane.add(lb12, 2, 5);
        lb12.setVisible(false);

        Okay.setOnAction(e -> {
            String b = StreetAddress.getText();
            String c = City.getText();
            String f = nobed.getText();
            String g = nobath.getText();
            String h = PurchasePrice.getText();
            String i = tax.getText();

            Alist.add(b);
            Alist.add(c);
            Alist.add(f);
            Alist.add(g);
            Alist.add(h);
            Alist.add(i);

            if (Objects.equals(b, "")) {
                lb7.setVisible(true);
                Alist.remove(b);
                Alist.remove(c);
                Alist.remove(f);
                Alist.remove(g);
                Alist.remove(h);
                Alist.remove(i);
            } else {
                lb7.setVisible(false);
            }
            try {
                Integer.parseInt(b);
                lb1.setVisible(true);
                Alist.remove(b);
                Alist.remove(c);
                Alist.remove(f);
                Alist.remove(g);
                Alist.remove(h);
                Alist.remove(i);
            } catch (NumberFormatException e1) {
                lb1.setVisible(false);
            }
            if (Objects.equals(c, "")) {
                lb8.setVisible(true);
                Alist.remove(b);
                Alist.remove(c);
                Alist.remove(f);
                Alist.remove(g);
                Alist.remove(h);
                Alist.remove(i);
            } else {
                lb8.setVisible(false);
            }
            try {
                Integer.parseInt(c);
                lb2.setVisible(true);
                Alist.remove(b);
                Alist.remove(c);
                Alist.remove(f);
                Alist.remove(g);
                Alist.remove(h);
                Alist.remove(i);
            } catch (NumberFormatException e1) {
                lb2.setVisible(false);
            }
            if (Objects.equals(f, "")) {
                lb9.setVisible(true);
                Alist.remove(b);
                Alist.remove(c);
                Alist.remove(f);
                Alist.remove(g);
                Alist.remove(h);
                Alist.remove(i);
            } else {
                lb9.setVisible(false);
            }
            if (!Objects.equals(f, "")) {
                try {
                    Integer.parseInt(f);
                    lb3.setVisible(false);
                } catch (NumberFormatException e1) {
                    lb3.setVisible(true);
                    Alist.remove(b);
                    Alist.remove(c);
                    Alist.remove(f);
                    Alist.remove(g);
                    Alist.remove(h);
                    Alist.remove(i);
                }
            }
            if (Objects.equals(g, "")) {
                lb10.setVisible(true);
                Alist.remove(b);
                Alist.remove(c);
                Alist.remove(f);
                Alist.remove(g);
                Alist.remove(h);
                Alist.remove(i);
            } else {
                lb10.setVisible(false);
            }
            if (!Objects.equals(g, "")) {
                try {
                    Integer.parseInt(g);
                    lb4.setVisible(false);
                } catch (NumberFormatException e1) {
                    lb4.setVisible(true);
                    Alist.remove(b);
                    Alist.remove(c);
                    Alist.remove(f);
                    Alist.remove(g);
                    Alist.remove(h);
                    Alist.remove(i);
                }
            }
            if (Objects.equals(h, "")) {
                lb11.setVisible(true);
                Alist.remove(b);
                Alist.remove(c);
                Alist.remove(f);
                Alist.remove(g);
                Alist.remove(h);
                Alist.remove(i);
            } else {
                lb11.setVisible(false);
            }
            if (!Objects.equals(h, "")) {
                try {
                    Integer.parseInt(h);
                    lb5.setVisible(false);
                } catch (NumberFormatException e1) {
                    lb5.setVisible(true);
                    Alist.remove(b);
                    Alist.remove(c);
                    Alist.remove(f);
                    Alist.remove(g);
                    Alist.remove(h);
                    Alist.remove(i);
                }
            }
            if (Objects.equals(i, "")) {
                lb12.setVisible(true);
                Alist.remove(b);
                Alist.remove(c);
                Alist.remove(f);
                Alist.remove(g);
                Alist.remove(h);
                Alist.remove(i);
            } else {
                lb12.setVisible(false);
            }
            if (!Objects.equals(i, "")) {
                try {
                    Integer.parseInt(i);
                    lb6.setVisible(false);
                } catch (NumberFormatException e1) {
                    lb6.setVisible(true);
                    Alist.remove(b);
                    Alist.remove(c);
                    Alist.remove(f);
                    Alist.remove(g);
                    Alist.remove(h);
                    Alist.remove(i);
                }
            }
        });

        Button returnMain = new Button("Return to Main Menu");
        gridPane.add(returnMain, 1, 7);
        returnMain.setMinWidth(200);
        returnMain.setOnAction(new MainMenuHandler(primaryStage));

        Button exitProgram = new Button("Exit Program");
        gridPane.add(exitProgram, 1, 8);
        exitProgram.setMinWidth(200);
        exitProgram.setOnAction(e -> System.exit(0));

        Scene scene = new Scene(gridPane, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Create New House");
        primaryStage.show();
    }
}
