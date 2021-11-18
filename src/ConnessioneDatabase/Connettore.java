package ConnessioneDatabase;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;







public class Connettore {

	public Connection con = null;
	public Connettore () {};
	
	public Connection connessione () throws SQLException  {
		
		
		MysqlDataSource mysql = new MysqlDataSource();
		mysql.setUser("root");
		mysql.setPassword("......");
		mysql.setPortNumber(3306);
		mysql.setDatabaseName("........");
		mysql.setServerName("127.0.0.1");
		
		con =  mysql.getConnection();
		return con;
	}
       public Connection primaConnessione (String root , String password , int port , String database , String server) throws SQLException{
         
         MysqlDataSource mysql = new MysqlDataSource();
		mysql.setUser(root);
		mysql.setPassword(password);
		mysql.setPortNumber(port);
		mysql.setDatabaseName(database);
		mysql.setServerName(server);
		
		con =  mysql.getConnection();
	
            
            return con;
                }
}
