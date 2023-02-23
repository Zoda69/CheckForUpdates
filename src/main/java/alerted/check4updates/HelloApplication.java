package alerted.check4updates;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Checks.fxml"));

        Parent root = fxmlLoader.load();

        Button upd = (Button) root.lookup("#upd");
        Label meinVer = (Label) root.lookup("#meinVer");
        Label lateVer = (Label) root.lookup("#lateVer");

        try {
            File myObj = new File("src/main/resources/ver.txt");
            Scanner myReader = new Scanner(myObj);
            String cocks=myReader.nextLine();
            meinVer.setText(cocks.substring(6,cocks.indexOf("l")));
            lateVer.setText(cocks.substring(cocks.indexOf(":")+1));
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        if(!(lateVer.getText().trim().equals(meinVer.getText().trim())))
        {
            upd.setVisible(true);
            lateVer.setTextFill(Color.RED);
        }

        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Check4Updates");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}