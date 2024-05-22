package C4.Backend.dao.impl;

import C4.Backend.bd.H2Connection;
import C4.Backend.dao.IDao;
import C4.Backend.model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao <Odontologo> {

    private static Logger LOGGER = Logger.getLogger(OdontologoDaoH2.class);
    private static String SQL_INSERT = "INSERT INTO ODONTOLOGOS VALUES (DEFAULT, ?, ?, ?)";
    private static String SQL_SELECT_ALL = "SELECT * FROM ODONTOLOGOS";


    @Override
    public Odontologo registar(Odontologo odontologo) {
        Connection connection = null;
        Odontologo retornarOdontologo = null;

        try {
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, odontologo.getNombre());
            preparedStatement.setString(2, odontologo.getApellido());
            preparedStatement.setString(3, odontologo.getMatricula());

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                retornarOdontologo = new Odontologo(id, odontologo.getNombre(), odontologo.getApellido(), odontologo.getMatricula());
            }

            LOGGER.info("El odontologo es: " + retornarOdontologo);

            connection.commit();
            connection.setAutoCommit(true);

        } catch (Exception e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    LOGGER.info(ex.getMessage());
                    ex.printStackTrace();
                }
            }
            LOGGER.info(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.info(e.getMessage());
                e.printStackTrace();
            }
        }
        return retornarOdontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {
        Connection connection = null;
        List<Odontologo> odontologos = new ArrayList<>();

        try {
            connection = H2Connection.getConnection();
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);
            while (resultSet.next()) {
                Odontologo odontologo = new Odontologo(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4) );

                LOGGER.info("Odontologos devueltos: " + odontologo);
                odontologos.add(odontologo);

            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.error(e.getMessage());
                e.printStackTrace();
            }
        }
        return odontologos;
    }
}
