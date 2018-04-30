package com.example.cormac.gym12m;

import java.io.Serializable;

/**
 * Created by Cormac on 27/04/2018.
 */

public class Workout implements Serializable {

    private int id;
    private String name;

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
}
