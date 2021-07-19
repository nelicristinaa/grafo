package br.com.grafo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.grafo.Repository.GraphRepository;
import br.com.grafo.Repository.RouteRepository;
import br.com.grafo.model.Graph;
import br.com.grafo.model.Route;


@RestController
@RequestMapping("/")
public class GraphController {

  //  private List<Graph>  graphs = new ArrayList<>();


    @Autowired
    private GraphRepository graphRepository;
    
    @Autowired
    private RouteRepository routeRepository;

    @PostMapping("/route")
    public Route route(@RequestBody Route route){
        
         this.routeRepository.save(route);
        return route;

    }


    @PostMapping("/graph")
    public Graph graph(@RequestBody Graph graph){
        
        return this.graphRepository.save(graph);

    }

    @GetMapping("/get")
    public Iterable<Graph> list() {
        return graphRepository.findAll();
    }


    @GetMapping("/{id}")
    public Graph graph(@PathVariable("id") Long id) {
  
      Optional<Graph> userFind = this.graphRepository.findById(id);
  
      if (userFind.isPresent()) {
        return userFind.get();
      }
  
      return null;
    }
}
