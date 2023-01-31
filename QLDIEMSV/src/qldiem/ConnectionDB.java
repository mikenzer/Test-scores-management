package qldiem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;	

public class ConnectionDB {
	public void Connection(Connection con) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qldiem?" + "user=root");
			System.out.println("Kết nối thành công!");
		} 
		catch (Exception e) {          
			System.out.println("Kết nối thất bại!");
	    }

	}
}
