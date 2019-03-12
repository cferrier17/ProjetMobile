package com.example.myapplication.Model;

import java.util.ArrayList;

public class Hero {
    private int id;
    private String name;
    private String description;
    private int health;
    private int armour;
    private int shield;
    private String real_name;
    private int age;
    private String affiliation;
    private String base_of_operations;
    private int difficulty;
    private ArrayList<Ability> abilities;

    public Hero(int id, String name, String description, int health, int shield, String real_name, int age, String affiliation, String base_of_operations, int difficulty, ArrayList<Ability> abilities) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.health = health;
        this.shield = shield;
        this.real_name = real_name;
        this.age = age;
        this.affiliation = affiliation;
        this.base_of_operations = base_of_operations;
        this.difficulty = difficulty;
        this.abilities = abilities;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getHealth() {
        return health;
    }

    public int getShield() {
        return shield;
    }

    public String getReal_name() {
        return real_name;
    }

    public int getAge() {
        return age;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public String getBase_of_operations() {
        return base_of_operations;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public ArrayList<Ability> getAbilities() {
        return abilities;
    }

    public int getArmour() {
        return armour;
    }

    public void setArmour(int armour) {
        this.armour = armour;
    }
}
