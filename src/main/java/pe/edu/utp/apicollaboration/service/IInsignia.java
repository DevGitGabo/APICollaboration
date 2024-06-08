package pe.edu.utp.apicollaboration.service;

import pe.edu.utp.apicollaboration.model.entity.Insignia;

public interface IInsignia {
    Insignia save(Insignia insignia);
    Insignia findById(Long id);
    void delete(Insignia insignia);
}
