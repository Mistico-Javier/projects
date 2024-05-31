package dgtic.proyecto.controller.ticket;

import dgtic.proyecto.exception.UsuarioNotFoundException;
import dgtic.proyecto.model.entities.Domicilio;
import dgtic.proyecto.model.entities.Ticket;
import dgtic.proyecto.model.entities.TicketDetalle;
import dgtic.proyecto.model.entities.Usuario;
import dgtic.proyecto.service.domicilio.DomicilioService;
import dgtic.proyecto.service.ticket.TicketService;
import dgtic.proyecto.service.ticketdetalle.TicketDetalleService;
import dgtic.proyecto.service.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class HistorialController {
    @Autowired
    private TicketService ticketService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private TicketDetalleService ticketDetalleService;

    @GetMapping("/historial")
    public String verHistorial(Model model, Principal principal) throws UsuarioNotFoundException {
        Usuario usuario = usuarioService.buscarPorCorreo(principal.getName());
        if (usuario == null) {
            return "redirect:/historial/vacio";
        }

        List<Ticket> tickets = ticketService.buscarTicketUsuarioId(usuario.getId());
        if (tickets == null || tickets.isEmpty()) {
            return "redirect:/historial/vacio";
        }

        List<TicketDetalle> ticketDetalles = ticketDetalleService.buscarTicketDetallePorUsuarioId(usuario.getId());
        if (ticketDetalles == null || ticketDetalles.isEmpty()) {
            return "redirect:/historial/vacio";
        }

        model.addAttribute("ticketDetalles", ticketDetalles);
        return "historial";
    }

    @GetMapping("/historial/vacio")
    public String historialVacio(Model model) {
        return "historial-vacio";
    }
}
