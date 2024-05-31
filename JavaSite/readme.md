# Getting Started

# Project Name: Together We Play

"Together We Play" is an online store designed to sell video game consoles, video games, and computer components. The project was developed as part of the final project of a computer science diploma and uses Spring Boot for the backend, along with JWT for user authentication and authorization.

## Features

- User registration and authentication
- Product viewing and search
- Shopping cart management
- Checkout and payment process
- Order history
- Security with JWT

## Database Setup

1. Create the together_we_play database. The definition file is located within the Resources folder named creacion-base.sql
2. Insert data into the database. The file to insert the data is located within the Resources folder named insercion-datos.sql

## User Manual
### Registration and Authentication

- Navigate to http://localhost:8090/ in your preferred browser.
- Click on the section in the navigation bar that says "Hola bienvenid@, Inicia sesi�n".
- Complete the registration form with email, username, and password.
- Here are some test data you can use to log in:
- - correo: valesin@gmail.com
- - contrase�a: evanescence94@
- The first and last names can be chosen by the user.
- Proceed to the next registration page to enter address details.
- Complete the registration by selecting a payment method.
- Here is some test data to use if selecting a card as the payment method:
- - 9999888877776666
- Complete the user creation in the system, and you will be redirected to the Login page to sign in.

### Sign In
- Once an account is created in the system, you will be redirected to the Login page to sign in.
- You can also return to the home page and select sign in.
- Once on the sign-in interface, simply enter the registered email and password.
- You will be redirected to the home page to start searching for products.

### Searching for Products
- Use the search bar at the top of the page.
- Enter the product name and press the "Enter" key.

### Shopping Cart Management
1. Add Products to the Cart:
- Navigate to the product details page.
- Select the desired quantity.
- Click "A�adir al Carrito".

2. View Shopping Cart:
- The added products will be listed in the cart.
- The cart can be reviewed at any time by clicking on the "Carrito" section in the navigation bar.

3. Modify Cart:
- You can change the quantity of products or remove products from the cart.
- Click on the corresponding buttons for Quantity(Cantidad) or Remove(Eliminar).

### Checkout and Payment Process
1. Proceed to Checkout:
- Within the shopping cart, you can proceed to checkout by clicking the "Confirmar compra".

2. Make the Payment:
- A summary of the added products, user's name, purchase date, total purchase amount, registered payment method, shipping address, and estimated delivery date will be displayed.
- You can modify the previously registered shipping address by clicking on the "Modificar Domicilio" button.
- If modifying the address, you will be redirected to a new page to complete this process.
- Once the new address details are entered, click the "Guardar" button, and you will be redirected back to the checkout page with the updated address.
- To confirm the purchase, click the "Confirmar Compra" button.

### Order History
- The order history can be reviewed by clicking on the "Pedidos" section in the navigation menu.
- Completed orders will be listed with their details.

### Log Out
- To log out, click the "Cerrar Sesi�n" button located in the toolbar.

### Additional Information
- Autor: Javier Dur�n Calzada
- Contact: mistico.javier58@gmail.com



# Spanish

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

### Cerrar Sesi�n
- Para cerrar sesi�n se debe dar click en el bot�n "Cerrar sesi�n" que se encuentra en la barra de herramientas

### Informaci�n adicional
- Autor: Javier Dur�n Calzada
- Contacto: aspirina_wero@hotmail.com
