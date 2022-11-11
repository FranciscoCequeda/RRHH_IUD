USE IUD_RRHH;

-- Poblado de tabla Estado Civil
INSERT INTO estados_civiles(estado_civil) VALUES ('SOLTERO/A');
INSERT INTO estados_civiles(estado_civil) VALUES ('CASADO/A');
INSERT INTO estados_civiles(estado_civil) VALUES ('VIUDO/A');
INSERT INTO estados_civiles(estado_civil) VALUES ('UNION LIBRE');
INSERT INTO estados_civiles(estado_civil) VALUES ('SEPARADO/A');

SELECT * FROM estados_civiles;


-- Poblado de tabla Sexo
INSERT INTO sexos(sexo, sigla) VALUES ('MASCULINO', 'M');
INSERT INTO sexos(sexo, sigla) VALUES ('FEMENINO', 'F');
INSERT INTO sexos(sexo, sigla) VALUES ('OTRO', 'O');

SELECT * FROM sexos;

-- Poblado de tabla Parentescos
INSERT INTO parentescos(parentesco) VALUES('Padre');
INSERT INTO parentescos(parentesco) VALUES('Madre');
INSERT INTO parentescos(parentesco) VALUES('Esposo/a');
INSERT INTO parentescos(parentesco) VALUES('Hijo/a');
INSERT INTO parentescos(parentesco) VALUES('Nieto/a');
INSERT INTO parentescos(parentesco) VALUES('Hermano/a');
INSERT INTO parentescos(parentesco) VALUES('Otro/a');

SELECT * FROM parentescos;

-- Poblado de tabla Tipo Documento
INSERT INTO tipo_documentos(tipo_documento, sigla) VALUES('Cedula de ciudadania', 'CC');
INSERT INTO tipo_documentos(tipo_documento, sigla) VALUES('Tarjeta de identidad', 'TI');
INSERT INTO tipo_documentos(tipo_documento, sigla) VALUES('Registro Civil', 'RC');
INSERT INTO tipo_documentos(tipo_documento, sigla) VALUES('Cedula de extranjeria', 'CE');
INSERT INTO tipo_documentos(tipo_documento, sigla) VALUES('Pasaporte', 'PA');

SELECT * FROM tipo_documentos;

-- Poblado de tabla Instituciones Educativas
INSERT INTO instituciones_educativas(nombre_ies, codigo_ies) VALUES('INSTITUCION UNIVERSITARIA DIGITAL DE ANTIOQUIA -IU. DIGITAL', '9927');
INSERT INTO instituciones_educativas(nombre_ies, codigo_ies) VALUES('SERVICIO NACIONAL DE APRENDIZAJE -SENA-', '9110');
INSERT INTO instituciones_educativas(nombre_ies, codigo_ies) VALUES('UNIVERSIDAD DE CORDOBA', '1113');
INSERT INTO instituciones_educativas(nombre_ies, codigo_ies) VALUES('UNIVERSIDAD TECNOLOGICA DE PEREIRA - UTP', '1111');
INSERT INTO instituciones_educativas(nombre_ies, codigo_ies) VALUES('UNIVERSIDAD NACIONAL DE COLOMBIA', '1101');

SELECT * FROM instituciones_educativas;

-- Poblado de tabla Nivel Academico
INSERT INTO niveles_academicos(nivel_academico) VALUES('Profesional');
INSERT INTO niveles_academicos(nivel_academico) VALUES('Tecnico');
INSERT INTO niveles_academicos(nivel_academico) VALUES('Tecnologo');
INSERT INTO niveles_academicos(nivel_academico) VALUES('Bachiller');
INSERT INTO niveles_academicos(nivel_academico) VALUES('Magister');
INSERT INTO niveles_academicos(nivel_academico) VALUES('Doctorado');

SELECT * FROM niveles_academicos;

-- Poblado de tabla Funcionarios
INSERT INTO funcionarios(tipo_documento_id, numero_identificacion, nombre1, nombre2, apellido1, apellido2, fecha_nacimiento, estado_civil_id, sexo_id, direccion, celular)
VALUES(1, '1063298244', 'FRANCISCO', 'LUIS', 'CEQUEDA', 'ALVAREZ', '1994-09-09', 1, 1, 'Montelibano', '3145066923'), 
	  (1, '50959498', 'RAMONA', '','PINEDA', 'SEQUEDA', '1975-05-09', 1, 2, 'Montelibano', '3205488251'),
      (1, '30060842', 'ELIZABETH', '','CEQUEDA', 'ALVAREZ', '1956-05-11', 3, 2, 'Montelibano', '3023139803'),
      (2, '1063304475', 'JORGE', 'LUIS', 'JARABA', 'PINEDA', '2015-03-15', 1, 1, 'Montelibano', '3154124774');

SELECT * FROM funcionarios;


-- Poblado de tabla Informacion Academica
INSERT INTO informaciones_academicas(funcionario_id, nivel_academico_id, titulo, instituciones_educativas_id, fecha_inicio, fecha_fin)
VALUES(1, 1, 'ADMINISTRADOR EN FINANZAS Y NEGOCIOS INTERNACIONALES', 3, '2012-07-15', '2017-07-27'), 
	  (1, 2, 'TECNICO EN SISTEMAS', 2, '2013-03-09', '2015-10-20'),
      (1, 2, 'TECNICO EN PROGRAMACION DE SOFTWARE', 2, '2017-09-23', '2019-05-15'),
      (1, 3, 'TECNOLOGO EN DESARROLLO DE SOFTWARE', 1, '2020-10-20', '2023-03-20');

SELECT * FROM informaciones_academicas;

-- Poblado de tabla grupo Familiar
INSERT INTO grupos_familiares(funcionarios_id, tipo_documento_id, numero_documento, nombre1, nombre2, apellido1, apellido2, fecha_nacimiento, sexo_id, estado_civil_id, direccion, celular, parentesco_id)
VALUES(1, 1, '50959498', 'RAMONA', '','PINEDA', 'SEQUEDA', '1975-05-09', 1, 2, 'Montelibano', '3205488251', 6),
      (1, 1, '30060842', 'ELIZABETH', '','CEQUEDA', 'ALVAREZ', '1956-05-11', 3, 2, 'Montelibano', '3023139803', 1),
      (1, 2, '1063304475', 'JORGE', 'LUIS', 'JARABA', 'PINEDA', '2015-03-15', 1, 1, 'Montelibano', '3154124774', 7);

SELECT * FROM grupos_familiares;