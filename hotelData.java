import java.sql.*;
import javax.swing.*;


public class hotelData {
	
	public static Connection ConnectDB{
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriveManager.getConnection
					("jdbc : sqlite : ")
			
		}
		catch(Exception e){
			
			
		}
		
	}

}
