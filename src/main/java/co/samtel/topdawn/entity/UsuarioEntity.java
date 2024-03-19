package co.samtel.topdawn.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tbl_usuario")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tbl_name")
    private String name;

    @Column(name = "tbl_lastname")
    private String lastname;
}
