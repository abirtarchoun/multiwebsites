package app.igesa.metiers;

import app.igesa.dto.AccountDTO;
import app.igesa.dto.ChangerPasswordDTO;
import app.igesa.entity.Account;
import app.igesa.enumerations.ErrorCode;
import app.igesa.exceptions.ResourceNotFoundException;
import app.igesa.repository.IaccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.Optional;





@Service
public class AccountImp implements Iaccount{
    @Autowired
    IaccountRepository iaccountRepository ;

    private static final Logger log = LoggerFactory.getLogger(AccountImp.class);



    public Optional<AccountDTO> findById(Long id) {
        log.debug("HTTP GET BY ID {} ..",id);
        if ( id == null) {
            log.error(" Account by  Id is NULL .. !!");
            return null ;
        }

        return  Optional.of(iaccountRepository.findById(id).map(AccountDTO::fromEntity).orElseThrow(()->
                new ResourceNotFoundException(" No Account with  Id = :: " +id+ " was founded {} ..!",
                        ErrorCode.CATEGORY_NOT_FOUND)));

    }

    @Override
    public AccountDTO changerPassword(ChangerPasswordDTO dto) {

        validate(dto);
        Optional<Account> accountOptional = iaccountRepository.findById(dto.getId());
        if(!accountOptional.isPresent()){
            log.warn("no account was foud with the  provided id ");
            throw new ResourceNotFoundException("no account was founded the provided id " +dto.getId(),ErrorCode.ACCOUNT_NOT_VALID);
        }

        Account account = accountOptional.get();
        account.setPassword(dto.getPassword());
        return AccountDTO.fromEntity(iaccountRepository.save(account));

        }

    private void validate (ChangerPasswordDTO dto){
        if (dto == null) {
            log.warn("it seem be impossible to edite the password  !");
            throw new ResourceNotFoundException(" password it seem be null ",
                    ErrorCode.PASSWORD_CHANGE_NOT_VALID);
        }


        if (dto.getId()== null){
            log.warn("id it seem be null !");
            throw new ResourceNotFoundException(" id account was  null , it seem be impossile to edite the  passwordd",
                    ErrorCode.PASSWORD_CHANGE_NOT_VALID);
        }

        if (!StringUtils.hasLength(dto.getPassword()) || !StringUtils.hasLength(dto.getConfirmPassword())){
            log.warn("password it seem be null !");
            throw new ResourceNotFoundException("  it seem be impossile to edite a  password  with a value of null",
                    ErrorCode.PASSWORD_CHANGE_NOT_VALID);
        }

        if (!dto.getPassword().equals(dto.getConfirmPassword())){
            log.warn("password it seem be not the same !");
            throw new ResourceNotFoundException("  it seem be impossile to edite a  password  with tow diffrent value ",
                    ErrorCode.PASSWORD_CHANGE_NOT_VALID);
        }
    }
}
