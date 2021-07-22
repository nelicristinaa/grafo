package br.com.grafo.controllers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.Query;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.node.ObjectNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.grafo.Repository.GraphRepository;
import br.com.grafo.Repository.RouteRepository;
import br.com.grafo.controllers.grafo.App;
import br.com.grafo.controllers.grafo.Dijkstra;
import br.com.grafo.controllers.grafo.Edge;
import br.com.grafo.controllers.grafo.Vertex;
import br.com.grafo.model.Distance;
import br.com.grafo.model.Graph;
import br.com.grafo.model.Path;
import br.com.grafo.model.Route;
import javassist.expr.NewArray;
import org.springframework.data.jpa.repository.*;



@RestController
@RequestMapping("/")
public class GraphController {

  //  private List<Graph>  graphs = new ArrayList<>();
  private List<Path>  paths = new ArrayList<>();


    @Autowired
    private GraphRepository graphRepository;

    
    
    @Autowired
    private RouteRepository routeRepository;

    @PostMapping("/route")
    public Route route(@RequestBody Route route){
        
         this.routeRepository.save(route);
        return route;

    }


    @GetMapping("/get")
    public Iterable<Graph> list() {
        return graphRepository.findAll();
    }


    @GetMapping("/graph/{id}")
    public Graph graph(@PathVariable("id") Long id) {
  
      Optional<Graph> userFind = this.graphRepository.findById(id);

      
  
      if (userFind.isPresent()) {
        return userFind.get();
      }
  
      return null;
    }

     @PostMapping("/graph")
    public Graph graph(@RequestBody Graph graph){
        
        return this.graphRepository.save(graph);

    } 

    @PostMapping("/distance/{id}")
    public HashMap<Object, Object>  path(@RequestBody Path path, @PathVariable("id") Long id ){
     /*  System.out.println("oi" + routeRepository.verifica()); */
      Optional<Graph> graphFind = this.graphRepository.findById(id);
      int distancia = 0;
 
      App app = new App();
      if (graphFind.isPresent()) {
      
        distancia = app.calc(path, graphFind.get());
        System.out.println(distancia);
        
        
      } else {
        System.out.println("grafo não existe");
      }
      String distance = Integer.toString(distancia);
     
      HashMap<Object, Object> map = new HashMap<>();
     
      map.put("path", path.getPath());
      map.put("distance", distance);
      
      
        return map;            

    } 

   

}
