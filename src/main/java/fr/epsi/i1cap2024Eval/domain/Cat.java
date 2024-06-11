package fr.epsi.i1cap2024Eval.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity //  entité JPA
@Table(name = "cat") // Spécifie le nom de la table dans la base de données
public class Cat extends Animal { // La classe Cat hérite de la classe Animal

    // Mappe l'attribut chipId à la colonne CHIPID de la table
    @Column(name="CHIPID")
    private String chipId;

    // Constructeur par défaut
    public Cat() {
    }
    // Constructeurs optionnels qui initialise les attributs
    public Cat(String chipId) {
        this.chipId = chipId;
    }
    public Cat(LocalDate birth, String couleur, PetStore petStore, String chipId) {
        super(birth, couleur, petStore);
        this.chipId = chipId;
    }
    public Cat(LocalDate birth, String couleur, String chipId) {
        super(birth, couleur);
        this.chipId = chipId;
    }

//    Getter et Setter
    public String getChipId() {
        return chipId;
    }

    public void setChipId(String chipId) {
        this.chipId = chipId;
    }

//    Methode toString pour afficher les informations du chat
    public String toString() {
        return
                "Cat{" +
                "chipId='" + chipId + '\'' + super.toString() +
                '}';
    }
}
