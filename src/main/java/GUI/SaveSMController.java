package GUI;

import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import utility.Settings;

public class SaveSMController extends Application {

    private MainViewController mvc;
    private static Window convertWindow = new Stage();
    private String content[];
    
    @FXML private TextField fileNameField;
    
    public void setMainViewController(MainViewController mvcInput) {
    	mvc = mvcInput;
    }
    
    public void initialize() {
		Settings s = Settings.getInstance();
	}
    
    public void setContent(String c[]) {
    	content =c;
    }
    
    @FXML
    private void saveButtonClicked() {
//    	setContent()
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save As");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PDF File", "*.pdf", "*.PDF");
        fileChooser.getExtensionFilters().add(extFilter);

        File initialDir = new File(Settings.getInstance().outputFolder);
        String initialName = null;
        if (!fileNameField.getText().isBlank() && fileNameField.getText().length()<50)
            initialName = fileNameField.getText().strip();

        if (mvc.saveFile != null) {
            if (initialName == null) {
                String name = mvc.saveFile.getName();
                if(name.contains("."))
                    name = name.substring(0, name.lastIndexOf('.'));
                initialName = name;
            }
            File parentDir = new File(mvc.saveFile.getParent());
            if (parentDir.exists())
                initialDir = parentDir;
        }
        if (initialName != null)
            fileChooser.setInitialFileName(initialName);

        if (!(initialDir.exists() && initialDir.canRead()))
            initialDir = new File(System.getProperty("user.home"));

        fileChooser.setInitialDirectory(initialDir);

        File file = fileChooser.showSaveDialog(convertWindow);

        if (file != null) {
            mvc.converter.saveSMFile(file, content);
            mvc.saveFile = file;
            cancelButtonClicked();
        }
    }

    @FXML
    private void cancelButtonClicked()  {
    	mvc.convertWindow.hide();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {}
}