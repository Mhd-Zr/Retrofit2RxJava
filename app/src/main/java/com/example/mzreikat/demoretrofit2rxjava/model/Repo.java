package com.example.mzreikat.demoretrofit2rxjava.model;

public class Repo
{
    private int id;
    private String name, full_name;
    private Owner owner;

    public Repo(int id, String name, String full_name, Owner owner) {
        this.id = id;
        this.name = name;
        this.full_name = full_name;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFull_name() {
        return full_name;
    }

    public Owner getOwner() {
        return owner;
    }
}