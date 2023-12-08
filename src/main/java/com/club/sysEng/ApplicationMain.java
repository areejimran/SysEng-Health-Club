package com.club.sysEng;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * The ApplicationMain class serves as the entry point for the SysEng Club application.
 * It initializes the main application window and launches the user interface.
 */
public class ApplicationMain extends Application {

    /**
     * Initializes and displays the main application window.
     * Loads the SysEng.fxml file to create the user interface.
     *
     * @param stage The primary stage to display the application.
     * -
     * created Date: 11/29/2023
     * Author:
     */
    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ApplicationMain.class.getResource("SysEng.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("SysEng Club");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /**
     * The main method of the application, which launches the JavaFX application.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        launch(args);
    }

}
