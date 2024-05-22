DROP TABLE IF EXISTS ODONTOLOGOS;
CREATE TABLE ODONTOLOGOS (
                            ID INT AUTO_INCREMENT PRIMARY KEY,
                            NOMBRE VARCHAR(50) NOT NULL,
                            APELLIDO VARCHAR(50) NOT NULL,
                            MATRICULA VARCHAR(50) NOT NULL
                            );

INSERT INTO ODONTOLOGOS VALUES (DEFAULT, 'HOMERO', 'SIMPSON','1234'),
                               (DEFAULT, 'MAGGIE', 'SIMPSON','4567');
