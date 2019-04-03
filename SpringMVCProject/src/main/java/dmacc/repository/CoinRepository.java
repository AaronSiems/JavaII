package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dmacc.beans.Coins;

public interface CoinRepository extends JpaRepository<Coins, Long>{

}
