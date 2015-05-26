
CREATE SEQUENCE vehicle_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1140
  CACHE 1;
ALTER TABLE vehicle_id_seq
  OWNER TO postgres;


CREATE TABLE car
(
  id integer NOT NULL DEFAULT nextval('vehicle_id_seq'::regclass),
  color character varying(255) NOT NULL,
  no_wheels integer NOT NULL,
  last_update timestamp without time zone NOT NULL DEFAULT now(),
  no_doors integer NOT NULL,
  CONSTRAINT car_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE car
  OWNER TO postgres;

CREATE TRIGGER last_updated
  BEFORE UPDATE
  ON car
  FOR EACH ROW
  EXECUTE PROCEDURE last_updated();



CREATE TABLE chopper
(
  id integer NOT NULL DEFAULT nextval('vehicle_id_seq'::regclass),
  color character varying(255) NOT NULL,
  no_wheels integer NOT NULL,
  last_update timestamp without time zone NOT NULL DEFAULT now(),
  CONSTRAINT chopper_pkey PRIMARY KEY (id),
  CONSTRAINT chopper_id_fkey FOREIGN KEY (id)
      REFERENCES chopper (id) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE RESTRICT
)
WITH (
  OIDS=FALSE
);
ALTER TABLE chopper
  OWNER TO postgres;

CREATE TRIGGER last_updated
  BEFORE UPDATE
  ON chopper
  FOR EACH ROW
  EXECUTE PROCEDURE last_updated();


  
  
CREATE SEQUENCE passenger_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1140
  CACHE 1;
ALTER TABLE passenger_id_seq
  OWNER TO postgres;


CREATE TABLE passenger
(
  id integer NOT NULL DEFAULT nextval('passenger_id_seq'::regclass),
  first_name character varying(45) NOT NULL,
  last_name character varying(45) NOT NULL,
  last_update timestamp without time zone NOT NULL DEFAULT now(),
  CONSTRAINT passenger_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE passenger
  OWNER TO postgres;

CREATE TRIGGER last_updated
  BEFORE UPDATE
  ON passenger
  FOR EACH ROW
  EXECUTE PROCEDURE last_updated();

  
 CREATE TABLE passenger_vehicle
(
  passenger_id integer NOT NULL,
  car_id integer,
  chopper_id integer,
  vehicle_type character varying(45) NOT NULL,
  last_update timestamp without time zone NOT NULL DEFAULT now(),
  CONSTRAINT passenger_vehicle_unique UNIQUE (passenger_id),
  CONSTRAINT passenger_vehicle_passenger_id_fkey FOREIGN KEY (passenger_id)
      REFERENCES passenger (id) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE RESTRICT,
  CONSTRAINT passenger_vehicle_car_id_fkey FOREIGN KEY (car_id)
      REFERENCES car (id) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE RESTRICT,
  CONSTRAINT passenger_vehicle_chopper_id_fkey FOREIGN KEY (chopper_id)
      REFERENCES chopper (id) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE RESTRICT
)
WITH (
  OIDS=FALSE
);
ALTER TABLE passenger
  OWNER TO postgres;
 

