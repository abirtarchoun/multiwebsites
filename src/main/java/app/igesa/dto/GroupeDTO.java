package app.igesa.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import app.igesa.entity.Groupe;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GroupeDTO  {
    private Long id ; 
    private String name ;
    private String description ; 
    private boolean active ;
    private boolean confirmed;
    private boolean deleted ;
    private CompanyBusinessDTO companyBusiness;
    
    @JsonIgnore
    private List<EntrepriseDTO>entreprise ;
    @JsonIgnore
   // private List<RoleDTO>role;




    public static GroupeDTO fromEntity(Groupe groupe) {

		return GroupeDTO.builder()
				.id(groupe.getId())
				.name(groupe.getName())
				.active(groupe.isActive())
				.confirmed(groupe.isConfirmed())
				.deleted(groupe.isDeleted())
				.description(groupe.getDescription())
                .companyBusiness(CompanyBusinessDTO.fromEntity(groupe.getCompanyBusiness()))
                .build();
				//boucle infini
				/*.entreprise(groupe.getEntreprise() != null? 
						       groupe.getEntreprise().stream().map(EntrepriseDTO::fromEntity).collect(Collectors.toList()):null)*/

    }


    
    public static Groupe toEntity(GroupeDTO dto) {

    	
           Groupe groupe = new Groupe();
           groupe.setId(dto.getId());
           groupe.setName(dto.getName());
           groupe.setActive(dto.isActive());
           groupe.setConfirmed(dto.isConfirmed());
           groupe.setDeleted(dto.isDeleted());
           groupe.setDescription(dto.getDescription());
           groupe.setCompanyBusiness(CompanyBusinessDTO.toEntity(dto.getCompanyBusiness()));
          /* groupe.setEntreprise(dto.getEntreprise()!= null? dto.getEntreprise().stream().map(EntrepriseDTO::toEntity).collect(Collectors.toList()):null);
		   */
        return groupe;
    }
}
