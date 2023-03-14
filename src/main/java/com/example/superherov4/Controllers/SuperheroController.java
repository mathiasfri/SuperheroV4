package com.example.superherov4.Controllers;

import com.example.superherov4.Model.Superhero;
import com.example.superherov4.Model.SuperheroCity;
import com.example.superherov4.Model.SuperheroNumOfPowers;
import com.example.superherov4.Model.SuperheroSuperpower;
import com.example.superherov4.Services.SuperheroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

// All pathing for the website
@Controller
@RequestMapping("superheroes")
public class SuperheroController {
    private SuperheroService superheroService;

    public SuperheroController(){
        superheroService = new SuperheroService();
    }

    @GetMapping("list")
    public ResponseEntity<List<Superhero>> listSuperheroes(){
        List<Superhero> superheroes = superheroService.getSuperheroes();


        return new ResponseEntity<>(superheroes, HttpStatus.OK);
    }

    @GetMapping("/list/{name}")
    public ResponseEntity<List<Superhero>> listSuperhero(@PathVariable String name){
        List<Superhero> superhero = superheroService.getSuperhero(name);

        return new ResponseEntity<>(superhero, HttpStatus.OK);
    }

    @GetMapping("/superpower/count")
    public ResponseEntity<List<SuperheroNumOfPowers>> superheroesWithPowerCount(){
        List<SuperheroNumOfPowers> superheroes = superheroService.getSuperheroesWithPowerCount();

        return new ResponseEntity<>(superheroes, HttpStatus.OK);
    }

    @GetMapping("/superpower/count/{name}")
    public ResponseEntity<List<SuperheroNumOfPowers>> superheroWithPowerCount(@PathVariable String name){
        List<SuperheroNumOfPowers> superheroes = superheroService.getSuperheroWithPowerCount(name);

        return new ResponseEntity<>(superheroes, HttpStatus.OK);
    }

    @GetMapping("/superpower")
    public ResponseEntity<List<SuperheroSuperpower>> superheroPowers(){
        List<SuperheroSuperpower> superpowers = superheroService.getSuperheroPowers();

        return new ResponseEntity<>(superpowers, HttpStatus.OK);
    }

    @GetMapping("/superpower/{name}")
    public ResponseEntity<List<SuperheroSuperpower>> superheroPowersSearch(@PathVariable String name){
        List<SuperheroSuperpower> superpowers = superheroService.getSuperheroPowersSearch(name);

        return new ResponseEntity<>(superpowers, HttpStatus.OK);
    }

    @GetMapping("/city")
    public ResponseEntity<List<SuperheroCity>> superheroCity(){
        List<SuperheroCity> cities = superheroService.getSuperheroCityList();

        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping("/city/{name}")
    public ResponseEntity<List<SuperheroCity>> superheroCitySearch(@PathVariable String name){
        List<SuperheroCity> cities = superheroService.getSuperheroCitySearch(name);

        return new ResponseEntity<>(cities, HttpStatus.OK);
    }
}
