package com.lrest.server.entity.food;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/7/19.
 */
@Entity
@Table(name = "food_food", schema = "test", catalog = "")
public class FoodFoodEntity {
    private Integer id;
    private Integer foodKindId;
    private String code;
    private String name;
    private String alias;
    private String thumbImageUrl;
    private String isLiquid;
    private Integer healthLight;
    private Integer weight;
    private BigDecimal calory;
    private BigDecimal fat;
    private BigDecimal protein;
    private BigDecimal fiberDietary;
    private BigDecimal carbohydrate;
    private BigDecimal vitaminA;
    private BigDecimal thiamine;
    private BigDecimal lactoflavin;
    private BigDecimal vitaminC;
    private BigDecimal vitaminE;
    private BigDecimal niacin;
    private BigDecimal natrium;
    private BigDecimal calcium;
    private BigDecimal iron;
    private BigDecimal kalium;
    private BigDecimal iodine;
    private BigDecimal zinc;
    private BigDecimal selenium;
    private BigDecimal magnesium;
    private BigDecimal copper;
    private BigDecimal manganese;
    private BigDecimal cholesterol;
    private String createTime;

    @Id
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "FOOD_KIND_ID", nullable = true)
    public Integer getFoodKindId() {
        return foodKindId;
    }

    public void setFoodKindId(Integer foodKindId) {
        this.foodKindId = foodKindId;
    }

    @Basic
    @Column(name = "CODE", nullable = true, length = 100)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "NAME", nullable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "ALIAS", nullable = true, length = 50)
    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Basic
    @Column(name = "THUMB_IMAGE_URL", nullable = true, length = 200)
    public String getThumbImageUrl() {
        return thumbImageUrl;
    }

    public void setThumbImageUrl(String thumbImageUrl) {
        this.thumbImageUrl = thumbImageUrl;
    }

    @Basic
    @Column(name = "IS_LIQUID", nullable = true, length = 18)
    public String getIsLiquid() {
        return isLiquid;
    }

    public void setIsLiquid(String isLiquid) {
        this.isLiquid = isLiquid;
    }

    @Basic
    @Column(name = "HEALTH_LIGHT", nullable = true)
    public Integer getHealthLight() {
        return healthLight;
    }

    public void setHealthLight(Integer healthLight) {
        this.healthLight = healthLight;
    }

    @Basic
    @Column(name = "WEIGHT", nullable = true)
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "CALORY", nullable = true, precision = 1)
    public BigDecimal getCalory() {
        return calory;
    }

    public void setCalory(BigDecimal calory) {
        this.calory = calory;
    }

    @Basic
    @Column(name = "FAT", nullable = true, precision = 1)
    public BigDecimal getFat() {
        return fat;
    }

    public void setFat(BigDecimal fat) {
        this.fat = fat;
    }

    @Basic
    @Column(name = "PROTEIN", nullable = true, precision = 1)
    public BigDecimal getProtein() {
        return protein;
    }

    public void setProtein(BigDecimal protein) {
        this.protein = protein;
    }

    @Basic
    @Column(name = "FIBER_DIETARY", nullable = true, precision = 1)
    public BigDecimal getFiberDietary() {
        return fiberDietary;
    }

    public void setFiberDietary(BigDecimal fiberDietary) {
        this.fiberDietary = fiberDietary;
    }

    @Basic
    @Column(name = "CARBOHYDRATE", nullable = true, precision = 1)
    public BigDecimal getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(BigDecimal carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    @Basic
    @Column(name = "VITAMIN_A", nullable = true, precision = 1)
    public BigDecimal getVitaminA() {
        return vitaminA;
    }

    public void setVitaminA(BigDecimal vitaminA) {
        this.vitaminA = vitaminA;
    }

    @Basic
    @Column(name = "THIAMINE", nullable = true, precision = 1)
    public BigDecimal getThiamine() {
        return thiamine;
    }

    public void setThiamine(BigDecimal thiamine) {
        this.thiamine = thiamine;
    }

    @Basic
    @Column(name = "LACTOFLAVIN", nullable = true, precision = 1)
    public BigDecimal getLactoflavin() {
        return lactoflavin;
    }

    public void setLactoflavin(BigDecimal lactoflavin) {
        this.lactoflavin = lactoflavin;
    }

    @Basic
    @Column(name = "VITAMIN_C", nullable = true, precision = 1)
    public BigDecimal getVitaminC() {
        return vitaminC;
    }

    public void setVitaminC(BigDecimal vitaminC) {
        this.vitaminC = vitaminC;
    }

    @Basic
    @Column(name = "VITAMIN_E", nullable = true, precision = 1)
    public BigDecimal getVitaminE() {
        return vitaminE;
    }

    public void setVitaminE(BigDecimal vitaminE) {
        this.vitaminE = vitaminE;
    }

    @Basic
    @Column(name = "NIACIN", nullable = true, precision = 1)
    public BigDecimal getNiacin() {
        return niacin;
    }

    public void setNiacin(BigDecimal niacin) {
        this.niacin = niacin;
    }

    @Basic
    @Column(name = "NATRIUM", nullable = true, precision = 1)
    public BigDecimal getNatrium() {
        return natrium;
    }

    public void setNatrium(BigDecimal natrium) {
        this.natrium = natrium;
    }

    @Basic
    @Column(name = "CALCIUM", nullable = true, precision = 1)
    public BigDecimal getCalcium() {
        return calcium;
    }

    public void setCalcium(BigDecimal calcium) {
        this.calcium = calcium;
    }

    @Basic
    @Column(name = "IRON", nullable = true, precision = 1)
    public BigDecimal getIron() {
        return iron;
    }

    public void setIron(BigDecimal iron) {
        this.iron = iron;
    }

    @Basic
    @Column(name = "KALIUM", nullable = true, precision = 1)
    public BigDecimal getKalium() {
        return kalium;
    }

    public void setKalium(BigDecimal kalium) {
        this.kalium = kalium;
    }

    @Basic
    @Column(name = "IODINE", nullable = true, precision = 1)
    public BigDecimal getIodine() {
        return iodine;
    }

    public void setIodine(BigDecimal iodine) {
        this.iodine = iodine;
    }

    @Basic
    @Column(name = "ZINC", nullable = true, precision = 1)
    public BigDecimal getZinc() {
        return zinc;
    }

    public void setZinc(BigDecimal zinc) {
        this.zinc = zinc;
    }

    @Basic
    @Column(name = "SELENIUM", nullable = true, precision = 1)
    public BigDecimal getSelenium() {
        return selenium;
    }

    public void setSelenium(BigDecimal selenium) {
        this.selenium = selenium;
    }

    @Basic
    @Column(name = "MAGNESIUM", nullable = true, precision = 1)
    public BigDecimal getMagnesium() {
        return magnesium;
    }

    public void setMagnesium(BigDecimal magnesium) {
        this.magnesium = magnesium;
    }

    @Basic
    @Column(name = "COPPER", nullable = true, precision = 1)
    public BigDecimal getCopper() {
        return copper;
    }

    public void setCopper(BigDecimal copper) {
        this.copper = copper;
    }

    @Basic
    @Column(name = "MANGANESE", nullable = true, precision = 1)
    public BigDecimal getManganese() {
        return manganese;
    }

    public void setManganese(BigDecimal manganese) {
        this.manganese = manganese;
    }

    @Basic
    @Column(name = "CHOLESTEROL", nullable = true, precision = 1)
    public BigDecimal getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(BigDecimal cholesterol) {
        this.cholesterol = cholesterol;
    }

    @Basic
    @Column(name = "CREATE_TIME", nullable = true, length = 32)
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FoodFoodEntity that = (FoodFoodEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (foodKindId != null ? !foodKindId.equals(that.foodKindId) : that.foodKindId != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (alias != null ? !alias.equals(that.alias) : that.alias != null) return false;
        if (thumbImageUrl != null ? !thumbImageUrl.equals(that.thumbImageUrl) : that.thumbImageUrl != null)
            return false;
        if (isLiquid != null ? !isLiquid.equals(that.isLiquid) : that.isLiquid != null) return false;
        if (healthLight != null ? !healthLight.equals(that.healthLight) : that.healthLight != null) return false;
        if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;
        if (calory != null ? !calory.equals(that.calory) : that.calory != null) return false;
        if (fat != null ? !fat.equals(that.fat) : that.fat != null) return false;
        if (protein != null ? !protein.equals(that.protein) : that.protein != null) return false;
        if (fiberDietary != null ? !fiberDietary.equals(that.fiberDietary) : that.fiberDietary != null) return false;
        if (carbohydrate != null ? !carbohydrate.equals(that.carbohydrate) : that.carbohydrate != null) return false;
        if (vitaminA != null ? !vitaminA.equals(that.vitaminA) : that.vitaminA != null) return false;
        if (thiamine != null ? !thiamine.equals(that.thiamine) : that.thiamine != null) return false;
        if (lactoflavin != null ? !lactoflavin.equals(that.lactoflavin) : that.lactoflavin != null) return false;
        if (vitaminC != null ? !vitaminC.equals(that.vitaminC) : that.vitaminC != null) return false;
        if (vitaminE != null ? !vitaminE.equals(that.vitaminE) : that.vitaminE != null) return false;
        if (niacin != null ? !niacin.equals(that.niacin) : that.niacin != null) return false;
        if (natrium != null ? !natrium.equals(that.natrium) : that.natrium != null) return false;
        if (calcium != null ? !calcium.equals(that.calcium) : that.calcium != null) return false;
        if (iron != null ? !iron.equals(that.iron) : that.iron != null) return false;
        if (kalium != null ? !kalium.equals(that.kalium) : that.kalium != null) return false;
        if (iodine != null ? !iodine.equals(that.iodine) : that.iodine != null) return false;
        if (zinc != null ? !zinc.equals(that.zinc) : that.zinc != null) return false;
        if (selenium != null ? !selenium.equals(that.selenium) : that.selenium != null) return false;
        if (magnesium != null ? !magnesium.equals(that.magnesium) : that.magnesium != null) return false;
        if (copper != null ? !copper.equals(that.copper) : that.copper != null) return false;
        if (manganese != null ? !manganese.equals(that.manganese) : that.manganese != null) return false;
        if (cholesterol != null ? !cholesterol.equals(that.cholesterol) : that.cholesterol != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (foodKindId != null ? foodKindId.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (alias != null ? alias.hashCode() : 0);
        result = 31 * result + (thumbImageUrl != null ? thumbImageUrl.hashCode() : 0);
        result = 31 * result + (isLiquid != null ? isLiquid.hashCode() : 0);
        result = 31 * result + (healthLight != null ? healthLight.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (calory != null ? calory.hashCode() : 0);
        result = 31 * result + (fat != null ? fat.hashCode() : 0);
        result = 31 * result + (protein != null ? protein.hashCode() : 0);
        result = 31 * result + (fiberDietary != null ? fiberDietary.hashCode() : 0);
        result = 31 * result + (carbohydrate != null ? carbohydrate.hashCode() : 0);
        result = 31 * result + (vitaminA != null ? vitaminA.hashCode() : 0);
        result = 31 * result + (thiamine != null ? thiamine.hashCode() : 0);
        result = 31 * result + (lactoflavin != null ? lactoflavin.hashCode() : 0);
        result = 31 * result + (vitaminC != null ? vitaminC.hashCode() : 0);
        result = 31 * result + (vitaminE != null ? vitaminE.hashCode() : 0);
        result = 31 * result + (niacin != null ? niacin.hashCode() : 0);
        result = 31 * result + (natrium != null ? natrium.hashCode() : 0);
        result = 31 * result + (calcium != null ? calcium.hashCode() : 0);
        result = 31 * result + (iron != null ? iron.hashCode() : 0);
        result = 31 * result + (kalium != null ? kalium.hashCode() : 0);
        result = 31 * result + (iodine != null ? iodine.hashCode() : 0);
        result = 31 * result + (zinc != null ? zinc.hashCode() : 0);
        result = 31 * result + (selenium != null ? selenium.hashCode() : 0);
        result = 31 * result + (magnesium != null ? magnesium.hashCode() : 0);
        result = 31 * result + (copper != null ? copper.hashCode() : 0);
        result = 31 * result + (manganese != null ? manganese.hashCode() : 0);
        result = 31 * result + (cholesterol != null ? cholesterol.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
