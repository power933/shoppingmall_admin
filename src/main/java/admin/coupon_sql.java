package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class coupon_sql {

	private String idx;
	private String cname;
	private String ckind;
	private String cstart_date;
	private String cend_date;
	private String ctype;
	private String csale;
	private String cleast;
	private String cimg;
	
	Connection con = null;
	PreparedStatement ps = null;
	tools t = new tools();
	public ArrayList<coupon_sql> select() {
		String sql = "";
		ArrayList<coupon_sql> al = null;
		try {
			sql = "select * from coupon";
			con = t.dbcon();
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			al = new ArrayList<coupon_sql>();
			while(rs.next()) {
				coupon_sql cs = new coupon_sql();
				cs.setIdx(rs.getString("idx"));
				cs.setCname(rs.getString("cname"));
				cs.setCkind(rs.getString("ckind"));
				cs.setCstart_date(rs.getString("cstart_date"));
				cs.setCend_date(rs.getString("cend_date"));
				cs.setCtype(rs.getString("ctype"));
				cs.setCsale(rs.getString("csale"));
				cs.setCleast(rs.getString("cleast"));
				cs.setCimg(rs.getString("cimg"));
				al.add(cs);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return al;
				
	}
	
	public boolean insert(ArrayList<String> al, String b) {
		String sql = "";
		boolean bool = false;
		try {
			sql = "insert into coupon values('0',?,?,?,?,?,?,?,?)";
			con = t.dbcon();
			ps = con.prepareStatement(sql);
			for(int i =0; i<al.size();i++) {
				ps.setString(i+1, al.get(i));
			}
			int r = ps.executeUpdate();
			if(r>0) bool = true;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return bool;
	}
	
	
	
	
	
	
	
	
	
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCkind() {
		return ckind;
	}
	public void setCkind(String ckind) {
		this.ckind = ckind;
	}
	public String getCstart_date() {
		return cstart_date;
	}
	public void setCstart_date(String cstart_date) {
		this.cstart_date = cstart_date;
	}
	public String getCend_date() {
		return cend_date;
	}
	public void setCend_date(String cend_date) {
		this.cend_date = cend_date;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public String getCsale() {
		return csale;
	}
	public void setCsale(String csale) {
		this.csale = csale;
	}
	public String getCleast() {
		return cleast;
	}
	public void setCleast(String cleast) {
		this.cleast = cleast;
	}
	public String getCimg() {
		return cimg;
	}
	public void setCimg(String cimg) {
		this.cimg = cimg;
	}
	
	
	
}
