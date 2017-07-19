package com.lrest.server.entity.user;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/7/19.
 */
@Entity
@Table(name = "t_func_tree", schema = "test", catalog = "")
public class TFuncTreeEntity {
    private Integer id;
    private Integer pid;
    private String funcTitle;
    private Integer platform;
    private String funcCode;
    private Integer seq;

    @Id
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "PID", nullable = false)
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Basic
    @Column(name = "FUNC_TITLE", nullable = false, length = 200)
    public String getFuncTitle() {
        return funcTitle;
    }

    public void setFuncTitle(String funcTitle) {
        this.funcTitle = funcTitle;
    }

    @Basic
    @Column(name = "PLATFORM", nullable = false)
    public Integer getPlatform() {
        return platform;
    }

    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    @Basic
    @Column(name = "FUNC_CODE", nullable = false, length = 200)
    public String getFuncCode() {
        return funcCode;
    }

    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode;
    }

    @Basic
    @Column(name = "SEQ", nullable = false)
    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TFuncTreeEntity that = (TFuncTreeEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (pid != null ? !pid.equals(that.pid) : that.pid != null) return false;
        if (funcTitle != null ? !funcTitle.equals(that.funcTitle) : that.funcTitle != null) return false;
        if (platform != null ? !platform.equals(that.platform) : that.platform != null) return false;
        if (funcCode != null ? !funcCode.equals(that.funcCode) : that.funcCode != null) return false;
        if (seq != null ? !seq.equals(that.seq) : that.seq != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (pid != null ? pid.hashCode() : 0);
        result = 31 * result + (funcTitle != null ? funcTitle.hashCode() : 0);
        result = 31 * result + (platform != null ? platform.hashCode() : 0);
        result = 31 * result + (funcCode != null ? funcCode.hashCode() : 0);
        result = 31 * result + (seq != null ? seq.hashCode() : 0);
        return result;
    }
}
