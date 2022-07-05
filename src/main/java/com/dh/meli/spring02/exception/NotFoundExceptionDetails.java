package com.dh.meli.spring02.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// ANOTAÇÃO DO LOMBOK QUE CRIA OS MÉTODOS DA CLASSE
@Data

// PERMITE ESCOLHER QUAIS ATRIBUTOS QUERO MOSTRAR
@Builder // padrão pra criar objetos sem utilizar o contrutor

@NoArgsConstructor // constutor vazio
@AllArgsConstructor // construtor com todos os parâmetros

// ESTA CLASSE FICARÁ RESPONSÁVEL POR LIDAR COM AS INFORMAÇÕES QUE EU QUERO TRATAR.
// SÓ SERÃO MOSTRADAS AS INFORMAÇÕES QUE FOREM DETERMINADAS AQUI PARA SEREM MOSTRADAS
public class NotFoundExceptionDetails {
    private String title;
    private int status;
    private String message;
    private LocalDateTime timestamp;
}
