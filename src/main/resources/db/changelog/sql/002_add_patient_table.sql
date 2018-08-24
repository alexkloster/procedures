CREATE TABLE patient (

  id bigserial NOT NULL,
  name character varying(127) NOT NULL,
  sex character varying(3) NOT NULL,
  day_of_birth DATE,

  CONSTRAINT patient_pk PRIMARY KEY (id)
);