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
	 * 회원 개별 조회 
	*/
	public MemberListDto find(int custno) {
		MemberListDto result = new MemberListDto();
		try {
			String sql = "select * from MEMBER_TBL_02 where CUSTNO = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, custno);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				result.setCustno(rs.getInt("custno")); result.setCustname(rs.getString("custname"));
				result.setPhone(rs.getString("phone")); result.setAddress(rs.getString("address"));
				result.setJoindate(rs.getString("joindate")); result.setGrade(rs.getString("grade"));
				result.setCity(rs.getString("city"));
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
	
	/**
	 * 회원등록 
	*/
	public boolean create(MemberListDto memberDto) {
		try { // insert into member_tbl_02 values(100001, '김행복', '010-1111-2222', '서울 동대문구 휘경1동', '20151202', 'A', '01');
			String sql = "insert into MEMBER_TBL_02 values (?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, memberDto.getCustno()); ps.setString(2, memberDto.getCustname()); ps.setString(3, memberDto.getPhone());
			ps.setString(4, memberDto.getAddress()); ps.setString(5, memberDto.getJoindate()); ps.setString(6, memberDto.getGrade());
			ps.setString(7, memberDto.getCity());
			int count = ps.executeUpdate();
			if(count == 1) { return true; }
		} catch(SQLException e) {
			System.out.println(e);
		}
		return false;
	}
	
	/**
	 * 회원정보 수정 
	*/
	public boolean update(MemberListDto memberDto) {
		try {
			String sql = "update MEMBER_TBL_02 set CUSTNO = ?, CUSTNAME = ?, PHONE = ?, ADDRESS = ?, JOINDATE = ?, GRADE = ?, CITY = ? "
					+ "where CUSTNO = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, memberDto.getCustno()); ps.setString(2, memberDto.getCustname()); ps.setString(3,  memberDto.getPhone());
			ps.setString(4, memberDto.getAddress()); ps.setString(5, memberDto.getJoindate()); ps.setString(6, memberDto.getGrade());
			ps.setString(7, memberDto.getCity()); ps.setInt(8, memberDto.getCustno());
			int count = ps.executeUpdate();
			if(count == 1) { return true; }
		} catch(SQLException e) {
			System.out.println(e);
		}
		return false;
	}
	
}
