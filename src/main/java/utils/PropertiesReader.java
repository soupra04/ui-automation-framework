package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
	
	public static String readkey(String key)  {
		try {
		//readkey will read the value from data file
		FileInputStream fileinputStream = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/resources/data.properties");
		Properties p = new Properties();
		p.load(fileinputStream);
		return p.getProperty(key);
		} catch (IOException e) {
			throw new RuntimeException(e);
			
		}
	}

}
