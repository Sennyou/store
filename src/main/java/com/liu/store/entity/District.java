package com.liu.store.entity;

import java.util.Objects;
//省市区实体类
public class District {
    private Integer id;
    private String code;
    private String name;
    private String parent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof District)) return false;
        District district = (District) o;
        return Objects.equals(getId(), district.getId()) && Objects.equals(getCode(), district.getCode()) && Objects.equals(getName(), district.getName()) && Objects.equals(getParent(), district.getParent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCode(), getName(), getParent());
    }

    @Override
    public String toString() {
        return "District{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", parent='" + parent + '\'' +
                '}';
    }
}
