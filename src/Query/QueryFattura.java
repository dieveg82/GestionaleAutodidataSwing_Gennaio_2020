package Query;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.joda.time.LocalDateTime;

import com.mysql.jdbc.PreparedStatement;

import ConnessioneDatabase.Connettore;

public class QueryFattura {
	Connection con;
	public boolean errore = false;
	
	public QueryFattura ()	 {
		
		Connettore connetto = new Connettore();
		try {
		 con =	connetto.connessione();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
	
		public  void inserimentoFattura (String dataFatturaString , String cognome , String nome , String codiceFiscale , String via , String numeroCivico , String codicePostale ,String citta , String capoluogo , String trattamento , String trattamento2 , String trattamento3 , String imponibile , String empap , String bollo , String totaleFattura , String metodoPagamento) throws SQLException, IOException {
			
			java.util.Date dataDate = new java.util.Date();
			dataDate.parse(dataFatturaString);
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			
			String sql = ("INSERT  INTO fattura (`NumeroFattura`,`DataFattura`, `Cognome`, `Nome`, `CodiceFiscale`, `Via`, `NumeroCivico`, `CodicePostale`, `Citta`, `Capoluogo`, `Trattamento`, `Trattamento2`, `Trattamento3`, `Imponibile`, `Empap`, `Bollo`, `TotaleFattura`, `MetodoPagamento`) VALUES ('0','"+format.format(dataDate)+"' , '"+cognome+"','"+nome+"','"+codiceFiscale+"','"+via+"','"+numeroCivico+"', '"+codicePostale+"' ,'"+citta+"','"+capoluogo+"','"+trattamento+"' , '"+trattamento2+"' , '"+trattamento3+"' , '"+imponibile+"' ,'"+empap+"' , '"+bollo+"' ,'"+totaleFattura+"', '"+metodoPagamento+"' ) ") ;
				//																																																																	`NumeroFattura`,`DataFattura`, `Cognome`, `Nome`, `CodiceFiscale`, `Via`, `NumeroCivico`, `CodicePostale`, `Citta`, `Capoluogo`, `Trattamento`, `Trattamento2`, `Trattamento3`, `Imponibile`, `Empap`, `Bollo`, `TotaleFattura`
			PreparedStatement ps =  (PreparedStatement) con.prepareStatement(sql);

			ps.executeUpdate();

		}
		
		public ResultSet selezioneFattura () throws SQLException {
		
			String sql = "SELECT * FROM fattura ";

			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			return rs ;	
		}	
		
		public void riposizionaIdFattura (int i) throws SQLException {
			
			String sql = "ALTER TABLE fattura " + " AUTO_INCREMENT = "+i+" ";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			
			ps.executeUpdate();	
			
		}
		
		public void cancellaFattura (int selezione ) throws SQLException{
			
			String sql = " DELETE FROM fattura WHERE (`NumeroFattura` = "+selezione+")" ;
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);

			ps.executeUpdate();		
		}
		
		public void modificaFattura (int numeroFattura ,String dataFattura ,String cognome ,String nome , String trattamento , String trattamento2 , String trattamento3 , String imponibile ,String empap, String bollo , String totaleFattura , String metodoPagamento) throws SQLException {
			
			if (cognome.isEmpty() == true) { errore = true;	}
			
			else {
				
			
			String sql =(" UPDATE fattura SET `DataFattura` = '"+dataFattura+"', `Cognome` = '"+cognome+"', `Nome` = '"+nome+"', `Trattamento` = '"+trattamento+"', `Trattamento2` = '"+trattamento2+"', `Trattamento3` = '"+trattamento3+"', `Imponibile` = '"+imponibile+"', `Empap` = '"+empap+"', `Bollo` = '"+bollo+"', `TotaleFattura` = '"+totaleFattura+"' ,  `MetodoPagamento` = '"+metodoPagamento+"' WHERE (`NumeroFattura` = '"+numeroFattura+"')");
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);

			ps.executeUpdate(sql);	}
	}
		
		public ResultSet selezioneidFattura (int i) throws SQLException {
			
			String sql = "SELECT * FROM fattura WHERE `NumeroFattura` = ('"+i+"') ";
		
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
	
			return rs ;	
	}
}
