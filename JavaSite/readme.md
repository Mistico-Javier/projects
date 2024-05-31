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
- Click on the section in the navigation bar that says "Hola bienvenid@, Inicia sesión".
- Complete the registration form with email, username, and password.
- Here are some test data you can use to log in:
- - correo: valesin@gmail.com
- - contraseña: evanescence94@
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
- Click "Añadir al Carrito".

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
- To log out, click the "Cerrar Sesión" button located in the toolbar.

### Additional Information
- Autor: Javier Durán Calzada
- Contact: mistico.javier58@gmail.com



# Spanish

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

### Cerrar Sesión
- Para cerrar sesión se debe dar click en el botón "Cerrar sesión" que se encuentra en la barra de herramientas

### Información adicional
- Autor: Javier Durán Calzada
- Contacto: aspirina_wero@hotmail.com
