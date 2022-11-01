package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.mysql.fabric.xmlrpc.base.Array;

public class notice_delete {
	public ArrayList<Boolean> delete(String list[]) {
		boolean b = false;
		ArrayList<Boolean> bl = new ArrayList<Boolean>();
		tools t = new tools();
		Connection con = t.dbcon();
		try {
			String sql = "delete from notice where idx=?";
			PreparedStatement ps = con.prepareStatement(sql);
			int a = 0;
			for(int i = 0; i<list.length;i++) {
				ps.setString(1, list[i]);
				a = ps.executeUpdate();
			}
			if(a >0) {
				bl.add(true);
			}
			else {
				bl.add(false);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return bl;
	}
}
