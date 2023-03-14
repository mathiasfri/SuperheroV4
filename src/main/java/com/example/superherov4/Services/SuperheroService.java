package com.example.superherov4.Services;

import com.example.superherov4.Model.Superhero;
import com.example.superherov4.Model.SuperheroCity;
import com.example.superherov4.Model.SuperheroNumOfPowers;
import com.example.superherov4.Model.SuperheroSuperpower;
import com.example.superherov4.Repositories.SuperheroRepository;

import java.util.List;

public class SuperheroService {
    private SuperheroRepository superheroRepository;

    public SuperheroService() {
        this.superheroRepository = new SuperheroRepository();
    }

    public List<Superhero> getSuperheroes() {
        return superheroRepository.getSuperheroes();
    }

    public List<Superhero> getSuperhero(String name){
        return superheroRepository.getSuperhero(name);
    }

    public List<SuperheroNumOfPowers> getSuperheroesWithPowerCount() {
        return superheroRepository.getSuperheroesWithSuperpowerCount();
    }

    public List<SuperheroNumOfPowers> getSuperheroWithPowerCount(String name){
        return superheroRepository.getSuperheroWithSuperpowerCount(name);
    }

    public List<SuperheroSuperpower> getSuperheroPowers(){
        return superheroRepository.superheroSuperpowers();
    }

    public List<SuperheroSuperpower> getSuperheroPowersSearch(String name){
        return superheroRepository.superheroSuperpowersSearch(name);
    }

    public List<SuperheroCity> getSuperheroCityList(){
        return superheroRepository.superheroCityList();
    }

    public List<SuperheroCity> getSuperheroCitySearch(String name){
        return superheroRepository.superheroCitySearch(name);
    }
}
