package com.mycompany.cenaflix.modelos;

/**
 * Modelo para representar um filme.
 * Esta classe utiliza um record para armazenar as informações de um filme de forma imutável.
 *
 * @param nome           O nome do filme.
 * @param dataLancamento A data de lançamento do filme (formato String, ex: "dd/MM/yyyy").
 * @param categoria      A categoria do filme.
 * @author (Nome do Autor)
 * @version 1.0
 * @since 1.0
 */

public record FilmeModelo (String nome, String dataLancamento, String categoria) {
    
}
