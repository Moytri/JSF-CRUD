package ca.bcit.com4613.utility;

import java.util.ResourceBundle;

public class ReadPropertiesFile {
	
	public static String getString( String resourceBundle, String key ) {		
		ResourceBundle rb = ResourceBundle.getBundle("ca/bcit/properties/"+resourceBundle);
		return rb.getString(key);
	}	
		
}

