package GUI;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;

import Parser.Parser;
import SMWriter.partToString;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ShowSMController extends Application {
	
	public File saveFile;
    private MainViewController mvc;
	public Highlighter highlighter;

	@FXML public CodeArea smText;

	public ShowSMController() {}
	
	@FXML 
	public void initialize() {
		smText.setParagraphGraphicFactory(LineNumberFactory.get(smText));
	}

    public void setMainViewController(MainViewController mvcInput) {
    	mvc = mvcInput;
    }
    
    public void update() throws IOException {
		Parser par = new Parser(mvc.converter.getMusicXML());
		par.createParts();
		partToString x = new partToString(par.getPart());
		x.generateString();
		System.out.println("STAGNANE");
		smText.replaceText(x.getString());
		smText.moveTo(0);
		smText.requestFollowCaret();
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