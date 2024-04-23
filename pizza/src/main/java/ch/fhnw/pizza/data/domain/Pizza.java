package ch.fhnw.pizza.data.domain;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pizza")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    // @Column(name = "pizza_toppings")
    // private String pizzaToppings;

    @Column(name = "pizza_name")
    private String pizzaName;

    @JsonIgnore
    @ManyToOne
    private Menu menu;

    @ElementCollection(targetClass = Topping.class)
    @JoinTable(name = "toppings", joinColumns = @JoinColumn(name = "pizza_id", referencedColumnName = "id"))
    private Set<Topping> pizzaToppings = new HashSet<Topping>();
    


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // public String getPizzaToppings() {
    //     return pizzaToppings;
    // }

    // public void setPizzaToppings(String pizzaToppings) {
    //     this.pizzaToppings = pizzaToppings;
    // }

    public Set<Topping> getPizzaToppings() {
        return pizzaToppings;
    }

    public void setPizzaToppings(Set<Topping> pizzaToppings) {
        this.pizzaToppings = pizzaToppings;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    } 
    
}
