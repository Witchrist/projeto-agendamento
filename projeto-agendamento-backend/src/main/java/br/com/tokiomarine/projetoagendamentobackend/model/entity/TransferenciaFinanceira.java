package br.com.tokiomarine.projetoagendamentobackend.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity(name="tb_transferencia_financeira")
@Data
public class TransferenciaFinanceira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_TRANSFERENCIA")
    private Long idTransferencia;

    @Column(name="CONTA_ORIGEM")
    private String contaOrigem;

    @Column(name="CONTA_DESTINO")
    private String contaDestino;

    @Column(name="VALOR_TRANSFERENCIA")
    private Double vlrTransferencia;

    @Column(name="TAXA")
    private Double taxa;

    @Column(name="DATA_TRANSFERENCIA")
    private Date dtTransferencia;

    @Column(name="DATA_AGENDAMENTO")
    private Date dtAgendamento;
}
