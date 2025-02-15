package com.sunbeam.entities;

public class Order {
    private int id;
    private int userId;
    private int mobileId;
    public Order() {
    }
    public Order(int id, int userId, int mobileId) {
		this.id = id;
		this.userId = userId;
		this.mobileId = mobileId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getMobileId() {
		return mobileId;
	}
	public void setMobileId(int mobileId) {
		this.mobileId = mobileId;
	}
	public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", mobileId=" + mobileId + "]";
	}
}
