package adding;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
 
import java.io.File;
import java.io.IOException;
 
import java.util.Random;
/**
 * Adding No Carry worksheet
 */
public class Print_No_Carry {
    
    public static final String DEST = "results/noCarry/test1.pdf";
    
	public static int generateRandom() {
		Random rand = new Random();
		int low = 0;
		int high = 9;
		int result = rand.nextInt(high - low) + low;
		return result;
	}
	
	public static boolean check(int num1, int num2) {
		return ((num1 + num2) < 9);
	}
	
	public static int[] generateFour() {
		int [] numbers = new int[4];
		
		int number1 = generateRandom();
		int number2 = generateRandom();
		int number3 = generateRandom();
		int number4 = generateRandom();
		
		while(check(number1, number2) != true) {
			number1 = generateRandom();
			number2 = generateRandom();
		}
		while(check(number3, number4) != true) {
			number3 = generateRandom();
			number4 = generateRandom();
		}
		
		numbers[0] = number1;
		numbers[1] = number2;
		numbers[2] = number3;
		numbers[3] = number4;
		
		return numbers;
		
	}
	
	public static Paragraph[] generateProblems() {
		
		Paragraph [] problems = new Paragraph[6];
		int [] numbers = new int[4];
		for(int i = 0; i < 6; i++) {
            problems[i] = new Paragraph("");
        }
		for(int i = 0; i < 6; i++) {
			numbers = generateFour();
        	problems[0].add("                    " + numbers[0] + "" + numbers[2]);
        	problems[1].add("              +    " + numbers[1] + "" + numbers[3]);
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
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new Print_No_Carry().createPdf(DEST);
    }
    
}
