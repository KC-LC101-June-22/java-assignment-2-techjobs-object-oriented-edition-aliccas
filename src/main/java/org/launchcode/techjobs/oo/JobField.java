package org.launchcode.techjobs.oo;

import java.util.Objects;

//public and private are access modifiers
public abstract class JobField {
    //declare common fields
    private int id;
    //declare variable and make static so value is not stored within any JobField object
    //static is used for a constant variable or method that is same for every instance of a class
    private static int nextId = 1;
    private String value;

    //Constructors
    //automatically assign each new object a unique ID number
    public JobField(){
        id = nextId;
        nextId++;
    }

    //initialize id by calling the first constructor with this() which makes initializing id a default behavior
    // initialize value field for object
    public JobField(String value) {
        this();
        this.value = value;
    }

    //perform reference check on the object o
    //perform null check and class check on o
    //cast o as a JobField object
    //compare id field of the objects
    //override annotation denotes that the child class method overrides the base class method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobField jobField = (JobField) o;
        return id == jobField.id;
    }

    //use id field that was used in equal
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    //returns a string representation of a class
    @Override
    public String toString() {
        return value;
    }

    //getters and setters
    // id only needs a getter since the unique value is set with the constructor
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public int getNextId() {
        return nextId;
    }
}
