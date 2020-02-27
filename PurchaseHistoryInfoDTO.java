package com.internousdev.rose.dto;

import java.util.Date;

public class PurchaseHistoryInfoDTO {

	private int id;
	private String userId;
	private int productId;
	private String productName;
	private String productNameKana;
	private String imageFilePath;
	private String imageFileName;
	private String releaseCompany;
	private Date releaseDate;
	private int price;
	private int productCount;
	private int subtotal;
	private String familyName;
	private String firstName;
	private String userAddress;

	public int getId() {
		return this.id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getProductId() {
		return this.productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return this.productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductNameKana() {
		return this.productNameKana;
	}
	public void setProductNameKana(String productNameKana) {
		this.productNameKana = productNameKana;
	}
	public String getImageFilePath() {
		return this.imageFilePath;
	}
	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}
	public String getImageFileName() {
		return this.imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	public String getReleaseCompany() {
		return this.releaseCompany;
	}
	public void setReleaseCompany(String releaseCompany) {
		this.releaseCompany = releaseCompany;
	}
	public Date getReleaseDate() {
		return this.releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public int getPrice() {
		return this.price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getProductCount() {
		return this.productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	public int getSubtotal() {
		return this.subtotal;
	}
	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}
	public String getFamilyName() {
		return this.familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public String getFirstName() {
		return this.firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getUserAddress() {
		return this.userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

}
