package com.zucc.demo.model;

import java.io.Serializable;

public class EmployeeVO implements Serializable
{
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String firstName;
    private String lastName;

    //Setters and Getters
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {return this.id;}

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getFirstName() {return this.firstName;}

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
public String getLastName() {return this.lastName;}
    @Override
    public String toString() {
        return "EmployeeVO [id=" + id + ", firstName=" + firstName
                + ", lastName=" + lastName + "]";
    }
}