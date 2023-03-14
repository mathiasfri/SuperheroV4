package com.example.superherov4.Model;

public class SuperheroSuperpower {
    private String heroName;
    private String realName;
    private String superpowers;

    public SuperheroSuperpower(String heroName, String realName, String superpowers){
        this.heroName = heroName;
        this.realName = realName;
        this.superpowers = superpowers;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSuperpowers() {
        return superpowers;
    }

    public void setSuperpowers(String superpowers) {
        this.superpowers = superpowers;
    }

    @Override
    public String toString() {
        return  "Hero Name: " + heroName +
                "Real Name: " + realName +
                "Superpowers: " + superpowers;
    }
}
