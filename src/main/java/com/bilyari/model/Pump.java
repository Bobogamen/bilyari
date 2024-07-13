package com.bilyari.model;

public class Pump implements Comparable<Pump> {

    private int id;
    private String name;
    private double value;

    public Pump() {
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

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public int compareTo(Pump o) {
        return 0;
    }
}
