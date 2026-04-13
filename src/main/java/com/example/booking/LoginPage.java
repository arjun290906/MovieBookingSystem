package com.example.booking;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginPage extends Application {

    @Override
    public void start(Stage stage) {

        Label lblUser = new Label("Username:");
        Label lblPass = new Label("Password:");
        Label lblMsg = new Label();

        TextField txtUser = new TextField();
        PasswordField txtPass = new PasswordField();

        Button btnLogin = new Button("Login");

        btnLogin.setOnAction(e -> {
            String user = txtUser.getText();
            String pass = txtPass.getText();

            Stage stageRef = (Stage) btnLogin.getScene().getWindow();
            stageRef.setScene(MainPage.getScene());
        });

        GridPane grid = new GridPane();

        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(lblUser, 0, 0);
        grid.add(txtUser, 1, 0);

        grid.add(lblPass, 0, 1);
        grid.add(txtPass, 1, 1);

        grid.add(btnLogin, 1, 2);
        grid.add(lblMsg, 1, 3);

        grid.setAlignment(Pos.CENTER);

        Scene scene = new Scene(grid, 800, 600);

        stage.setTitle("Login Page");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
