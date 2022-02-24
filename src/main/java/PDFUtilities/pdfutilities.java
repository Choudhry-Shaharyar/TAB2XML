package PDFUtilities;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

public final class pdfutilities
{
	PDDocument document = new PDDocument();
	
    private static void createPDF() throws IOException
    {
    	PDDocument document = new PDDocument();
    	PDPage blankPage = new PDPage();
    	document.addPage(blankPage);
    	System.out.println(System.getProperty("user.dir"));
    	document.save("src//main//resources//pdfutilities//BlankPage.pdf");
    	document.close();
    }
    
    public static void createPage(String file, String message, String pfbPath) throws IOException {
        
        try (PDDocument doc = new PDDocument())
        {
            PDPage page = new PDPage();
            doc.addPage(page);

            PDType0Font font;
            try (InputStream is = new FileInputStream(pfbPath))
            {
                font = PDType0Font.load(doc, new File("src//main//resources\\fonts\\lasolsi_not.ttf"));
            }

            try (PDPageContentStream contents = new PDPageContentStream(doc, page))
            {
                contents.beginText();
                contents.setFont(font, 72);
                contents.newLineAtOffset(100, 700);
                contents.showText(message);
                contents.endText();
            }

            doc.save(file); 
        }
    }
    
    public static void openFile(String path) throws IOException {
    	File x = new File(path);
    	if (x.exists()) {
    		if(Desktop.isDesktopSupported()) {
    			Desktop.getDesktop().open(x);
    		}
    		else throw new IOException("DesktopAPI not supported on your Operating System");
    	}
    	else throw new IOException("File Not Fount");
    }
    
    public static void start() throws IOException
    {
        createPDF();
        createPage("src//main//resources//pdfutilities//Sheet-Music.pdf","Hello Everyone","src//main//resources//pdfutilities//BlankPage.pdf");
        //newLine();
        openFile("src//main//resources//pdfutilities//Sample-Sheet-Music.pdf");
        
    }
}
