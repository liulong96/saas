package com.power.saas.entity.user;

import com.power.saas.common.BaseEntity;
import org.apache.ibatis.type.Alias;

import java.lang.Integer;
import java.lang.String;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * <br>
 * <b>功能：</b>用户表 UserEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-01-17 <br>
 */
@Alias("User")
public class User extends BaseEntity{
    //id
	private Integer id;
    //登录名
	private String loginName;
    //登录密码
	private String password;
    //昵称
	private String nickName;
    //姓名
	private String name;
    //性别 0 保密 1男 2女
	private Integer sex;
    //手机号
	private String mobile;
    //出生日期
	private Date birthDay;
    //邮件
	private String email;
    //1 个人 2员工
	private Integer type;
    //经度
	private BigDecimal longitude;
    //纬度
	private BigDecimal latitude;
    //随机串
	private String random;
    //状态 0 无效 1 有效
	private String status;
    //头像
	private Integer headPicId;
    //是否身份认证 0未认证 1已认证
	private Integer cardAuthen;
    //创建日期
	private Date createTime;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getBirthDay() {
		return this.birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public BigDecimal getLongitude() {
		return this.longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public BigDecimal getLatitude() {
		return this.latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public String getRandom() {
		return this.random;
	}

	public void setRandom(String random) {
		this.random = random;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getHeadPicId() {
		return this.headPicId;
	}

	public void setHeadPicId(Integer headPicId) {
		this.headPicId = headPicId;
	}

	public Integer getCardAuthen() {
		return this.cardAuthen;
	}

	public void setCardAuthen(Integer cardAuthen) {
		this.cardAuthen = cardAuthen;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}

