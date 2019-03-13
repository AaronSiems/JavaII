package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.Drink;

public interface DrinkRepository extends JpaRepository<Drink, Long>{

}
