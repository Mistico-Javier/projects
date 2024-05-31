-- Inserciones para la tabla rol
INSERT INTO rol (nombre_rol)
VALUES
    ('ADMIN'),
    ('USER');

-- Inserciones para la tabla metodo_Pago
INSERT INTO metodo_Pago (metodo_Pago)
VALUES
    ('Tarjeta de cr�dito'),
    ('Tarjeta de d�bito'),
    ('Efectivo'),
    ('PayPal');

-- Inserciones para la tabla producto
INSERT INTO producto (nombre, descripcion, marca, precio)
VALUES
('Demon''s Souls', 'Remake del cl�sico juego de rol de acci�n con gr�ficos mejorados y jugabilidad renovada.', 'Sony', 69.99),
('Spider-Man: Miles Morales', 'Acompa�a a Miles Morales en su aventura como el nuevo Spider-Man en la ciudad de Nueva York.', 'Sony', 49.99),
('Ratchet & Clank: Rift Apart', 'Juego de plataformas y disparos en tercera persona con gr�ficos de �ltima generaci�n.', 'Insomniac Games', 69.99),
('Returnal', 'Juego de disparos en tercera persona con elementos roguelike y una narrativa profunda.', 'Housemarque', 69.99),
('Sackboy: A Big Adventure', 'Juego de plataformas 3D protagonizado por el carism�tico Sackboy.', 'Sumo Digital', 59.99),
('Resident Evil Village', 'La octava entrega de la saga de terror Resident Evil con gr�ficos impresionantes y una historia envolvente.', 'Capcom', 59.99),
('Horizon Forbidden West', 'Secuela del exitoso Horizon Zero Dawn, con nuevas aventuras y misterios en el oeste prohibido.', 'Guerrilla Games', 69.99),
('Gran Turismo 7', 'El simulador de carreras definitivo con una gran cantidad de coches y circuitos.', 'Polyphony Digital', 69.99),
('Final Fantasy XVI', 'La �ltima entrega de la serie Final Fantasy con una historia �pica y gr�ficos espectaculares.', 'Square Enix', 69.99),
('God of War: Ragnarok', 'Contin�a la �pica historia de Kratos y Atreus en la mitolog�a n�rdica.', 'Santa Monica Studio', 69.99),
('Deathloop', 'Juego de disparos en primera persona con una mec�nica de bucles temporales y un estilo art�stico �nico.', 'Arkane Studios', 59.99),
('Kena: Bridge of Spirits', 'Un hermoso juego de acci�n y aventura con un toque m�gico y personajes entra�ables.', 'Ember Lab', 39.99),
('Ghost of Tsushima: Director''s Cut', 'Versi�n mejorada del aclamado juego de acci�n y aventura ambientado en el Jap�n feudal.', 'Sucker Punch', 69.99),
('NBA 2K22', 'La �ltima entrega de la serie de simulaci�n de baloncesto con gr�ficos realistas y jugabilidad mejorada.', '2K Sports', 59.99),
('FIFA 22', 'La nueva edici�n del popular simulador de f�tbol con mejoras en la jugabilidad y gr�ficos.', 'EA Sports', 59.99),
('Assassin''s Creed Valhalla', 'Explora el mundo de los vikingos en esta nueva entrega de la saga Assassin''s Creed.', 'Ubisoft', 59.99),
('Cyberpunk 2077', 'Un juego de rol y acci�n ambientado en un futuro dist�pico con una narrativa profunda.', 'CD Projekt Red', 49.99),
('Far Cry 6', 'Lucha por la libertad en una isla tropical gobernada por un dictador despiadado.', 'Ubisoft', 59.99),
('Hitman 3', 'Convi�rtete en el asesino m�s letal en la conclusi�n de la trilog�a World of Assassination.', 'IO Interactive', 59.99),
('Dying Light 2', 'Sobrevive en un mundo post-apocal�ptico lleno de zombies y peligros.', 'Techland', 59.99);

INSERT INTO producto (nombre, descripcion, marca, precio)
VALUES
('Halo Infinite', 'La nueva entrega de la legendaria saga Halo, con un vasto mundo abierto y una historia �pica.', '343 Industries', 59.99),
('Forza Horizon 5', 'Juego de carreras de mundo abierto ambientado en un hermoso y diverso M�xico.', 'Playground Games', 59.99),
('Gears 5', 'Juego de disparos en tercera persona con gr�ficos impresionantes y una historia envolvente.', 'The Coalition', 39.99),
('Psychonauts 2', 'Juego de plataformas y aventuras con un estilo �nico y una historia intrigante.', 'Double Fine', 59.99),
('The Medium', 'Juego de terror psicol�gico con una innovadora jugabilidad en doble realidad.', 'Bloober Team', 49.99),
('Flight Simulator 2020', 'El simulador de vuelo m�s realista, con gr�ficos impresionantes y una simulaci�n detallada.', 'Asobo Studio', 59.99),
('Fable', 'Un reinicio de la cl�sica serie de juegos de rol y aventuras con un mundo m�gico y vibrante.', 'Playground Games', 69.99),
('Everwild', 'Un juego de aventuras con un mundo m�gico y una jugabilidad innovadora.', 'Rare', 59.99),
('Hellblade II: Senua''s Saga', 'Secuela del aclamado juego de acci�n y aventura con una narrativa profunda y emocional.', 'Ninja Theory', 69.99),
('Avowed', 'Juego de rol en primera persona ambientado en el mundo de Eora.', 'Obsidian Entertainment', 69.99),
('State of Decay 3', 'Juego de supervivencia en un mundo post-apocal�ptico lleno de zombies.', 'Undead Labs', 59.99),
('Elden Ring', 'Juego de rol y acci�n con un vasto mundo abierto y una historia envolvente.', 'FromSoftware', 69.99),
('Tunic', 'Un encantador juego de aventuras protagonizado por un peque�o zorro.', 'Andrew Shouldice', 29.99),
('Scorn', 'Juego de terror atmosf�rico con un dise�o visual �nico y perturbador.', 'Ebb Software', 39.99),
('Bright Memory: Infinite', 'Juego de disparos en primera persona con gr�ficos de �ltima generaci�n y jugabilidad r�pida.', 'FYQD-Studio', 19.99),
('Stalker 2: Heart of Chernobyl', 'Juego de disparos y supervivencia ambientado en la zona de exclusi�n de Chernobyl.', 'GSC Game World', 59.99),
('The Ascent', 'Juego de rol y acci�n en un mundo cyberpunk con modo cooperativo.', 'Neon Giant', 29.99),
('CrossfireX', 'Juego de disparos en primera persona con una campa�a emocionante y modos multijugador.', 'Smilegate Entertainment', 29.99),
('Sable', 'Juego de exploraci�n y aventuras con un estilo art�stico �nico.', 'Shedworks', 24.99),
('Yakuza: Like a Dragon', 'Juego de rol y acci�n con una historia profunda y un sistema de combate por turnos.', 'Ryu Ga Gotoku Studio', 59.99);

INSERT INTO producto (nombre, descripcion, marca, precio)
VALUES
('The Legend of Zelda: Breath of the Wild', 'Un juego de aventuras y acci�n en un vasto mundo abierto.', 'Nintendo', 59.99),
('Super Mario Odyssey', 'Acompa�a a Mario en una nueva aventura para salvar a la princesa Peach.', 'Nintendo', 59.99),
('Animal Crossing: New Horizons', 'Crea tu propia isla paradis�aca y vive a tu ritmo.', 'Nintendo', 59.99),
('Mario Kart 8 Deluxe', 'Carreras alocadas con los personajes del universo de Mario.', 'Nintendo', 59.99),
('Splatoon 2', 'Juego de disparos multijugador con batallas de tinta.', 'Nintendo', 59.99),
('Super Smash Bros. Ultimate', 'El crossover de luchadores m�s grande de la historia de los videojuegos.', 'Nintendo', 59.99),
('Luigi\'s Mansion 3', 'Ayuda a Luigi a salvar a sus amigos en un hotel encantado.', 'Nintendo', 59.99),
('Fire Emblem: Three Houses', 'Juego de rol t�ctico con una profunda historia y personajes memorables.', 'Nintendo', 59.99),
('Xenoblade Chronicles 2', 'Un �pico juego de rol en un mundo abierto con una historia emocionante.', 'Monolith Soft', 59.99),
('Pok�mon Sword', 'Explora la regi�n de Galar y atrapa nuevos Pok�mon.', 'Game Freak', 59.99),
('Pok�mon Shield', 'Explora la regi�n de Galar y atrapa nuevos Pok�mon.', 'Game Freak', 59.99),
('Hyrule Warriors: Age of Calamity', 'Un juego de acci�n que narra los eventos antes de Breath of the Wild.', 'Koei Tecmo', 59.99),
('Ring Fit Adventure', 'Un juego de fitness y aventura que te mantiene en forma.', 'Nintendo', 79.99),
('Octopath Traveler', 'Un juego de rol con ocho historias �nicas y un estilo art�stico HD-2D.', 'Square Enix', 59.99),
('Astral Chain', 'Juego de acci�n y aventuras con un sistema de combate innovador.', 'PlatinumGames', 59.99),
('Donkey Kong Country: Tropical Freeze', 'Acompa�a a Donkey Kong y sus amigos en una aventura congelada.', 'Retro Studios', 59.99),
('Mario + Rabbids Kingdom Battle', 'Un crossover t�ctico entre Mario y los Rabbids.', 'Ubisoft', 59.99),
('Paper Mario: The Origami King', 'Ayuda a Mario a liberar el Reino Champi��n de la invasi�n del Rey Olly.', 'Intelligent Systems', 59.99),
('Kirby Star Allies', 'Un juego de plataformas donde Kirby puede reclutar aliados.', 'HAL Laboratory', 59.99),
('The Witcher 3: Wild Hunt - Complete Edition', 'Una �pica aventura de rol en un vasto mundo abierto.', 'CD Projekt Red', 49.99);

INSERT INTO producto (nombre, descripcion, marca, precio)
VALUES
('The Witcher 3: Wild Hunt', 'Un juego de rol en un vasto mundo abierto lleno de aventuras.', 'CD Projekt Red', 49.99),
('Red Dead Redemption 2', 'Una �pica aventura de acci�n en el Salvaje Oeste.', 'Rockstar Games', 59.99),
('Half-Life: Alyx', 'Un juego de realidad virtual que expande el universo de Half-Life.', 'Valve', 59.99),
('DOOM Eternal', 'Un juego de disparos en primera persona con acci�n intensa y fren�tica.', 'id Software', 59.99),
('Hades', 'Un juego de acci�n y mazmorras con elementos de roguelike.', 'Supergiant Games', 24.99),
('Among Us', 'Un juego multijugador de deducci�n social en el espacio.', 'Innersloth', 4.99),
('Valorant', 'Un juego de disparos t�ctico en primera persona con h�roes �nicos.', 'Riot Games', 0.00),
('Fortnite', 'Un juego de batalla real con construcci�n y un estilo de arte �nico.', 'Epic Games', 0.00),
('Minecraft', 'Un juego de construcci�n y aventuras en un mundo de bloques.', 'Mojang', 26.95),
('Grand Theft Auto V', 'Un juego de acci�n y aventuras en una vasta ciudad abierta.', 'Rockstar Games', 29.99),
('The Elder Scrolls V: Skyrim', 'Un juego de rol en un mundo abierto lleno de dragones y aventuras.', 'Bethesda', 39.99),
('Stardew Valley', 'Un juego de simulaci�n de granja con elementos de rol y aventuras.', 'ConcernedApe', 14.99),
('Civilization VI', 'Un juego de estrategia por turnos donde construyes y gestionas un imperio.', 'Firaxis Games', 59.99),
('Overwatch', 'Un juego de disparos en equipo con h�roes �nicos y habilidades especiales.', 'Blizzard Entertainment', 39.99),
('Apex Legends', 'Un juego de batalla real con personajes �nicos y habilidades.', 'Respawn Entertainment', 0.00),
('The Sims 4', 'Un juego de simulaci�n de vida donde puedes crear y controlar personas.', 'Maxis', 39.99),
('Rainbow Six Siege', 'Un juego de disparos t�ctico en equipos con destructibilidad avanzada.', 'Ubisoft', 19.99),
('Dark Souls III', 'Un juego de rol y acci�n conocido por su dificultad y ambientaci�n oscura.', 'FromSoftware', 59.99),
('Fall Guys: Ultimate Knockout', 'Un divertido juego multijugador de carreras y obst�culos.', 'Mediatonic', 19.99);

INSERT INTO producto (nombre, descripcion, marca, precio)
VALUES
('Mouse Logitech MX Master 3', 'Un mouse avanzado para usuarios exigentes con desplazamiento electromagn�tico y m�ltiples botones programables.', 'Logitech', 99.99),
('Mouse Razer DeathAdder V2', 'Un mouse para gamers con sensor �ptico de alta precisi�n y dise�o ergon�mico.', 'Razer', 69.99),
('Mouse SteelSeries Rival 600', 'Mouse gamer con sistema de pesas personalizable y doble sensor para precisi�n extrema.', 'SteelSeries', 79.99),
('Mouse Microsoft Surface Mouse', 'Un mouse minimalista y port�til dise�ado para combinar con dispositivos Surface.', 'Microsoft', 49.99),
('Mouse Corsair Dark Core RGB/SE', 'Un mouse gamer inal�mbrico con carga Qi y sensor �ptico de alta precisi�n.', 'Corsair', 89.99),
('Mouse Logitech G502 HERO', 'Mouse gamer con sensor HERO 25K, 11 botones programables y pesos ajustables.', 'Logitech', 79.99),
('Mouse Apple Magic Mouse 2', 'Mouse inal�mbrico con superficie Multi-Touch para gestos intuitivos y bater�a recargable.', 'Apple', 79.99),
('Mouse HP X3000 Wireless Mouse', 'Mouse inal�mbrico para uso general con dise�o ergon�mico y hasta 12 meses de duraci�n de bater�a.', 'HP', 14.99),
('Mouse Logitech M185 Wireless Mouse', 'Mouse inal�mbrico compacto y asequible, ideal para uso diario y port�til.', 'Logitech', 12.99),
('Mouse Roccat Kone AIMO', 'Mouse gamer con iluminaci�n RGB, sensor �ptico Owl-Eye y dise�o ergon�mico.', 'Roccat', 79.99);

INSERT INTO producto (nombre, descripcion, marca, precio)
VALUES
('Teclado Logitech MX Keys', 'Teclado inal�mbrico avanzado con teclas retroiluminadas y dise�o ergon�mico.', 'Logitech', 99.99),
('Teclado Razer BlackWidow V3', 'Teclado mec�nico gamer con switches Razer Green y retroiluminaci�n RGB.', 'Razer', 139.99),
('Teclado Corsair K95 RGB Platinum', 'Teclado mec�nico gamer con switches Cherry MX Speed y iluminaci�n RGB din�mica.', 'Corsair', 199.99),
('Teclado Microsoft Sculpt Ergonomic Keyboard', 'Teclado ergon�mico dise�ado para mayor comodidad y reducci�n de tensi�n en las mu�ecas.', 'Microsoft', 69.99),
('Teclado SteelSeries Apex Pro', 'Teclado mec�nico gamer con switches ajustables y pantalla OLED integrada.', 'SteelSeries', 199.99),
('Teclado Apple Magic Keyboard', 'Teclado inal�mbrico con bater�a recargable y un dise�o compacto y elegante.', 'Apple', 99.99),
('Teclado HyperX Alloy FPS Pro', 'Teclado mec�nico gamer compacto con switches Cherry MX Red y estructura de acero.', 'HyperX', 79.99),
('Teclado Dell KM717 Premier', 'Teclado y mouse inal�mbricos con dise�o moderno y conectividad dual Bluetooth.', 'Dell', 79.99),
('Teclado Logitech K380 Multi-Device', 'Teclado inal�mbrico compacto para m�ltiples dispositivos con Bluetooth.', 'Logitech', 39.99),
('Teclado Roccat Vulcan 120 AIMO', 'Teclado mec�nico gamer con switches Titan y iluminaci�n RGB AIMO.', 'Roccat', 159.99);

INSERT INTO producto (nombre, descripcion, marca, precio)
VALUES
('Motherboard ASUS ROG Strix Z590-E Gaming WiFi', 'Placa base ATX para Intel Core de 11� y 10� generaci�n con iluminaci�n RGB y soporte para PCIe 4.0.', 'ASUS', 349.99),
('Motherboard GIGABYTE B550 AORUS PRO', 'Placa base ATX para procesadores AMD Ryzen con soporte para PCIe 4.0 y dise�o t�rmico avanzado.', 'GIGABYTE', 169.99),
('Motherboard MSI MPG B550 GAMING EDGE WIFI', 'Placa base ATX para procesadores AMD Ryzen con conectividad WiFi 6 y soporte para PCIe 4.0.', 'MSI', 189.99),
('Motherboard ASRock B450M PRO4', 'Placa base microATX para procesadores AMD Ryzen con compatibilidad con memoria DDR4 de hasta 3200MHz.', 'ASRock', 89.99),
('Motherboard ASUS TUF GAMING B550M-PLUS', 'Placa base microATX para procesadores AMD Ryzen con dise�o resistente y soporte PCIe 4.0.', 'ASUS', 149.99),
('Motherboard MSI MAG B460M MORTAR WIFI', 'Placa base microATX para procesadores Intel Core de 10� generaci�n con conectividad WiFi 6 y LAN de 2.5G.', 'MSI', 129.99),
('Motherboard GIGABYTE Z590 UD AC', 'Placa base ATX para Intel Core de 11� y 10� generaci�n con conectividad WiFi y soporte para PCIe 4.0.', 'GIGABYTE', 179.99),
('Motherboard ASRock X570 Phantom Gaming 4', 'Placa base ATX para procesadores AMD Ryzen con soporte PCIe 4.0 y dise�o de disipaci�n de calor.', 'ASRock', 159.99),
('Motherboard ASUS Prime B560-PLUS', 'Placa base ATX para procesadores Intel Core de 11� y 10� generaci�n con iluminaci�n LED y soporte PCIe 4.0.', 'ASUS', 119.99),
('Motherboard GIGABYTE Z490 AORUS ELITE AC', 'Placa base ATX para procesadores Intel Core de 10� generaci�n con conectividad WiFi 6 y dise�o t�rmico avanzado.', 'GIGABYTE', 219.99);

INSERT INTO producto (nombre, descripcion, marca, precio)
VALUES
('Tarjeta gr�fica NVIDIA GeForce RTX 3080', 'Tarjeta gr�fica de alta gama con arquitectura Ampere, 10GB GDDR6X de memoria y trazado de rayos en tiempo real.', 'NVIDIA', 699.99),
('Tarjeta gr�fica AMD Radeon RX 6900 XT', 'Tarjeta gr�fica tope de gama con arquitectura RDNA 2, 16GB GDDR6 de memoria y compatibilidad con tecnolog�a de trazado de rayos.', 'AMD', 999.99),
('Tarjeta gr�fica NVIDIA GeForce RTX 3070', 'Tarjeta gr�fica de gama alta con arquitectura Ampere, 8GB GDDR6 de memoria y rendimiento excepcional en juegos de �ltima generaci�n.', 'NVIDIA', 499.99),
('Tarjeta gr�fica AMD Radeon RX 6800', 'Tarjeta gr�fica de alto rendimiento con arquitectura RDNA 2, 16GB GDDR6 de memoria y optimizada para juegos 4K.', 'AMD', 579.99),
('Tarjeta gr�fica NVIDIA GeForce GTX 1660 Ti', 'Tarjeta gr�fica de gama media con arquitectura Turing, 6GB GDDR6 de memoria y excelente rendimiento en juegos Full HD.', 'NVIDIA', 279.99),
('Tarjeta gr�fica AMD Radeon RX 6700 XT', 'Tarjeta gr�fica de gama media-alta con arquitectura RDNA 2, 12GB GDDR6 de memoria y optimizada para juegos en resoluciones 1440p.', 'AMD', 479.99),
('Tarjeta gr�fica NVIDIA GeForce RTX 3060', 'Tarjeta gr�fica de gama media con arquitectura Ampere, 12GB GDDR6 de memoria y rendimiento s�lido para juegos modernos.', 'NVIDIA', 329.99),
('Tarjeta gr�fica AMD Radeon RX 6600 XT', 'Tarjeta gr�fica de gama media con arquitectura RDNA 2, 8GB GDDR6 de memoria y optimizada para juegos en 1080p.', 'AMD', 379.99),
('Tarjeta gr�fica NVIDIA GeForce GTX 1650 Super', 'Tarjeta gr�fica de entrada con arquitectura Turing, 4GB GDDR6 de memoria y buen rendimiento en juegos a 1080p.', 'NVIDIA', 199.99),
('Tarjeta gr�fica AMD Radeon RX 5500 XT', 'Tarjeta gr�fica de gama baja-media con arquitectura RDNA, 8GB GDDR6 de memoria y excelente relaci�n rendimiento-precio.', 'AMD', 199.99);

INSERT INTO producto (nombre, descripcion, marca, precio)
VALUES
('Procesador Intel Core i9-11900K', 'Procesador de alto rendimiento de la 11� generaci�n de Intel, con 8 n�cleos y 16 hilos, frecuencia base de 3.50 GHz y frecuencia m�xima turbo de 5.30 GHz.', 'Intel', 539.99),
('Procesador AMD Ryzen 9 5900X', 'Procesador de alta gama de la serie Ryzen 5000 de AMD, con 12 n�cleos y 24 hilos, frecuencia base de 3.70 GHz y frecuencia m�xima turbo de 4.80 GHz.', 'AMD', 549.99),
('Procesador Intel Core i7-11700K', 'Procesador de alto rendimiento de la 11� generaci�n de Intel, con 8 n�cleos y 16 hilos, frecuencia base de 3.60 GHz y frecuencia m�xima turbo de 5.00 GHz.', 'Intel', 399.99),
('Procesador AMD Ryzen 7 5800X', 'Procesador de gama alta de la serie Ryzen 5000 de AMD, con 8 n�cleos y 16 hilos, frecuencia base de 3.80 GHz y frecuencia m�xima turbo de 4.70 GHz.', 'AMD', 449.99),
('Procesador Intel Core i5-11600K', 'Procesador de alto rendimiento de la 11� generaci�n de Intel, con 6 n�cleos y 12 hilos, frecuencia base de 3.90 GHz y frecuencia m�xima turbo de 4.90 GHz.', 'Intel', 269.99),
('Procesador AMD Ryzen 5 5600X', 'Procesador de gama media-alta de la serie Ryzen 5000 de AMD, con 6 n�cleos y 12 hilos, frecuencia base de 3.70 GHz y frecuencia m�xima turbo de 4.60 GHz.', 'AMD', 299.99),
('Procesador Intel Core i3-10100', 'Procesador de entrada de la 10� generaci�n de Intel, con 4 n�cleos y 8 hilos, frecuencia base de 3.60 GHz y sin tecnolog�a de turbo boost.', 'Intel', 109.99),
('Procesador AMD Ryzen 3 3300X', 'Procesador de gama media de la serie Ryzen 3000 de AMD, con 4 n�cleos y 8 hilos, frecuencia base de 3.80 GHz y sin tecnolog�a de turbo boost.', 'AMD', 129.99),
('Procesador Intel Core i9-10900K', 'Procesador de alto rendimiento de la 10� generaci�n de Intel, con 10 n�cleos y 20 hilos, frecuencia base de 3.70 GHz y frecuencia m�xima turbo de 5.30 GHz.', 'Intel', 499.99),
('Procesador AMD Ryzen 9 3900X', 'Procesador de alta gama de la serie Ryzen 3000 de AMD, con 12 n�cleos y 24 hilos, frecuencia base de 3.80 GHz y frecuencia m�xima turbo de 4.60 GHz.', 'AMD', 499.99);

INSERT INTO producto (nombre, descripcion, marca, precio)
VALUES
('Memoria RAM Corsair Vengeance LPX 16GB (2x8GB) DDR4 3200MHz', 'Kit de memoria RAM DDR4 de alto rendimiento de 16GB (2x8GB) de capacidad, con una velocidad de 3200MHz. Dise�ado para ofrecer un rendimiento �ptimo en sistemas gaming y de alto rendimiento.', 'Corsair', 79.99),
('Memoria RAM G.SKILL Ripjaws V Series 16GB (2x8GB) DDR4 3600MHz', 'Kit de memoria RAM DDR4 de la serie Ripjaws V de G.SKILL, con 16GB (2x8GB) de capacidad y una velocidad de 3600MHz. Dise�ado para ofrecer un rendimiento excepcional en sistemas de alta gama.', 'G.SKILL', 89.99),
('Memoria RAM Crucial Ballistix RGB 32GB (2x16GB) DDR4 3600MHz', 'Kit de memoria RAM DDR4 de alto rendimiento de 32GB (2x16GB) de capacidad, con una velocidad de 3600MHz. Presenta iluminaci�n RGB personalizable para una est�tica gaming atractiva.', 'Crucial', 139.99),
('Memoria RAM HyperX Fury 16GB (2x8GB) DDR4 3200MHz', 'Kit de memoria RAM DDR4 de la serie Fury de HyperX, con 16GB (2x8GB) de capacidad y una velocidad de 3200MHz. Dise�ado para ofrecer un rendimiento fiable y una f�cil instalaci�n.', 'HyperX', 84.99),
('Memoria RAM TEAMGROUP T-Force Delta RGB 32GB (2x16GB) DDR4 3200MHz', 'Kit de memoria RAM DDR4 de 32GB (2x16GB) de capacidad, con una velocidad de 3200MHz. Presenta iluminaci�n RGB vibrante y un dise�o elegante para sistemas gaming.', 'TEAMGROUP', 129.99),
('Memoria RAM Patriot Viper Steel Series 32GB (2x16GB) DDR4 3600MHz', 'Kit de memoria RAM DDR4 de la serie Viper Steel de Patriot, con 32GB (2x16GB) de capacidad y una velocidad de 3600MHz. Ofrece un rendimiento fiable y una disipaci�n t�rmica eficiente.', 'Patriot', 149.99),
('Memoria RAM ADATA XPG Z1 16GB (2x8GB) DDR4 3200MHz', 'Kit de memoria RAM DDR4 de la serie XPG Z1 de ADATA, con 16GB (2x8GB) de capacidad y una velocidad de 3200MHz. Dise�ado para proporcionar un rendimiento excepcional en sistemas de alto rendimiento.', 'ADATA', 79.99),
('Memoria RAM Kingston HyperX Predator RGB 32GB (2x16GB) DDR4 3600MHz', 'Kit de memoria RAM DDR4 de la serie HyperX Predator de Kingston, con 32GB (2x16GB) de capacidad y una velocidad de 3600MHz. Presenta iluminaci�n RGB personalizable y un dise�o agresivo para sistemas gaming.', 'Kingston', 159.99),
('Memoria RAM Crucial Ballistix MAX RGB 32GB (2x16GB) DDR4 4000MHz', 'Kit de memoria RAM DDR4 de alto rendimiento de 32GB (2x16GB) de capacidad, con una velocidad de 4000MHz. Presenta iluminaci�n RGB personalizable y un dise�o robusto para sistemas gaming exigentes.', 'Crucial', 199.99),
('Memoria RAM TEAMGROUP T-Create Expert 64GB (2x32GB) DDR4 3600MHz', 'Kit de memoria RAM DDR4 de la serie T-Create Expert de TEAMGROUP, con 64GB (2x32GB) de capacidad y una velocidad de 3600MHz. Dise�ado para aplicaciones creativas y estaciones de trabajo de alto rendimiento.', 'TEAMGROUP', 249.99);

INSERT INTO producto (nombre, descripcion, marca, precio)
VALUES
('Enfriador Noctua NH-D15', 'El Noctua NH-D15 es un enfriador de CPU de alto rendimiento con dise�o de doble torre y dos ventiladores NF-A15 de 140 mm. Ofrece una excelente capacidad de enfriamiento para CPUs de alto rendimiento.', 'Noctua', 99.90),
('Enfriador Cooler Master Hyper 212 RGB Black Edition', 'El Cooler Master Hyper 212 RGB Black Edition es un enfriador de CPU con un dise�o elegante en negro y ventilador RGB de 120 mm. Ofrece un rendimiento de enfriamiento eficiente y una est�tica atractiva.', 'Cooler Master', 44.99),
('Enfriador be quiet! Dark Rock Pro 4', 'El be quiet! Dark Rock Pro 4 es un enfriador de CPU de gama alta con un dise�o de doble torre y ventiladores Silent Wings de 120 mm y 135 mm. Ofrece un rendimiento silencioso y eficiente para sistemas de alto rendimiento.', 'be quiet!', 89.90),
('Enfriador NZXT Kraken X73', 'El NZXT Kraken X73 es un enfriador de CPU l�quido todo en uno con un radiador de 360 mm y una bomba de agua RGB. Ofrece un rendimiento de enfriamiento superior y una est�tica moderna para sistemas gaming.', 'NZXT', 179.99),
('Enfriador Corsair H100i RGB Platinum SE', 'El Corsair H100i RGB Platinum SE es un enfriador de CPU l�quido con un radiador de 240 mm y ventiladores RGB de 120 mm. Ofrece un enfriamiento potente y una iluminaci�n RGB personalizable para sistemas gaming.', 'Corsair', 159.99),
('Enfriador Arctic Freezer 34 eSports DUO', 'El Arctic Freezer 34 eSports DUO es un enfriador de CPU de alto rendimiento con dise�o de doble ventilador y tecnolog�a de ventiladores BioniX de Arctic. Ofrece un rendimiento de enfriamiento excepcional para sistemas gaming.', 'Arctic', 39.99),
('Enfriador Scythe Mugen 5 Rev.B', 'El Scythe Mugen 5 Rev.B es un enfriador de CPU con un dise�o de una sola torre y un ventilador Kaze Flex de 120 mm. Ofrece un rendimiento de enfriamiento eficiente y una operaci�n silenciosa.', 'Scythe', 49.99),
('Enfriador Deepcool GAMMAXX 400', 'El Deepcool GAMMAXX 400 es un enfriador de CPU econ�mico con un dise�o de cuatro tubos de calor y un ventilador PWM de 120 mm. Ofrece un rendimiento de enfriamiento decente a un precio asequible.', 'Deepcool', 24.99),
('Enfriador Thermaltake Floe Riing RGB 360 TT Premium Edition', 'El Thermaltake Floe Riing RGB 360 TT Premium Edition es un enfriador de CPU l�quido todo en uno con un radiador de 360 mm y ventiladores Riing RGB de 120 mm. Ofrece un rendimiento de enfriamiento extremo y una iluminaci�n RGB personalizable.', 'Thermaltake', 249.99),
('Enfriador ID-COOLING SE-224-XT', 'El ID-COOLING SE-224-XT es un enfriador de CPU de bajo perfil con un dise�o de torre de aluminio y un ventilador de 120 mm. Ofrece un rendimiento de enfriamiento eficiente para sistemas compactos y HTPC.', 'ID-COOLING', 29.99);

INSERT INTO producto (nombre, descripcion, marca, precio)
VALUES
('Disco duro Samsung 970 EVO Plus', 'El Samsung 970 EVO Plus es un SSD NVMe de alta velocidad con capacidades de hasta 2 TB. Ofrece velocidades de lectura y escritura ultrarr�pidas para mejorar el rendimiento de tu sistema.', 'Samsung', 149.99),
('Disco duro Crucial MX500', 'El Crucial MX500 es un SSD SATA de alta capacidad con tecnolog�a 3D NAND. Ofrece una combinaci�n perfecta de rendimiento, velocidad y confiabilidad para tus necesidades de almacenamiento.', 'Crucial', 79.99),
('Disco duro Western Digital WD Blue SN550', 'El Western Digital WD Blue SN550 es un SSD NVMe econ�mico con velocidades de hasta 2400 MB/s. Ofrece un rendimiento s�lido a un precio asequible para actualizar tu PC.', 'Western Digital', 64.99),
('Disco duro Seagate Barracuda 2TB', 'El Seagate Barracuda es un disco duro HDD de 2 TB con una velocidad de 7200 RPM. Ofrece una gran capacidad de almacenamiento y un rendimiento confiable para tus necesidades de almacenamiento de datos.', 'Seagate', 59.99),
('Disco duro ADATA XPG SX8200 Pro', 'El ADATA XPG SX8200 Pro es un SSD NVMe PCIe Gen3x4 de alto rendimiento con velocidades de hasta 3500/3000 MB/s. Ofrece una experiencia de juego y carga de aplicaciones m�s r�pida para usuarios exigentes.', 'ADATA', 129.99),
('Disco duro Toshiba P300 4TB', 'El Toshiba P300 es un disco duro interno HDD de 4 TB con una velocidad de 7200 RPM. Ofrece una gran capacidad de almacenamiento para usuarios que requieren mucho espacio para sus archivos.', 'Toshiba', 89.99),
('Disco duro Kingston A2000', 'El Kingston A2000 es un SSD NVMe PCIe Gen3x4 con velocidades de lectura/escritura de hasta 2200/2000 MB/s. Ofrece un rendimiento potente y una gran confiabilidad para tus aplicaciones y juegos m�s exigentes.', 'Kingston', 79.99),
('Disco duro Sabrent Rocket Q 1TB', 'El Sabrent Rocket Q es un SSD NVMe PCIe Gen3x4 de alta capacidad con velocidades de hasta 3200/2000 MB/s. Ofrece una excelente relaci�n rendimiento-precio para usuarios que necesitan mucho espacio de almacenamiento.', 'Sabrent', 119.99),
('Disco duro G-Technology G-DRIVE USB 3.0 4TB', 'El G-Technology G-DRIVE es un disco duro externo de 4 TB con conexi�n USB 3.0. Ofrece una gran capacidad de almacenamiento y una transferencia r�pida de datos para respaldar tus archivos importantes.', 'G-Technology', 139.99),
('Disco duro Intel 660p Series 1TB', 'El Intel 660p Series es un SSD NVMe PCIe Gen3x4 de alta capacidad con tecnolog�a QLC NAND. Ofrece un rendimiento excepcional y una gran durabilidad para tus necesidades de almacenamiento intensivo.', 'Intel', 109.99);

INSERT INTO producto (nombre, descripcion, marca, precio)
VALUES
('Consola PlayStation 5', 'La PlayStation 5 es la �ltima consola de Sony que ofrece gr�ficos de alta fidelidad, tiempos de carga r�pidos y una experiencia de juego inmersiva. Viene con un potente hardware que incluye una CPU AMD Zen 2 y una GPU personalizada basada en RDNA 2.', 'Sony', 499.99),
('Consola Xbox Series X', 'La Xbox Series X es la consola m�s potente de Microsoft hasta la fecha. Ofrece gr�ficos de pr�xima generaci�n, tiempos de carga r�pidos y una amplia gama de juegos exclusivos. Con un potente hardware que incluye una CPU AMD Zen 2 y una GPU personalizada de la serie Xbox Velocity Architecture, ofrece una experiencia de juego de alto rendimiento.', 'Microsoft', 499.99),
('Consola Nintendo Switch', 'La Nintendo Switch es una consola h�brida que te permite jugar tanto en casa como en movimiento. Ofrece una amplia variedad de juegos exclusivos de Nintendo, as� como la capacidad de jugar en modo port�til o en modo TV. Su innovador dise�o y su amplia biblioteca de juegos la convierten en una opci�n popular entre los jugadores de todas las edades.', 'Nintendo', 299.99),
('Consola PlayStation 4 Pro', 'La PlayStation 4 Pro es una consola de gama alta de Sony que ofrece gr�ficos mejorados y un rendimiento m�s r�pido. Con capacidades de juego en 4K y HDR, es ideal para jugadores que buscan una experiencia de juego inmersiva. Adem�s, ofrece una amplia biblioteca de juegos exclusivos de PlayStation.', 'Sony', 399.99),
('Consola Xbox One X', 'La Xbox One X es una consola de alta gama de Microsoft que ofrece juegos en 4K y HDR. Con un potente hardware y una amplia gama de juegos exclusivos, proporciona una experiencia de juego de alta calidad. Adem�s, ofrece capacidades de reproducci�n de Blu-ray en 4K para una experiencia multimedia completa.', 'Microsoft', 399.99),
('Consola Nintendo Switch Lite', 'La Nintendo Switch Lite es una versi�n m�s compacta y port�til de la Nintendo Switch original. Dise�ada espec�ficamente para el juego port�til, ofrece una experiencia de juego ligera y port�til sin la capacidad de cambiar entre modos de juego. Es ideal para jugadores que prefieren jugar en movimiento.', 'Nintendo', 199.99),
('Consola PlayStation 4 Slim', 'La PlayStation 4 Slim es una versi�n m�s delgada y ligera de la PlayStation 4 original. Ofrece el mismo rendimiento y funcionalidad que su predecesora en un dise�o m�s compacto. Con una amplia biblioteca de juegos y capacidades de transmisi�n de contenido multimedia, es una opci�n popular entre los jugadores.', 'Sony', 299.99),
('Consola Xbox One S', 'La Xbox One S es una versi�n m�s delgada y elegante de la Xbox One original. Ofrece capacidades de juego en 4K y HDR, as� como una amplia variedad de juegos exclusivos de Xbox. Con un dise�o compacto y funcionalidades multimedia adicionales, es una opci�n vers�til para los jugadores.', 'Microsoft', 299.99),
('Consola Nintendo 3DS', 'La Nintendo 3DS es una consola port�til que ofrece juegos en 3D sin necesidad de gafas especiales. Con una amplia biblioteca de juegos exclusivos y la capacidad de jugar en 3D, proporciona una experiencia de juego �nica y emocionante. Adem�s, ofrece conectividad Wi-Fi para jugar en l�nea con amigos.', 'Nintendo', 149.99),
('Consola PlayStation Vita', 'La PlayStation Vita es una consola port�til de Sony que ofrece juegos de alta calidad en la palma de tu mano. Con una pantalla t�ctil OLED de alta resoluci�n y controles intuitivos, proporciona una experiencia de juego envolvente. Adem�s, ofrece conectividad Wi-Fi y 3G para jugar en l�nea y descargar contenido.', 'Sony', 199.99);
