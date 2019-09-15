import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;




/**
 *
 * @author Alex Ordonez
 */
public class depure {

    /**
     * @param args the command line arguments
     */
    
	static ArrayList<String> Palabras=new ArrayList(); 


    public static void cargarDiccionario(String file) throws FileNotFoundException, IOException {

        String cadena;
		File archivo = new File (file);
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            System.out.println(cadena);
            Palabras.add(cadena);	
        }
        b.close();
    }
	
	public static void Limpiar(String file) throws FileNotFoundException, IOException {
		String cadena;
		File archivo = new File (file);
		Scanner sc=new Scanner(archivo);
		FileWriter fichero = new FileWriter("./Dataset_Limpio.txt");
		PrintWriter pw = new PrintWriter(fichero);
		while(sc.hasNext()){
			boolean esta=false;
            cadena=sc.next();
			cadena=cadena.toLowerCase();
			for(int i=0;i<Palabras.size();i++){
                if(cadena.equals(Palabras.get(i))){
				esta=true;
                            }
			}
			if(esta){
                pw.print(" "+cadena);
			System.out.print(" "+cadena);
			}
		}
		sc.close();
		fichero.close();
	}

    public static void main(String[] args) throws IOException {
        cargarDiccionario("./usa.txt");
	Limpiar("./Answers.txt");
		
    }
}
