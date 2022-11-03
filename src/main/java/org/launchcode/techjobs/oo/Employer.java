package org.launchcode.techjobs.oo;

import java.util.Objects;
//extends keyword is used to establish inheritance
//super () keyword is used to invoke immediate parent class constructor
//The extends and super keywords link the JobField and Employer classes
public class Employer extends JobField {

    public Employer(String value) {
        super(value);
    }
}
