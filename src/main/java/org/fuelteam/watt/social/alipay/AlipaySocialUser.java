package org.fuelteam.watt.social.alipay;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class AlipaySocialUser {

    // 用户头像
    private String avatar;

    // 用户昵称
    private String nickName;

    // 详细地址
    private String address;

    // 区县
    private String area;

    // 城市
    private String city;

    // 省份
    private String province;

    // 用户性别, M为男性，F为女性
    private String gender;

    // 用户类型, 1代表公司账户, 2代表个人账户
    private String userType;

    // 是否通过实名认证, T是通过, F是没有实名认证
    private String certified;

    // 证件类型, certified为T才有意义
    private String certType;

    // 证件号码, certified为T才有意义
    private String certNo;

    // 是否是学生
    private String student;

    // 学信网的学校名称
    private String collegeName;

    // 学信网的学历/学位信息
    private String degree;

    // 邮箱登录名
    private String email;

    // 手机号码
    private String mobile;

    // 支付宝用户的userId, 不可空
    private String userId;

    // 个人用户的真实姓名, 企业用户的企业名称
    private String userName;

    // 用户状态（Q/T/B/W）
    private String userStatus;

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getCertified() {
        return certified;
    }

    public void setCertified(String certified) {
        this.certified = certified;
    }

    public String getCertType() {
        return certType;
    }

    public void setCertType(String certType) {
        this.certType = certType;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }
}