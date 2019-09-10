package adding;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
 
import java.io.File;
import java.io.IOException;
 
import java.util.Random;
/**
 * Adding any 2 digitsworksheet
 */
public class Print_2Digit {
    
    public static final String DEST = "results/add2digit/2digit.pdf";
    
	public static int generateRandom() {
		Random rand = new Random();
		int low = 10;
		int high = 99;
		int result = rand.nextInt(high - low) + low;
		return result;
	}
	
	public static Paragraph[] generateProblems() {
		Paragraph [] problems = new Paragraph[6];
		for(int i = 0; i < 6; i++) {
            problems[i] = new Paragraph("");
        }
		for(int i = 0; i < 6; i++) {
        	problems[0].add("                     " + generateRandom());
        	problems[1].add("               +    " + generateRandom());
        	problems[2].add("               ---------");
        	problems[3].add("                 ");
        	problems[4].add("                 ");
        	problems[5].add("                 ");
        }
		return problems;
	}
    
    public void createPdf(String dest) throws IOException {
    	
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);
        
        for(int i = 0; i < 5; i++) {
        	for(int j = 0; j < 6; j++) {
        		document.add(generateProblems()[j]);
        	}
        }
 
        //Close document
        document.close();
    }
    
    public static void main(String args[]) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new Print_2Digit().createPdf(DEST);
    }
    
}