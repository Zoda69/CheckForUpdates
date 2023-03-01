package alerted.check4updates;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class checksController
{
    @FXML
    private Label meinVer1, meinVer2;

    @FXML
    private Label lateVer1, lateVer2;

    @FXML
    private Button upd1, upd2;
    public void ChekingUpdates1()
    {
        try
        {
            Document doc = Jsoup.connect("https://vsetop.org/games/150-skachat-payday-2-torrent.html").get();
            Elements element = doc.select("div.body > b");
            String text = "";
            for (Element elemented : element)
            {
                text=elemented.text();
                System.out.println(text);
                if(text.startsWith("Скачать") && !(text.substring(18,28).trim().startsWith(meinVer1.getText().trim())))
                {
                    System.out.println(text.substring(18,28).trim());
                    upd1.setVisible(true);
                    lateVer1.setText(text.substring(18,28).trim());
                    lateVer1.setTextFill(Color.RED);
                    try {
                        FileWriter writed = new FileWriter("src/main/resources/ver1.txt");

                        writed.write("myver-"+meinVer1.getText().trim()+"letver:"+text.substring(18,28).trim());

                        writed.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateE1()
    {
        try {
            FileWriter writed = new FileWriter("src/main/resources/ver1.txt");

            writed.write("myver-"+lateVer1.getText().trim()+"letver:"+lateVer1.getText().trim());

            writed.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        meinVer1.setText(lateVer1.getText().trim());
        lateVer1.setTextFill(Color.WHITE);
        upd1.setVisible(false);
    }

    public void ChekingUpdates2()
    {
        try
        {
            Document doc = Jsoup.connect("https://vsetop.org/games/1761-my-summer-car.html").get();
            Elements element = doc.select("div.body > b");
            String text = "";
            System.out.println(text);
            for (Element elemented : element)
            {
                text=elemented.text();
                if(text.startsWith("Скачать") && !(text.substring(23,33).trim().startsWith(meinVer2.getText().trim())))
                {
                    System.out.println(text.substring(18,28).trim());
                    upd2.setVisible(true);
                    lateVer2.setText(text.substring(23,33).trim());
                    lateVer2.setTextFill(Color.RED);
                    try {
                        FileWriter writed = new FileWriter("src/main/resources/ver2.txt");

                        writed.write("myver-"+meinVer2.getText().trim()+"letver:"+text.substring(18,28).trim());

                        writed.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateE2()
    {
        try {
            FileWriter writed = new FileWriter("src/main/resources/ver2.txt");

            writed.write("myver-"+lateVer2.getText().trim()+"letver:"+lateVer2.getText().trim());

            writed.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        meinVer2.setText(lateVer2.getText().trim());
        lateVer2.setTextFill(Color.WHITE);
        upd2.setVisible(false);
    }
}