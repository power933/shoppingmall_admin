package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class setting_select {

	private String stitle;
	private String semail;
	private String spointuse;
	private String sbasicpoint;
	private String sbasiclevel;
	private String scompany_name;
	private String sbn;
	private String schairman;
	private String stel;
	private String stn;
	private String ssub_bn;
	private String spost;
	private String saddr;
	private String sres_name;
	private String sres_email;
	private String sbank_name;
	private String sbank_num;
	private String suse_card;
	private String suse_tel;
	private String suse_book;
	private String spoint_least;
	private String spoint_limit;
	private String suse_receipt;
	private String sdelivery_name;
	private String sdelivery_payment;
	private String suse_hopedate;
	public String getStitle() {
		return stitle;
	}
	public void setStitle(String stitle) {
		this.stitle = stitle;
	}
	public String getSemail() {
		return semail;
	}
	public void setSemail(String semail) {
		this.semail = semail;
	}
	public String getSpointuse() {
		return spointuse;
	}
	public void setSpointuse(String spointuse) {
		this.spointuse = spointuse;
	}
	public String getSbasicpoint() {
		return sbasicpoint;
	}
	public void setSbasicpoint(String sbasicpoint) {
		this.sbasicpoint = sbasicpoint;
	}
	public String getSbasiclevel() {
		return sbasiclevel;
	}
	public void setSbasiclevel(String sbasiclevel) {
		this.sbasiclevel = sbasiclevel;
	}
	public String getScompany_name() {
		return scompany_name;
	}
	public void setScompany_name(String scompany_name) {
		this.scompany_name = scompany_name;
	}
	public String getSbn() {
		return sbn;
	}
	public void setSbn(String sbn) {
		this.sbn = sbn;
	}
	public String getSchairman() {
		return schairman;
	}
	public void setSchairman(String schairman) {
		this.schairman = schairman;
	}
	public String getStel() {
		return stel;
	}
	public void setStel(String stel) {
		this.stel = stel;
	}
	public String getStn() {
		return stn;
	}
	public void setStn(String stn) {
		this.stn = stn;
	}
	public String getSsub_bn() {
		return ssub_bn;
	}
	public void setSsub_bn(String ssub_bn) {
		this.ssub_bn = ssub_bn;
	}
	public String getSpost() {
		return spost;
	}
	public void setSpost(String spost) {
		this.spost = spost;
	}
	public String getSaddr() {
		return saddr;
	}
	public void setSaddr(String saddr) {
		this.saddr = saddr;
	}
	public String getSres_name() {
		return sres_name;
	}
	public void setSres_name(String sres_name) {
		this.sres_name = sres_name;
	}
	public String getSres_email() {
		return sres_email;
	}
	public void setSres_email(String sres_email) {
		this.sres_email = sres_email;
	}
	public String getSbank_name() {
		return sbank_name;
	}
	public void setSbank_name(String sbank_name) {
		this.sbank_name = sbank_name;
	}
	public String getSbank_num() {
		return sbank_num;
	}
	public void setSbank_num(String sbank_num) {
		this.sbank_num = sbank_num;
	}
	public String getSuse_card() {
		return suse_card;
	}
	public void setSuse_card(String suse_card) {
		this.suse_card = suse_card;
	}
	public String getSuse_tel() {
		return suse_tel;
	}
	public void setSuse_tel(String suse_tel) {
		this.suse_tel = suse_tel;
	}
	public String getSuse_book() {
		return suse_book;
	}
	public void setSuse_book(String suse_book) {
		this.suse_book = suse_book;
	}
	public String getSpoint_least() {
		return spoint_least;
	}
	public void setSpoint_least(String spoint_least) {
		this.spoint_least = spoint_least;
	}
	public String getSpoint_limit() {
		return spoint_limit;
	}
	public void setSpoint_limit(String spoint_limit) {
		this.spoint_limit = spoint_limit;
	}
	public String getSuse_receipt() {
		return suse_receipt;
	}
	public void setSuse_receipt(String suse_receipt) {
		this.suse_receipt = suse_receipt;
	}
	public String getSdelivery_name() {
		return sdelivery_name;
	}
	public void setSdelivery_name(String sdelivery_name) {
		this.sdelivery_name = sdelivery_name;
	}
	public String getSdelivery_payment() {
		return sdelivery_payment;
	}
	public void setSdelivery_payment(String sdelivery_payment) {
		this.sdelivery_payment = sdelivery_payment;
	}
	public String getSuse_hopedate() {
		return suse_hopedate;
	}
	public void setSuse_hopedate(String suse_hopedate) {
		this.suse_hopedate = suse_hopedate;
	}
	
	public ArrayList<setting_select> select() {
		tools t = new tools();
		ArrayList<setting_select> al = new ArrayList<setting_select>();
		String sql = "select * from setting";
		Connection con = t.dbcon();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				setting_select ss = new setting_select();
				ss.setStitle(rs.getString("stitle"));
				ss.setSemail(rs.getString("semail"));
				ss.setSpointuse(rs.getString("spointuse"));
				ss.setSbasicpoint(rs.getString("sbasicpoint"));
				ss.setSbasiclevel(rs.getString("sbasiclevel"));
				ss.setScompany_name(rs.getString("scompany_name"));
				ss.setSbn(rs.getString("sbn"));
				ss.setSchairman(rs.getString("schairman"));
				ss.setStel(rs.getString("stel"));
				ss.setStn(rs.getString("stn"));
				ss.setSsub_bn(rs.getString("ssub_bn"));
				ss.setSpost(rs.getString("spost"));
				ss.setSaddr(rs.getString("saddr"));
				ss.setSres_name(rs.getString("sres_name"));
				ss.setSres_email(rs.getString("sres_email"));
				ss.setSbank_name(rs.getString("sbank_name"));
				ss.setSbank_num(rs.getString("sbank_num"));
				ss.setSuse_card(rs.getString("suse_card"));
				ss.setSuse_tel(rs.getString("suse_tel"));
				ss.setSuse_book(rs.getString("suse_book"));
				ss.setSpoint_least(rs.getString("spoint_least"));
				ss.setSpoint_limit(rs.getString("spoint_limit"));
				ss.setSuse_receipt(rs.getString("suse_receipt"));
				ss.setSdelivery_name(rs.getString("sdelivery_name"));
				ss.setSdelivery_payment(rs.getString("sdelivery_payment"));
				ss.setSuse_hopedate(rs.getString("suse_hopedate"));
				al.add(ss);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return al;
	}
	
	
}
