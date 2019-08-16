package by.pvt.pojo;

import com.mysql.fabric.xmlrpc.base.Data;
import org.graalvm.compiler.code.DataSection;

import java.io.Serializable;


public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String firstName;
    private String lastName;
    private Data dateOfBirth;
    private char   gender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Data getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Data dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }




}
