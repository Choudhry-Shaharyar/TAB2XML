package GUI;

import java.io.IOException;

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
import javafx.stage.Stage;

public class MusicPlayerController extends Application {
	@FXML  Button playMusic;
	@FXML  Button stopMusic;
	@FXML  Button goBackMeasure;
	@FXML  Button goForwardMeasure;
	@FXML  Button pauseAndPlay;
	@FXML  Slider volumeControl;
	
	@FXML 
	public void initialize() {
		volumeControl.setValue(100);		
	}

	@FXML
	private void playMusic() throws IOException {
		System.out.println("play music Button Clicked!");
	}
	@FXML
	private void pauseMusic() throws IOException {
		System.out.println("pause Button Clicked!");
	}
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
	
	
//	#playMusic
	
}
