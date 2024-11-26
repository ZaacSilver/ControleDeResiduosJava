CREATE SEQUENCE SEQ_USUARIOS
 START WITH 1
 INCREMENT BY 1
 NOCACHE
 NOCYCLE;

CREATE TABLE TBL_USUARIOS (
 USUARIO_ID INTEGER DEFAULT SEQ_USUARIOS.NEXTVAL NOT NULL,
 NOME VARCHAR2(100) NOT NULL,
 EMAIL VARCHAR2(100) UNIQUE NOT NULL,
 SENHA VARCHAR2(20) NOT NULL,
 ROLES VARCHAR2(50) DEFAULT 'USER'

 );