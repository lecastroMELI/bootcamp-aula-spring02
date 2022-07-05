package com.dh.meli.spring02.service;
import com.dh.meli.spring02.dto.VeiculoDto;
import com.dh.meli.spring02.model.Veiculo;
// import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface VeiculoService {
    // MÉTODOS QUE SERÃO TRABALHADOS
    // AS AÇÕES QUE O CONTROLE PRECISA
    VeiculoDto getVeiculo(String placa);
    List<VeiculoDto> getAllVeiculo();
    void saveVeiculo(Veiculo novoVeiculo);
    List<VeiculoDto> getAllOrderByValue();
    List<VeiculoDto> getAllOrderByModelo();
    List<VeiculoDto> getByModelo(String modelo);
}
