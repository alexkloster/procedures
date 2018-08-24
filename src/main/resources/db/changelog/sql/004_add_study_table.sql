CREATE TABLE study (

  id bigserial NOT NULL,
  patient_id int NOT NULL,
  description character varying(127) NOT NULL,
  status character varying(127) NOT NULL,
  planned_start_time date not null,
  estimated_end_time date,
  room_id int not null,
  doctor_id int not null,

  CONSTRAINT study_pk PRIMARY KEY (id),
  CONSTRAINT patient_fk FOREIGN KEY (patient_id)
      REFERENCES patient (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE,
  CONSTRAINT doctor_fk FOREIGN KEY (doctor_id)
      REFERENCES doctors (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE,
  CONSTRAINT room_fk FOREIGN KEY (room_id)
      REFERENCES room (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE
);