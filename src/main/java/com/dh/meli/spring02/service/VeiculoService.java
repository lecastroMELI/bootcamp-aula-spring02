package com.dh.meli.spring02.service;
import com.dh.meli.spring02.model.Veiculo;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface VeiculoService {
    // MÉTODOS QUE SERÃO TRABALHADOS
    // AS AÇÕES QUE O CONTROLE PRECISA
    Veiculo getVeiculo(String placa);
    List<Veiculo> getAllVeiculo();
    void saveVeiculo(Veiculo novoVeiculo);
}
