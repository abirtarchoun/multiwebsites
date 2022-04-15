package app.igesa.dto;
import app.igesa.entity.Account;
import app.igesa.entity.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import java.util.List;


@Data
@Builder
public class RoleDTO {
    
	private Long id;
	private String name;
	@JsonIgnore
	private List<AccountDTO> account;


	public static RoleDTO fromEntity(Role role) {
		if ( role == null) {
			return null;
		}
		return RoleDTO.builder()
				.id(role.getId())
				.name(role.getName())
				.build();
	}

	public static Role toEntity(RoleDTO dto) {

		if (dto == null) {
			return null;
		}

		Role role = new Role();
		role.setId(dto.getId());
		role.setName(dto.getName());
		return role;
	}

}
