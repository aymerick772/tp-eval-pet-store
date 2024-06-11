package fr.epsi.i1cap2024Eval.domain;

import fr.epsi.i1cap2024Eval.emun.FishLivEnv;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;


@Entity //  entité JPA
@Table(name = "fish")  // Spécifie le nom de la table dans la base de données
public class Fish extends Animal{
    @Column(name = "LIVINGENV")// Mappe l'attribut livingEnv à la colonne LIVINGENV de la table
    private FishLivEnv livingEnv;

    public Fish() {
    }

    public Fish(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }

    public Fish(LocalDate birth, String couleur, PetStore petStore, FishLivEnv livingEnv) {
        super(birth, couleur, petStore);
        this.livingEnv = livingEnv;
    }

    public Fish(LocalDate birth, String couleur, FishLivEnv livingEnv) {
        super(birth, couleur);
        this.livingEnv = livingEnv;
    }

    public FishLivEnv getLivingEnv() {
        return livingEnv;
    }

    public void setLivingEnv(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }

    //    Methode toString pour afficher les informations du poisson
    public String toString() {
        return "Fish{" +
                "livingEnv=" + livingEnv + super.toString() +
                '}';
    }
}
