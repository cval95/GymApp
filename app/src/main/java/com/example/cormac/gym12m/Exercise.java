package com.example.cormac.gym12m;

import java.io.Serializable;

/**
 * Created by Cormac on 27/04/2018.
 */

public class Exercise implements Serializable {

    private int id;
    private String name;
    private int set;
    private int weight;
    private int reps;

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

    public int getSet() {
        return set;
    }

    public void setSet(int set) {
        this.set = set;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }
}
