CREATE TABLE User (
  id            NUMBER(10,0) NOT NULL AUTO_INCREMENT,
  user_name     VARCHAR(20) NOT NULL,
  email         VARCHAR(50) NOT NULL,
  firstname     VARCHAR(50) DEFAULT NULL,
  lastname      VARCHAR(50) DEFAULT NULL,
  password      VARCHAR(50) NOT NULL,
  account_type  VARCHAR(20) NOT NULL,
  PRIMARY KEY (id)
);