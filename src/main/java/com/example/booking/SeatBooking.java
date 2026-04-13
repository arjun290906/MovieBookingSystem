package com.example.booking;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SeatBooking {

    public static Scene getScene() {
        Label lblHeading = new Label("Select Your Seats");
        lblHeading.setStyle("-fx-font-size: 14px;");
        Label lblScreen = new Label("SCREEN THIS WAY");
        lblScreen.setStyle("-fx-font-weight: bold;");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        int rows = 12, cols = 10;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                String seatNo = "" + (char)('A' + i) + (j + 1);
                CheckBox seat = new CheckBox(seatNo);
                grid.add(seat, j, i + 1);
            }
        }

        Button btnConfirm = new Button("Confirm Booking");
        btnConfirm.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Booking Status");
            alert.setHeaderText(null);
            alert.setContentText("Successfully booked tickets for " + MainPage.bookedMovie.getName() + "\nYour show will start at " + MainPage.bookedMovie.getShowTime());
            alert.showAndWait();
        });

        grid.add(btnConfirm, 0, rows + 5, cols, 1);
        grid.add(lblHeading, 0, 0, cols, 1);
        grid.add(lblScreen, 0, rows + 2, cols, 1);
        GridPane.setHalignment(lblHeading, javafx.geometry.HPos.CENTER);
        GridPane.setHalignment(btnConfirm, javafx.geometry.HPos.CENTER);
        GridPane.setHalignment(lblScreen, javafx.geometry.HPos.CENTER);
        grid.setAlignment(Pos.CENTER);

        Scene scene = new Scene(grid, 800, 600);
        return scene;
    }
}
