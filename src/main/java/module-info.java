module alerted.check4updates {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jsoup;


    opens alerted.check4updates to javafx.fxml;
    exports alerted.check4updates;
}