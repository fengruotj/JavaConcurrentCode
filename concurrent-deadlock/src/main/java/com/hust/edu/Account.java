package com.hust.edu;

/**
 * locate com.hust.edu
 * Created by MasterTj on 2019/1/10.
 */
public class Account {
    private int id;
    private String name;

    public Account(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Account() {
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

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
