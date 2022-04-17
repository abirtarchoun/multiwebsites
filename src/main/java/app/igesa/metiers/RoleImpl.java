package app.igesa.metiers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import app.igesa.enumerations.ErrorCode;
import app.igesa.exceptions.InvalideEntityException;
import app.igesa.exceptions.ResourceNotFoundException;
import app.igesa.repository.RoleRepository;
//import app.igesa.validators.RoleValidator;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.igesa.entity.Role;
/*
@AllArgsConstructor
@NoArgsConstructor
@Service
public class RoleImpl {


    @Autowired
    private RoleRepository roleRepository;
    private static final Logger log = LoggerFactory.getLogger(RoleImpl.class);

   
    public RoleDTO save(RoleDTO r) {
        List<String> errors = RoleValidator.validate(r);
        if (r.getId()!= null) {

        }
        if(!errors.isEmpty()) {
            log.error("Role not valid !" ,r);
            throw new InvalideEntityException("Role not valid !", ErrorCode.ROLE_NOT_VALID,errors);}

           Role saved =roleRepository.save(RoleDTO.toEntity(r));
           return RoleDTO.fromEntity(saved);

    }

    public Optional<RoleDTO> findById(Long id) {
        if ( id == null) {
            log.error(" Role Id is NULL .. !!");
            return null ;
        }

        return  Optional.of(roleRepository.findById(id).map(RoleDTO::fromEntity).orElseThrow(()->
                new ResourceNotFoundException(" No Role with  Id = :: " +id+ " was founded {} ..!",
                        ErrorCode.ROLE_NOT_FOUND)));
    }
    

    
    public List<RoleDTO> findAll() {
        return roleRepository.findAll().stream()
                .map(RoleDTO::fromEntity)
                .collect(Collectors.toList());
    }

	public void delete(Long id) {
        if ( id == null) {
            log.error(" Role ID IS NULL ");
            return;
        }
       roleRepository.deleteById(id);
    }

    public RoleDTO update(Long id, RoleDTO r) {
        return null;
    }


}
*/


