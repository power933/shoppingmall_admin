package admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Base64.Encoder;

public class tools {
	public Connection dbcon() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
//			con = DriverManager.getConnection("jdbc:mysql://umj7-009.cafe24.com/power933","power933","so9332650!@");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/power933","power933","so9332650!@");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
	public String time() {
		LocalDateTime dt = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String date = dt.format(dtf);
		return date;
	}
	
	public String time2() {
		LocalDateTime dt = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		String date = dt.format(dtf);
		return date;
	}
	
	public String toesc(String pw) {
		byte[] code = pw.getBytes();
		Encoder ec = Base64.getEncoder();
		byte[] code2 = ec.encode(code);
		String npw = new String(code2);
		
		return npw;
	}
}









