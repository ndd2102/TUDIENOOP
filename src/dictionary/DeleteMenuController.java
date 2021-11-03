/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dictionary;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 *
 * @author Dell 2419h
 */
public class DeleteMenuController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField wordDelete;

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
    private void switchToAdd(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AddMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void Delete(ActionEvent event) throws IOException {
        Library delete = new Library();
        delete.readFile();
        boolean ck = delete.deleteWord(wordDelete.getText());
        if(ck) {
            Image img = new Image("Image/tick.png");
            Notifications.create()
                .title("Thông Báo")
                .text("Xóa từ thành công")
                .graphic(new ImageView(img))
                .position(Pos.CENTER)
                .hideAfter(Duration.seconds(2))
                .show();
            delete.writeFile();
        } else {
            Notifications.create()
                .title("Thông Báo")
                .text("Từ không tồn tại")
                .position(Pos.CENTER)
                .hideAfter(Duration.seconds(2))
                .showError();
        }
    }
    
}
