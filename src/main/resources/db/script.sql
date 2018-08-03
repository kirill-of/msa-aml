DROP Table IF Exists msa;

CREATE TABLE  msa (
  id bigint auto_increment primary key,
  full_name VARCHAR(100) ,
  passport  VARCHAR(12),
  date_of_birth VARCHAR(12),
  list_type  VARCHAR(50)
);