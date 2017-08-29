package com.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class UserEntity {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "USERNAME", nullable = false, unique = true)
    private String username;
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    @Column(name = "SEX")
    private boolean sex = false;
    @Column(name = "AGE")
    private Integer age;
    @Column(name = "XUEHAO")
    private String xuehao;
    @Column(name = "BANJI")
    private String banji;
    @Column(name = "BIRTH")
    private String birth;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSex() {
        return this.sex;
    }

    public void setSex(Boolean sex) {
        if (sex == null) {
            sex = false;
        }
        this.sex = sex;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        if (age == null) {
            age = 0;
        }
        this.age = age;
    }

    public String getXuehao() {
        return this.xuehao;
    }

    public void setXuehao(String xuehao) {
        this.xuehao = xuehao;
    }

    public String getBanji() {
        return this.banji;
    }

    public void setBanji(String banji) {
        this.banji = banji;
    }

    public String getBirth() {
        return this.birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

}