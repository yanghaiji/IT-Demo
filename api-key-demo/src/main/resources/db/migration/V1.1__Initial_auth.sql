
CREATE TABLE auth (
  api_key   UUID          PRIMARY KEY,
  user_id   VARCHAR(50)   NOT NULL
);

INSERT INTO auth(api_key, user_id) VALUES ('A18BF786EFB76A3D56EE69A3B343952A','testuser@gmail.com');
