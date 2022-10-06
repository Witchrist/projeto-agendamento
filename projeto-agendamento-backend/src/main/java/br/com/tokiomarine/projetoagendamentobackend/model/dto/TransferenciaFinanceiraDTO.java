package br.com.tokiomarine.projetoagendamentobackend.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TransferenciaFinanceiraDTO {

    private Long idTransferencia;
    private String contaOrigem;
    private String contaDestino;
    private Double vlrTransferencia;
    private Double taxa;
    private String dtTransferencia;
    private String dtAgendamento;
}
