/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package dictionary;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Dell 2419h
 */
public class AddMenuController implements Initializable {
    
    /**
     * Initializes the controller class.
     */
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextArea newTranslate;
    @FXML
    private TextField newWord;
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
    private void switchToSearchText(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("TextMenu.fxml"));
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
    private void addWord(ActionEvent event) throws IOException {
        Library add = new Library();
        add.readFile();
        boolean check = add.addWord(newWord.getText(), newTranslate.getText());
        if(check) {
            Image img = new Image("Image/tick.png");
            Notifications.create()
                .title("Thông Báo")
                .text("Thêm từ thành công")
                .graphic(new ImageView(img))
                .position(Pos.CENTER)
                .hideAfter(Duration.seconds(2))
                .show();
            add.writeFile();
        } else {
            Notifications.create()
                .title("Thông Báo")
                .text("Từ đã tồn tại")
                .position(Pos.CENTER)
                .hideAfter(Duration.seconds(2))
                .showError();
        }
    }
    
}
