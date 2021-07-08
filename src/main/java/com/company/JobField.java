package com.company;

import java.util.Objects;

public class JobField {
    private static int nextId = 1;

    private final int id;
    private String value;

    public JobField() {
        id = nextId;
        nextId++;
    }

    public JobField(String value) {
        this();
        this.value = value;
    }

    // Custom toString, equals, and hashCode methods:

    @Override
    public String toString() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobField jobfield = (JobField) o;
        return id == jobfield.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // Getters and Setters:

    public int getId() { return this.id; }

    public String getValue() { return this.value; }

    public void setValue(String value) { this.value = value; }

}
