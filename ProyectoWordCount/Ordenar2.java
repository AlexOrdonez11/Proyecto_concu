import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/**
 *
 * @author Alex Ordonez
 */
public class Ordenar2 {

    /**
     * @param args the command line arguments
     */
	
	static ArrayList<Estructura> wordcount=new ArrayList();

    public static void Ordenar(String file) throws FileNotFoundException, IOException {
	File archivo = new File (file);
	Scanner sc=new Scanner(archivo);
	Scanner s=null;
	FileWriter fichero = new FileWriter("./Dataset_Ordenado.txt");
	PrintWriter pw = new PrintWriter(fichero);
	while(sc.hasNext()){
		Estructura struct=new Estructura();
		struct.setWord(sc.next()+" "+sc.next());
		struct.setCount(Integer.parseInt(sc.next()));
		wordcount.add(struct);
	}
	sc.close();
        Collections.sort(wordcount);
        for (Estructura e : wordcount) {
            pw.println(e.toString());
            System.out.println(e);
            
        }
        fichero.close();
    }
        

    public static void main(String[] args) throws IOException {
		Ordenar("./part-r-00001.txt");		
    }
}
