package app.igesa.validators;

import app.igesa.dto.EntrepriseDTO;
import app.igesa.dto.RoleDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class RoleValidator {
    public static List<String> validate (RoleDTO roleDTO){

        List<String> errors = new ArrayList<>() ;

        if (roleDTO==null) {

            errors.add("Veuillez renseigner le nom  !");
            errors.add("Veuillez renseigner le Groupe de l'account !");

            return errors;
        }

        if(!StringUtils.hasLength(roleDTO.getName())) {
            errors.add("Veuillez renseigner le nom  !");
        }

        if(roleDTO.getAccount()== null) {
            errors.add("Veuillez renseigner le Groupe de l'account !");
        }
        return errors;
    }

}
