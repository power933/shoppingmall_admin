package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class select {
	private String aidx;
	private String aid;
	private String apass;
	private String aname;
	private String aemail;
	private String atel;
	private String apart;
	private String aposition;
	private String aindate;
	private String auseable;
	
	public String getAidx() {
		return aidx;
	}
	public void setAidx(String aidx) {
		this.aidx = aidx;
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getApass() {
		return apass;
	}
	public void setApass(String apass) {
		this.apass = apass;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getAemail() {
		return aemail;
	}
	public void setAemail(String aemail) {
		this.aemail = aemail;
	}
	public String getAtel() {
		return atel;
	}
	public void setAtel(String atel) {
		this.atel = atel;
	}
	public String getApart() {
		return apart;
	}
	public void setApart(String apart) {
		this.apart = apart;
	}
	public String getAposition() {
		return aposition;
	}
	public void setAposition(String aposition) {
		this.aposition = aposition;
	}
	public String getAindate() {
		return aindate;
	}
	public void setAindate(String aindate) {
		this.aindate = aindate;
	}
	public String getAuseable() {
		return auseable;
	}
	public void setAuseable(String auseable) {
		this.auseable = auseable;
	}
	
	public ArrayList<select> selec(int num, String name, String name2){ // 0: 조건없이 1:아이디 2:list
		
		ArrayList<select> al = new ArrayList<select>();
		String sql = "";
		if(num==0) {
			sql = "select * from admin_join order by aidx desc"; //where aid="+"'"+id+"'"
		}
		else if(num==1) {
			sql = "select * from admin_join where aid ="+"'"+name+"'";
		}
		else if(num==2) {
			int st = Integer.parseInt(name);
			int end = Integer.parseInt(name2);
			sql = "select * from admin_join order by aidx desc limit "+st+","+end; 
			
		}
		tools t = new tools();
		Connection con =  t.dbcon();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				select s = new select();
				s.setAidx(rs.getString("aidx"));
				s.setAid(rs.getString("aid"));
				s.setApass(rs.getString("apass"));
				s.setAname(rs.getString("aname"));
				s.setAemail(rs.getString("aemail"));
				s.setAtel(rs.getString("atel"));
				s.setApart(rs.getString("apart"));
				s.setAposition(rs.getString("aposition"));
				s.setAindate(rs.getString("aindate"));
				s.setAuseable(rs.getString("auseable"));
				al.add(s);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return al;
	}
	
}
