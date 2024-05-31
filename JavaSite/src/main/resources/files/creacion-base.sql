SET NAMES 'UTF8MB4';
DROP DATABASE IF EXISTS `together_we_play`;
CREATE SCHEMA `together_we_play` DEFAULT CHARACTER SET UTF8MB4;
USE together_we_play;

DROP TABLE IF EXISTS carrito;
DROP TABLE IF EXISTS rol_usuario_relacion;
DROP TABLE IF EXISTS usuario_metodo_pago_relacion;
DROP TABLE if EXISTS ticket_detalle;
DROP TABLE IF EXISTS ticket;
DROP TABLE IF EXISTS producto;
DROP TABLE IF EXISTS tarjeta;
DROP TABLE IF EXISTS rol;
DROP TABLE IF EXISTS domicilio;
DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS metodo_Pago;

CREATE TABLE usuario (
    IDusuario INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido_Paterno VARCHAR(50) NOT NULL,
    apellido_Materno VARCHAR(50) NOT NULL,
    correo VARCHAR(45) NOT NULL UNIQUE,
    password VARCHAR(64) NOT NULL,
    fecha_Creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    use_id_status INTEGER NOT NULL
);
CREATE TABLE domicilio (
    IDdomicilio INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    calle VARCHAR(30) NOT NULL,
    numero VARCHAR(30),
    colonia_Barrio VARCHAR(50) NOT NULL,
    codigo_Postal INT NOT NULL,
    alcaldia_Municipio VARCHAR(50) NOT NULL,
    estado VARCHAR(50) NOT NULL,
    IDusuario INT NOT NULL,
	 CONSTRAINT fk_domicilio_usuario FOREIGN KEY (IDusuario) REFERENCES usuario (IDusuario)
);
CREATE TABLE rol (
    IDrol INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre_Rol VARCHAR(30) NOT NULL
);
CREATE TABLE metodo_Pago (
    IDmetodo_Pago INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    metodo_Pago VARCHAR(20) NOT NULL
);
CREATE TABLE tarjeta (
    IDtarjeta INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre_Persona_Tarjeta VARCHAR(70) NOT NULL,
    numero_Tarjeta VARCHAR(16) NOT NULL UNIQUE,
    tipo_Tarjeta VARCHAR(10) NOT NULL,
    vencimiento_Tarjeta DATE NOT NULL,
    IDusuario INT NOT NULL,
    CONSTRAINT fk_tarjeta_usuario FOREIGN KEY (IDusuario) REFERENCES usuario (IDusuario)
);
CREATE TABLE producto (
    IDproducto INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL UNIQUE,
    descripcion VARCHAR(500) NOT NULL,
    marca VARCHAR(50) NOT NULL,
    precio DECIMAL(8,2) NOT NULL,
    imagen VARCHAR(100) DEFAULT 'Sin_imagen_disponible.jpg'
);
CREATE TABLE rol_usuario_relacion (
    IDrol_usuario_relacion INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    IDusuario INT NOT NULL,
    IDrol INT NOT NULL,
    CONSTRAINT fk_usuario FOREIGN KEY (IDusuario) REFERENCES usuario (IDusuario),
    CONSTRAINT fk_rol FOREIGN KEY (IDrol) REFERENCES rol (IDrol)
);
CREATE TABLE usuario_metodo_pago_relacion (
    IDusuario_metodo_pago_relacion INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    IDusuario INT NOT NULL,
    IDmetodo_Pago INT NOT NULL,
    CONSTRAINT fk_usuario_metodo_pago FOREIGN KEY (IDusuario) REFERENCES usuario (IDusuario),
    CONSTRAINT fk_metodo_pago FOREIGN KEY (IDmetodo_Pago) REFERENCES metodo_Pago (IDmetodo_Pago)
);
CREATE TABLE ticket (
    IDticket INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    IDusuario INT NOT NULL,
    IDmetodo_Pago INT NOT NULL,
    fecha_Compra DATETIME NOT NULL,
    total_Compra DECIMAL(10,2) NOT NULL,
    fecha_Entrega DATETIME NOT NULL,
    CONSTRAINT fk_ticket_usuario FOREIGN KEY (IDusuario) REFERENCES usuario (IDusuario),
    CONSTRAINT fk_ticket_metodoPago FOREIGN KEY (IDmetodo_Pago) REFERENCES metodo_Pago (IDmetodo_Pago)
);
CREATE TABLE carrito (
    IDcarrito INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    IDproducto INT NOT NULL,
    IDusuario INT NOT NULL,
    cantidad INT NOT NULL,
    CONSTRAINT fk_carrito_producto FOREIGN KEY (IDproducto) REFERENCES producto (IDproducto),
    CONSTRAINT fk_carrito_usuario FOREIGN KEY (IDusuario) REFERENCES usuario (IDusuario)
);
CREATE TABLE ticket_detalle (
    IDticket_detalle INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    IDticket INT NOT NULL,
    IDproducto INT NOT NULL,
    cantidad INT NOT NULL,
    precio DECIMAL(8,2) NOT NULL,
    CONSTRAINT fk_ticket_detalle_ticket FOREIGN KEY (IDticket) REFERENCES ticket (IDticket),
    CONSTRAINT fk_ticket_detalle_producto FOREIGN KEY (IDproducto) REFERENCES producto (IDproducto)
);
CREATE INDEX ix_correoUsuario ON usuario (correo);
CREATE INDEX ix_numeroTarjeta ON tarjeta (numero_Tarjeta);
CREATE INDEX ix_nombreProducto ON producto (nombre);
CREATE INDEX ix_marcaProducto ON producto (marca);
CREATE INDEX ix_precioProducto ON producto (precio);
CREATE INDEX ix_fechaCompra ON ticket (fecha_Compra);
CREATE INDEX ix_idProducto ON ticket_detalle (IDproducto);
CREATE INDEX ix_idTicket ON ticket_detalle (IDticket);
CREATE INDEX ix_IDproducto ON carrito (IDproducto);