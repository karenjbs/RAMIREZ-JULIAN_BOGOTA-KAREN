package C4.Backend.service;

import C4.Backend.dao.IDao;
import C4.Backend.model.Odontologo;

import java.util.List;

public class OdontologoService {
    private IDao<Odontologo> odontologoIDao;

    public OdontologoService(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    public Odontologo registrarOdontologo(Odontologo odontologo){
        return odontologoIDao.registar(odontologo);
    }

    public List<Odontologo> listarOdontologos(){
        return odontologoIDao.listarTodos();
    }
}
