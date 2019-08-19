DROP TABLE IF EXISTS parents;
DROP TABLE IF EXISTS children;


CREATE TABLE parents
(
  id            INT AUTO_INCREMENT PRIMARY KEY,
  title         VARCHAR(5)   NOT NULL,
  first_name    VARCHAR(250) NOT NULL,
  last_name     VARCHAR(250) NOT NULL,
  email_address VARCHAR(250) NOT NULL,
  date_of_birth DATE         NOT NULL,
  gender        VARCHAR(250) DEFAULT NULL,
  second_name   VARCHAR(250) DEFAULT NULL
);

CREATE TABLE children
(
  parent_id INT NOT NULL,
  child_id  INT NOT NULL,
  FOREIGN KEY (parent_id) REFERENCES parents (id),
  FOREIGN KEY (child_id) REFERENCES parents (id)
);

INSERT INTO parents (title, first_name, last_name, email_address, date_of_birth, gender, second_name)
VALUES ('Mr', 'Donald', 'Trump', 'donald@trump.com', '1955-06-23', 'M', 'president'),
       ('Mrs', 'Melina', 'Trump', 'melina@trump.com', '1968-05-12', 'F', ''),
       ('Ms', 'Ivanka', 'Trump', 'ivanka@trump.com', '1984-11-09', 'F', ''),
       ('Mr', 'Sherlock', 'Holmes', 'sherlock@gmail.com', '1934-12-28', 'M', '');

INSERT INTO children (parent_id, child_id)
VALUES (1, 3),
       (2, 3);

