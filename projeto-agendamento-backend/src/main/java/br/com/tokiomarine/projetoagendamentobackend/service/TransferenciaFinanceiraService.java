package br.com.tokiomarine.projetoagendamentobackend.service;

import br.com.tokiomarine.projetoagendamentobackend.model.dto.TransferenciaFinanceiraDTO;
import br.com.tokiomarine.projetoagendamentobackend.model.entity.TransferenciaFinanceira;
import br.com.tokiomarine.projetoagendamentobackend.repository.TransferenciaFinanceiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransferenciaFinanceiraService {

    @Autowired
    TransferenciaFinanceiraRepository transfFinRepository;

    public List<TransferenciaFinanceiraDTO> buscarTransferencias(){
        List<TransferenciaFinanceira> listaTransf = transfFinRepository.findAll();
        List<TransferenciaFinanceiraDTO> listaTransfDto = listToDto(listaTransf);

        return listaTransfDto;
    }

    public void criarTransferencia(TransferenciaFinanceiraDTO dto){
        TransferenciaFinanceira transf = dtoToBusiness(dto);
        transfFinRepository.saveAndFlush(transf);
    }

    public TransferenciaFinanceira dtoToBusiness (TransferenciaFinanceiraDTO dto) {
        TransferenciaFinanceira transf = new TransferenciaFinanceira();

        transf.setContaOrigem(dto.getContaOrigem());
        transf.setContaDestino(dto.getContaDestino());
        transf.setVlrTransferencia(dto.getVlrTransferencia());
        transf.setTaxa(dto.getTaxa());
        transf.setDtTransferencia(dto.getDtTransferencia());
        transf.setDtAgendamento(dto.getDtAgendamento());

        return transf;
    }

    public TransferenciaFinanceiraDTO businessToDTO (TransferenciaFinanceira transf){
        TransferenciaFinanceiraDTO dto = new TransferenciaFinanceiraDTO();

        dto.setIdTransferencia(transf.getIdTransferencia());
        dto.setContaOrigem(transf.getContaOrigem());
        dto.setContaDestino(transf.getContaDestino());
        dto.setVlrTransferencia(transf.getVlrTransferencia());
        dto.setTaxa(transf.getTaxa());
        dto.setDtTransferencia(transf.getDtTransferencia());
        dto.setDtAgendamento(transf.getDtAgendamento());

        return dto;
    }

    public List<TransferenciaFinanceiraDTO> listToDto(List<TransferenciaFinanceira> list) {
        List<TransferenciaFinanceiraDTO> listDTO = new ArrayList<TransferenciaFinanceiraDTO>();

        for (TransferenciaFinanceira transf : list) {
            listDTO.add(this.businessToDTO(transf));
        }
        return listDTO;
    }
}
