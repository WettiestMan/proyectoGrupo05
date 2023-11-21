SET NOCOUNT ON 
GO

USE master
GO
IF exists (SELECT * FROM sysdatabases WHERE name='BeatoJuanPabloII') 
        DROP DATABASE BeatoJuanPabloII 
GO

CREATE DATABASE BeatoJuanPabloII 
GO

USE BeatoJuanPabloII 
GO

CREATE TABLE Empleados ( 
    id_Empleado INTEGER IDENTITY(1, 1) PRIMARY KEY NOT NULL, 
    Nombre       VARCHAR(30) NOT NULL,
    Apellidos    VARCHAR(30) NOT NULL,
    Cargo        VARCHAR(20) NOT NULL,
    Sueldo       MONEY       NOT NULL,
)
GO

CREATE TABLE Profesores ( 
    id_Profesor INTEGER IDENTITY(1, 1) PRIMARY KEY NOT NULL,
    Nombre        VARCHAR(60) NOT NULL,
    Apellidos     VARCHAR(60) NOT NULL,
    Sueldo        MONEY       NOT NULL,
)
GO

CREATE TABLE Estudiantes (
    id_Estudiante     INTEGER IDENTITY(1, 1) PRIMARY KEY NOT NULL,
    Nombre            VARCHAR(255)    NOT NULL,
    Apellidos         VARCHAR(255)    NOT NULL,
    DNI               INTEGER         NOT NULL,
    Email             VARCHAR (255)   NOT NULL,
    numero_telefonico INTEGER         NOT NULL,
)
GO

CREATE TABLE Clases (
    id_Clase    INTEGER IDENTITY(1, 1) PRIMARY KEY NOT NULL,
    Nivel       VARCHAR(10)  NOT NULL,
    Grado       TINYINT      NOT NULL,
    Seccion     CHAR (1)     NOT NULL,
    id_Profesor INTEGER      NOT NULL REFERENCES Profesores,
)
GO

CREATE TABLE Pago (
    id_Pago     INTEGER IDENTITY(1, 1) PRIMARY KEY NOT NULL,
    DNI_cliente INTEGER             NOT NULL,
    Fecha       DATE                NOT NULL,
    id_Empleado INTEGER             NOT NULL REFERENCES Empleados,
)
GO

 CREATE TABLE Estudiantes_Clases (
    id_Est_Clase  INTEGER IDENTITY(1, 1) PRIMARY KEY NOT NULL,
    id_Clase      INTEGER            NOT NULL REFERENCES Clases,
    id_Estudiante INTEGER            NOT NULL REFERENCES Estudiantes,
    Estado        VARCHAR(20)        NOT NULL,
)
GO

CREATE TABLE Detalle_Pago (
    id_DetallePago      INTEGER IDENTITY(1, 1) PRIMARY KEY NOT NULL,
    id_Pago             INTEGER       NOT NULL REFERENCES Pago,
    costo               INTEGER       NOT NULL,
    descripcion         VARCHAR(255)  NOT NULL,
    razon               VARCHAR(255)  NOT NULL,
    id_Estudiante_Clase INTEGER       NOT NULL REFERENCES Estudiantes_Clases
)
GO 

CREATE TABLE Cursos (
    id_Curso    INTEGER IDENTITY(1, 1) PRIMARY KEY NOT NULL,
    Titulo      VARCHAR(50)        NOT NULL,
    id_Profesor INTEGER            NOT NULL REFERENCES Profesores,
    id_Clase    INTEGER            NOT NULL REFERENCES Clases,
)
GO
