CREATE TABLE Cuentas (
	id_cuenta SERIAL PRIMARY KEY,
	numero_cuenta VARCHAR(20),
	tipo_cuenta VARCHAR(30),
	saldo_cuenta DECIMAL DEFAULT 0
);

INSERT INTO Cuentas (numero_cuenta, tipo_cuenta, saldo_cuenta) 
VALUES 
('1234-5', 'Ahorros', 100000),
('1234-7', 'Corriente', 0);