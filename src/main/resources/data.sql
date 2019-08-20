DROP TABLE IF EXISTS person;
DROP TABLE IF EXISTS parent_children;


CREATE TABLE person
(
  id            INT AUTO_INCREMENT PRIMARY KEY,
  title         VARCHAR(5),
  first_name    VARCHAR(250) NOT NULL,
  last_name     VARCHAR(250) NOT NULL,
  email_address VARCHAR(250) NOT NULL,
  date_of_birth DATE         NOT NULL,
  is_parent     BOOLEAN      NOT NULL,
  gender        VARCHAR(250) DEFAULT NULL,
  second_name   VARCHAR(250) DEFAULT NULL
);

CREATE TABLE parent_children
(
  id        INT AUTO_INCREMENT PRIMARY KEY,
  parent_id INT NOT NULL,
  child_id  INT NOT NULL,
  FOREIGN KEY (parent_id) REFERENCES person (id),
  FOREIGN KEY (child_id) REFERENCES person (id)
);

INSERT INTO person (title, first_name, last_name, email_address, date_of_birth, is_parent, gender, second_name)
VALUES ('Mr', 'Donald', 'Trump', 'donald@trump.com', '1955-06-23', 'true', 'male', 'president'),
       ('Mrs', 'Melina', 'Trump', 'melina@trump.com', '1968-05-12', 'true', 'female', ''),
       (null, 'Ivanka', 'Trump', 'ivanka@trump.com', '1984-11-09', 'false', 'female', ''),
       ('Mr', 'Sherlock', 'Holmes', 'sherlock@gmail.com', '1934-12-28', 'true', 'male', '');

INSERT INTO parent_children (parent_id, child_id)
VALUES (1, 3),
       (2, 3);

