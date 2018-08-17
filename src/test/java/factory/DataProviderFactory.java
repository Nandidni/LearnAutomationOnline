package factory;

import dataprovider.ConfigDataProvider;
import dataprovider.ExcelDataProvider;

public class DataProviderFactory {
	
	public static ConfigDataProvider getconfig()
	{
		ConfigDataProvider config=new ConfigDataProvider();
		return config;
	}
	
	public static ExcelDataProvider getexcel()
	{
		ExcelDataProvider excel=new ExcelDataProvider();
		return excel;
	}

}
