package app.igesa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(name = "Username")
    private String username ;

    @Column(name = "Firsname")
    private String Firstname;

    @Column(name = "Lastname")
    private String Lastname;

    @Column(name = "Password")
    private String password;

    @Column(name = "Datebirth")
    private LocalDate Datebirth ;

    @Column(name = "CodeFiscale")
    private String fiscaleCode;

    @Column(name = "BarreCode")
    private String bareCode ;

    @Column(name = "Email")
    private String email ;


    /******************** relation *************************/

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "groupe_id")
    private Groupe groupe ;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private Role role ;



}
