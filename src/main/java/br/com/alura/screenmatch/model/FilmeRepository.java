
package br.com.alura.screenmatch.model;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author davi_
 */
public interface FilmeRepository extends JpaRepository<Filme, Long> {
    
}
