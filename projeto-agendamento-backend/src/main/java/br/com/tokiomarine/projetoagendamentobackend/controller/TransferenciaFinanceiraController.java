package br.com.tokiomarine.projetoagendamentobackend.controller;

import br.com.tokiomarine.projetoagendamentobackend.model.dto.TransferenciaFinanceiraDTO;
import br.com.tokiomarine.projetoagendamentobackend.service.TransferenciaFinanceiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transferencia")
public class TransferenciaFinanceiraController {

    @Autowired
    TransferenciaFinanceiraService transfFinService;

    //Metodo para retornar todas as transferencias financeiras
    @GetMapping
    public List<TransferenciaFinanceiraDTO> buscarTransferencias(){
        return transfFinService.buscarTransferencias();
    }

    @PostMapping
    public void criarTransferencia(@RequestBody TransferenciaFinanceiraDTO dto){

    }
}
