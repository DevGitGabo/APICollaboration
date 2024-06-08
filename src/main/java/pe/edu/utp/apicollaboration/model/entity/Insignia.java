package pe.edu.utp.apicollaboration.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "insignia")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Insignia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInsignia;

    @Column(nullable = false)
    private String nombreInsignia;

    @ManyToMany(mappedBy = "insignias")
    private List<Usuario> usuarios;
}
