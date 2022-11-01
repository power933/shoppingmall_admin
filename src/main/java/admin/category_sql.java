package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class category_sql {
	
	private String idx;
	private String ctotal_cate;
	private String clarge_cate;
	private String clarge_name;
	private String clarge_only;
	private String csmaill_cate;
	private String csmaill_name;
	private String cuse;
	
	public boolean insert(ArrayList<String> al) {
		boolean b = false;
		tools t = new tools();
		Connection con = t.dbcon();
		String sql = "insert into category values ('0',?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			for(int i =0; i<al.size();i++) {
				ps.setString(i+1, al.get(i));
			}
			int a = ps.executeUpdate();
			if(a>0) 
				b = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return b;
	}
	
	public ArrayList<category_sql> select(String a, String b,String c, String d){
		tools t = new tools();
		Connection con = t.dbcon();
		String sql = "";
		PreparedStatement ps = null;
		ArrayList<category_sql> al = new ArrayList<category_sql>();
		try {
			if(a.equals("name")) {
				if(d.equals("all")) {
					sql = "select * from category where clarge_name like ? or csmall_name like ? order by idx desc";					
				}
				else {
					sql = "select * from category where clarge_name like ? or csmall_name like ? order by idx desc limit "+c+","+d;
					
				}
				ps = con.prepareStatement(sql);
				ps.setString(1, "%"+b+"%");
				ps.setString(2, "%"+b+"%");
			}
			else if(a.equals("code")) {
				if(d.equals("all")) {
					sql = "select * from category where ctotal_cate like ? or clarge_cate like ? or csmall_cate like ? order by idx";
				}
				else {
					sql = "select * from category where ctotal_cate like ? or clarge_cate like ? or csmall_cate like ? order by idx desc limit "+c+","+d;
				}
				
				ps = con.prepareStatement(sql);
				ps.setString(1, "%"+b+"%");
				ps.setString(2, "%"+b+"%");
				ps.setString(3, "%"+b+"%");
			}
			else if(a.equals("limit")) {
				sql = "select * from category order by idx desc limit "+b+","+c;
				ps = con.prepareStatement(sql);
			}
			else if(a.equals("lck")) {
				sql = "select * from category where clarge_cate="+b;
				ps = con.prepareStatement(sql);
			}
			else if(a.equals("sck")) {
				sql = "select * from category where csmall_cate="+b;
				ps = con.prepareStatement(sql);
			}
			else if(a.equals("idx")) {
				sql = "select * from category where idx="+b;
				ps = con.prepareStatement(sql);
			}
			else if(a.equals("total")) {
				sql = "select * from category where ctotal_cate="+b;
				ps = con.prepareStatement(sql);
			}
			else {
				sql = "select * from category order by idx desc";
				 ps = con.prepareStatement(sql);
			}
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				category_sql cs = new category_sql();
				cs.setIdx(rs.getString("idx"));
				cs.setCtotal_cate(rs.getString("ctotal_cate"));
				cs.setClarge_cate(rs.getString("clarge_cate"));
				cs.setClarge_name(rs.getString("clarge_name"));
				cs.setCuse(rs.getString("cuse"));
				cs.setCsmaill_cate(rs.getString("csmall_cate"));
				cs.setCsmaill_name(rs.getString("csmall_name"));
				cs.setCuse(rs.getString("cuse"));
				al.add(cs);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return al;
	}
	
	public boolean delete(String a) {
		boolean b = false;
		tools t = new tools();
		Connection con = null;
		PreparedStatement ps = null; 
		String sql = "";
		try {
			con = t.dbcon();
			sql = "delete from category where idx="+a;
			ps = con.prepareStatement(sql);
			int x = ps.executeUpdate();
			if(x>0) {
				b = true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return b;
	}
	
	
	
	
	
	
	
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	public String getCtotal_cate() {
		return ctotal_cate;
	}
	public void setCtotal_cate(String ctotal_cate) {
		this.ctotal_cate = ctotal_cate;
	}
	public String getClarge_cate() {
		return clarge_cate;
	}
	public void setClarge_cate(String clarge_cate) {
		this.clarge_cate = clarge_cate;
	}
	public String getClarge_name() {
		return clarge_name;
	}
	public void setClarge_name(String clarge_name) {
		this.clarge_name = clarge_name;
	}
	public String getClarge_only() {
		return clarge_only;
	}
	public void setClarge_only(String clarge_only) {
		this.clarge_only = clarge_only;
	}
	public String getCsmaill_cate() {
		return csmaill_cate;
	}
	public void setCsmaill_cate(String csmaill_cate) {
		this.csmaill_cate = csmaill_cate;
	}
	public String getCsmaill_name() {
		return csmaill_name;
	}
	public void setCsmaill_name(String csmaill_name) {
		this.csmaill_name = csmaill_name;
	}
	public String getCuse() {
		return cuse;
	}
	public void setCuse(String cuse) {
		this.cuse = cuse;
	}
}
