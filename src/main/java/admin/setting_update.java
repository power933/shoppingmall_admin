package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class setting_update {

	public boolean update(ArrayList<String> al) {
		String sql = "update setting set stitle=?,semail=?,spointuse=?,sbasicpoint=?,sbasiclevel=?,scompany_name=?,sbn=?,schairman=?,stel=?,stn=?,ssub_bn=?,spost=?,saddr=?,sres_name=?,sres_email=?,sbank_name=?,sbank_num=?,suse_card=?,suse_tel=?,suse_book=?,spoint_least=?,spoint_limit=?,suse_receipt=?,sdelivery_name=?,sdelivery_payment=?,suse_hopedate=?,sidx=?";
		al.add("1");
		boolean b = false;
		
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
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return b;
	}
	
}
