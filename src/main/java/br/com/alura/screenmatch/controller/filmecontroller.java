
package br.com.alura.screenmatch.controller;

import br.com.alura.screenmatch.model.Filme;
import br.com.alura.screenmatch.model.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author davi_
 */
@Controller
@RequestMapping("/filmes")
public class filmecontroller {
    
    @Autowired
    private FilmeRepository repository;
    
    @GetMapping("/formulario")
    public String carregarPaginaFormulario(Model model, Filme filme){
        model.addAttribute("filme", filme);
        return "formulario";
    }
    
    @GetMapping
    public String carregarPaginaListagem(Model model){
        model.addAttribute("filmes", repository.findAll());
        return "listagem";
    }
    
    
    @GetMapping("/editar")
    public String carregarPaginaEdicao(Model model, Filme filme, Long id){
        filme = repository.getReferenceById(id);
        model.addAttribute("filme", filme);
        return "editar";
    }
    
    
    @PostMapping
    @Transactional
    public String cadastrarFilme(Filme filme){
        repository.save(filme);
        return "formulario";
    }
    
    
    @PutMapping
    @Transactional
    public String atualizarFilme(Filme filme){
        Filme filmeAtualizado = repository.getReferenceById(filme.getId());
        filmeAtualizado.atualizarFilme(filme);
        repository.save(filmeAtualizado);
        return "redirect:/filmes";
    }
    
    
    @DeleteMapping
    @Transactional
    public String deletarFilme(Long id){
        repository.deleteById(id);
        return "redirect:/filmes";
    }
}
