/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package dictionary;

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
import tudien.translate;

/**
 *
 * @author Dell 2419h
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button button;
    @FXML
    private TextField inPut;
    @FXML
    private TextArea outPut;
    @FXML
    private ListView<String> listhis;
     private Stage stage;
     private Scene scene;
    private Parent root;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void search(ActionEvent event) throws IOException, Exception {
        Library x = new Library();
        x.readFile();
        String s = x.searchWord(inPut.getText());
        outPut.setText(s);
    }

    private void addWord(ActionEvent event) throws FileNotFoundException, IOException {
        String s1 = inPut.getText();
        s1 = "@" + s1;
        String s2 = outPut.getText();
        FileWriter fileWriter = new FileWriter("dictionary.txt", true);
        BufferedWriter bw = new BufferedWriter(fileWriter);
        bw.newLine();
        bw.write(s1);
        bw.newLine();
        bw.write(s2);
        bw.close();
        fileWriter.close();
    }

    @FXML
    private void addHistory(MouseEvent event)throws Exception{
        listhis.getItems().add(0, inPut.getText());
    
    }

    @FXML
    private void switchToScene2(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
     
    }
    public void switchToScene1(ActionEvent event) throws IOException {
  root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
 }
    
}
