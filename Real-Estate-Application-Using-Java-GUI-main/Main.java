package com.example.realestatesystem;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

//My application ensures the user enters correct data please try entering wrong inputs.

public class Main extends Application {

    private Object MainMenuHandler;

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainMenuHandler = new MainMenuHandler(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
class MainMenuHandler implements EventHandler<ActionEvent>, varr {
    Stage primaryStage = new Stage();

    protected MainMenuHandler() {
    }

    protected MainMenuHandler(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.buildMainMenu();
    }

    private void buildMainMenu() {
        VBox root = new VBox();

        Text heading = new Text("Ben Wambura Real Estate Listing System");
        heading.setFont(Font.font("Arial", FontWeight.BOLD, 22));

        Button createHouse = new Button("Create House Listing");
        createHouse.setMinWidth(200);

        createHouse.setOnAction(new CreateHouseHandler(primaryStage));

        Button createCondo = new Button("Create Condominiums Listing");
        createCondo.setMinWidth(200);
        createCondo.setOnAction(new CreateCondoHandler(primaryStage));

        Button createRental = new Button("Create Rental Listing");
        createRental.setMinWidth(200);
        createRental.setOnAction(new CreateRentalHandler(primaryStage));

        Button viewListings = new Button("View Listings");
        viewListings.setMinWidth(200);
        viewListings.setOnAction(new ViewListingsHandler(primaryStage));

        Button exitProgram = new Button("Exit Program");
        exitProgram.setMinWidth(200);
        exitProgram.setOnAction(new ExitHandler(primaryStage));

        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);
        root.getChildren().addAll(heading, createHouse, createCondo, createRental, viewListings, exitProgram);

        primaryStage.setTitle("Ben Wambura Real Estate Listing System");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
    }

    public void handle(ActionEvent e) {
        this.buildMainMenu();
    }
}
class ExitHandler implements EventHandler<ActionEvent> {
    Stage primaryStage = new Stage();

    protected ExitHandler() {
    }

    protected ExitHandler(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void handle(ActionEvent e) {
        System.exit(0);
    }
}
