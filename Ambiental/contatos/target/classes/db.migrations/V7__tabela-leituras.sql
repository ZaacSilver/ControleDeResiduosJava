CREATE TABLE LEITURAS (
ID_LEITURA INT PRIMARY KEY IDENTITY,
SENSOR_ID INT,
VALOR DECIMAL(10,2),
DATA_HORA DATETIME,
FOREIGN KEY (SENSOR_ID) REFERENCES SENSORES(ID_SENSOR)
);
