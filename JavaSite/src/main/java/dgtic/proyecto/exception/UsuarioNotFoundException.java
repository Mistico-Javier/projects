package dgtic.proyecto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UsuarioNotFoundException extends Exception{
    public UsuarioNotFoundException(Long id) {
        super("User Info with id " + id + " is NOT found");
    }

    public UsuarioNotFoundException(String email) {
        super("User Email already exists! " + email);
    }
}
