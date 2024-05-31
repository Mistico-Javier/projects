package dgtic.proyecto.service.carrito;

import dgtic.proyecto.model.entities.Carrito;
import dgtic.proyecto.repository.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CarritoServiceImpl implements CarritoService{
    @Autowired
    CarritoRepository carritoRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<Carrito> buscarCarrito(Pageable pageable) {
        return carritoRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Carrito> buscarCarrito() {
        return carritoRepository.findAll();
    }

    @Override
    @Transactional
    public void guardar(Carrito carrito) {
        carritoRepository.save(carrito);
    }

    @Override
    @Transactional
    public void borrar(Integer id) {
        carritoRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Carrito buscarCarritoId(Integer id) {
        Optional<Carrito> op = carritoRepository.findById(id);
        return op.orElse(null);
    }

    @Override
    public Carrito buscarCarritoPorUsuarioId(int id) {
        return carritoRepository.findCarritoByUsuarioId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Carrito> buscarCarritosPorUsuarioId(int id) {
        return carritoRepository.findCarritosByUsuarioId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Carrito> buscarCarritoPorProductoId(int id) {
        return carritoRepository.findByProductoId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Carrito> buscarCarritosPorUsuarioYProducto(int idUsuario, int idProducto) {
        return carritoRepository.findCarritosByUsuarioIdAndProductoId(idUsuario, idProducto);
    }

    @Override
    @Transactional(readOnly = true)
    public Carrito buscarCarritoPorUsuarioYProducto(int idUsuario, int idProducto) {
        return carritoRepository.findByUsuarioIdAndProductoId(idUsuario, idProducto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Carrito> buscarCarritoPorUsuarioYCantidadMayorQue(int idUsuario, int cantidad) {
        return carritoRepository.findByUsuarioIdAndCantidadGreaterThan(idUsuario, cantidad);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Carrito> buscarCarritoPorUsuarioYPrecioMayorQue(int idUsuario, double precio) {
        return carritoRepository.findByUsuarioIdAndProductoPrecioGreaterThan(idUsuario, precio);
    }

    @Modifying
    @Override
    @Transactional
    public void borrarCarritoPorUsuarioId(int id) {
        carritoRepository.deleteCarritoByUsuarioId(id);
    }
}
