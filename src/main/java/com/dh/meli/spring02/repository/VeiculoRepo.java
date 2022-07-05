package com.dh.meli.spring02.repository;

import com.dh.meli.spring02.exception.NotFoundException;
import com.dh.meli.spring02.exception.NotFoundExceptionDetails;
import com.dh.meli.spring02.model.Veiculo;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class VeiculoRepo {
    private final String linkFile = "src/main/resources/dados.json";

    public Veiculo getVeiculo(String placa) {
        ObjectMapper mapper = new ObjectMapper();
        List<Veiculo> lista = null;
        try {
            lista = Arrays.asList
                    (mapper.readValue(new File(linkFile), Veiculo[].class));
        } catch (Exception ex) {

        }

        for (Veiculo v : lista) {
            if (v.getPlaca().equals(placa)) {
                return v;
            }
        }

        // ----------------------- EXCEÇÕES AULA 05/07 ------------------------ //

        /* EXCEÇÃO PADRÃO
        * No exemplo, será lançada uma exceção quando não localizar um veículo.
        * É possível fazer com o EXCEPTION, mas ele é muito genérico, portanto foi usado o RUNTIMEEXCEPTION
        */
        // throw new RuntimeException("Veículo não localizado");

        /* EXCEÇÃO PERSONALIZADA
        * Foi criada a classe NotFoundException que contém a exceção personalizada
        * A 'mensagem' informada nos parênteses vai ser usada dentro da classe com o tratamento personalizado
        * */
        throw new NotFoundException("Veículo não localizado (essa mensagem está escrita em VeículoRepo.java)");


        /* PADRÃO BUILDER
        * ELE DEVE SER DEFINIDO NA CLASSE COM @Builder
        * O Lombok pega exatamente o nome do atributo para gerar o método
        * A seguir apenas um exemplo de como seria sua implementação aqui:
        */
//        NotFoundExceptionDetails nf = NotFoundExceptionDetails.builder()
//            .mesage("Um mensagem qualquert")
//            .status(25)
//            .build();

        // return null;
    }

    public List<Veiculo> getAllVeiculo() {
        ObjectMapper mapper = new ObjectMapper();
        List<Veiculo> lista = null;
        try {
            lista = Arrays.asList
                    (mapper.readValue(new File(linkFile), Veiculo[].class));

        } catch (Exception ex) {

        }

        return lista;
    }

    public void saveVeiculo(Veiculo novoVeiculo) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer (new DefaultPrettyPrinter());
        List<Veiculo> listaAtual = null;
        try {
            listaAtual = Arrays.asList
                    (mapper.readValue(new File(linkFile), Veiculo[].class));
            List<Veiculo> listaCopia = new ArrayList<>(listaAtual);
            listaCopia.add(novoVeiculo);
            writer.writeValue(new File(linkFile), listaCopia);
        } catch (Exception ex) {
            System.out.println("Errooo");
        }

    }
}
