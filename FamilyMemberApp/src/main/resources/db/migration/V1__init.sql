CREATE SEQUENCE public.id_sequence
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;


CREATE TABLE IF NOT EXISTS public.family_member
(
    id bigint NOT NULL,
    family_id bigint,
    family_name character varying(255) COLLATE pg_catalog."default",
    given_name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT family_member_pkey PRIMARY KEY (id)
)


