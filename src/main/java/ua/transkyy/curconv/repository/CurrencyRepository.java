package ua.transkyy.curconv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.transkyy.curconv.entity.Currencies;

@Repository
public interface CurrencyRepository extends JpaRepository<Currencies, Long> {

}
