CREATE TABLE tasks
  (
    id SERIAL NOT NULL,
    number varchar(20) NOT NULL,
    date timestamp DEFAULT current_timestamp,
    checked BOOLEAN NOT NULL,
    PRIMARY KEY (id)
  );