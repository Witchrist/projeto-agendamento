package br.com.tokiomarine.projetoagendamentobackend.exception;

import java.time.DateTimeException;

public class ValidacaoDataTransferenciaException extends DateTimeException {

    public ValidacaoDataTransferenciaException(String message) {
        super(message);
    }
}
