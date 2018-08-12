package org.kxrtik.spring.spring_data_learn.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;

@Entity
@Table(name = "category")
public class Category {

    private BigInteger id;
    private String name;
    private String tag;

    public Category() {}

    public Category(String name, String tag) {
        this.name = name;
        this.tag = tag;
    }

    public Category(BigInteger id, String name, String tag) {
        this.id = id;
        this.name = name;
        this.tag = tag;
    }

    @Id
    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;

        Category category = (Category) o;

        if (!getId().equals(category.getId())) return false;
        if (getName() != null ? !getName().equals(category.getName()) : category.getName() != null) return false;
        return getTag() != null ? getTag().equals(category.getTag()) : category.getTag() == null;
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getTag() != null ? getTag().hashCode() : 0);
        return result;
    }
}
