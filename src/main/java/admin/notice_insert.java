package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class notice_insert {
	public boolean insert(ArrayList<String> al) { 
		String sql = "insert into notice values('0',?,?,?,?,?,?,?)";
		boolean b = false;
		tools t = new tools();
		Connection con = t.dbcon();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			for(int i = 0; i<al.size();i++) {
				ps.setString(i+1, al.get(i));
			}
			int a = ps.executeUpdate();
			if(a>0)
				b =true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return b;
	}
	
	public boolean update(ArrayList<String> al, String idx) {
		boolean b = false;
		String sql = "update notice set nuse_notice=?,ntitle=?,nwriter=?,nfilurl=?,ncontent=?,ncount=? where idx="+idx;
		tools t = new tools();
		Connection con = t.dbcon();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			for(int i =0; i<al.size();i++) {
				ps.setString(i+1, al.get(i));
			}
			int a = ps.executeUpdate();
			if(a>0) {
				b=true;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return b;
	}
}
