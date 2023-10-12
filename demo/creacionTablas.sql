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
