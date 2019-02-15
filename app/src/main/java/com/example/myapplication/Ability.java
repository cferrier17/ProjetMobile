package com.example.myapplication;

class Ability {
    private int id;
    private String name;
    private String description;
    private boolean is_ultimate;

    public Ability(int id, String name, String description, boolean is_ultimate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.is_ultimate = is_ultimate;
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

    public boolean isIs_ultimate() {
        return is_ultimate;
    }


}
