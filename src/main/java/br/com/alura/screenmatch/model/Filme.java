
package br.com.alura.screenmatch.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

/**
 *
 * @author davi_
 */
@Entity
@Table(name="filmes")
public class Filme {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String genero;
    private int duracao;
    private LocalDate lancamento;

    public Filme(Cadastro dados) {
        this.nome = dados.nome();
        this.genero = dados.genero();
        this.duracao = dados.duracao();
        this.lancamento = dados.lancamento();
    }

    public Filme() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public void setLancamento(LocalDate lancamento) {
        this.lancamento = lancamento;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public int getDuracao() {
        return duracao;
    }

    public LocalDate getLancamento() {
        return lancamento;
    }
    
    public void atualizarFilme(Filme filme){
        this.id = filme.getId();
        this.duracao = filme.getDuracao();
        this.genero = filme.getGenero();
        this.lancamento = filme.getLancamento();
        this.nome = filme.getNome();
    }

    @Override
    public String toString() {
        return "Filme{" + "id=" + id + ", nome=" + nome + ", genero=" + genero + ", duracao=" + duracao + ", lancamento=" + lancamento + '}';
    }
    
    
  
}
