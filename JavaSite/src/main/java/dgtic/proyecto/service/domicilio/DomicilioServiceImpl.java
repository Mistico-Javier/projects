package dgtic.proyecto.service.domicilio;

import dgtic.proyecto.model.entities.Domicilio;
import dgtic.proyecto.repository.DomicilioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DomicilioServiceImpl implements DomicilioService{
    @Autowired
    DomicilioRepository domicilioRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<Domicilio> buscarDomicilio(Pageable pageable) {
        return domicilioRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Domicilio> buscarDomicilio() {
        return domicilioRepository.findAll();
    }

    @Override
    @Transactional
    public void guardar(Domicilio domicilio) {
        domicilioRepository.save(domicilio);
    }

    @Override
    @Transactional
    public void borrar(Integer id) {
        domicilioRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Domicilio buscarDomicilioId(Integer id) {
        Optional<Domicilio> op = domicilioRepository.findById(id);
        return op.orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Domicilio> buscarDomicilioCalle(String patron) {
        return domicilioRepository.findByCalle(patron);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Domicilio> buscarDomicilioColoniaBarrio(String patron) {
        return domicilioRepository.findByColoniaBarrio(patron);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Domicilio> buscarDomicilioAlcaldiaMunicipio(String patron) {
        return domicilioRepository.findByAlcaldiaMunicipio(patron);
    }

    @Override
    @Transactional(readOnly = true)
    public Domicilio buscarDomicilioPorCorreo(String correo) {
        return domicilioRepository.findByUsuarioCorreo(correo);
    }

    @Override
    @Transactional(readOnly = true)
    public Domicilio buscarDomicilioPorUsuarioId(int id) {
        return domicilioRepository.findByUsuarioId(id);
    }

    @Override
    @Transactional
    @Modifying
    public void actualizarDomicilio(Domicilio domicilio) {
        domicilioRepository.updateDomicilioByUsuarioId(
                domicilio.getUsuario().getId(),
                domicilio.getCalle(),
                domicilio.getNumero(),
                domicilio.getColoniaBarrio(),
                domicilio.getCodigoPostal(),
                domicilio.getAlcaldiaMunicipio(),
                domicilio.getEstado()
        );
    }

}
