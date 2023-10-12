CREATE TABLE IF NOT EXISTS public.usuario (
    rut character varying(30) COLLATE pg_catalog."default" NOT NULL,
    nombres character varying(30) COLLATE pg_catalog."default" NOT NULL,
    apellidos character varying(30) COLLATE pg_catalog."default" NOT NULL,
    email character varying(30) COLLATE pg_catalog."default" NOT NULL,
    pass character varying(15) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT usuario_pkey PRIMARY KEY (rut)
)
TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.usuario
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.tarea (
    id_tarea SERIAL PRIMARY KEY,
    titulo character varying(255) COLLATE pg_catalog."default" NOT NULL,
    descripcion character varying(255) COLLATE pg_catalog."default" NOT NULL,
    fechaCreacion character varying(30) NOT NULL,
    fechaFin character varying(30) NULL,
    estado character varying(30) COLLATE pg_catalog."default" NOT NULL,
    prioridad character varying(30) COLLATE pg_catalog."default",
    rut character varying(30) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT fk_usuario FOREIGN KEY (rut)
        REFERENCES public.usuario (rut) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.tarea
    OWNER to postgres;


INSERT INTO usuario(rut, nombres, apellidos, email, pass) VALUES ('19999998-k', 'Juan Carlos', 'Perez Gomez', 'juan@gmail.com', 'clave1');
INSERT INTO usuario(rut, nombres, apellidos, email, pass) VALUES ('20.000.002-2', 'Maria Isabel', 'Lopez Rodriguez', 'maria@gmail.com', 'clave2');
INSERT INTO usuario(rut, nombres, apellidos, email, pass) VALUES ('20.000.003-3', 'Pedro Antonio', 'Gonzalez Perez', 'pedro@gmail.com', 'clave3');
INSERT INTO usuario(rut, nombres, apellidos, email, pass) VALUES ('20.000.004-4', 'Luis Miguel', 'Rodriguez Martinez', 'luis@gmail.com', 'clave4');
INSERT INTO usuario(rut, nombres, apellidos, email, pass) VALUES ('20.000.005-5', 'Ana Maria', 'Martinez Garcia', 'ana@gmail.com', 'clave5');

INSERT INTO usuario(rut,nombres,apellidos,email,pass) VALUES ('19999998','Juan Carlos','Cuarenta Veinte','correo40@gmail.com','cocolegran');
INSERT INTO usuario(rut,nombres,apellidos,email,pass) VALUES ('284329','Carlos','Pinto','tututu@gmail.com','suspenso');
INSERT INTO usuario(rut,nombres,apellidos,email,pass) VALUES ('311200','Jesu','Cristo','cruz@gmail.cl','amen');
INSERT INTO usuario(rut,nombres,apellidos,email,pass) VALUES ('313131','Felix','Poio','pollito@gmail.com','noeasy');
INSERT INTO usuario(rut,nombres,apellidos,email,pass) VALUES ('471623','Pedro','Pedrozo','piedrita@gmail.com','piedrota');
INSERT INTO usuario(rut,nombres,apellidos,email,pass) VALUES ('512392','Pedrito','Pascal','papito@gmail.com','mandalor');
INSERT INTO usuario(rut,nombres,apellidos,email,pass) VALUES ('887238','Juan','Zolezzi','triplez@gmail.com','usachita');
INSERT INTO usuario(rut,nombres,apellidos,email,pass) VALUES ('992312','Gabriel','Boric','chilito@gmail.com','polonia');
INSERT INTO usuario(rut,nombres,apellidos,email,pass) VALUES ('623432','Alan','Turing','maquinadeturing@gmail.com','manzanita');
INSERT INTO usuario(rut,nombres,apellidos,email,pass) VALUES ('113874','Alan','Turing','maquinadeturing@gmail.com','manzanita');


INSERT INTO tarea(id_tarea, titulo, descripcion, fechacreacion, fechafin, estado, prioridad, rut) VALUES (1000,'Pago', 'Realizar el pago por medio de tarjeta u transferencia.', '7-10-2023', '9-10-2023', 'Finalizado', 'Alta', '19999998-k');
INSERT INTO tarea(id_tarea, titulo, descripcion, fechacreacion, fechafin, estado, prioridad, rut) VALUES (1002,'Evaluación', 'Revisar el estado del sector y medios de comunicacion.', '10-10-2023', '11-10-2023', 'Pendiente', 'Media', '19999998-k');
INSERT INTO tarea(id_tarea, titulo, descripcion, fechacreacion, fechafin, estado, prioridad, rut) VALUES (1003,'Contratar', 'Obtener personal para el proyecto.', '12-10-2023', '16-10-2023', 'Pendiente', 'Alta', '19999998-k');
INSERT INTO tarea(id_tarea, titulo, descripcion, fechacreacion, fechafin, estado, prioridad, rut) VALUES (1004,'Cambio de herramientas', 'Obtener herramientas actualizadas para una buena aplicacion.', '3-10-2023', '9-10-2023', 'Finalizado', 'Baja', '19999998-k');
INSERT INTO tarea(id_tarea, titulo, descripcion, fechacreacion, fechafin, estado, prioridad, rut) VALUES (1005,'Asignación de personal', 'Asignar personal respectivas tareas para el proyecto.', '16-10-2023', '20-10-2023', 'Pendiente', 'Alta', '19999998-k');
INSERT INTO tarea(id_tarea, titulo, descripcion, fechacreacion, fechafin, estado, prioridad, rut) VALUES (1006,'Traslacion', 'Trasladar herramientas.', '4-10-2023', '5-10-2023', 'Finalizado', 'Baja', '19999998-k');
INSERT INTO tarea(id_tarea, titulo, descripcion, fechacreacion, fechafin, estado, prioridad, rut) VALUES (1007,'Reemplazo', 'Reemplazar utilidades desgastadas.', '10-10-2023', '11-10-2023', 'Pendiente', 'Baja', '19999998-k');
INSERT INTO tarea(id_tarea, titulo, descripcion, fechacreacion, fechafin, estado, prioridad, rut) VALUES (1008,'Actualización', 'Actualizar inventario.', '16-10-2023', '17-10-2023', 'Pendiente', 'Media', '19999998-k');
INSERT INTO tarea(id_tarea, titulo, descripcion, fechacreacion, fechafin, estado, prioridad, rut) VALUES (1009,'Traspaso de información', 'Contactar con interesados en el proyecto para recabar información.', '12-10-2023', '20-10-2023', 'Pendiente', 'Alta', '19999998-k');
