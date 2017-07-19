package com.lrest.server.entity.user;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/7/19.
 */
@Entity
@Table(name = "t_user", schema = "test", catalog = "")
public class TUserEntity {
    private Integer id;
    private Integer roleNum;
    private String loginName;
    private String loginPwd;
    private String userName;
    private String nickName;
    private Integer sex;
    private String cellphone;
    private String email;
    private Integer fileUserIconId;
    private String birthdate;
    private String remark;
    private Integer createUserId;
    private Long createTime;
    private Integer isDelete;

    @Id
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ROLE_NUM", nullable = true)
    public Integer getRoleNum() {
        return roleNum;
    }

    public void setRoleNum(Integer roleNum) {
        this.roleNum = roleNum;
    }

    @Basic
    @Column(name = "LOGIN_NAME", nullable = true, length = 100)
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Basic
    @Column(name = "LOGIN_PWD", nullable = false, length = 100)
    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    @Basic
    @Column(name = "USER_NAME", nullable = true, length = 100)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "NICK_NAME", nullable = true, length = 50)
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Basic
    @Column(name = "SEX", nullable = true)
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "CELLPHONE", nullable = false, length = 50)
    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    @Basic
    @Column(name = "EMAIL", nullable = true, length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "FILE_USER_ICON_ID", nullable = true)
    public Integer getFileUserIconId() {
        return fileUserIconId;
    }

    public void setFileUserIconId(Integer fileUserIconId) {
        this.fileUserIconId = fileUserIconId;
    }

    @Basic
    @Column(name = "BIRTHDATE", nullable = true, length = 20)
    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    @Basic
    @Column(name = "REMARK", nullable = true, length = 500)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "CREATE_USER_ID", nullable = true)
    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    @Basic
    @Column(name = "CREATE_TIME", nullable = true)
    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "IS_DELETE", nullable = true)
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TUserEntity that = (TUserEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (roleNum != null ? !roleNum.equals(that.roleNum) : that.roleNum != null) return false;
        if (loginName != null ? !loginName.equals(that.loginName) : that.loginName != null) return false;
        if (loginPwd != null ? !loginPwd.equals(that.loginPwd) : that.loginPwd != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (nickName != null ? !nickName.equals(that.nickName) : that.nickName != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        if (cellphone != null ? !cellphone.equals(that.cellphone) : that.cellphone != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (fileUserIconId != null ? !fileUserIconId.equals(that.fileUserIconId) : that.fileUserIconId != null)
            return false;
        if (birthdate != null ? !birthdate.equals(that.birthdate) : that.birthdate != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (createUserId != null ? !createUserId.equals(that.createUserId) : that.createUserId != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (isDelete != null ? !isDelete.equals(that.isDelete) : that.isDelete != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (roleNum != null ? roleNum.hashCode() : 0);
        result = 31 * result + (loginName != null ? loginName.hashCode() : 0);
        result = 31 * result + (loginPwd != null ? loginPwd.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (nickName != null ? nickName.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (cellphone != null ? cellphone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (fileUserIconId != null ? fileUserIconId.hashCode() : 0);
        result = 31 * result + (birthdate != null ? birthdate.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (createUserId != null ? createUserId.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (isDelete != null ? isDelete.hashCode() : 0);
        return result;
    }
}
