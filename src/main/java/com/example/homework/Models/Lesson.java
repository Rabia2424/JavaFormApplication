package com.example.homework.Models;

public class Lesson {
    private int id;
    private String Name;
    private int Credit;

    public Lesson(){
    }
    public Lesson(int id,String Name,int Credit){
        this.id=id;
        this.Name =Name;
        this.Credit =Credit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {this.id = id;}

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public int getCredit() {
        return Credit;
    }

    public void setCredit(int Credit) {
        this.Credit = Credit;
    }
}
