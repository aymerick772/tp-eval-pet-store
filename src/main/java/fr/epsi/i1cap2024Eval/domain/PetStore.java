package fr.epsi.i1cap2024Eval.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity //entité JPA
@Table(name = "petstore") // Spécifie le nom de la table dans la base de données
public class PetStore {
    @Id // Indique que ce champ est la clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Génère automatiquement l'ID avec une stratégie d'identité
    @Column(name = "ID") // Mappe l'attribut id à la colonne ID de la table
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "MANAGERNAME")
    private String managerName;

    @OneToOne(cascade = CascadeType.ALL) // Relation One-to-One avec cascade sur toutes les opérations
    @JoinColumn(name = "address_ID") // Nom de la colonne de jointure dans la table
    private Address address;

    @ManyToMany // Relation Many-to-Many avec l'entité Product
    // Table de jointure pour la relation Many-to-Many
    @JoinTable(name = "STO_PRO",
        joinColumns = @JoinColumn(name = "ID_STO", referencedColumnName = "ID"),
        inverseJoinColumns = @JoinColumn(name = "ID_PRO", referencedColumnName = "ID")
    )
    private Set<Product> products;

    // Relation One-to-Many avec cascade sur toutes les opérations et mappée par l'attribut petStore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="petStore")
    private Set<Animal> animals;

    // Constructeur par défaut
    public PetStore() {
    }

    // Constructeurs optionnels qui initialise les attributs
    public PetStore(String name, String managerName, Address address, Set<Product> products, Set<Animal> animals) {
        this.name = name;
        this.managerName = managerName;
        this.address = address;
        this.products = products;
        this.animals = animals;
    }
    //    Getters et Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Set<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Animal> animals) {
        this.animals = animals;
    }

//    Methode toString pour afficher les informations de l'animalerie
    @Override
    public String toString() {
        return "PetStore{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", managerName='" + managerName + '\'' +
                ", address=" + address +
                '}';
    }
}
