package com.zte.entity;

import java.util.Date;

public class User {
/*	  HU_USER_ID       NUMBER(10)  PRIMARY KEY,
	  HU_USER_NAME     VARCHAR2(20) not null,
	  HU_PASSWORD      VARCHAR2(20) not null,
	  HU_SEX           CHAR(2) not null,
	  HU_BIRTHDAY      DATE,
	  HU_IDENTITY_CODE VARCHAR2(60),
	  HU_EMAIL         VARCHAR2(80),
	  HU_MOBILE        VARCHAR2(11),
	  HU_ADDRESS       VARCHAR2(200) not null,
	  HU_STATUS        NUMBER(6) not null*/
	
	private int userId;//唯一id
	private String userName;//姓名
	private String password;//密码
	private String sex;//性别
	private Date birthday;//出生日期
	private String identityCode;//身份证号
	private String email;//邮箱
	private String mobile;//手机号
	private String address;//地址
	private int status;//状态标识
	public User() {
		
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getIdentityCode() {
		return identityCode;
	}
	public void setIdentityCode(String identityCode) {
		this.identityCode = identityCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public User(int userId, String userName, String password, String sex, Date birthday, String identityCode,
			String email, String mobile, String address, int status) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.sex = sex;
		this.birthday = birthday;
		this.identityCode = identityCode;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.status = status;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", sex=" + sex
				+ ", birthday=" + birthday + ", identityCode=" + identityCode + ", email=" + email + ", mobile="
				+ mobile + ", address=" + address + ", status=" + status + "]";
	}
	
	
}
