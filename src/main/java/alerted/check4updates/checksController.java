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
    private Label meinVer;

    @FXML
    private Label lateVer;

    @FXML
    private Button upd;
    public void ChekingUpdates1()
    {
        try {
            Document doc = Jsoup.connect("https://vsetop.org/games/150-skachat-payday-2-torrent.html").get();
            Elements element = doc.select("div.body > b");
            String text = "";
            for (Element elemented : element)
            {
                text=elemented.text();
                if(text.startsWith("Скачать") && !(text.substring(18,28).trim().startsWith(meinVer.getText().trim())))
                {
                    upd.setVisible(true);
                    lateVer.setText(text.substring(18,28).trim());
                    lateVer.setTextFill(Color.RED);
                    try {
                        FileWriter writed = new FileWriter("src/main/resources/ver.txt");

                        writed.write("myver-"+meinVer.getText().trim()+"letver:"+text.substring(18,28).trim());

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
            FileWriter writed = new FileWriter("src/main/resources/ver.txt");

            writed.write("myver-"+lateVer.getText().trim()+"letver:"+lateVer.getText().trim());

            writed.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        meinVer.setText(lateVer.getText().trim());
        lateVer.setTextFill(Color.WHITE);
        upd.setVisible(false);
    }
}