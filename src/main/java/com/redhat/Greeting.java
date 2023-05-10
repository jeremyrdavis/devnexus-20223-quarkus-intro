package com.redhat;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class Greeting extends PanacheEntity {

    String text;

    public Greeting() {
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "text='" + text + '\'' +
                '}';
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
