package br.com.tokiomarine.projetoagendamentobackend.service;

import br.com.tokiomarine.projetoagendamentobackend.model.dto.TransferenciaFinanceiraDTO;
import br.com.tokiomarine.projetoagendamentobackend.model.entity.TransferenciaFinanceira;
import br.com.tokiomarine.projetoagendamentobackend.repository.TransferenciaFinanceiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    public TransferenciaFinanceiraDTO criarTransferencia(TransferenciaFinanceiraDTO dto){
        dto.setDtAgendamento(formatarDataParaString(new Date()));
        String tpTaxa = verificarTaxa(dto);
        Double vlrTaxa = calcularTaxa(dto.getVlrTransferencia(), tpTaxa);
        dto.setTaxa(vlrTaxa);
        TransferenciaFinanceira transf = dtoToBusiness(dto);
        transfFinRepository.saveAndFlush(transf);

        return businessToDTO(transf);
    }

    public String verificarTaxa(TransferenciaFinanceiraDTO transfDto){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        long qtDias = 0;

        try{
            Date dtAgendamento = sdf.parse(transfDto.getDtAgendamento());
            Date dtTransferencia = sdf.parse(transfDto.getDtTransferencia());
            qtDias = (dtTransferencia.getTime()-dtAgendamento.getTime())/86400000l;
        } catch (ParseException e){
            e.printStackTrace();
            return "";
        }


        Double vlrTransferencia = transfDto.getVlrTransferencia();

        if(qtDias <= 10 && vlrTransferencia>2000){
            return ""; //maior que 10 dias e menor que 2000 tambem nao se encaixa
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

        Double vlrTaxa = 0.0; //formatar valor da taxa para duas casas decimais :)

        switch(taxa){
            case "a":
                vlrTaxa = (vlrTransferencia*0.03)+3;
                break;
            case "b":
                vlrTaxa = 12.0;
                break;
            case "c1":
                vlrTaxa = (vlrTransferencia*0.082);
                break;
            case "c2":
                vlrTaxa = (vlrTransferencia*0.069);
                break;
            case "c3":
                vlrTaxa = (vlrTransferencia*0.047);
                break;
            case "c4":
                vlrTaxa = (vlrTransferencia*0.017);
                break;
            default:
                break;
        }

        BigDecimal bg = new BigDecimal(vlrTaxa).setScale(2, RoundingMode.CEILING);
        vlrTaxa = bg.doubleValue();

        return vlrTaxa;
    }

    public String formatarDataParaString(Date data){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        return sdf.format(data);
    }

    public Date formatarStringParaData(String data){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try{
            return sdf.parse(data);
        } catch(ParseException e){
            return null;
        }
    }

    public TransferenciaFinanceira dtoToBusiness (TransferenciaFinanceiraDTO dto) {

        TransferenciaFinanceira transf = new TransferenciaFinanceira();

        transf.setContaOrigem(dto.getContaOrigem());
        transf.setContaDestino(dto.getContaDestino());
        transf.setVlrTransferencia(dto.getVlrTransferencia());
        transf.setTaxa(dto.getTaxa());
        transf.setDtTransferencia(formatarStringParaData(dto.getDtTransferencia()));
        transf.setDtAgendamento(formatarStringParaData(dto.getDtAgendamento()));

        return transf;
    }

    public TransferenciaFinanceiraDTO businessToDTO (TransferenciaFinanceira transf){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        TransferenciaFinanceiraDTO dto = new TransferenciaFinanceiraDTO();

        dto.setIdTransferencia(transf.getIdTransferencia());
        dto.setContaOrigem(transf.getContaOrigem());
        dto.setContaDestino(transf.getContaDestino());
        dto.setVlrTransferencia(transf.getVlrTransferencia());
        dto.setTaxa(transf.getTaxa());
        dto.setDtTransferencia(formatarDataParaString(transf.getDtTransferencia()));
        dto.setDtAgendamento(formatarDataParaString(transf.getDtAgendamento()));

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
