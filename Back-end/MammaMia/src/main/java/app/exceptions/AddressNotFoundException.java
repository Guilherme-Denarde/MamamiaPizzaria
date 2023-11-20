package app.exceptions;


public class AddressNotFoundException extends RuntimeException {
    public AddressNotFoundException(Long id) {
        super("with ID " + id + " not found");
    }

}
