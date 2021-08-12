package com.rest.app.entities;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Bank {


    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String address;

    private String description;


    @OneToMany(mappedBy = "bank", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<User> users;


    public Bank() {

    }

    public Bank(String name, String address, String description, List<User> users) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, description, users);
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bank bank = (Bank) o;
        return Objects.equals(id, bank.id) &&
                Objects.equals(name, bank.name) &&
                Objects.equals(address, bank.address) &&
                Objects.equals(description, bank.description) &&
                Objects.equals(users, bank.users);
    }


    @Override
    public String toString() {
        return "Bank{" +
                "id= " + id +
                ", name= '" + name + '\'' +
                ", address= '" + address + '\'' +
                ", description= '" + description + '\'' +
                ", users= '" + users + '\'' +
                '}';

    }

}




















