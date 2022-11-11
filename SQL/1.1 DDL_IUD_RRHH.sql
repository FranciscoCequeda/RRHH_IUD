-- Creacion de DB
CREATE DATABASE IF NOT EXISTS IUD_RRHH;

-- Uso de DB
USE IUD_RRHH;

-- Tabla sexo
CREATE TABLE IF NOT EXISTS sexos (
  id INT NOT NULL AUTO_INCREMENT,
  sexo VARCHAR(45) NOT NULL UNIQUE,
  sigla VARCHAR(10) NOT NULL UNIQUE,
  estado TINYINT(1) NOT NULL DEFAULT 1,
  fecha_creacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id));

-- Tabla estados civiles
CREATE TABLE IF NOT EXISTS estados_civiles (
  id INT NOT NULL AUTO_INCREMENT,
  estado_civil VARCHAR(45) NOT NULL UNIQUE,
  estado TINYINT(1) NOT NULL DEFAULT 1,
  fecha_creacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id));

-- Tabla tipo documentos
CREATE TABLE IF NOT EXISTS tipo_documentos(
  id INT NOT NULL AUTO_INCREMENT,
  tipo_documento VARCHAR(45) NOT NULL UNIQUE,
  sigla VARCHAR(6) NOT NULL UNIQUE,
  estado TINYINT(1) NOT NULL DEFAULT 1,
  fecha_creacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id));

-- Tabla funcionarios
CREATE TABLE IF NOT EXISTS funcionarios (
  id INT NOT NULL AUTO_INCREMENT,
  tipo_documento_id INT NOT NULL,
  numero_identificacion VARCHAR(25) NOT NULL UNIQUE,
  nombre1 VARCHAR(40) NOT NULL,
  nombre2 VARCHAR(45) NULL,
  apellido1 VARCHAR(45) NOT NULL,
  apellido2 VARCHAR(45) NOT NULL,
  fecha_nacimiento DATE NOT NULL,
  estado_civil_id INT NOT NULL,
  sexo_id INT NOT NULL,
  direccion VARCHAR(255) NOT NULL,
  celular VARCHAR(15) NOT NULL,
  estado TINYINT(1) NOT NULL DEFAULT 1,
  fecha_creacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  FOREIGN KEY (sexo_id) REFERENCES sexos(id),
  FOREIGN KEY (estado_civil_id) REFERENCES estados_civiles(id),
  FOREIGN KEY (tipo_documento_id) REFERENCES tipo_documentos(id));

-- Tabla niveles academicos
CREATE TABLE IF NOT EXISTS niveles_academicos (
  id INT NOT NULL AUTO_INCREMENT,
  nivel_academico VARCHAR(50) NOT NULL,
  estado TINYINT(1) NOT NULL DEFAULT 1,
  fecha_creacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY(id));

-- Tabla instituciones educativas
CREATE TABLE IF NOT EXISTS instituciones_educativas (
  id INT NOT NULL AUTO_INCREMENT,
  nombre_ies VARCHAR(255) NOT NULL UNIQUE,
  codigo_ies VARCHAR(5) NOT NULL UNIQUE,
  estado TINYINT(1) NOT NULL DEFAULT 1,
  fecha_creacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY(id));

-- Tabla informaciones academicas
CREATE TABLE IF NOT EXISTS informaciones_academicas (
  id INT NOT NULL AUTO_INCREMENT,
  funcionario_id INT NOT NULL,
  nivel_academico_id INT NOT NULL,
  titulo VARCHAR(255) NOT NULL,
  instituciones_educativas_id INT NOT NULL,
  fecha_inicio DATE NOT NULL,
  fecha_fin DATE NOT NULL,
  estado TINYINT(1) NOT NULL DEFAULT 1,
  fecha_creacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  FOREIGN KEY (nivel_academico_id) REFERENCES niveles_academicos(id),
  FOREIGN KEY (instituciones_educativas_id) REFERENCES instituciones_educativas(id),
  FOREIGN KEY (funcionario_id) REFERENCES funcionarios(id));

-- Tabla parentescos
CREATE TABLE IF NOT EXISTS parentescos (
  id INT NOT NULL AUTO_INCREMENT,
  parentesco VARCHAR(45) NOT NULL,
  estado TINYINT(1) NOT NULL DEFAULT 1,
  fecha_creacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY(id));

-- Tabla grupos familiares
CREATE TABLE IF NOT EXISTS grupos_familiares (
  id INT NOT NULL AUTO_INCREMENT,
  funcionarios_id INT NOT NULL,
  tipo_documento_id INT NOT NULL,
  numero_documento VARCHAR(11) NOT NULL,
  nombre1 VARCHAR(45) NOT NULL,
  nombre2 VARCHAR(45) NULL,
  apellido1 VARCHAR(45) NOT NULL,
  apellido2 VARCHAR(45) NOT NULL,
  fecha_nacimiento DATE NOT NULL,
  sexo_id INT NOT NULL,
  estado_civil_id INT NOT NULL,
  direccion VARCHAR(255) NOT NULL,
  celular VARCHAR(15) NOT NULL,
  parentesco_id INT NOT NULL,
  estado TINYINT(1) NOT NULL DEFAULT 1,
  fecha_creacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  FOREIGN KEY (parentesco_id) REFERENCES parentescos(id),
  FOREIGN KEY (funcionarios_id) REFERENCES funcionarios(id),
  FOREIGN KEY (tipo_documento_id) REFERENCES tipo_documentos(id),
  FOREIGN KEY (sexo_id) REFERENCES sexos(id),
  FOREIGN KEY (estado_civil_id)REFERENCES estados_civiles(id));