# Getting Started

# Nombre del Proyecto: Together We Play

"Together We Play" es una tienda en línea diseñada para vender consolas de videojuegos, videojuegos y componentes de computadora. El proyecto se desarrolló como parte del proyecto final de un diplomado de computación y utiliza Spring Boot para el backend, junto con JWT para la autenticación y autorización de usuarios.

## Características

- Registro y autenticación de usuarios
- Visualización y búsqueda de productos
- Gestión de carrito de compras
- Proceso de checkout y pago
- Historial de pedidos
- Seguridad con JWT

## Configurar la Base de Datos

1. Crear la base de datos together_we_play. El archivo de definición se encuentra dentro de la carpeta Resources con el nombre de creacion-base.sql
2. Insertar los datos en la base de datos. El archivo que inserta los datos se encuentra dentro de la carpeta Resources con el nombre de insercion-datos.sql

## Manual de Uso
### Registro y Autenticación
- Navegar a http://localhost:8090/ dentro de el navegador de su preferencia.
- En la barra de navegación dar click en la sección que dice "Hola bienvenid@, Inicia sesión"
- Completar el formulario de registro con correo electrónico, nombre de usuario y contraseña.
- Aquí hay algunos datos de prueba con los que se puede ingresar:
- - correo: valesin@gmail.com
- - contraseña: evanescence94@
- El nombre y apellidos pueden ser a elección del usuario.
- Continuar a la siguiente página de registro de un domicilio e insertar los datos correspondientes.
- Finalizar el registro seleccionando un método de pago.
- Aquí hay un dato de prueba para ingresar en el caso de seleccionar alguna tarjeta como método de pago:
- - 9999888877776666
- Finalizar la creación del usuario en el sistema y se le redireccionará a la página de Login para iniciar sesión.

### Inicio de Sesión
- Una vez creado una cuenta en el sistema se le redireccionará a la página de Login para iniciar sesión.
- También se puede optar por regresar a la página de inicio y seleccionar iniciar sesión.
- Una vez dentro de la interfaz para iniciar sesión solo hay que ingresar el correo que registró y la contraseña.
- Se le redireccionará a la página de inicio para empezar a buscar productos.

### Buscar Productos
- Utilizar la barra de búsqueda en la parte superior de la página. 
- Ingresar el nombre del producto y presionar la tecla "Enter".

### Gestión del carrito de compras
1. Añadir Productos al Carrito:
- Navegar a la página de detalles del producto.
- Seleccionar la cantidad deseada.
- Hacer clic en "Añadir al Carrito".

2. Ver Carrito de Compras:
- Los productos añadidos estarán listados en el carrito.
- El carrito se puede revisar en cualquier momento dando click en la barra de navegación en la sección "Carrito".

3. Modificar Carrito:
- Se puede cambiar la cantidad de productos o eliminar productos del carrito.
- Dando click en los botones correspondientes de Cantidad o Eliminar.

### Proceso de Checkout y Pago
1. Proceder al Checkout:
- Dentro del carrito de compras se puede proceder al checkout de los productos dando click en el botón "Confirmar compra".

2. Realizar el Pago:
- Se mostrará un resumen de los productos agregados al carrito, el nombre del usuario, la fecha de compra, el total de la compra, el método de pago registrado, el domicilio de envío y la fecha estimada de entrega.
- Se puede modificar la dirección de envío previamente registrada dando click en el botón de "Modificar Domicilio".
- Si es el caso de modificación del domicilio, se le redireccionará a una nueva página para realizar este proceso.
- Una vez insertados los datos del nuevo domicilio se da click en el botón "Guardar" y se le redireccionará de vuelta a la página de checkout con el domicilio actualizado.
- Para confirmar la compra dar click en el botón "Confirmar compra"

### Historial de pedidos
- Se puede revisar el historial de pedidos dando click en el menu de navegación en la sección "Pedidos"
- Los pedidos realizados estarán listados con sus detalles.

### Historial de pedidos
- Para cerrar sesión se debe dar click en el botón "Cerrar sesión" que se encuentra en la barra de herramientas

### Información adicional
- Autor: Javier Durán Calzada
- Contacto: aspirina_wero@hotmail.com
