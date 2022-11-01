package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class notice_select {
	
	private String idx;
	private String ntitle;
	private String nwriter;
	private String ndate;
	private String ncount;
	private String nuse_notice;
	private String ncontent;
	private String nfilurl;
	
	public String getNfilurl() {
		return nfilurl;
	}
	public void setNfilurl(String nfilurl) {
		this.nfilurl = nfilurl;
	}
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	public String getNtitle() {
		return ntitle;
	}
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	public String getNwriter() {
		return nwriter;
	}
	public void setNwriter(String nwriter) {
		this.nwriter = nwriter;
	}
	public String getNdate() {
		return ndate;
	}
	public void setNdate(String ndate) {
		this.ndate = ndate;
	}
	public String getNcount() {
		return ncount;
	}
	public void setNcount(String ncount) {
		this.ncount = ncount;
	}
	public String getNuse_notice() {
		return nuse_notice;
	}
	public void setNuse_notice(String nuse_notice) {
		this.nuse_notice = nuse_notice;
	}
	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	
	
	public ArrayList<notice_select> select(int a, int b, int c) {	//0:전체 1:idx 2: limit
		ArrayList<notice_select> al = new ArrayList<notice_select>();
		String sql = "";
		if(a==0) {
			sql = "select * from notice order by idx desc";
		}
		else if(a==1) {
			sql = "select * from notice where idx="+b;
		}
		else if(a==2) {
			String x = String.valueOf(b);
			String y = String.valueOf(c);
			sql = "select * from notice where nuse_notice = 'n' order by idx desc limit "+b+","+c;
		}
		else if(a==3) {
			sql = "select * from notice where nuse_notice = 'n'";
		}
		tools t = new tools();
		Connection con = t.dbcon();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				notice_select ns = new notice_select();
				ns.setIdx(rs.getString("idx"));
				ns.setNtitle(rs.getString("ntitle"));
				ns.setNwriter(rs.getString("nwriter"));
				ns.setNdate(rs.getString("ndate"));
				ns.setNcount(rs.getString("ncount"));
				ns.setNuse_notice(rs.getString("nuse_notice"));
				ns.setNcontent(rs.getString("ncontent"));
				ns.setNfilurl(rs.getString("nfilurl"));
				al.add(ns);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}
}
