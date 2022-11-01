package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class update {
	
	public boolean update_yn(ArrayList<String> al) {
		tools t = new tools();
		boolean b = false;
		Connection con = t.dbcon();
		String sql = "update admin_join set auseable =? where aid=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, al.get(0));
			ps.setString(2, al.get(1));
			int a = ps.executeUpdate();
			if(a>0)
				b = true;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return b;
	}
	
}
