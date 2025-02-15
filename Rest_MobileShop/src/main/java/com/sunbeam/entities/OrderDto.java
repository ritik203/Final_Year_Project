

package com.sunbeam.entities;

public class OrderDto {
	private int id;
	private User user;
	private Mobile mobile;
	public OrderDto() {
	}
	public OrderDto(int id, User user, Mobile mobile) {
		this.id = id;
		this.user = user;
		this.mobile = mobile;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Mobile getMobile() {
		return mobile;
	}
	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "OrderDto [id=" + id + ", user=" + user + ", mobile=" + mobile + "]";
	}
}
