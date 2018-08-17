package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro;
	public ConfigDataProvider()
	{
		File src=new File("./configuration/config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			 pro=new Properties();
			 
			 pro.load(fis);
			 
		} catch (Exception e)
		{
			System.out.println("Exception is"+e.getMessage());
			
		}
	}
	
	public String getIEpath()
	{
		String url=pro.getProperty("IEpath");
		return url;
	}
	
	public String getChromepath()
	{
		String url=pro.getProperty("chromepath");
		return url;
	}
	
	public String getApplicationurl()
	{
		String url=pro.getProperty("url");
		return url;
	}
	
	
}
