package com.example.realestatesystem;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

class ViewListingsHandler implements EventHandler<ActionEvent>,varr {

    Stage primaryStage = new Stage();

    protected ViewListingsHandler(Stage primaryStage) {
        this.primaryStage = this.primaryStage;
    }

     public void handle(ActionEvent e){
        int i=0,r=0,o=0, f=8, g=9, k=8;

         TextArea textArea = new TextArea();
         textArea.setFont(Font.font("Times New Roman", FontWeight.BOLD, 14));
         if(Alist.size()!=0) {
             textArea.appendText("The House Listings are Below:" + "\n");
             textArea.appendText( "Street   City   bedrooms   bathrooms   price   annualtax\n");
             for (String alis: Alist) {
                 textArea.appendText(alis+"  ");
                 i++;
                 if (i==f) {
                     f += 8;
                     textArea.appendText("\n");
                 }
             } textArea.appendText("\n");
         } else
             textArea.appendText("no house listings data found"+ "\n\n");

         if(Blist.size()!=0) {
             textArea.appendText("\nThe condominium listings:" + "\n");
             textArea.appendText( "Street City bedrooms bathrooms price annualtax  managementfee\n");
             for (String blis: Blist) {
                 textArea.appendText(blis+"  ");
                 r++;
                 if (r==g) {
                     g += 9;
                     textArea.appendText("\n");
                 }
             } textArea.appendText("\n");
         } else
             textArea.appendText("no condominium listings data found"+ "\n\n");

         if(Clist.size()!=0) {
             textArea.appendText("\nThe apartment listings:" + "\n");
             textArea.appendText( "Street City bedrooms bathrooms rent lease\n");
             for (String clis: Clist) {
                 textArea.appendText(clis+"  ");
                 o++;
                 if (o==k) {
                     k += 8;
                     textArea.appendText("\n");
                 }
             } textArea.appendText("\n");
         } else
             textArea.appendText("no apartment listings data found"+ "\n\n");

         VBox root = new VBox();
         Button returnMain = new Button("Return Main");
        returnMain.setOnAction(new MainMenuHandler(primaryStage));
        returnMain.setMinWidth(200);

        Button exitProgram = new Button("Exit Program");
        exitProgram.setMinWidth(200);

        exitProgram.setOnAction(new ExitHandler());
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);
        Scene scene = new Scene(root, 500, 500);

        primaryStage.setScene(scene);
        root.getChildren().addAll(textArea, returnMain, exitProgram);
    }
}
