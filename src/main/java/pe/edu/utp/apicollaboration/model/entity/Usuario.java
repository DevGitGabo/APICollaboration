package pe.edu.utp.apicollaboration.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @Column(nullable = false)
    private String codigoUniversitario;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String contrasena;

    @Column(nullable = false)
    private Long numMvp;

    private String descripcion;

    private String imagenUsuario;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleCurso> detalleCursos;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Publicacion> publicaciones;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MiembroGrupo> miembroGrupos;

    @ManyToMany
    @JoinTable(
        name = "usuario_etiqueta",
        joinColumns = @JoinColumn(name = "id_usuario"),
        inverseJoinColumns = @JoinColumn(name = "id_etiqueta")
    )
    private List<Etiqueta> etiquetas;

    @ManyToMany
    @JoinTable(
        name = "usuario_insignia",
        joinColumns = @JoinColumn(name = "id_usuario"),
        inverseJoinColumns = @JoinColumn(name = "id_insignia")
    )
    private List<Insignia> insignias;

    @ManyToMany
    @JoinTable(
        name = "seguidores",
        joinColumns = @JoinColumn(name = "id_seguidor"),
        inverseJoinColumns = @JoinColumn(name = "id_seguido")
    )
    private List<Usuario> seguidos;

    @ManyToMany(mappedBy = "seguidos")
    private List<Usuario> seguidores;
}
