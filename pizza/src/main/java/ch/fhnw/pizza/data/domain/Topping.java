package ch.fhnw.pizza.data.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Topping {

    @Column(name = "topping_name")
    private String toppingName;

    public String getToppingName() {
        return this.toppingName;
    }

    public void setToppingName(String toppingName) {
        this.toppingName = toppingName;
    }

    

}
