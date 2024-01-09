package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataReader {

	public static String ReadData(String key) throws IOException
	{
	 String  PropertyPath=System.getProperty("user.dir")+"\\src\\test\\resources\\Data.properties";	
	 FileInputStream F=new FileInputStream(PropertyPath);
	 Properties P=new Properties();
	 P.load(F);
	 String value=P.getProperty(key);
	 return value;
	}
}
