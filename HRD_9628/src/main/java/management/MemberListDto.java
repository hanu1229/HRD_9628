package management;

public class MemberListDto {
	private int custno;
	private String custname;
	private String phone;
	private String address;
	private String joindate;
	private String grade;
	private String city;
	
	public MemberListDto() {}
	public MemberListDto(int custno, String custname, String phone, String address, String joindate, String grade, String city) {
		super();
		this.custno = custno; this.custname = custname; this.phone = phone;
		this.address = address; this.joindate = joindate;
		this.grade = grade; this.city = city;
	}
	
	// getter
	public int getCustno() {return custno;}
	public String getCustname() {return custname;}
	public String getPhone() {return phone;}
	public String getAddress() {return address;}
	public String getJoindate() {return joindate;}
	public String getGrade() {return grade;}
	public String getCity() {return city;}
	
	// setter
	public void setCustno(int custno) {this.custno = custno;}
	public void setCustname(String custname) {this.custname = custname;}
	public void setPhone(String phone) {this.phone = phone;}
	public void setAddress(String address) {this.address = address;}
	public void setJoindate(String joindate) {this.joindate = joindate;}
	public void setGrade(String grade) {this.grade = grade;}
	public void setCity(String city) {this.city = city;}
	
	// toString
	@Override
	public String toString() {
		return "MemberListDto [custno = " + custno + ", custname = " + custname + ", phone = " + phone + ", address = "
				+ address + ", joindate = " + joindate + ", grade = " + grade + ", city = " + city + "]";
	}
	
}
