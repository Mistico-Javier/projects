package dgtic.proyecto;

import dgtic.proyecto.model.entities.Administrador;
import dgtic.proyecto.model.entities.Producto;
import dgtic.proyecto.model.entities.Ticket;
import dgtic.proyecto.model.entities.Usuario;
import dgtic.proyecto.repository.AdministradorRepository;
import dgtic.proyecto.repository.ProductoRepository;
import dgtic.proyecto.repository.UsuarioRepository;
import dgtic.proyecto.service.administrador.AdministradorService;
import dgtic.proyecto.service.ticket.TicketService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@SpringBootTest
class M9JavierDuranApplicationTests {
	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	ProductoRepository productoRepository;

	@Autowired
	TicketService ticketService;

	@Test
	void buscarTodosUsuario(){
		System.out.println("Test Usuarios");
		System.out.println("Buscar todos los Usuarios");
		Iterable<Usuario> iterable = usuarioRepository.findAll();
		iterable.forEach(System.out::println);
	}

	@Test
	void busquedaProducto(){
		System.out.println("Test Búsqueda de producto");
		System.out.println("Buscar todos los productos con coincidencia");
		int page = 0;
		Pageable pagReq= PageRequest.of(page,4);
		String text= "camara";
		Iterable<Producto> iterable = productoRepository.findByNombreProducto(text, pagReq);
		iterable.forEach(System.out::println);
	}

}
