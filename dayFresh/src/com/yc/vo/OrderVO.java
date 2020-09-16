package com.yc.vo;

public class OrderVO {

	private String orderNo;
	private String orderDate;
	private Integer addrNo;
	private String sdate;
	private String rdate;
	private Integer status;
	private Double price;
	private String invoice;
	
	private Integer memberNo;
	private String name;
	private String tel;
	private String province;
	private String city;
	private String area;
	private String addr;
	private Integer flag;
	@Override
	public String toString() {
		return "OrderVO [orderNo=" + orderNo + ", orderDate=" + orderDate + ", addrNo=" + addrNo + ", sdate=" + sdate
				+ ", rdate=" + rdate + ", status=" + status + ", price=" + price + ", invoice=" + invoice
				+ ", memberNo=" + memberNo + ", name=" + name + ", tel=" + tel + ", province=" + province + ", city="
				+ city + ", area=" + area + ", addr=" + addr + ", flag=" + flag + "]";
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public Integer getAddrNo() {
		return addrNo;
	}
	public void setAddrNo(Integer addrNo) {
		this.addrNo = addrNo;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getInvoice() {
		return invoice;
	}
	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}
	public Integer getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	
	
}
