package GUI;

import java.io.File;
import java.io.IOException;

import Parser.Parser;
import SMWriter.partToString;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ShowSMController extends Application {
	
	public File saveFile;
    private MainViewController mvc;
	public Highlighter highlighter;

	@FXML public TextArea smText;
	@FXML public ScrollPane scPane;

	public ShowSMController() {}
	
	@FXML 
	public void initialize() {
//		smText.setParagraphGraphicFactory(LineNumberFactory.get(smText));
	}

    public void setMainViewController(MainViewController mvcInput) {
    	mvc = mvcInput;
    }
    
    public void update() throws IOException {
		Parser par = new Parser(mvc.converter.getMusicXML());
		par.createParts();
		partToString x = new partToString(par.getPart());
		x.generateString();
		Font custom = Font.loadFont("file:src/main/resources/fonts/TABMusic.otf", 20);
		smText.setFont(custom);
		smText.appendText(x.getString());
        smText.requestFocus();
        smText.setEditable(false);
	}
    
	@FXML
	private void saveMXLButtonHandle() {
		mvc.saveMXLButtonHandle();
	}

    
	@Override
	public void start(Stage primaryStage) throws Exception {}
}