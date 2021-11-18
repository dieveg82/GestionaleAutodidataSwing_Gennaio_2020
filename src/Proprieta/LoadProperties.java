 package Proprieta;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Spliterator;

import com.mysql.jdbc.Connection;



public class LoadProperties {

    private Properties prop;
    private final String propFileName = "config.properties";
    public File prorieta = new File(propFileName);
    public Object[] keyArrayList;
    public String[] valuesArrayList;
    public boolean load = false;
    
    
    public LoadProperties() throws Exception {
    	
    	if (prorieta.exists() == true)
    	{
    	FileInputStream inputStream = new FileInputStream(prorieta);
    	prop = new Properties();
    	if ( inputStream != null) {
    	prop.load(inputStream);
    	keyArrayList = prop.keySet().toArray();
    	int j = keyArrayList.length;
    	valuesArrayList = new String  [j];
    	
    	//valuesArrayList = new ArrayList<String>();
    	for ( int i = 0 ; i < keyArrayList.length ; i++) {
    		valuesArrayList [i] = prop.getProperty((String) keyArrayList[i]);
    		//valuesArrayList.add((String) keyArrayList[i]);
    	}
    	
    	load = true;
    	
    	} 
    }}
    
    
}

