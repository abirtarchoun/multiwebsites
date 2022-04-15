package app.igesa.dto;

import app.igesa.entity.Groupe;
import app.igesa.entity.Meta;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MetaDTO {
	
	private Long id ;
	private String metatitle ;
	private String metadescription ;
	private String  urlkey;
	private String metakey ;
	//private PostDTO post;
	private ProductDTO product;


	public static MetaDTO fromEntity(Meta meta ) {

		return MetaDTO.builder()
				.id(meta.getId())
				.metakey(meta.getMetakey())
				.metatitle(meta.getMetatitle())
				.metadescription(meta.getMetadescription())
				.urlkey(meta.getUrlkey())
				.product(ProductDTO.fromEntity(meta.getProduct()))
				.build();
	}


	public static Meta toEntity(MetaDTO dto) {
		if (dto==null) {
			return null; }
		    Meta meta = new Meta();
		    meta.setId(dto.getId());
			meta.setMetakey(dto.getMetakey());
			meta.setMetatitle(dto.getMetatitle());
			meta.setMetadescription(dto.getMetadescription());
			meta.setUrlkey(dto.getUrlkey());
			return meta;
	}
}
