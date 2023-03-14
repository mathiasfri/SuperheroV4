package com.example.superherov4.Model;

public class Superhero {
    private int superheroID;
    private String heroName;
    private String realName;

    private int creationYear;

    public Superhero(int superheroID, String heroName, String realName, int creationYear)
    {
        this.superheroID = superheroID;
        this.heroName = heroName;
        this.realName = realName;
        this.creationYear = creationYear;
    }

    public String getHeroName(){
        return heroName;
    }

    public void setHeroName(String heroName){
        this.heroName = heroName;
    }

    public String getRealName(){
        return realName;
    }

    public void setRealName(String realName){
        this.realName = realName;
    }

    public int getSuperheroID() {
        return superheroID;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public void setSuperheroID(int superheroID) {
        this.superheroID = superheroID;
    }

    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }

    @Override
    public String toString() {
        return  "ID: " + superheroID + "\n" +
                "Hero Name: " + heroName + "\n" +
                "Real name: " + realName + "\n" +
                "Creation Year: " + creationYear + "\n";
    }
}

