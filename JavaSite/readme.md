# Getting Started

# Nombre del Proyecto: Together We Play

"Together We Play" es una tienda en l�nea dise�ada para vender consolas de videojuegos, videojuegos y componentes de computadora. El proyecto se desarroll� como parte del proyecto final de un diplomado de computaci�n y utiliza Spring Boot para el backend, junto con JWT para la autenticaci�n y autorizaci�n de usuarios.

## Caracter�sticas

- Registro y autenticaci�n de usuarios
- Visualizaci�n y b�squeda de productos
- Gesti�n de carrito de compras
- Proceso de checkout y pago
- Historial de pedidos
- Seguridad con JWT

## Configurar la Base de Datos

1. Crear la base de datos together_we_play. El archivo de definici�n se encuentra dentro de la carpeta Resources con el nombre de creacion-base.sql
2. Insertar los datos en la base de datos. El archivo que inserta los datos se encuentra dentro de la carpeta Resources con el nombre de insercion-datos.sql

## Manual de Uso
### Registro y Autenticaci�n
- Navegar a http://localhost:8090/ dentro de el navegador de su preferencia.
- En la barra de navegaci�n dar click en la secci�n que dice "Hola bienvenid@, Inicia sesi�n"
- Completar el formulario de registro con correo electr�nico, nombre de usuario y contrase�a.
- Aqu� hay algunos datos de prueba con los que se puede ingresar:
- - correo: valesin@gmail.com
- - contrase�a: evanescence94@
- El nombre y apellidos pueden ser a elecci�n del usuario.
- Continuar a la siguiente p�gina de registro de un domicilio e insertar los datos correspondientes.
- Finalizar el registro seleccionando un m�todo de pago.
- Aqu� hay un dato de prueba para ingresar en el caso de seleccionar alguna tarjeta como m�todo de pago:
- - 9999888877776666
- Finalizar la creaci�n del usuario en el sistema y se le redireccionar� a la p�gina de Login para iniciar sesi�n.

### Inicio de Sesi�n
- Una vez creado una cuenta en el sistema se le redireccionar� a la p�gina de Login para iniciar sesi�n.
- Tambi�n se puede optar por regresar a la p�gina de inicio y seleccionar iniciar sesi�n.
- Una vez dentro de la interfaz para iniciar sesi�n solo hay que ingresar el correo que registr� y la contrase�a.
- Se le redireccionar� a la p�gina de inicio para empezar a buscar productos.

### Buscar Productos
- Utilizar la barra de b�squeda en la parte superior de la p�gina. 
- Ingresar el nombre del producto y presionar la tecla "Enter".

### Gesti�n del carrito de compras
1. A�adir Productos al Carrito:
- Navegar a la p�gina de detalles del producto.
- Seleccionar la cantidad deseada.
- Hacer clic en "A�adir al Carrito".

2. Ver Carrito de Compras:
- Los productos a�adidos estar�n listados en el carrito.
- El carrito se puede revisar en cualquier momento dando click en la barra de navegaci�n en la secci�n "Carrito".

3. Modificar Carrito:
- Se puede cambiar la cantidad de productos o eliminar productos del carrito.
- Dando click en los botones correspondientes de Cantidad o Eliminar.

### Proceso de Checkout y Pago
1. Proceder al Checkout:
- Dentro del carrito de compras se puede proceder al checkout de los productos dando click en el bot�n "Confirmar compra".

2. Realizar el Pago:
- Se mostrar� un resumen de los productos agregados al carrito, el nombre del usuario, la fecha de compra, el total de la compra, el m�todo de pago registrado, el domicilio de env�o y la fecha estimada de entrega.
- Se puede modificar la direcci�n de env�o previamente registrada dando click en el bot�n de "Modificar Domicilio".
- Si es el caso de modificaci�n del domicilio, se le redireccionar� a una nueva p�gina para realizar este proceso.
- Una vez insertados los datos del nuevo domicilio se da click en el bot�n "Guardar" y se le redireccionar� de vuelta a la p�gina de checkout con el domicilio actualizado.
- Para confirmar la compra dar click en el bot�n "Confirmar compra"

### Historial de pedidos
- Se puede revisar el historial de pedidos dando click en el menu de navegaci�n en la secci�n "Pedidos"
- Los pedidos realizados estar�n listados con sus detalles.

### Historial de pedidos
- Para cerrar sesi�n se debe dar click en el bot�n "Cerrar sesi�n" que se encuentra en la barra de herramientas

### Informaci�n adicional
- Autor: Javier Dur�n Calzada
- Contacto: aspirina_wero@hotmail.com
