package br.jus.stm.localizacao.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalizacaoAPIException extends RuntimeException {

    private String message;

    private Integer code;

    private String type;

    public LocalizacaoAPIException(final String message) {
        this.message = message;
    }

    public LocalizacaoAPIException(final String message, final Throwable causa) {
        super(message, causa);
        this.message = message;
    }

}
