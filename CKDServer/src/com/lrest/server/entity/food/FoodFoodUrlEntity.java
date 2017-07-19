package com.lrest.server.entity.food;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator on 2017/7/19.
 */
@Entity
@Table(name = "food_food_url", schema = "test", catalog = "")
public class FoodFoodUrlEntity {
    private String url;
    private String foodKind;
    private Integer id;
    private String data;

    @Basic
    @Column(name = "URL", nullable = true, length = 500)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "FOOD_KIND", nullable = true, length = 255)
    public String getFoodKind() {
        return foodKind;
    }

    public void setFoodKind(String foodKind) {
        this.foodKind = foodKind;
    }

    @Basic
    @Column(name = "ID", nullable = true)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "DATA", nullable = true, length = -1)
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FoodFoodUrlEntity that = (FoodFoodUrlEntity) o;

        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (foodKind != null ? !foodKind.equals(that.foodKind) : that.foodKind != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = url != null ? url.hashCode() : 0;
        result = 31 * result + (foodKind != null ? foodKind.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }
}
