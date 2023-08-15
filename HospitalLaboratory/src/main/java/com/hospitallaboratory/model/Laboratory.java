package com.hospitallaboratory.model;

public class Laboratory {
	private String category;
	private String testName;
	private Integer testId;
	private double testAmount;
	private int categoryId;
	public Laboratory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Laboratory(String category, String testName, Integer testId, double testAmount, int categoryId) {
		super();
		this.category = category;
		this.testName = testName;
		this.testId = testId;
		this.testAmount = testAmount;
		this.categoryId = categoryId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public Integer getTestId() {
		return testId;
	}
	public void setTestId(Integer testId) {
		this.testId = testId;
	}
	public double getTestAmount() {
		return testAmount;
	}
	public void setTestAmount(double testAmount) {
		this.testAmount = testAmount;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	@Override
	public String toString() {
		return "Laboratory [category=" + category + ", testName=" + testName + ", testId=" + testId + ", testAmount="
				+ testAmount + ", categoryId=" + categoryId + "]";
	}
	
}
