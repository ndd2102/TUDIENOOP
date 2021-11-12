/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package dictionary;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import static dictionary.translate.translate;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell 2419h
 */
public class TextMenuController implements Initializable {


    /**
     * Initializes the controller class.
     */
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextArea outPutText;
    @FXML
    private TextArea inPutText;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void switchToSearchWord(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void switchToAdd(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AddMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void switchToDelete(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("DeleteMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void searchText(ActionEvent event) throws IOException {
         String str = "";
        String r = "";
        Vector<String> text = new Vector<>();
        String s = inPutText.getText();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '\n' || i == s.length() - 1 ) {
               text.add(str);
               str = "";
            } else {
                str += s.charAt(i);
            }
        }
        for (int i = 0; i < text.size(); i++) {
            r += translate("en", "vi", text.get(i));
            r += '\n';
        }
         outPutText.setText(r);
    }

    @FXML
    private void speechText(ActionEvent event) {
        Voice voice;
        VoiceManager voicemanager = VoiceManager.getInstance();
        voice = voicemanager.getVoice("kevin16");
        voice.allocate();
        try {
            voice.speak(inPutText.getText());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
