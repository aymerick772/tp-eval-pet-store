package fr.epsi.i1cap2024Eval.domain;

import jakarta.persistence.*;

@Entity //  entité JPA
@Table(name = "address") // Spécifie le nom de la table dans la base de données
public class Address {
    @Id  // Indique que ce champ est la clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Génère automatiquement l'ID avec une stratégie d'identité
    @Column(name = "ID")// Mappe l'attribut id à la colonne ID de la table
    private Long id;
    @Column(name = "NUMBER")
    private String number;
    @Column(name = "STREET")
    private String zipCode;
    @Column(name = "CITY")
    private String city;

    @OneToOne // Relation One-to-One avec l'entité PetStore
    private PetStore petStore;

    // Constructeur par défaut
    public Address() {
    }
    // Constructeurs optionnels qui initialise les attributs
    public Address(String number, String zipCode, String city) {
        this.number = number;
        this.zipCode = zipCode;
        this.city = city;
    }
    //    Getters et Setters
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public PetStore getPetStore() {
        return petStore;
    }

    public void setPetStore(PetStore petStore) {
        this.petStore = petStore;
    }
}
