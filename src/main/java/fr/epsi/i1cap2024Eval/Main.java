package fr.epsi.i1cap2024Eval;

import fr.epsi.i1cap2024Eval.domain.*;
import fr.epsi.i1cap2024Eval.emun.FishLivEnv;
import fr.epsi.i1cap2024Eval.emun.ProdType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.*;

import static fr.epsi.i1cap2024Eval.emun.FishLivEnv.*;
import static fr.epsi.i1cap2024Eval.emun.ProdType.*;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pet-eval");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
//        initialisation de toutes les collections

        Set<Product> productsForStevensPets = new HashSet<>();
        Set<Product> productsForKevinsPets = new HashSet<>();
        Set<Product> productsForAymericksPets = new HashSet<>();

        Set<Animal> animalsStevensPets = new HashSet<>();
        Set<Animal> animalsKevinsPets = new HashSet<>();
        Set<Animal> animalsAymericksPets = new HashSet<>();

        Set<Animal> allAnimals = new HashSet<>();
        Set<Product> allProducts = new HashSet<>();
        Set<PetStore> allPetStores = new HashSet<>();
        Set<Address> allAddress = new HashSet<>();
//        Création des produits

        Product musoliereChat = new Product("1524498", "musoliereChat", ACCESSORY, 42.25);
        Product specialCannin = new Product("1524499", "special Cannin", FOOD, 28.00);
        Product poussettePoissons = new Product("1524500", "Poussette poissons", ACCESSORY, 42.25);
        Product javel =  new Product("1524500", "Javel Nettoyant", CLEANNING, 12.99);
        Product ballesFlotantes =  new Product("1524501", "Balles Flotantes", ACCESSORY, 8.99);
        Product piscinePoissions =  new Product("1524502", "Piscine Poissions", ACCESSORY, 82.99);
        Product matelasRafraichissant =  new Product("1524503", "Matelas Rafraichissant", ACCESSORY, 82.99);
        Product balançoireChat =  new Product("1524504", "balançoire pour chat", ACCESSORY, 67.99);
        Product huileSaumon =  new Product("1524504", "Huile Saumon", FOOD, 2.99);
        Product croquettePoissons =  new Product("1524505", "Huile Saumon", FOOD, 27.99);
        Product dessertPoissons =  new Product("1524506", "Dessert Poissons", FOOD, 22.99);
        Product dessertChat =  new Product("1524506", "Dessert Chat", FOOD, 12.99);
        Product aperitifsChat =  new Product("1524507", "Aperitifs Chat", FOOD, 2.99);
        Product salomonChat =  new Product("1524508", "Equivalent Nike airmax pour chien", ACCESSORY, 185.99);

        // Ajouter les produits à la collection
        Collections.addAll(allProducts, musoliereChat, specialCannin, poussettePoissons, javel, ballesFlotantes, piscinePoissions, matelasRafraichissant, balançoireChat, huileSaumon, croquettePoissons, dessertPoissons, dessertChat, aperitifsChat, salomonChat);


//        Ajout produits vers le petStore de Steven's
        productsForStevensPets.add(musoliereChat);
        productsForStevensPets.add(specialCannin);
        productsForStevensPets.add(poussettePoissons);
        productsForStevensPets.add(javel);
        productsForStevensPets.add(croquettePoissons);
        productsForStevensPets.add(dessertPoissons);
        productsForStevensPets.add(dessertChat);
        productsForStevensPets.add(aperitifsChat);
//        Ajout produits vers le petStore de Kevin's
        productsForKevinsPets.add(musoliereChat);
        productsForKevinsPets.add(specialCannin);
        productsForKevinsPets.add(matelasRafraichissant);
        productsForKevinsPets.add(salomonChat);
        productsForKevinsPets.add(huileSaumon);
        productsForKevinsPets.add(javel);
        productsForKevinsPets.add(croquettePoissons);
        productsForKevinsPets.add(dessertPoissons);
        productsForKevinsPets.add(dessertChat);
        productsForKevinsPets.add(aperitifsChat);
//        Ajout produits vers le petStore de Aymerick's
        productsForAymericksPets.add(piscinePoissions);
        productsForAymericksPets.add(balançoireChat);
        productsForAymericksPets.add(ballesFlotantes);
        productsForAymericksPets.add(javel);
        productsForAymericksPets.add(specialCannin);
        productsForAymericksPets.add(matelasRafraichissant);
        productsForAymericksPets.add(poussettePoissons);
        productsForAymericksPets.add(musoliereChat);
        productsForAymericksPets.add(croquettePoissons);
        productsForAymericksPets.add(dessertPoissons);
        productsForAymericksPets.add(dessertChat);
        productsForAymericksPets.add(aperitifsChat);


//        Création des animaux
        Cat pepsi = new Cat(LocalDate.parse("2020-07-29"), "Marron","555001");
        Cat myriam = new Cat(LocalDate.parse("2021-06-04"), "beige","555002");
        Cat felix = new Cat(LocalDate.parse("2019-03-15"), "noir", "555003");
        Cat luna = new Cat(LocalDate.parse("2022-01-21"), "blanc", "555004");
        Fish bertran = new Fish(LocalDate.parse("2021-12-23"), "rouge", FRESH_WATER);
        Fish nemo = new Fish(LocalDate.parse("2020-11-12"), "rouge", SEA_WATER);
        Fish dory = new Fish(LocalDate.parse("2022-07-09"), "bleu", SEA_WATER);
        Fish marlin = new Fish(LocalDate.parse("2019-04-30"), "orange", SEA_WATER);
        Fish bubbles = new Fish(LocalDate.parse("2020-11-20"), "jaune", FRESH_WATER);

//        Ajouter les produits à la collection
        Collections.addAll(allAnimals, pepsi, myriam, felix, luna, bertran, nemo, dory, marlin, bubbles);

//        Attribution des animaux vers les petStores
        animalsStevensPets.add(pepsi);
        animalsStevensPets.add(myriam);
        animalsStevensPets.add(bertran);

        animalsKevinsPets.add(felix);
        animalsKevinsPets.add(dory);
        animalsKevinsPets.add(nemo);

        animalsAymericksPets.add(luna);
        animalsAymericksPets.add(bubbles);
        animalsAymericksPets.add(marlin);


//        Création des adresses et des petStore
        Address adressStevensPets = new Address("28", "34070", "Montpellier");
        Address adressKevinsPets = new Address("12", "34000", "Montpellier");
        Address adressAymericksPets = new Address("42", "34090", "Montpellier");

        Collections.addAll(allAddress, adressStevensPets, adressKevinsPets, adressAymericksPets);

        PetStore stevensPets = new PetStore("Steven's PetStore", "Steven", adressStevensPets, productsForStevensPets, animalsStevensPets);
        PetStore kevinsPets = new PetStore("Kevin's PetStore", "Kevon", adressKevinsPets, productsForKevinsPets, animalsKevinsPets);
        PetStore aymerickPets = new PetStore("Aymerick's PetStore", "Aymerick", adressAymericksPets, productsForAymericksPets, animalsAymericksPets);

        Collections.addAll(allPetStores, stevensPets, kevinsPets, aymerickPets);


//        Associer les adresses aux petStores
        adressStevensPets.setPetStore(stevensPets);
        adressKevinsPets.setPetStore(kevinsPets);
        adressAymericksPets.setPetStore(aymerickPets);

//        Associer les animaux aux petStores
      for (Animal animalsStevens : animalsStevensPets) {
            animalsStevens.setPetStore(stevensPets);
      }
      for (Animal animalsKevins : animalsKevinsPets) {
          animalsKevins.setPetStore(aymerickPets);
      }
      for (Animal animalsAymerick : animalsAymericksPets) {
          animalsAymerick.setPetStore(kevinsPets);
      }


//         Persist des entitées  produits / animaux / adresses / petStores
        for (PetStore petStore : allPetStores) {
            entityManager.persist(petStore);
        }
        for (Product product : allProducts) {
            entityManager.persist(product);
        }
        for (Animal animal : allAnimals) {
            entityManager.persist(animal);
        }
        for (Address address : allAddress) {
            entityManager.persist(address);
        }



        TypedQuery<Animal> query = entityManager.createQuery("SELECT a FROM Animal a WHERE a.petStore.name = ?1", Animal.class);
        query.setParameter(1, "Steven's PetStore");
        List<Animal> resultAnimalStevensPetstore = query.getResultList();
        if(resultAnimalStevensPetstore != null && !resultAnimalStevensPetstore.isEmpty()){
            for (Animal animal : resultAnimalStevensPetstore) {
                System.out.println(animal);
            }
        }else{
            System.out.println("Pas d'animaux dans cette pauvre animalerie :~/");
        }

//

        entityManager.getTransaction().commit();
        entityManager.close();
        emf.close();
    }

}