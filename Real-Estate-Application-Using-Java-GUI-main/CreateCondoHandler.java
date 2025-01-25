package com.example.realestatesystem;

//hey please do this for each remove everthing concerning the Postal Code and State and return the updated codes remove their fields too


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

class CreateCondoHandler implements EventHandler<ActionEvent>, varr {
    Stage primaryStage = new Stage();

    protected CreateCondoHandler() {
    }

    protected CreateCondoHandler(Stage primaryStage) {
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

        final TextField Manfee = new TextField();
        gridPane.add(new Label("Management Fee:"), 0, 6);
        gridPane.add(Manfee, 1, 6);

        gridPane.setAlignment(Pos.CENTER);
        StreetAddress.setAlignment(Pos.BOTTOM_RIGHT);
        City.setAlignment(Pos.BOTTOM_RIGHT);
        nobed.setAlignment(Pos.BOTTOM_RIGHT);
        nobath.setAlignment(Pos.BOTTOM_RIGHT);
        PurchasePrice.setAlignment(Pos.BOTTOM_RIGHT);
        tax.setAlignment(Pos.BOTTOM_RIGHT);
        Manfee.setAlignment(Pos.BOTTOM_RIGHT);

        // Label error messages
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

        Label lb7 = new Label("- please enter numbers only");
        lb7.setTextFill(Color.RED);
        gridPane.add(lb7, 2, 6);
        lb7.setVisible(false);

        Button Okay = new Button("Submit");
        gridPane.add(Okay, 1, 7);
        Okay.setMinWidth(200);

        Label lb11 = new Label("- please enter any value");
        lb11.setTextFill(Color.RED);
        gridPane.add(lb11, 2, 0);
        lb11.setVisible(false);

        Label lb12 = new Label("- please enter any value");
        lb12.setTextFill(Color.RED);
        gridPane.add(lb12, 2, 1);
        lb12.setVisible(false);

        Label lb13 = new Label("- please enter any value");
        lb13.setTextFill(Color.RED);
        gridPane.add(lb13, 2, 2);
        lb13.setVisible(false);

        Label lb14 = new Label("- please enter any value");
        lb14.setTextFill(Color.RED);
        gridPane.add(lb14, 2, 3);
        lb14.setVisible(false);

        Label lb15 = new Label("- please enter any value");
        lb15.setTextFill(Color.RED);
        gridPane.add(lb15, 2, 4);
        lb15.setVisible(false);

        Label lb16 = new Label("- please enter any value");
        lb16.setTextFill(Color.RED);
        gridPane.add(lb16, 2, 5);
        lb16.setVisible(false);

        Label lb17 = new Label("- please enter any value");
        lb17.setTextFill(Color.RED);
        gridPane.add(lb17, 2, 6);
        lb17.setVisible(false);

        Okay.setOnAction(e -> {
            String b = StreetAddress.getText();
            String c = City.getText();
            String f = nobed.getText();
            String g = nobath.getText();
            String h = PurchasePrice.getText();
            String i = tax.getText();
            String j = Manfee.getText();

            Blist.add(b);
            Blist.add(c);
            Blist.add(f);
            Blist.add(g);
            Blist.add(h);
            Blist.add(i);
            Blist.add(j);

            // Validation checks for empty fields
            if (Objects.equals(b, "")) {
                lb11.setVisible(true);
                Blist.remove(b);
            } else {
                lb11.setVisible(false);
            }

            if (Objects.equals(c, "")) {
                lb12.setVisible(true);
                Blist.remove(c);
            } else {
                lb12.setVisible(false);
            }

            if (Objects.equals(f, "")) {
                lb15.setVisible(true);
                Blist.remove(f);
            } else {
                lb15.setVisible(false);
            }

            if (Objects.equals(g, "")) {
                lb16.setVisible(true);
                Blist.remove(g);
            } else {
                lb16.setVisible(false);
            }

            if (Objects.equals(h, "")) {
                lb17.setVisible(true);
                Blist.remove(h);
            } else {
                lb17.setVisible(false);
            }

            // Additional validation for numeric inputs
            try {
                Integer.parseInt(f);
                lb5.setVisible(false);
            } catch (NumberFormatException e1) {
                lb5.setVisible(true);
                Blist.remove(f);
            }

            try {
                Integer.parseInt(g);
                lb6.setVisible(false);
            } catch (NumberFormatException e1) {
                lb6.setVisible(true);
                Blist.remove(g);
            }

            try {
                Integer.parseInt(h);
                lb7.setVisible(false);
            } catch (NumberFormatException e1) {
                lb7.setVisible(true);
                Blist.remove(h);
            }
        });

        Scene scene = new Scene(gridPane, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Create Condo");
        primaryStage.show();
    }
}
