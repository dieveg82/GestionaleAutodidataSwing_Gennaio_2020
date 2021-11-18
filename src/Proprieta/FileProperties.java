package Proprieta;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;


public class FileProperties {

	//PPP  l'acronimo di ProvaProPerties. L'estensione di un file properties  per convenzione .properties
	public static String fileProperties = "config.properties";
	public static Properties ppts;
	public ArrayList<String>  key;
	public ArrayList<String> value;
	public static File file;
	//I blocchi statici vengono eseguiti una volta al caricamento in memoria della classe.
		static {
			ppts = new Properties();
			file = new File(fileProperties);
			
			try {
				//Il metodo createNewFile() crea un file vuoto se e soltanto se il file non esiste
				if(file.createNewFile())
				{
					System.out.println(	"Il file  " +fileProperties+ " non esiste.\n"+
								"Per evitare errori � stato creato.\n"+
								"-----------------------------------");
				}
			}catch(IOException ioe) {
				System.out.println(ioe);
				System.exit(-1); //Errore. Probabilmente non si hanno i permessi di scrittura.
			}
		}

	
		public FileProperties () {}
			
		public void initialize () {
			if ( ppts.isEmpty() == false) {
					
			}
			
			else {
		
			
			for (int i = 0 ; i <= key.size() -1  ; i++) {
				String keyString = key.get(i);
				String valueString = value.get(i);
				
				ppts.setProperty(keyString, valueString);}
			
			String commento = "Commento al file.";
			
			try( FileOutputStream os = new FileOutputStream(FileProperties.fileProperties) )
			{
				ppts.store(os, commento);
			}catch(IOException ioe) {
				System.out.println(ioe);
				System.exit(-1); //Errore. Probabilmente non si hanno i permessi di scrittura.
			}
		}}

		public static ArrayList getProperties() {
			// TODO Auto-generated method stub
			return null;
		}


	


}