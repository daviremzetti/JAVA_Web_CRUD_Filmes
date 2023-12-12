
package br.com.alura.screenmatch.model;

import java.time.LocalDate;

/**
 *
 * @author davi_
 */
public record Cadastro(String nome, Integer duracao, String genero, LocalDate lancamento) {}
