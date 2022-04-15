package app.igesa.dto;
import app.igesa.entity.Account;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
@Getter
@Setter
@Builder
public class AccountDTO {
    private Long id ;
    private String username ;
    private String Firstname;
    private String Lastname;
    private String password;
    private LocalDate Datebirth ;
    private String fiscaleCode;
    private String bareCode ;
    private String email ;
    private GroupeDTO groupe ;
    private RoleDTO role ;

    public static AccountDTO fromEntity(Account account) {
        if ( account == null) {
            return null;
        }
        return AccountDTO.builder()
                .id(account.getId())
                .bareCode(account.getBareCode())
                .email(account.getEmail())
                .Datebirth(account.getDatebirth())
                .Firstname(account.getFirstname())
                .Lastname(account.getLastname())
                .password(account.getPassword())
                .fiscaleCode(account.getFiscaleCode())
                .username(account.getUsername())
                .role(RoleDTO.fromEntity(account.getRole()))
                .groupe(GroupeDTO.fromEntity(account.getGroupe()))
                .build();
    }

    public static Account toEntity(AccountDTO dto) {

        if (dto == null) {
            return null;
        }

        Account account = new Account();
        account.setId(dto.getId());
        account.setBareCode(dto.getBareCode());
        account.setDatebirth(dto.getDatebirth());
        account.setEmail(dto.getEmail());
        account.setUsername(dto.getUsername());
        account.setFirstname(dto.getFirstname());
        account.setLastname(dto.getLastname());
        account.setPassword(dto.getPassword());
        account.setGroupe(GroupeDTO.toEntity(dto.getGroupe()));
        account.setRole(RoleDTO.toEntity(dto.getRole()));
        return account;
    }


}
