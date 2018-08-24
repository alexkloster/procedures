CREATE TABLE doctors (

  id bigserial NOT NULL,
  name character varying(127) NOT NULL,

  CONSTRAINT doctors_pk PRIMARY KEY (id)
);