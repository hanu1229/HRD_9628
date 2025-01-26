package management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManagementDao {
	private Connection conn;
	private String dburl = "jdbc:mysql://localhost:3306/hrd";
	private String dbuser = "root";
	private String dbpassword = "hanu1229";
	
	// singleton start
	private static ManagementDao instance = new ManagementDao();
	private ManagementDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbuser, dbpassword);
		} catch(ClassNotFoundException e) {
			System.out.println(e);
		} catch(SQLException e) {
			System.out.println(e);
		}
	}
	public static ManagementDao getInstance() { return instance; }
	// singleton end
	
	/**
	 * 회원목록 조회 
	*/
	public ArrayList<MemberListDto> findAll() {
		ArrayList<MemberListDto> result = new ArrayList<>();
		try {
			String sql = "select * from member_tbl_02;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				MemberListDto temp = new MemberListDto();
				temp.setCustno(rs.getInt("CUSTNO")); temp.setCustname(rs.getString("CUSTNAME"));
				temp.setPhone(rs.getString("PHONE")); temp.setAddress(rs.getString("ADDRESS"));
				temp.setJoindate(rs.getString("JOINDATE")); temp.setCity(rs.getString("CITY")); 
				switch(rs.getString("GRADE")) {
					case "A":
						temp.setGrade("VIP");
						break;
					case "B":
						temp.setGrade("일반");
						break;
					case "C":
						temp.setGrade("직원");
						break;
				}
				result.add(temp);
			}
		} catch(SQLException e) {
			System.out.println(e);
		}
		return result;
	}
	
	/**
	 * 회원매출 조회 
	*/
	public ArrayList<SalesDto> salesAll() {
		ArrayList<SalesDto> result = new ArrayList<>();
		try {
			String sql = "select member.custno, member.custname, member.grade, sum(money.price) from money_tbl_02 as money "
					+ "inner join member_tbl_02 as member on member.custno = money.custno "
					+ "group by money.custno order by sum(money.price) desc;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				SalesDto salesDto = new SalesDto();
				salesDto.setCustno(rs.getInt("member.custno")); salesDto.setCustname(rs.getString("member.custname"));
				switch(rs.getString("member.grade")) {
					case "A":
						salesDto.setGrade("VIP");
						break;
					case "B":
						salesDto.setGrade("일반");
						break;
					case "C":
						salesDto.setGrade("직원");
						break;
				}
				salesDto.setPrice(rs.getInt("sum(money.price)"));
				result.add(salesDto);
			}
		} catch(SQLException e) {
			System.out.println(e);
		}
		return result;
	}
	
}
