/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package dictionary;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 *
 * @author Dell 2419h
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField inPut;
    @FXML
    private TextArea outPut;
    private Stage stage;
    private Scene scene;
    private Parent root;
    Library x = new Library();
    @FXML
    private ListView<String> listHistory;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void switchToAdd(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AddMenu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void switchToSearchText(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("TextMenu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void switchToDelete(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("DeleteMenu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void search(ActionEvent event) throws IOException {
        x.readFile();
        String s = x.searchWord(inPut.getText());
        if (s == "...") {
            Notifications.create()
                    .title("Thông Báo")
                    .text("Từ không tồn tại")
                    .position(Pos.CENTER)
                    .hideAfter(Duration.seconds(2))
                    .showError();

        } else {
            outPut.setText(s);
        }
    }

    @FXML
    private void texttospeech(ActionEvent event) {
        Voice voice;
        VoiceManager voicemanager = VoiceManager.getInstance();
        voice = voicemanager.getVoice("kevin16");
        voice.allocate();
        try {
            voice.speak(inPut.getText());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    private void addHistory(MouseEvent event) {
        listHistory.getItems().add(0, inPut.getText());
    }
}
