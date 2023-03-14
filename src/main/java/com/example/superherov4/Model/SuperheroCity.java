package com.example.superherov4.Model;

public class SuperheroCity {
    private String heroName;
    private String city;

    public SuperheroCity(String heroName, String city){
        this.heroName = heroName;
        this.city = city;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return  "Hero name: " + heroName +
                "City: " + city;
    }
}
