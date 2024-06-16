create database scg_db default character set utf8mb4 ;
use scg_db ;

create table tipo_documento (
  id_tipo_docum int not null primary key auto_increment,
  nom_documento varchar(45) not null
);

create table persona (
  id_person bigint not null primary key auto_increment,
  nombres varchar(45) not null,
  apellidos varchar(45) not null,
  cedula bigint not null unique,
  celular bigint not null,
  nom_contacto varchar(45) not null,
  celular_alt bigint not null,
  email varchar(45) not null unique,
  tipo_documento int,
  constraint fk_persona_tipodocumento
    foreign key (tipo_documento)
    references tipo_documento (id_tipo_docum) on delete set null
);

create table formacion (
  id_formacion int not null primary key auto_increment,
  nom_formacion varchar(70) not null
);

create table ficha (
  id_ficha int not null primary key auto_increment,
  numero bigint not null,
  formacion int,
  constraint fk_ficha_formacion
    foreign key (formacion)
    references formacion (id_formacion) on delete set null
);

create table aprendiz (
  id_aprend bigint not null primary key auto_increment,
  restric_medicas varchar(200) not null,
  persona bigint not null unique,
  ficha int,
  constraint fk_aprendiz_persona
    foreign key (persona)
    references persona (id_person),
  constraint fk_aprendiz_ficha
    foreign key (ficha)
    references ficha (id_ficha)
);

create table asistencia (
  id_asist bigint not null primary key auto_increment,
  fecha datetime not null,
  aprendiz bigint,
  constraint fk_asistencia_aprendiz
    foreign key (aprendiz)
    references aprendiz (id_aprend) on delete cascade
);

create table cargo (
  id_cargo int not null primary key auto_increment,
  nom_cargo varchar(45) not null
);

create table personal (
  id_personal bigint not null primary key auto_increment,
  persona bigint not null unique,
  cargo int,
  constraint fk_personal_persona
    foreign key (persona)
    references persona (id_person),
  constraint fk_personal_cargo
    foreign key (cargo)
    references cargo (id_cargo) on delete set null
);

create table usuario (
  id_usu bigint not null primary key auto_increment,
  nom_usu varchar(45) not null unique,
  cont_usu varchar(45) not null,
  personal bigint not null unique,
  constraint fk_usuario_personal
    foreign key (personal)
    references personal (id_personal)
);

create table plan (
  id_plan int not null primary key auto_increment,
  nom_plan varchar(45) not null,
  meses int not null
);

create table aprendiz_plan (
  id_aprendiz_plan bigint not null primary key auto_increment,
  inicio date not null,
  finaliza date not null,
  aprendiz bigint,
  plan int,
  constraint fk_aprendizplan_aprendiz
    foreign key (aprendiz)
    references aprendiz (id_aprend) on delete cascade,
  constraint fk_aprendizplan_plan
    foreign key (plan)
    references plan (id_plan) on delete cascade
);

create table nombre_ejercicio (
  id_nom_ejerc int not null primary key auto_increment,
  nom_ejerc varchar(45) not null
);

create table tipo_ejercicio (
  id_tipo_ejerc int not null primary key auto_increment,
  nom_tipo_ejerc varchar(45) not null
);

create table musculo (
  id_musculo int not null primary key auto_increment,
  nom_musculo varchar(45) not null
);

create table ejercicio (
  id_ejercicio int not null primary key auto_increment,
  series int not null,
  repeticiones int not null,
  descanso int not null,
  nombre_ejercicio int,
  tipo_ejercicio int,
  musculo int,
  constraint fk_ejercicio_nombreejercicio
    foreign key (nombre_ejercicio)
    references nombre_ejercicio (id_nom_ejerc) on delete set null,
  constraint fk_ejercicio_tipoejercicio
    foreign key (tipo_ejercicio)
    references tipo_ejercicio (id_tipo_ejerc) on delete set null,
  constraint fk_ejercicio_musculo
    foreign key (musculo)
    references musculo (id_musculo) on delete set null
);

create table genero (
  id_genero int not null primary key auto_increment,
  nom_genero varchar(45) not null
);

create table fichaantropo (
  id_fich_ant bigint not null primary key auto_increment,
  num_control int not null,
  fecha_toma date not null,
  altura float not null,
  peso float not null,
  imc float not null,
  personal bigint,
  genero int,
  aprendiz bigint,
  constraint fk_fichaAntropo_personal
    foreign key (personal)
    references personal (id_personal) on delete set null,
  constraint fk_fichaAntropo_genero
    foreign key (genero)
    references genero (id_genero) on delete set null,
  constraint fk_fichaAntropo_aprendiz
    foreign key (aprendiz)
    references aprendiz (id_aprend) on delete cascade
);

create table perimetros (
  id_perimetros bigint not null primary key auto_increment,
  cabeza float not null,
  cuello float not null,
  brazo_relax float not null,
  brazo_tensionado float not null,
  antebrazo float not null,
  muñeca float not null,
  torax float not null,
  cintura float not null,
  cadera float not null,
  muslo_max float not null,
  muslo_min float not null,
  pantorrilla_max float not null,
  pantorrilla_min float not null,
  fichaantropo bigint not null unique,
  constraint fk_perimetros_fichaAntropo
    foreign key (fichaantropo)
    references fichaantropo (id_fich_ant)
);

create table tipo_rutina (
  id_tipo_rutina int not null primary key auto_increment,
  nom_rutina varchar(45) not null
);

create table rutina (
  id_rutina int not null primary key auto_increment,
  numero_rutina int not null,
  tipo_rutina int,
  constraint fk_rutina_tiporutina
    foreign key (tipo_rutina)
    references tipo_rutina (id_tipo_rutina) on delete set null
);

create table plan_rutina (
  id_plan_rutina int not null primary key auto_increment,
  plan int,
  rutina int,
  constraint fk_planrutina_plan
    foreign key (plan)
    references plan (id_plan) on delete cascade,
  constraint fk_planrutina_rutina
    foreign key (rutina)
    references rutina (id_rutina) on delete cascade
);

create table rutina_ejercicio (
  id_rutina_ejercicio int not null primary key auto_increment,
  rutina int,
  ejercicio int,
  constraint fk_rutinaejercicio_rutina
    foreign key (rutina)
    references rutina (id_rutina) on delete cascade,
  constraint fk_rutinaejercicio_ejercicio
    foreign key (ejercicio)
    references ejercicio (id_ejercicio) on delete cascade
);

insert into tipo_documento (nom_documento) values ("cedula de ciudadania");
insert into tipo_documento (nom_documento) values ("cedula de extranjeria");
insert into tipo_documento (nom_documento) values ("tarjeta de identidad");

insert into persona (nombres, apellidos, cedula, celular, nom_contacto, celular_alt, email, tipo_documento) values ("Diana", "Acevedo Martinez", 607901669, 315683455, "Carlos Orozco", 321409264, "diam123@gmail.com",1);
insert into persona (nombres, apellidos, cedula, celular, nom_contacto, celular_alt, email, tipo_documento) values ("Laura Nataly", "Giraldo Rodriguez", 1020123456, 31012312345, "Liliana Rodriguez", 3203456789, "lngr2020@gmail.com",1);

insert into cargo (nom_cargo) values ("instructor");
insert into cargo (nom_cargo) values ("medico");
insert into cargo (nom_cargo) values ("administrador");

insert into personal (persona, cargo) values (1,1);

insert into usuario (nom_usu, cont_usu, personal) values ("607901669", "Gimnasio2024*", 1);

insert into formacion (nom_formacion) values ("Tecnologia en Analisis y Desarrollo de Software");

insert into ficha (numero, formacion) values (2521999, 1);
insert into ficha (numero, formacion) values (2522000, 1);
insert into ficha (numero, formacion) values (2522001, 1);
insert into ficha (numero, formacion) values (2522002, 1);

insert into aprendiz (restric_medicas, persona, ficha) values ("Ninguna", 2, 2);

insert into genero (nom_genero) values ("masculino");
insert into genero (nom_genero) values ("femenino");

insert into fichaantropo (num_control, fecha_toma, altura, peso, imc, personal, genero, aprendiz) values (1, "2024-06-09", 1.55, 53, 20, 1, 2, 1);

insert into perimetros (cabeza, cuello, brazo_relax, brazo_tensionado, antebrazo, muñeca, torax, cintura, cadera, muslo_max, muslo_min, pantorrilla_max, pantorrilla_min, fichaantropo) values (55, 30, 27, 28, 22,14, 85.5, 67, 90, 54, 52, 32, 20, 1);

insert into asistencia (fecha, aprendiz) values ("2024-06-12 16:39:21", 1);

insert into plan (nom_plan, meses) values ("Aumentar masa muscular", 3);

insert into aprendiz_plan (inicio, finaliza, aprendiz, plan) values ("2024-06-08", "2024-09-16", 1, 1);

insert into tipo_rutina (nom_rutina) values ("Full-Fuerza");
insert into tipo_rutina (nom_rutina) values ("Full-Resistencia");
insert into tipo_rutina (nom_rutina) values ("Fuerza");
insert into tipo_rutina (nom_rutina) values ("Resistencia");
insert into tipo_rutina (nom_rutina) values ("hibrido");

insert into rutina (numero_rutina, tipo_rutina) values (1, 1);

insert into plan_rutina (plan, rutina) values (1, 1);

insert into nombre_ejercicio (nom_ejerc) values ("abdominales");
insert into nombre_ejercicio (nom_ejerc) values ("barra en supina");
insert into nombre_ejercicio (nom_ejerc) values ("barra en pronadas");
insert into nombre_ejercicio (nom_ejerc) values ("peso muerto");
insert into nombre_ejercicio (nom_ejerc) values ("sentadillas");
insert into nombre_ejercicio (nom_ejerc) values ("levantamiento de pesas");
insert into nombre_ejercicio (nom_ejerc) values ("flexiones de pecho");

insert into tipo_ejercicio (nom_tipo_ejerc) values ("fuerza");
insert into tipo_ejercicio (nom_tipo_ejerc) values ("equilibrado");
insert into tipo_ejercicio (nom_tipo_ejerc) values ("resistencia");

insert into musculo (nom_musculo) values ("adominal");
insert into musculo (nom_musculo) values ("espalda");
insert into musculo (nom_musculo) values ("pectoral");
insert into musculo (nom_musculo) values ("bipces");
insert into musculo (nom_musculo) values ("tripces");
insert into musculo (nom_musculo) values ("muslo");

insert into ejercicio (series, repeticiones, descanso, nombre_ejercicio, tipo_ejercicio, musculo) values (4, 8, 2, 1, 1, 1);
insert into ejercicio (series, repeticiones, descanso, nombre_ejercicio, tipo_ejercicio, musculo) values (6, 12, 3, 7, 2, 2);

insert into rutina_ejercicio (rutina, ejercicio) values (1, 1);
insert into rutina_ejercicio (rutina, ejercicio) values (1, 2);