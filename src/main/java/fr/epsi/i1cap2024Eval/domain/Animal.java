package fr.epsi.i1cap2024Eval.domain;

import jakarta.persistence.*;
import org.checkerframework.checker.units.qual.C;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "animal")
public abstract class Animal { // Classe Abstraite
    @Id// Indique que ce champ est la clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Génère automatiquement l'ID avec une stratégie d'identité
    @Column(name = "ID") // Mappe l'attribut id à la colonne ID de la table
    private Long id;
    @Column(name= "BIRTH")
    private LocalDate birth;
    @Column(name ="COULEUR")
    private String couleur;


    @ManyToOne // Relation Mano-To-Many avec l'entité PetStore
    @JoinColumn(name= "STO_ID") // Nom de la colonne de jointure dans la table
    private PetStore petStore;

    // Constructeur par défaut
    public Animal() {
    }
    // Constructeurs optionnels qui initialise les attributs
    public Animal(LocalDate birth, String couleur, PetStore petStore) {
        this.birth = birth;
        this.couleur = couleur;
        this.petStore = petStore;
    }

    public Animal(LocalDate birth, String couleur) {
        this.birth = birth;
        this.couleur = couleur;
    }

    //    Getters et Setters
    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public PetStore getPetStore() {
        return petStore;
    }

    public void setPetStore(PetStore petStore) {
        this.petStore = petStore;
    }

    //    Methode toString pour afficher les informations de l'animal
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", birth=" + birth +
                ", couleur='" + couleur +
                '}';
    }
}
