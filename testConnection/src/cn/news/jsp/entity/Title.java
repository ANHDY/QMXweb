package cn.news.jsp.entity;

import java.sql.Date;

public class Title {
/**
　　　　　*下面这四个属性为数据库表中的四个属性
　　　　　**/
    private int id;   
    private String name;
    private String password;
    
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
    public String getPassword() {
        return password;
    }
    public void setPassword(String creator) {
        this.password = creator;
    }
    
    public Title(int id, String name, String password) {
        super();
        this.id = id;
        this.name = name;
        this.password = password;
    }
    
}