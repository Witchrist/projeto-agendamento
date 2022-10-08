package br.com.tokiomarine.projetoagendamentobackend.service;

import br.com.tokiomarine.projetoagendamentobackend.model.dto.TransferenciaFinanceiraDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TransferenciaFinanceiraServiceTest {

    @Test
    public void verificarTaxa_comValorAcimaDe2000_comQtdDiasMenorQue10_naoDeveVerificar(){

        TransferenciaFinanceiraService transferenciaFinanceiraService = new TransferenciaFinanceiraService();
        TransferenciaFinanceiraDTO dto = new TransferenciaFinanceiraDTO();
        dto.setContaOrigem("111111");
        dto.setContaDestino("222222");
        dto.setDtTransferencia("07/10/2022");
        dto.setDtAgendamento("07/10/2022");
        dto.setVlrTransferencia(3000.0);

        Exception exception = assertThrows(Exception.class, () -> transferenciaFinanceiraService.verificarTaxa(dto));

        assertTrue(exception.getMessage().contains("Nao existe taxa aplicavel para essa transferencia"));
    }

    @Test
    public void verificarTaxa_comValorAbaixoDe2000_comQtdDiasMaiorQue10_naoDeveVerificar(){

        TransferenciaFinanceiraService transferenciaFinanceiraService = new TransferenciaFinanceiraService();
        TransferenciaFinanceiraDTO dto = new TransferenciaFinanceiraDTO();
        dto.setContaOrigem("111111");
        dto.setContaDestino("222222");
        dto.setDtAgendamento("07/10/2022");
        dto.setDtTransferencia("18/10/2022");
        dto.setVlrTransferencia(1000.0);

        Exception exception = assertThrows(Exception.class, () -> transferenciaFinanceiraService.verificarTaxa(dto));

        assertTrue(exception.getMessage().contains("Nao existe taxa aplicavel para essa transferencia"));
    }
}
