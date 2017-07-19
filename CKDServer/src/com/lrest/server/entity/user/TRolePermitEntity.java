package com.lrest.server.entity.user;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/7/19.
 */
@Entity
@Table(name = "t_role_permit", schema = "test", catalog = "")
public class TRolePermitEntity {
    private Integer id;
    private Integer roleNum;
    private Integer funcTreeId;

    @Id
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ROLE_NUM", nullable = false)
    public Integer getRoleNum() {
        return roleNum;
    }

    public void setRoleNum(Integer roleNum) {
        this.roleNum = roleNum;
    }

    @Basic
    @Column(name = "FUNC_TREE_ID", nullable = false)
    public Integer getFuncTreeId() {
        return funcTreeId;
    }

    public void setFuncTreeId(Integer funcTreeId) {
        this.funcTreeId = funcTreeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TRolePermitEntity that = (TRolePermitEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (roleNum != null ? !roleNum.equals(that.roleNum) : that.roleNum != null) return false;
        if (funcTreeId != null ? !funcTreeId.equals(that.funcTreeId) : that.funcTreeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (roleNum != null ? roleNum.hashCode() : 0);
        result = 31 * result + (funcTreeId != null ? funcTreeId.hashCode() : 0);
        return result;
    }
}
