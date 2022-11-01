package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class product_sql {
	private String idx;
	private String plarge_cate;
	private String psmall_cate;
	private String pcode;
	private String pname;
	private String psub_ex;
	private String pprice;
	private String ppercent;
	private String psale;
	private String pstock;
	private String puse;
	private String psoldout;
	private String pimg1;
	private String pimg2;
	private String pimg3;
	private String p_ex;
	
	

	public ArrayList<product_sql> select(String a, String b,String c, String d){
		tools t = new tools();
		Connection con = t.dbcon();
		String sql = "";
		PreparedStatement ps = null;
		ArrayList<product_sql> al = new ArrayList<product_sql>();
		try {
			if(a.equals("name")) {
				if(d.equals("all")) {
					sql = "select * from product where pname like ? order by idx desc";					
				}
				else {
					sql = "select * from product where pname like ? order by idx desc limit "+c+","+d;
				}
				ps = con.prepareStatement(sql);
				ps.setString(1, "%"+b+"%");
			}
			else if(a.equals("code")) {
				if(d.equals("all")) {
					sql = "select * from product where pcode like ? order by idx";
				}
				else {
					sql = "select * from product where pcode like ? order by idx desc limit "+c+","+d;
				}
				
				ps = con.prepareStatement(sql);
				ps.setString(1, "%"+b+"%");
			}
			else if(a.equals("limit")) {
				sql = "select * from product order by idx desc limit "+b+","+c;
				ps = con.prepareStatement(sql);
			}
			else if(a.equals("codeck")) {
				sql = "select * from product where pcode="+b;
				ps = con.prepareStatement(sql);
			}
			else {
				sql = "select * from product order by idx desc";
				ps = con.prepareStatement(sql);
			}
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				product_sql pd = new product_sql();
				pd.setIdx(rs.getString("idx"));
				pd.setPlarge_cate(rs.getString("plarge_cate"));
				pd.setPsmall_cate(rs.getString("psmall_cate"));
				pd.setPcode(rs.getString("pcode"));
				pd.setPname(rs.getString("pname"));
				pd.setPsub_ex(rs.getString("psub_ex"));
				pd.setPprice(rs.getString("pprice"));
				pd.setPpercent(rs.getString("ppercent"));
				pd.setPsale(rs.getString("psale"));
				pd.setPstock(rs.getString("pstock"));
				pd.setPuse(rs.getString("puse"));
				pd.setPsoldout(rs.getString("psoldout"));
				pd.setPimg1(rs.getString("pimg1"));
				pd.setPimg2(rs.getString("pimg2"));
				pd.setPimg3(rs.getString("pimg3"));
				pd.setP_ex(rs.getString("p_ex"));
				al.add(pd);
			}
			
		}catch (Exception e) {
		}
		
		
		return al;
	}
	
	public boolean insert(ArrayList<String> al, String x) {
		boolean b = false;
		tools t = new tools();
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = "insert into product values('0',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			con = t.dbcon();
			ps = con.prepareStatement(sql);
			for(int i =0; i<al.size();i++) {
				ps.setString(i+1, al.get(i));
			}
			int a = ps.executeUpdate();
			if(a>0)
				b = true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return b;
	}
	
	public boolean delete(String aa, String a, String b) {
		boolean bool = false;
		tools t = new tools();
		Connection con = null;
		PreparedStatement ps = null; 
		String sql = "";
		try {
			con = t.dbcon();
			if(aa.equals("idx")) {
				sql = "delete from product where idx="+a;
				ps = con.prepareStatement(sql);
			}
			else if(aa.equals("lcate")) {
				sql = "delete from product where plarge_cate="+a+" and psmall_cate="+b;
				ps = con.prepareStatement(sql);
			}
			int x = ps.executeUpdate();
			if(x>0) {
				bool = true;
			}
			
		} catch (Exception e) {
		}
		
		
		return bool;
	}
	
	
	
	public String getIdx() {
		return idx;
	}

	public void setIdx(String idx) {
		this.idx = idx;
	}

	public String getPlarge_cate() {
		return plarge_cate;
	}

	public void setPlarge_cate(String plarge_cate) {
		this.plarge_cate = plarge_cate;
	}

	public String getPsmall_cate() {
		return psmall_cate;
	}

	public void setPsmall_cate(String psmall_cate) {
		this.psmall_cate = psmall_cate;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPsub_ex() {
		return psub_ex;
	}

	public void setPsub_ex(String psub_ex) {
		this.psub_ex = psub_ex;
	}

	public String getPprice() {
		return pprice;
	}

	public void setPprice(String pprice) {
		this.pprice = pprice;
	}

	public String getPpercent() {
		return ppercent;
	}

	public void setPpercent(String ppercent) {
		this.ppercent = ppercent;
	}

	public String getPsale() {
		return psale;
	}

	public void setPsale(String psale) {
		this.psale = psale;
	}

	public String getPstock() {
		return pstock;
	}

	public void setPstock(String pstock) {
		this.pstock = pstock;
	}

	public String getPuse() {
		return puse;
	}

	public void setPuse(String puse) {
		this.puse = puse;
	}

	public String getPsoldout() {
		return psoldout;
	}

	public void setPsoldout(String psoldout) {
		this.psoldout = psoldout;
	}

	public String getPimg1() {
		return pimg1;
	}

	public void setPimg1(String pimg1) {
		this.pimg1 = pimg1;
	}

	public String getPimg2() {
		return pimg2;
	}

	public void setPimg2(String pimg2) {
		this.pimg2 = pimg2;
	}

	public String getPimg3() {
		return pimg3;
	}

	public void setPimg3(String pimg3) {
		this.pimg3 = pimg3;
	}

	public String getP_ex() {
		return p_ex;
	}

	public void setP_ex(String p_ex) {
		this.p_ex = p_ex;
	}
	
	
	
	
	
	
	
	
	
	
	
}
