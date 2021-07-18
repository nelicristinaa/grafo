package br.com.grafo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.databind.util.ArrayBuilders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.grafo.model.User;




@RestController
@RequestMapping("/users")
public class UserController {
 // GET
  // POST
  // PUT
  // DELETE
  // PATCH

   private List<User>  users = new ArrayList<>();



   //busca o usuário pelo id
    @GetMapping("/{id}")
    public User user(@PathVariable("id") Long id){
      //  System.out.println("o id é: " + id);
        Optional<User> userFind = users.stream().filter(user -> user.getId() == id).findFirst();
        
       if (userFind.isPresent()) {
        return userFind.get();
      }
      return null;

    }

    @PostMapping("/")
    public User user(@RequestBody User user){
        users.add(user);
        return user;

    }

   @GetMapping("/list")
   public List<User> list(){
       return users;
   }

    

}