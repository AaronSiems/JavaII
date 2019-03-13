//Aaron Siems
package dmacc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dmacc.beans.Drink;
import dmacc.controller.BeanConfiguration;
import dmacc.repository.DrinkRepository;

@SpringBootApplication
public class SpringBeansIntroProjectApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBeansIntroProjectApplication.class, args);
	}

	@Autowired
	DrinkRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		
		//creating a generic drink from config class
		ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		Drink d = appContext.getBean("drink", Drink.class);
		repo.save(d);
		
		//creating coca-cola from constructor
		Drink d2 = new Drink("Coca-Cola", "Black", 2.49);
		repo.save(d2);
		
		List<Drink> allDrinks = repo.findAll();
		for(Drink drink: allDrinks) {
			System.out.println(drink.toString());
		}
		
	}

}
