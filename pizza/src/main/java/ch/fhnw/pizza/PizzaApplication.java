package ch.fhnw.pizza;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.fhnw.pizza.business.service.MenuService;
import ch.fhnw.pizza.data.domain.Pizza;
import ch.fhnw.pizza.data.domain.Topping;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
@RestController
public class PizzaApplication {

	@Autowired
	private MenuService menuService;

	public static void main(String[] args) {
		SpringApplication.run(PizzaApplication.class, args);
	}

	@GetMapping(value="/")
    public String getWelcomeString() {
        
        return "Pizza Takeaway Service, welcome!";
    } 

	// Use this method to initialize placeholder data without using Postman
	// If you are persisting data in a file (see application.properties), initializing data that already exists will cause an error during starting the application
	// To resolve the error, delete the file and restart the application
	@PostConstruct
	private void initPlaceholderData() throws Exception {
		Pizza pizza = new Pizza();
		pizza.setPizzaName("Margherita");
		//a. use the following line if pizza toppings is an attribute of the Pizza class
		//pizza.setPizzaToppings("Tomato sauce, mozzarella, basil");

		//b. use the following lines if pizza toppings is a value object in the Pizza class
		Set<Topping> toppings1 = new HashSet<Topping>();
		Topping topping = new Topping();
		topping.setToppingName("Tomato sauce");
		toppings1.add(topping);
		topping = new Topping();
		topping.setToppingName("Mozzarella");
		toppings1.add(topping);
		topping = new Topping();
		topping.setToppingName("Basil");
		toppings1.add(topping);
		pizza.setPizzaToppings(toppings1);
		menuService.addPizza(pizza);

		pizza = new Pizza();
		pizza.setPizzaName("Funghi");
		//a. use the following line if pizza toppings is an attribute of the Pizza class
		//pizza.setPizzaToppings("Tomato sauce, mozzarella, mushrooms");

		//b. use the following lines if pizza toppings is a value object in the Pizza class
		Set<Topping> toppings2 = new HashSet<Topping>();
		topping = new Topping();
		topping.setToppingName("Tomato sauce");
		toppings2.add(topping);
		topping = new Topping();
		topping.setToppingName("Mozzarella");
		toppings2.add(topping);
		topping = new Topping();
		topping.setToppingName("Mushrooms");
		toppings2.add(topping);
		pizza.setPizzaToppings(toppings2);
		menuService.addPizza(pizza);
		
	}

}
