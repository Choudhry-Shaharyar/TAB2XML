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
    	document.save("src\\main\\resources//pdfutilities//BlankPage.pdf");
    	document.close();
    }
    
    public static void createPage(String file, String message[], String pfbPath) throws IOException {
        
        try (PDDocument doc = new PDDocument())
        {
            PDPage page = new PDPage();
            doc.addPage(page);

            PDType0Font font;
            try (InputStream is = new FileInputStream(pfbPath))
            {
                font = PDType0Font.load(doc, new File("src\\main\\Resources\\fonts\\TABMusic.ttf"));
            }

            try (PDPageContentStream contents = new PDPageContentStream(doc, page))
            {
                contents.beginText();
                contents.setFont(font, 12);
                contents.newLineAtOffset(25, 700);
                contents.setLeading(14.5f);
                for(String l:message) {
                	contents.showText(l);
                	contents.newLine();   
                }
                contents.endText();
            }

            doc.save(file); 
        }
    }
    
    public static void build(String[] text) throws IOException
    {
        createPDF();
        createPage("src\\main\\Resources//pdfutilities//Sheet-Music.pdf",text,"src\\main\\Resources//pdfutilities//BlankPage.pdf");
        //newLine();
        Desktop.getDesktop().open(new File("src\\main\\Resources//pdfutilities//Sheet-Music.pdf"));
        
    }
    
    public static void build(String[] text, String path) throws IOException
    {
        createPDF();
        createPage(path,text,"src\\main\\Resources//pdfutilities//BlankPage.pdf");
        
    }
}
