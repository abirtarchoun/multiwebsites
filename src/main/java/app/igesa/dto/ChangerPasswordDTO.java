package app.igesa.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ChangerPasswordDTO {
    private Long id ;
    private String password ;
    private String confirmPassword ;
}
