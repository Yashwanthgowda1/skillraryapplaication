package genericlibrareys;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileutilty {
	
	
	private FileInputStream fis;
	private Properties property;
	private FileOutputStream fos;

public void propertyconfg(String filepath) {
	try {
		 fis=new FileInputStream(filepath);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	 property=new Properties();
	try {
		property.load(fis);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	/**
	 * this method is used to fetch  the common data by by passing key
	 * @param key
	 * @return
	 */
	
	public String fetchproperty(String key) {
		
		return property.getProperty(key);
}
	public void setDataToprorprty(String key, String values,String filepath, String message) {
		property.put(key, values);
		
			try {
				fos=new FileOutputStream(filepath);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			try {
				property.store(fos, message);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
	
	}
}
