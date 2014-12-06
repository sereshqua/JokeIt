CREATE TABLE jokes
(
  id INT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(100),
  text TEXT
);

CREATE TABLE feedback
(
  id INT PRIMARY KEY AUTO_INCREMENT,
  assessment INT,
  comment VARCHAR(250),

  joke_id INT
);
