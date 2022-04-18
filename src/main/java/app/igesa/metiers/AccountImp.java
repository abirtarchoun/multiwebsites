package app.igesa.metiers;
import app.igesa.entity.Account;
import app.igesa.entity.Groupe;
import app.igesa.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;



@Service
public class AccountImp {
    @Autowired
    UserRepository userRepository;

    private static final Logger log = LoggerFactory.getLogger(RoleImpl.class);


    public Account save(Account account) {
        return userRepository.save(account);
    }

    public Optional<Account> findById(Long id) {
        return userRepository.findById(id);
    }

    public List<Account> findAll() {
        return userRepository.findAll();
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public Account update(Long id, Account user) {
        Groupe groupe = new Groupe();
        groupe.getId();
        Account account= userRepository.findById(id).orElseThrow(() -> new RuntimeException("Role introuvable avec id : : " +id));
        account.setUsername(user.getUsername());
        account.setFiscaleCode(user.getFiscaleCode());
        account.setGroupe(groupe);
        account.setMatchingPassword(user.getMatchingPassword());
        account.setPassword(user.getPassword());
        account.setEmail(account.getEmail());
        final Account updated=  userRepository.save(account);
        return updated;

    }


}