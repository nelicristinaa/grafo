package br.com.grafo.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

import br.com.grafo.model.Route;

public interface RouteRepository extends CrudRepository<Route, Long>{
   
    
}
