package com.cd.activiti.pojo;

/**
 * 获取用户表的相关信息
 * @author shaobing
 *
 */
public class SysUser {
    private Long id;//主键
    
    private String  create_time;//创建时间

    private String  update_time;//更新时间
    
    private Long fkCode;//外键唯一标识

    private Integer delStatus;//删除状态

    private String userAccount;//用户账号

    private String pwd;//用户密码

    private String salt;//要是使用盐值加密的情况下，存储盐值的

    private Long userFkCode;//用户关联的用户fk_code(这里可以是教职工，学生，后期还可以是家长)
    
    
    private Integer identity;//用户的身份(1学生，2家长，3教职工，4教育局用户)，根据个人的身份连表查询的表就不一样

    private Long creatorFkCode;//创建者的fk_code

    private String token;//移动端登录时设置的Token(使用UUID)

    private java.util.Date expiredDate;//Token过期时间

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}

	public Long getFkCode() {
		return fkCode;
	}

	public void setFkCode(Long fkCode) {
		this.fkCode = fkCode;
	}

	public Integer getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(Integer delStatus) {
		this.delStatus = delStatus;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Long getUserFkCode() {
		return userFkCode;
	}

	public void setUserFkCode(Long userFkCode) {
		this.userFkCode = userFkCode;
	}

	public Integer getIdentity() {
		return identity;
	}

	public void setIdentity(Integer identity) {
		this.identity = identity;
	}

	public Long getCreatorFkCode() {
		return creatorFkCode;
	}

	public void setCreatorFkCode(Long creatorFkCode) {
		this.creatorFkCode = creatorFkCode;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public java.util.Date getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(java.util.Date expiredDate) {
		this.expiredDate = expiredDate;
	}


}
