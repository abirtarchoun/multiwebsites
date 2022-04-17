package app.igesa.repository;

import app.igesa.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IaccountRepository extends JpaRepository<Account,Long>{
    Account findByEmail(String email);

    boolean existsByEmail(String email);


}
