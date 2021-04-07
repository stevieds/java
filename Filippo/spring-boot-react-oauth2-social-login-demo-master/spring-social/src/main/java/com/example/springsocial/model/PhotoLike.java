package com.example.springsocial.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
/*
@Entity significa che la classe corrisponde a una tabella di un db e ogni istanza di tale classe
è a sua volta un record/riga/row della tabella.
 */
//@JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class PhotoLike {

    @Id
    //@Id indica che una data variabile (ovvero un campo) è una chiave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*
    @GeneratedValue specifica come viene generate la chiave primaria. Tra gli argomenti Strategy
    definisce quale strategia adottare, a scelta tra le opzioni della enum.
    IDENTITY suppongo sia come auto-increment di mySQL
     */
    private Long id;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="owner", referencedColumnName="id")
    // Ovvero una foreign key. owner è il nome della colonna di questa tabella mentre id èil nome
    // di quella che si vuole referenziare. Per la tabella si fa riferimento al tipo di questa
    // variabile. In questo caso è User, quindi Java controlla la classe user e prende il nome
    // della tabella corrispondente.
    private User owner;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="photo", referencedColumnName="id")
    private Photo photo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }
}
