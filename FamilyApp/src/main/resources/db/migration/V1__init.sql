CREATE SEQUENCE public.id_sequence
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;


CREATE TABLE IF NOT EXISTS public.family
(
    id bigint NOT NULL,
    family_name character varying(255) COLLATE pg_catalog."default",
    nr_of_adults integer NOT NULL,
    nr_of_children integer NOT NULL,
    nr_of_infants integer NOT NULL,
    CONSTRAINT family_pkey PRIMARY KEY (id)
)