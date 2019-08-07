package adding;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
 
import java.io.File;
import java.io.IOException;
 
import java.util.Random;
import java.util.Scanner;
/**
 * Adding with user input worksheet
 */
public class Print_UserInput {
    
	public static int generateRandom() {
		Random rand = new Random();
		int low = 0;
		int high = 9;
		int result = rand.nextInt(high - low) + low;
		return result;
	}
	
	public static Paragraph[] generateProblems(int num) {
		Paragraph [] problems = new Paragraph[6];
		for(int i = 0; i < 6; i++) {
            problems[i] = new Paragraph("");
        }
		for(int i = 0; i < 6; i++) {
        	problems[0].add("                      " + generateRandom());
        	problems[1].add("                +    " + num);
        	problems[2].add("               --------");
        	problems[3].add("                 ");
        	problems[4].add("                 ");
        	problems[5].add("                 ");
        }
		return problems;
	}
    
    public void createPdf(String dest, int num) throws IOException {
    	
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);
        
        for(int i = 0; i < 5; i++) {
        	for(int j = 0; j < 6; j++) {
        		document.add(generateProblems(num)[j]);
        	}
        }
 
        //Close document
        document.close();
    }
    
    public static void main(String args[]) throws IOException {
    	
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a number between 0-9: ");
		int i = scan.nextInt();
    	
        File file = new File("results/user/adding" + i + ".pdf");
        file.getParentFile().mkdirs();
        new Print_UserInput().createPdf("results/user/adding" + i + ".pdf", i);
	System.out.println("Your worksheet for adding " + i + " has been created.");
    }
    
}
