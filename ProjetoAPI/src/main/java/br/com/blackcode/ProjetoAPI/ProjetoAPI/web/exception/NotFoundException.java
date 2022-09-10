package br.com.blackcode.ProjetoAPI.ProjetoAPI.web.exception;


import br.com.blackcode.ProjetoAPI.ProjetoAPI.web.ApiStatus;

/**
 * @author ock
 */
public class NotFoundException extends ApiException {
    /**
     *
     */
    public NotFoundException() {
        super(ApiStatus.NOT_FOUND, "");
    }

    /**
     * @param message
     */
    public NotFoundException(String message) {
        super(ApiStatus.NOT_FOUND, message);
    }
}
