package pe.edu.utp.apicollaboration.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.utp.apicollaboration.model.entity.Insignia;

public interface InsigniaDao extends CrudRepository<Insignia, Long> {
}
