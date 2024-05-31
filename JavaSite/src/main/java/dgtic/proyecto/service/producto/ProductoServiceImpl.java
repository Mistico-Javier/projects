package dgtic.proyecto.service.producto;

import dgtic.proyecto.model.entities.Producto;
import dgtic.proyecto.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    ProductoRepository productoRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<Producto> buscarProducto(Pageable pageable) {
        return productoRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> buscarProducto() {
        return productoRepository.findAll();
    }

    @Override
    @Transactional
    public void guardar(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    @Transactional
    public void borrar(Integer id) {
        productoRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Producto buscarProductoId(Integer id) {
        Optional<Producto> op = productoRepository.findById(id);
        return op.orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Producto> buscarProductoPorNombre(String dato, Pageable pageable) {
        return productoRepository.findByNombreProducto(dato, pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> buscarProductoMarcaPatron(String patron) {
        return productoRepository.findByMarcaProducto(patron);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> buscarProductoMarca(String marca) {
        return productoRepository.findByMarca(marca);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> buscarProductoMenorQue(Double precio) {
        return productoRepository.findByPrecioMenorQue(precio);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> buscarProductoMayorQue(Double precio) {
        return productoRepository.findByPrecioMayorQue(precio);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> buscarProductoEntre(Double precioMin, Double precioMax) {
        return productoRepository.findByPrecioBetween(precioMin,precioMax);
    }
}
