package GUI;

import java.io.IOException;

import Parser.Parser;
import XMLPlayer.mxmlPlayer;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;

import converter.Converter;
import javafx.application.Application;
//import javafx.beans.InvalidationListener;
//import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import models.Creator;

public class MusicPlayerController extends Application {
    
    private MainViewController mvc;


    @FXML  Button playMusic;
//    @FXML  Button stopMusic;
    @FXML  Button goBackMeasure;
    @FXML  Button goForwardMeasure;
    @FXML  Button pauseAndPlay;
    @FXML TextArea musicInfoTextArea;
    public Creator x;
    String info;

    
    @FXML 
    public void initialize() throws IOException {
    

    }
    
    public void setMainViewController(MainViewController mainViewController) throws IOException {
        mvc = mainViewController;
        addInfo();
    }
    
    private void addInfo() throws IOException {
        
    Parser xmlParse = new Parser(mvc.converter.getMusicXML());
    xmlParse.createParts();
    info = xmlParse.getPart().toString();
    musicInfoTextArea.setText(info);
    }

    @FXML
    private void playMusic() throws IOException {
        System.out.println("play music Button Clicked!");
        Parser xmlParse = new Parser(mvc.converter.getMusicXML());
        xmlParse.createParts();
        mxmlPlayer xmlPlayer = new mxmlPlayer(xmlParse.getPart());
        xmlPlayer.createReadableMusic();
        xmlPlayer.playMusic();
        

    }
//    @FXML
//    private void pauseMusic() throws IOException {
//        System.out.println("pause Button Clicked!");
//    }
    @FXML
    private void pauseAndPlayMusic() throws IOException {
        System.out.println("pause/play Button Clicked!");
    }
    @FXML
    private void goBack() throws IOException {
        System.out.println("go back measure Button Clicked!");
    }
    @FXML
    private void goForward() throws IOException {
        System.out.println("go forward measure Button Clicked!");
    }

    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
    }
// 



    public void update() {
    
    }
    
    
//    #playMusic
    
}


