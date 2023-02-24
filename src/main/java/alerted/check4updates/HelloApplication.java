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
import java.util.Scanner;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException { //runs
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Checks.fxml"));

        Parent root = fxmlLoader.load();

        Button upd1 = (Button) root.lookup("#upd1");
        Label meinVer1 = (Label) root.lookup("#meinVer1");
        Label lateVer1 = (Label) root.lookup("#lateVer1");

        Button upd2 = (Button) root.lookup("#upd2");
        Label meinVer2 = (Label) root.lookup("#meinVer2");
        Label lateVer2 = (Label) root.lookup("#lateVer2");

        try {
            File myObj1 = new File("src/main/resources/ver1.txt");
            Scanner myReader1 = new Scanner(myObj1);
            File myObj2 = new File("src/main/resources/ver2.txt");
            Scanner myReader2 = new Scanner(myObj2);

            String cocks1=myReader1.nextLine();
            meinVer1.setText(cocks1.substring(6,cocks1.indexOf("l")));
            lateVer1.setText(cocks1.substring(cocks1.indexOf(":")+1));

            String cocks2=myReader2.nextLine();
            meinVer2.setText(cocks2.substring(6,cocks2.indexOf("l")));
            lateVer2.setText(cocks2.substring(cocks2.indexOf(":")+1));

            myReader1.close();
            myReader2.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        if(!(lateVer1.getText().trim().equals(meinVer1.getText().trim())))
        {
            upd1.setVisible(true);
            lateVer1.setTextFill(Color.RED);
        }

        if(!(lateVer2.getText().trim().equals(meinVer2.getText().trim())))
        {
            upd2.setVisible(true);
            lateVer2.setTextFill(Color.RED);
        }

        Scene scene = new Scene(root, 600, 250);
        stage.setTitle("Check4Updates");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}