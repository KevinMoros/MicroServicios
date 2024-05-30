CREATE database if NOT EXISTS cursobd;
CREATE TABLE cursos(codCurso INT NOT NULL, nombre VARCHAR(255), duracion INT, precio double, PRIMARY KEY(codCurso));