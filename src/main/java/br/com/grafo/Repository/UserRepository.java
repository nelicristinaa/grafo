package br.com.grafo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import br.com.grafo.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    
}
