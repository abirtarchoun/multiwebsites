package app.igesa.validators;

import app.igesa.dto.AccountDTO;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.List;


public class AccountValidator {
    public static List<String> validate (AccountDTO accountDTO){

        List<String> errors = new ArrayList<>() ;

        if (accountDTO==null) {

            errors.add("Veuillez renseigner l email de l'account  !");
            errors.add("Veuillez renseigner le Nom de l'utilisateur !");
            errors.add("Veuillez renseigner le prenom de l'utilisateur !");
            errors.add("Veuillez renseigner le mot de passe !");
            errors.add("Veuillez renseigner le code fiscale de l'account !");
            errors.add("Veuillez renseigner le username!");
            errors.add("Veuillez renseigner le Role de l'utilisateur !");
            errors.add("Veuillez renseigner le Groupe!");

            return errors;
        }

        if(!StringUtils.hasLength(accountDTO.getEmail())) {
            errors.add("Veuillez renseigner l email de l'account  !");
        }
        if(!StringUtils.hasLength(accountDTO.getFirstname())) {
            errors.add("Veuillez renseigner le Nom de l'utilisateur !");
        }
        if(!StringUtils.hasLength(accountDTO.getLastname())) {
            errors.add("Veuillez renseigner le prenom de l'utilisateur !");
        }
        if(!StringUtils.hasLength(accountDTO.getPassword())) {
            errors.add("Veuillez renseigner le mot de passe !");
        }

        if(!StringUtils.hasLength(accountDTO.getFiscaleCode())) {
            errors.add("Veuillez renseigner le code fiscale de l'account !");
        }
        if(!StringUtils.hasLength(accountDTO.getUsername())) {
            errors.add("Veuillez renseigner le username!");
        }

        if(accountDTO.getRole()== null) {
            errors.add("Veuillez renseigner le Role de l'utilisateur !");
        }
        if(accountDTO.getGroupe()== null) {
            errors.add("Veuillez renseigner le Groupe!");
        }
        return errors;
    }
}
