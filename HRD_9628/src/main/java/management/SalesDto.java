package management;

public class SalesDto {
	// 회원번호
	private int custno;
	// 판매번호
	private int salenol;
	// 단가
	private int pcost;
	// 수량
	private int amount;
	// 가격(매출)
	private int price;
	// 상품코드
	private String pcode;
	// 판매일자
	private String sdate;
	// 회원성명
	private String custname;
	// 고객등급
	private String grade;
	
	public SalesDto() {}
	public SalesDto(int custno, int salenol, int pcost, int amount, int price, String pcode, String sdate, String custname, String grade) {
		this.custno = custno; this.salenol = salenol; this.pcost = pcost; this.amount = amount;
		this.price = price; this.pcode = pcode; this.sdate = sdate; this.custname = custname; this.grade = grade;
	}
	
	// getter
	public int getCustno() { return custno; }
	public int getSalenol() { return salenol; }
	public int getPcost() { return pcost; }
	public int getAmount() { return amount; }
	public int getPrice() { return price; }
	public String getPcode() { return pcode; }
	public String getSdate() { return sdate; }
	public String getCustname() { return custname; }
	public String getGrade() { return grade; }
	
	//setter
	public void setCustno(int custno) { this.custno = custno; }
	public void setSalenol(int salenol) { this.salenol = salenol; }
	public void setPcost(int pcost) { this.pcost = pcost; }
	public void setAmount(int amount) { this.amount = amount; }
	public void setPrice(int price) { this.price = price; }
	public void setPcode(String pcode) { this.pcode = pcode; }
	public void setSdate(String sdate) { this.sdate = sdate; }
	public void setCustname(String custname) { this.custname = custname; } 
	public void setGrade(String grade) { this.grade = grade; }
	
	// toString
	@Override
	public String toString() {
		return "SalesDto [custno = " + custno + ", salenol = " + salenol + ", pcost = " + pcost + ", amount = " + amount
				+ ", price = " + price + ", pcode = " + pcode + ", sdate = " + sdate + ", custname = " + custname
				+ ", grade = " + grade + "]";
	}

}
