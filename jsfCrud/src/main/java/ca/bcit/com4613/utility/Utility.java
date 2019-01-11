package ca.bcit.com4613.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Utility {

	//converts java.util.Date to java.sql.Date
	//used to store query data into Employee Object
	public static java.sql.Date convertFromUtiltoSql(java.util.Date date){
		java.sql.Date sqlDate = null;
		if (date != null) {
			sqlDate = new java.sql.Date(date.getTime());
		}
		 return sqlDate;
	}
	
	//converts java.sql.Date to java.util.Date
	//used to send Employee date of birth into db table using PreparedStatement
	public static java.util.Date convertFromSqlToUtil(java.sql.Date sqlDate) {
        java.util.Date utilDate = null;
        if (sqlDate != null) {
            utilDate = new java.util.Date(sqlDate.getTime());
        }
        return utilDate;
    }
	
	//converts string date (from UI) to java.util.Date
	public static java.util.Date convertFromStringToDate(String strDate){
		SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");       /*This stringDate is come from UI*/
		java.util.Date date = null;
		if(strDate != null && !strDate.trim().isEmpty()){
			try {
				date = format.parse(strDate);
				System.out.println(strDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}	
		return date;
	}


}
