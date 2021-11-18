package Query;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import ConnessioneDatabase.Connettore;



public class QueryDatabase {
	
	Connection con;
	
	public QueryDatabase ()	 {
		
		Connettore connetto = new Connettore();
		try {
		 con =	connetto.connessione();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
	
	
			public  void inserimentoAnagrafica (String cognome , String nome , String codiceFiscale , String via , String numeroCivico , String CodicePostale , String citta , String Capoluogo) throws SQLException, IOException {
		
				String sql = ("INSERT INTO anagrafica (`Cognome` , `Nome` , `CodiceFiscale` , `Via` , `NumeroCivico`, `CodicePostale` ,`Citta` , `Capoluogo`  ) VALUES ('"+cognome+"' , '"+nome+"' , '"+codiceFiscale+"' , '"+via+"' , '"+numeroCivico+"' ,'"+CodicePostale+"' , '"+citta+"' ,'"+Capoluogo+"' )");
				PreparedStatement ps =  (PreparedStatement) con.prepareStatement(sql);
		
				ps.executeUpdate();
		
		}
	
				
			public ResultSet selezioneid (int i) throws SQLException {
				
				String sql = "SELECT * FROM anagrafica WHERE `Id` = ('"+i+"') ";
			
				PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
		
				return rs ;	
		}
		
			public ResultSet selezionefiltro (String selezione , String valore) throws SQLException {
				
				String sql = "SELECT * FROM anagrafica WHERE `"+selezione+"` = ('"+valore+"') ";
				
				
				PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
		
				return rs ;	
		}
		
			
			public ResultSet selezioneAnagrafica () throws SQLException {
	
				String sql = "SELECT * FROM anagrafica ";
	
				PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
	
			return rs ;	
		}

	

			public void modifica (int id ,String Cognome ,String Nome , String CodiceFisacle , String Via , String NumeroCivico , String CodicePostale, String Citta , String Capoluogo ) throws SQLException {
	
				String sql = "UPDATE anagrafica SET `Cognome` = '"+Cognome+"', `Nome` = '"+Nome+"',  `CodiceFiscale` = '"+CodiceFisacle+"',`Via` = '"+Via+"', `NumeroCivico` = '"+NumeroCivico+"', `CodicePostale` = '"+CodicePostale+"', `Citta` = '"+Citta+"', `Capoluogo` = '"+Capoluogo+"' WHERE  ( `Id` =  '"+id+"')";
				PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
	
				ps.executeUpdate(sql);
		}

			public void cancella (int selezione ) throws SQLException{
	
				String sql = " DELETE FROM anagrafica WHERE (`Id` = '"+selezione+"')" ;
				PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
	
				ps.executeUpdate();		
			}

		
}
			
