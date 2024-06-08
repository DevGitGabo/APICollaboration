package pe.edu.utp.apicollaboration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.utp.apicollaboration.model.dao.InsigniaDao;
import pe.edu.utp.apicollaboration.model.entity.Insignia;
import pe.edu.utp.apicollaboration.service.IInsignia;

@Service
public class InsigniaImplService implements IInsignia {

    @Autowired
    private InsigniaDao insigniaDao;

    @Override
    @Transactional
    public Insignia save(Insignia insignia) {
        return insigniaDao.save(insignia);
    }

    @Override
    @Transactional(readOnly = true)
    public Insignia findById(Long id) {
        return insigniaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Insignia insignia) {
        insigniaDao.delete(insignia);
    }
}
