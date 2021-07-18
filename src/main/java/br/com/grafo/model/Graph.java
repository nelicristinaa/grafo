package br.com.grafo.model;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;



import br.com.grafo.model.Routes;


public class Graph {
   
    private Long id;    
    private List<Routes> data = new ArrayList<>();

    public List<Routes> getData() {
        return data;
    }

    public void setData(List<Routes> data) {
        this.data = data;
    }

    public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

}
