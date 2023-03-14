package com.example.superherov4.Model;

public class SuperheroNumOfPowers {
    private String heroName;
    private String realName;
    private int numberOfPowers;

    public SuperheroNumOfPowers(String heroName, String realName, int numberOfPowers){
        this.heroName = heroName;
        this.realName = realName;
        this.numberOfPowers = numberOfPowers;
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

    public int getNumberOfPowers() {
        return numberOfPowers;
    }

    public void setNumberOfPowers(int numberOfPowers) {
        this.numberOfPowers = numberOfPowers;
    }

    @Override
    public String toString() {
        return  "Hero name: " + heroName +
                "Real Name: " + realName +
                "Number of powers: " + numberOfPowers;
    }
}
