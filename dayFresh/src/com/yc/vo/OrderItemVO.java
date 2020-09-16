package com.yc.vo;

public class OrderItemVO {

	private Integer orderItemNo;
	private String orderNo;
	private Integer goodsNo;
	private Integer nums;
	private Double price;
	private Integer status;
	private Integer typeNo;
	private Integer balance;
	private String goodsName;
	private String intro;
	private String pictures;
	private String unit;
	private String qperied;
	private String weight;
	private String descr;
	@Override
	public String toString() {
		return "OrderItemVO [orderItemNo=" + orderItemNo + ", orderNo=" + orderNo + ", goodsNo=" + goodsNo + ", nums="
				+ nums + ", price=" + price + ", status=" + status + ", typeNo=" + typeNo + ", balance=" + balance
				+ ", goodsName=" + goodsName + ", intro=" + intro + ", pictures=" + pictures + ", unit=" + unit
				+ ", qperied=" + qperied + ", weight=" + weight + ", descr=" + descr + "]";
	}
	public Integer getOrderItemNo() {
		return orderItemNo;
	}
	public void setOrderItemNo(Integer orderItemNo) {
		this.orderItemNo = orderItemNo;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Integer getGoodsNo() {
		return goodsNo;
	}
	public void setGoodsNo(Integer goodsNo) {
		this.goodsNo = goodsNo;
	}
	public Integer getNums() {
		return nums;
	}
	public void setNums(Integer nums) {
		this.nums = nums;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getTypeNo() {
		return typeNo;
	}
	public void setTypeNo(Integer typeNo) {
		this.typeNo = typeNo;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getPictures() {
		return pictures;
	}
	public void setPictures(String pictures) {
		this.pictures = pictures;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getQperied() {
		return qperied;
	}
	public void setQperied(String qperied) {
		this.qperied = qperied;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
}
