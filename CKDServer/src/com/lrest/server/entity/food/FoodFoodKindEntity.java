package com.lrest.server.entity.food;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator on 2017/7/19.
 */
@Entity
@Table(name = "food_food_kind", schema = "test", catalog = "")
public class FoodFoodKindEntity {
    private Integer id;
    private String foodKindName;
    private String imageUrl;
    private String description;
    private String foodKind;

    @Basic
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "FOOD_KIND_NAME", nullable = true, length = 50)
    public String getFoodKindName() {
        return foodKindName;
    }

    public void setFoodKindName(String foodKindName) {
        this.foodKindName = foodKindName;
    }

    @Basic
    @Column(name = "IMAGE_URL", nullable = true, length = 255)
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Basic
    @Column(name = "DESCRIPTION", nullable = true, length = 200)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "FOOD_KIND", nullable = true, length = 20)
    public String getFoodKind() {
        return foodKind;
    }

    public void setFoodKind(String foodKind) {
        this.foodKind = foodKind;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FoodFoodKindEntity that = (FoodFoodKindEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (foodKindName != null ? !foodKindName.equals(that.foodKindName) : that.foodKindName != null) return false;
        if (imageUrl != null ? !imageUrl.equals(that.imageUrl) : that.imageUrl != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (foodKind != null ? !foodKind.equals(that.foodKind) : that.foodKind != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (foodKindName != null ? foodKindName.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (foodKind != null ? foodKind.hashCode() : 0);
        return result;
    }
}
