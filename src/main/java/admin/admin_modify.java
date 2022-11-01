package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;


public class admin_modify {
	PreparedStatement ps = null;
	boolean res = false;
	public boolean select(ArrayList<String> al, int xx)  {//0:join 1: login 
		tools t = new tools();
		
		Connection con = t.dbcon();
		String sql = "";
		if(xx ==1) {
			 sql = "insert into admin_loginlog values('0',?,?)";
			
		}
		else if(xx==0) {
			al.add(t.time());
			al.add("N");
			sql = "insert into admin_join values('0',?,?,?,?,?,?,?,?,?)";
		}
		else if(xx==2) {
			sql = "update admin_join set aid=?, apass=?,aname=?,aemail=?,atel=?,apart=?,aposition=? where aid=?";
		}
		
		try {
			ps = con.prepareStatement(sql);
			for(int i =0; i<al.size();i++) {
				ps.setString(i+1, al.get(i));
			}
			int a = ps.executeUpdate();
			if(a>0) {
				res = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
}
