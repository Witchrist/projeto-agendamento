package br.com.tokiomarine.projetoagendamentobackend.config;

import br.com.tokiomarine.projetoagendamentobackend.exception.TaxaAplicavelException;
import br.com.tokiomarine.projetoagendamentobackend.exception.ValidacaoDataTransferenciaException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.text.ParseException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { ParseException.class })
    protected ResponseEntity<Object> handleConflict(ParseException ex, WebRequest request) {
        String bodyOfResponse = "Status: "+HttpStatus.CONFLICT + "\nNão foi possível formatar a data";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(value = { ValidacaoDataTransferenciaException.class })
    protected ResponseEntity<Object> handleConflict(ValidacaoDataTransferenciaException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(value = { TaxaAplicavelException.class })
    protected ResponseEntity<Object> handleConflict(TaxaAplicavelException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(value = { Exception.class })
    protected ResponseEntity<Object> handleError(Exception ex, WebRequest request) {
        String bodyOfResponse = "Status: "+HttpStatus.INTERNAL_SERVER_ERROR + " - Ocorreu um erro";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
