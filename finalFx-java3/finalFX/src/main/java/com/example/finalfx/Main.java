package com.example.finalfx;

import com.example.finalfx.view.ViewManager;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException {

        ViewManager.getLogInStage().logInScene();
        ViewManager.getLogInStage().show();

    }

    public static void main(String[] args) {
        launch();
    }
}