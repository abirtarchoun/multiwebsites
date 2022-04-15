package app.igesa.dto;

import java.util.List;

import app.igesa.entity.CompanyBusiness;
import app.igesa.entity.Entreprise;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Builder
public class CompanyBusinessDTO {

    private Long id ;
	private String description ; 
	private String domainename ;
	@JsonIgnore
	private List<GroupeDTO>groupe ;


	public static CompanyBusinessDTO fromEntity(CompanyBusiness company) {
		/*if ( company == null) {
			return null;
		}*/
		return CompanyBusinessDTO.builder()
				.id(company.getId())
				.description(company.getDescription())
				.domainename(company.getDomainename())
				.build();
	}

	public static CompanyBusiness toEntity(CompanyBusinessDTO dto) {

		/*if (dto == null) {
			return null;
		}*/

		CompanyBusiness company = new CompanyBusiness();
		company.setId(dto.getId());
		company.setDescription(dto.getDescription());
		company.setDomainename(dto.getDomainename());
		return company;
	}

}
