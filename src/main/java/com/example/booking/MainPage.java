package com.example.booking;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Time;
import java.util.*;


public class MainPage {

    public static Movie bookedMovie;

    public static Scene getScene() {

        Label lblHeading = new Label("You can book your tickets here!");
        lblHeading.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Label lblMovieList = new Label("Currently Showing Movies:");
        lblMovieList.setStyle("-fx-font-size: 14px;");

        List<Movie> moviesList = Arrays.asList(
                new Movie("Inception", "Sci-Fi", 148, Time.valueOf("18:30:00")),
                new Movie("The Dark Knight", "Action", 152, Time.valueOf("20:00:00")),
                new Movie("Interstellar", "Sci-Fi", 169, Time.valueOf("21:30:00"))
        );

        TableView<Movie> table = new TableView<>();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN);

        TableColumn<Movie, String> colName = new TableColumn<>("Name");
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Movie, String> colGenre = new TableColumn<>("Genre");
        colGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));

        TableColumn<Movie, Integer> colDuration = new TableColumn<>("Duration");
        colDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));

        TableColumn<Movie, Time> colTime = new TableColumn<>("Show Time");
        colTime.setCellValueFactory(new PropertyValueFactory<>("showTime"));

        TableColumn<Movie, Void> colAction = new TableColumn<>("Action");

        colAction.setCellFactory(param -> new TableCell<>() {
            private final Button btn = new Button("Book");

            {
                btn.setOnAction(e -> {
                    Movie movie = getTableView().getItems().get(getIndex());
                    System.out.println("Booking: " + movie.getName());
                    bookedMovie = movie;

                    Stage stage = (Stage) btn.getScene().getWindow();
                    stage.setScene(SeatBooking.getScene());
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : btn);
            }
        });

        table.getItems().addAll(moviesList);
        table.getColumns().addAll(colName, colGenre, colDuration, colTime, colAction);

        VBox root = new VBox(15);
        root.setAlignment(Pos.CENTER);

        root.getChildren().addAll(lblHeading, lblMovieList, table);

        return new Scene(root, 800, 600);
    }
}