package br.com.tokiomarine.projetoagendamentobackend.service;

import br.com.tokiomarine.projetoagendamentobackend.model.dto.TransferenciaFinanceiraDTO;
import br.com.tokiomarine.projetoagendamentobackend.model.entity.TransferenciaFinanceira;
import br.com.tokiomarine.projetoagendamentobackend.repository.TransferenciaFinanceiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
        dto.setDtAgendamento(buscarDataHojeSemHoras());
        String tpTaxa = verificarTaxa(dto);
        Double vlrTaxa = calcularTaxa(dto.getVlrTransferencia(), tpTaxa);
        dto.setTaxa(vlrTaxa);
        TransferenciaFinanceira transf = dtoToBusiness(dto);
        transfFinRepository.saveAndFlush(transf);
    }

    public String verificarTaxa(TransferenciaFinanceiraDTO transfDto){
        Date dtAgendamento = transfDto.getDtAgendamento();
        Date dtTransferencia = transfDto.getDtTransferencia();
        long qtDias = (dtTransferencia.getTime()-dtAgendamento.getTime())/86400000l;

        Double vlrTransferencia = transfDto.getVlrTransferencia();

        if(qtDias <= 10 && vlrTransferencia>2000){
            return "";
        }
        if(qtDias == 0 && vlrTransferencia<=1000){
            return "a";
        }
        if(qtDias <= 10 && vlrTransferencia<=2000){
            return "b";
        }
        if(qtDias <= 20 && vlrTransferencia>2000){
            return "c1";
        }
        if(qtDias <= 30 && vlrTransferencia>2000){
            return "c2";
        }
        if(qtDias <= 40 && vlrTransferencia>2000){
            return "c3";
        }
        if(qtDias > 40 && vlrTransferencia>2000){
            return "c4";
        }

        return "";
    }

    public Double calcularTaxa(Double vlrTransferencia, String taxa ){
        Double vlrTaxa = 0.0;

        switch(taxa){
            case "a":
                vlrTaxa = (vlrTransferencia*1.03)+3;
                break;
            case "b":
                vlrTaxa = vlrTransferencia+12;
                break;
            case "c1":
                vlrTaxa = (vlrTransferencia*1.082);
                break;
            case "c2":
                vlrTaxa = (vlrTransferencia*1.069);
                break;
            case "c3":
                vlrTaxa = (vlrTransferencia*1.047);
                break;
            case "c4":
                vlrTaxa = (vlrTransferencia*1.017);
                break;
            default:
                break;
        }
        return vlrTaxa;
    }

    public Date buscarDataHojeSemHoras(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
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
