package com.example.thymeLeaf20200208.model;

public class User {

    int id;
    String name;
    String nazwisko;
    int wiek;

    public User(int id, String name, String nazwisko, int wiek) {
        this.id = id;
        this.name = name;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
    }

    public User() {

    }

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

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }
}
