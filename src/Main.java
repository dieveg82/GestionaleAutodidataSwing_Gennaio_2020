
import java.sql.SQLException;
import java.time.LocalDate;

import ConnessioneDatabase.Connettore;
import ConnessioneDatabase.MascheraConnessione;
import Grafica.Agenda;
import Grafica.PaginaIniziale;
import Proprieta.LoadProperties;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		
		try {
			LoadProperties loadProperties = new LoadProperties();
			if (loadProperties.load == false) 	{	MascheraConnessione inizio = new MascheraConnessione();	}
			else {
				 Connettore connettoConnessioneDatabase = new Connettore();
				 String loader = loadProperties.valuesArrayList[1];
				 int load = Integer.parseInt(loader);
				 connettoConnessioneDatabase.con = connettoConnessioneDatabase.primaConnessione(loadProperties.valuesArrayList[0], loadProperties.valuesArrayList[4], load, loadProperties.valuesArrayList[2], loadProperties.valuesArrayList[3]);
				 PaginaIniziale paginaIniziale = new PaginaIniziale();
				 paginaIniziale.initialize();	
			}
			
		} catch (Exception e3) {
			e3.printStackTrace();
		}
		
		

	}

}
