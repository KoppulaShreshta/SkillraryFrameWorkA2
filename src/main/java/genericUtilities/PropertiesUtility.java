package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * THIS CLASS CONTAINS REUSABLE METHODS TO INTILIZE AND READ DATA FROM PROPERTIES FILE
 * @author MUNI SRI VASTAVA
 */
public class PropertiesUtility {
	private Properties property;
	/**
	 * THIS METHOD IS USED TOintialize properties file
	 * @param filepath
	 */
	  public void propertesInit(String filepath)
	  
	  {
		  FileInputStream fis=null;
		  try {
		 fis =new   FileInputStream (filepath);
		  }
		  catch(FileNotFoundException e)
		  {
			  e.printStackTrace();
		  }
		  property=new Properties();
		  try {
			  property.load(fis);
		  }
		  catch(IOException e )
		  {
			  e.printStackTrace();
		  }
	  }
	  /**
	   * THIS METHOD FETCHES DATA FROM PROPERTIES FLE BASED ON THE KEY PASSED AS AN ARGUMRNT
	   * @param key
	   * @return
	   */
	  public String readFromProperties(String key)
	  {
		return property.getProperty(key);
		  
	  }

}
