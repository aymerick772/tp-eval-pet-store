package fr.epsi.i1cap2024Eval.domain;

import fr.epsi.i1cap2024Eval.emun.ProdType;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "CODE")
    private String code;
    @Column(name = "LABEL")
    private String label;
    @Column(name = "PRODTYPE")
    private ProdType prodType;
    @Column(name = "PRICE")
    private double price;

    public Product() {
    }

    @ManyToMany(mappedBy="products")
    private Set<PetStore> petStores;

    public Product(String code, String label, ProdType prodType, double price) {
        this.code = code;
        this.label = label;
        this.prodType = prodType;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ProdType getProdType() {
        return prodType;
    }

    public void setProdType(ProdType prodType) {
        this.prodType = prodType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<PetStore> getPetStores() {
        return petStores;
    }

    public void setPetStores(Set<PetStore> petStores) {
        this.petStores = petStores;
    }

//    Methode toString pour afficher les informations du produit
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", label='" + label + '\'' +
                ", prodType=" + prodType +
                ", price=" + price +
                ", petStores=" + petStores + super.toString() +
                '}';
    }
}
