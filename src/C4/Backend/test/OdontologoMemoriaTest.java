package C4.Backend.test;

import C4.Backend.dao.impl.OdontologoDaoMemoria;
import C4.Backend.model.Odontologo;
import C4.Backend.service.OdontologoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OdontologoMemoriaTest {
    private static OdontologoService odontologoService = new OdontologoService(new OdontologoDaoMemoria());

    @Test
    @DisplayName("Testear listado odontologos en memoria")
    void testPacienteGuardado(){
        Odontologo odontologo1 = new Odontologo("BART","SIMPSON","456464");
        Odontologo odontologo2 = new Odontologo("LISSA","SIMPSON","456464");

        Odontologo  odontologoMemoria1 = odontologoService.registrarOdontologo(odontologo1);
        Odontologo  odontologoMemoria2 = odontologoService.registrarOdontologo(odontologo2);

        List<Odontologo> odontologos = odontologoService.listarOdontologos();

        assertEquals(2, odontologos.size());

    }
}
