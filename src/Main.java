import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		File file = new File("C:\\Users\\42077\\Documents\\MOJE\\Škola\\JAVA projekty\\Parsing\\prijemce.txt");
Person p = new Person ();
p.Parse("Vážený pane Erik Heller, zaslali jsme Vám na email emreo@seznam.cz Vaše telefonní èíslo 774170527 a adresu Èistovická 95/13 pøeji hezký zbytek dne");
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
			System.out.println("soubor tam není");
		} catch (IOException e) {
		System.out.println("IO chyba");
		}
	}
	
	}
