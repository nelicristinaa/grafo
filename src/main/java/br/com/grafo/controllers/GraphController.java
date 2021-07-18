package br.com.grafo.controllers;

import java.util.List;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.util.ArrayBuilders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.grafo.Repository.UserRepository;
import br.com.grafo.model.Graph;

@RestController
@RequestMapping("/")
public class GraphController {

    private List<Graph> graphs =  new ArrayList<>();

    
 /*    @GetMapping("/graphw//")
    public Graph graph(){
        Graph graph = new Graph();
        graph.setSource("a");       
        graph.setTarget("b");
        graph.setDistance(1);
        return graph;
        
    } */
    
    @PostMapping("/graph")
    public Graph graph(@RequestBody Graph graph){
        
        graphs.add(graph);
        return graph;

    }
 
   
    


    
}
