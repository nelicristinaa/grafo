package br.com.grafo.Repository;

import org.springframework.data.repository.CrudRepository;

import br.com.grafo.model.Graph;

public interface GraphRepository  extends CrudRepository<Graph, Long>{
    
}
