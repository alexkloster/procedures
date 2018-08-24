CREATE TABLE room (

  id bigserial NOT NULL,
  name character varying(127) NOT NULL,

  CONSTRAINT room_pk PRIMARY KEY (id)
);