package adding;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
 
import java.io.File;
import java.io.IOException;
 
import java.util.Random;
/**
 * Adding multiple worksheet
 */
public class Test_MultiplePdfs {
    
    
	public static int generateRandom() {
		Random rand = new Random();
		int low = 0;
		int high = 9;
		int result = rand.nextInt(high - low) + low;
		return result;
	}
	
	public static Paragraph[] generateProblems() {
		Paragraph [] problems = new Paragraph[6];
		for(int i = 0; i < 6; i++) {
            problems[i] = new Paragraph("");
        }
		for(int i = 0; i < 6; i++) {
        	problems[0].add("                      " + generateRandom());
        	problems[1].add("                +    " + generateRandom());
        	problems[2].add("               --------");
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
    	for(int i = 1; i < 6; i++) {
            File file = new File("results/multiples/worksheet" + i + ".pdf");
            file.getParentFile().mkdirs();
            new Test_MultiplePdfs().createPdf("results/multiples/worksheet" + i + ".pdf");
    	}
    }
    
}
