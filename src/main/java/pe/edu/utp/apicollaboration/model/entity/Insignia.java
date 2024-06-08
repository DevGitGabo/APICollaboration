package pe.edu.utp.apicollaboration.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "insignia")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Insignia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInsignia;

    @Column(nullable = false)
    private String nombreInsignia;

    @ManyToMany(mappedBy = "insignias")
    private List<Usuario> usuarios;
}
