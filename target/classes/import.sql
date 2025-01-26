CREATE TABLE IF NOT EXISTS moneda (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    codigo VARCHAR(255) NOT NULL,
    nombre VARCHAR(255) NOT NULL
    );

INSERT INTO moneda (codigo, nombre) VALUES ('PEN', 'Sol Peruano');
INSERT INTO moneda (codigo, nombre) VALUES ('USD', 'Dólar Estadounidense');
INSERT INTO moneda (codigo, nombre) VALUES ('EUR', 'Euro');