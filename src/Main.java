import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		File file = new File("C:\\Users\\42077\\Documents\\MOJE\\�kola\\JAVA projekty\\Parsing\\prijemce.txt");
Person p = new Person ();
p.Parse("V�en� pane Erik Heller, zaslali jsme V�m na email emreo@seznam.cz Va�e telefonn� ��slo 774170527 a adresu �istovick� 95/13 p�eji hezk� zbytek dne");
 System.out.println(p);

	try {
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		String line;  
		while((line = br.readLine())!= null ){
			System.out.println(line);
		}
	
	}
	catch (FileNotFoundException e) {
			System.out.println("soubor tam nen�");
		} catch (IOException e) {
		System.out.println("IO chyba");
		}
	}
	
	}
