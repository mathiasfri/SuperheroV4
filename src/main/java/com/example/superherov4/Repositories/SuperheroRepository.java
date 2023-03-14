package com.example.superherov4.Repositories;

import com.example.superherov4.Model.Superhero;
import com.example.superherov4.Model.SuperheroCity;
import com.example.superherov4.Model.SuperheroNumOfPowers;
import com.example.superherov4.Model.SuperheroSuperpower;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// All methods for generating arrays
public class SuperheroRepository {
    // Shows all info about all superheroes
    public List<Superhero> getSuperheroes(){
        List<Superhero> superheroes = new ArrayList<>();
        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/main_schema", "root", "1234")){
            String SQL1 = "SELECT * FROM superheroes;";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL1);
            while (rs.next()){
                int ID = rs.getInt("superheroID");
                String heroName = rs.getString("heroName");
                String realName = rs.getString("realName");
                int creationYear = rs.getInt("creationYear");
                superheroes.add(new Superhero(ID, heroName, realName, creationYear));
            }
            return superheroes;
        }

        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    // Shows all info about a specified superhero
    public List<Superhero> getSuperhero(String name){
        List<Superhero> superheroes = new ArrayList<>();
        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/main_schema", "root", "1234")){
            String SQL1 = "SELECT * FROM superheroes WHERE heroName = ?";
            PreparedStatement ps = con.prepareStatement(SQL1);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int ID = rs.getInt("superheroID");
                String heroName = rs.getString("heroName");
                String realName = rs.getString("realName");
                int creationYear = rs.getInt("creationYear");
                superheroes.add(new Superhero(ID, heroName, realName, creationYear));
            }
            return superheroes;
        }

        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    // Shows heroname, realname and amount of superpowers on all superheroes
    public List<SuperheroNumOfPowers> getSuperheroesWithSuperpowerCount(){
        List<SuperheroNumOfPowers> superheroes = new ArrayList<>();
        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/main_schema", "root", "1234")){
            String SQL1 = "SELECT heroName, realName, count(*) as numberOfPowers FROM " +
                    "superhero_superpower join superheroes\n" +
                    "on superheroes.superheroID = superhero_superpower.superheroID\n" +
                    "GROUP BY superheroes.superheroID;";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL1);

            while (rs.next()){
                String heroName = rs.getString("heroName");
                String realName = rs.getString("realName");
                int numberOfPowers = rs.getInt("numberOfPowers");
                superheroes.add(new SuperheroNumOfPowers(heroName, realName, numberOfPowers));
            }
            return superheroes;
        }

        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    // Shows heroname, realname and amount of superpowers on a specified superhero
    public List<SuperheroNumOfPowers> getSuperheroWithSuperpowerCount(String name){
        List<SuperheroNumOfPowers> superheroes = new ArrayList<>();
        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/main_schema", "root", "1234")){
            String SQL1 = "SELECT heroName, realName, count(*) as numberOfPowers FROM " +
                    "superhero_superpower join superheroes\n" +
                    "on superheroes.superheroID = superhero_superpower.superheroID\n" +
                    "WHERE heroName = ?" +
                    "GROUP BY superheroes.superheroID;";
            PreparedStatement ps = con.prepareStatement(SQL1);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                String heroName = rs.getString("heroName");
                String realName = rs.getString("realName");
                int numberOfPowers = rs.getInt("numberOfPowers");
                superheroes.add(new SuperheroNumOfPowers(heroName, realName, numberOfPowers));
            }
            return superheroes;
        }

        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    // Shows heroname, realname and superpowers of all superheroes
    public List<SuperheroSuperpower> superheroSuperpowers(){
        List<SuperheroSuperpower> superpowers = new ArrayList<>();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/main_schema", "root", "1234")){
            String SQL1 = "SELECT heroName, realName, superpower.name AS Superpower FROM " +
                    "superpower join superheroes join superhero_superpower\n" +
                    "on superpower.superpowerID = superhero_superpower.superpowerID\n" +
                    "and superheroes.superheroID = superhero_superpower.superheroID;";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL1);

            while (rs.next()){
                String heroName = rs.getString("heroName");
                String realName = rs.getString("realName");
                String powers = rs.getString("Superpower");
                superpowers.add(new SuperheroSuperpower(heroName, realName, powers));
            }
            return superpowers;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    // Shows heroname, realname and superpowers of a specified superhero
    public List<SuperheroSuperpower> superheroSuperpowersSearch(String name){
        List<SuperheroSuperpower> superpowers = new ArrayList<>();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/main_schema", "root", "1234")){
            String SQL1 = "SELECT heroName, realName, superpower.name AS Superpower FROM superpower join superheroes join superhero_superpower\n" +
                    "on superpower.superpowerID = superhero_superpower.superpowerID\n" +
                    "and superheroes.superheroID = superhero_superpower.superheroID\n" +
                    "WHERE superheroes.heroName = ?;";
            PreparedStatement ps = con.prepareStatement(SQL1);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                String heroName = rs.getString("heroName");
                String realName = rs.getString("realName");
                String powers = rs.getString("Superpower");
                superpowers.add(new SuperheroSuperpower(heroName, realName, powers));
            }
            return superpowers;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    // Shows heroname and city of all superheroes
    public List<SuperheroCity> superheroCityList(){
        List<SuperheroCity> cities = new ArrayList<>();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/main_schema", "root", "1234")){
            String SQL1 = "SELECT heroName, city.name AS City FROM city JOIN superheroes JOIN city_superhero\n" +
                    "on city.cityID = city_superhero.cityID\n" +
                    "and superheroes.superheroID = city_superhero.superheroID\n;";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL1);

            while (rs.next()){
                String heroName = rs.getString("heroName");
                String city = rs.getString("City");
                cities.add(new SuperheroCity(heroName, city));
            }
            return cities;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    // Shows heroname and city of a specified superhero
    public List<SuperheroCity> superheroCitySearch(String name){
        List<SuperheroCity> cities = new ArrayList<>();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/main_schema", "root", "1234")){
            String SQL1 = "SELECT heroName, city.name AS City FROM city JOIN superheroes JOIN city_superhero\n" +
                    "on city.cityID = city_superhero.cityID\n" +
                    "and superheroes.superheroID = city_superhero.superheroID\n" +
                    "WHERE superheroes.heroName = ?;";
            PreparedStatement ps = con.prepareStatement(SQL1);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                String heroName = rs.getString("heroName");
                String city = rs.getString("City");
                cities.add(new SuperheroCity(heroName, city));
            }
            return cities;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
