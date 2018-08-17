package org.kxrtik.spring.spring_data_learn.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String name;
    private String tag;

    public Category() {}

    public Category(String name, String tag) {
        this.name = name;
        this.tag = tag;
    }

    public Category(int id, String name, String tag) {
        this.id = id;
        this.name = name;
        this.tag = tag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

        if (!(getId() == category.getId())) return false;
        if (getName() != null ? !getName().equals(category.getName()) : category.getName() != null) return false;
        return getTag() != null ? getTag().equals(category.getTag()) : category.getTag() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getTag() != null ? getTag().hashCode() : 0);
        return result;
    }
}
