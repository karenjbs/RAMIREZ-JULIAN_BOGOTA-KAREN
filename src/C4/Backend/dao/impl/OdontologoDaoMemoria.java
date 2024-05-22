package C4.Backend.dao.impl;

import C4.Backend.dao.IDao;
import C4.Backend.model.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoMemoria implements IDao <Odontologo> {

    private Logger LOGGER = Logger.getLogger(OdontologoDaoMemoria.class);
    List<Odontologo> odontologos = new ArrayList<>();
    @Override
    public Odontologo registar(Odontologo odontologo) {
        Integer id = odontologos.size()+1;
        odontologo.setId(id);

        odontologos.add(odontologo);
        LOGGER.info("odontologo guardado: "+ odontologo);
        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {
        for (Odontologo odontologo: odontologos){
            LOGGER.info("Odontologo en lista: " + odontologo);
        }
        return odontologos;
    }
}
