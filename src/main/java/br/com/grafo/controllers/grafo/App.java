package br.com.grafo.controllers.grafo;

import java.util.List;

import org.aspectj.weaver.ast.And;

import br.com.grafo.model.Graph;
import br.com.grafo.model.Path;

public class App {
   

    public int calc(Path path, Graph graph){

        Vertex [] v = new Vertex[28]; 
        String  [] x = {"A","B","C","D","E","F","G","H","I","J", "K", "L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z" };
        for(int i = 0; i < 25; i++){
            
          v[i] = new Vertex(x[i]); 
        }

        //Percorre todos os grafos
    
        for(int i = 0; i < graph.getRoutes().size(); i++){
            int source = 0;
            int target = 0;
            int distance = graph.getRoutes().get(i).getDistance();

     
            
           
           

              source = converteVertice(graph.getRoutes().get(i).getSource());
              target = converteVertice(graph.getRoutes().get(i).getTarget());
              addVizinho(v[source], distance, v[target]);
   
              System.out.println("Source: " + source);
              System.out.println("Target: " + target);
              System.out.println("Distance: " + distance);
            
                
          }
        
    
        
        /// popula o vertice[] com o path
        String[] vertice = new String[path.getPath().size()];
        Integer[] verticeInt = new Integer[path.getPath().size()];
        for(int i = 0; i < path.getPath().size(); i++){
            vertice[i] = (path.getPath().get(i));

             //converte os valores do path para int       
            verticeInt[i] = converteVertice(vertice[i]);
             // System.out.println( "vertice =" + vertice[i]);
                
          }
           
        
        //manda o path 
        int resultado;
        String sourceVertex = null; 
        String targetVertex = null;
        int distanciaTotal = 0;
        for(int i = 0; i < (path.getPath().size()) - 1; i++){
            
            Dijkstra dijkstra = new Dijkstra();
            dijkstra.computePath(v[verticeInt[i]]); 
            System.out.println(dijkstra.getShortestPathTo(v[i+1])); 
     
            
       if  (dijkstra.getShortestPathTo(v[i+1]).size() > 0)   {
        targetVertex = ( dijkstra.getShortestPathTo(v[i+1]).get((dijkstra.getShortestPathTo(v[i+1]).size())-1)).toString();
       }

       if  (dijkstra.getShortestPathTo(v[i+1]).size() > 1)   {
        sourceVertex = ( dijkstra.getShortestPathTo(v[i+1]).get((dijkstra.getShortestPathTo(v[i+1]).size())-2)).toString();
       }

         
      //verifica a distancia 
      int distancia;
       for (int s = 0; s < graph.getRoutes().size(); s++){
        if ( (graph.getRoutes().get(s).getSource().equals(sourceVertex))  && (graph.getRoutes().get(s).getTarget().equals(targetVertex)) ){
                distancia = (graph.getRoutes().get(s).getDistance());
                distanciaTotal = distancia + distanciaTotal;
               
        }
       }
       
       
            
        }


        System.out.println("Distancia Total:" + distanciaTotal);

        return distanciaTotal;
    }

    public void addVizinho(Vertex source, int distance, Vertex target ){

        source.addNeighbour(new Edge(distance, source, target));

   
    }

    public int converteVertice(String dado){
        int vertice = 0;
        switch (dado.toUpperCase()) {
            case "A":
             vertice = 0;
              break;
            case "B":
             vertice = 1;
              break;
            case "C":
             vertice = 2;
              break;
            case "D":
             vertice = 3;
              break;
            case "E":
             vertice = 4;
              break;
            case "F":
             vertice = 5;
              break;
            case "G":
             vertice = 6;
              break;
              case "H":
             vertice = 7;
              break;  
              case "I":
             vertice = 8;
              break;  
              case "J":
             vertice = 9;
              break;  
              case "K":
             vertice = 10;
              break;  
              case "L":
             vertice = 11;
              break;  
              case "M":
             vertice = 12;
              break;                 
              case "N":
             vertice = 13;
              break;  
              case "O":
             vertice = 14;
              break;  
              case "P":
             vertice = 15;
              break;  
              case "Q":
             vertice = 16;
              break;  
              case "R":
             vertice = 17;
              break;  
              case "S":
             vertice = 18;
              break;  
              case "T":
             vertice = 19;
              break;  
              case "U":
             vertice = 20;
              break;  
              case "V":
             vertice = 21;
              break;  
              case "W":
             vertice = 22;
              break;  
              case "X":
             vertice = 23;
              break;  
              case "Y":
             vertice = 24;
              break;  
              case "Z":
             vertice = 25;
              break;  
                          
                                   
          }
        
      return vertice;
    }


    public String [] calcDistVizinhos(String town1, String town2, Graph graph){
        int distancia = 0; 
        int distanciaTotal = 0;

        Vertex [] v = new Vertex[28]; 
        String  [] x = {"A","B","C","D","E","F","G","H","I","J", "K", "L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z" };
        for(int i = 0; i < 25; i++){
            
          v[i] = new Vertex(x[i]); 
        }

       
         //Percorre todos os grafos
        for(int i = 0; i < graph.getRoutes().size(); i++){
          int source = 0;
          int target = 0;
          int distance = graph.getRoutes().get(i).getDistance();


          
        
        

            source = converteVertice(graph.getRoutes().get(i).getSource());
            target = converteVertice(graph.getRoutes().get(i).getTarget());
            addVizinho(v[source], distance, v[target]);

            System.out.println("Source: " + source);
            System.out.println("Target: " + target);
            System.out.println("Distance: " + distance);
          
              
        }

       int verticeSource = converteVertice(town1);
       int verticeTarget = converteVertice(town2);


       //calcula o path
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.computePath(v[verticeSource]); 
        System.out.println(dijkstra.getShortestPathTo(v[verticeTarget])); 
        String resposta = dijkstra.getShortestPathTo(v[verticeTarget]).toString();
        System.out.println(resposta);
        //converte para um array de string
        String[] vertice = new String[dijkstra.getShortestPathTo(v[verticeTarget]).size()]; 
        for (int j = 0; j < dijkstra.getShortestPathTo(v[verticeTarget]).size(); j++){
        vertice[j] = dijkstra.getShortestPathTo(v[verticeTarget]).get(j).toString();
        System.out.println(vertice[j]);
      }

        //calcula a distancia de cada ponto
       
        for(int i = 0; i < vertice.length - 1; i++){
          String targetVertex = null;
          String sourceVertex = null;

          if  (dijkstra.getShortestPathTo(v[i+1]).size() > 0)   {
            targetVertex = ( dijkstra.getShortestPathTo(v[i+1]).get((dijkstra.getShortestPathTo(v[i+1]).size())-1)).toString();
           }

          if  (dijkstra.getShortestPathTo(v[i+1]).size() > 1)   {
            sourceVertex = ( dijkstra.getShortestPathTo(v[i+1]).get((dijkstra.getShortestPathTo(v[i+1]).size())-2)).toString();
           }

            //verifica a distancia 
          
          for (int s = 0; s < graph.getRoutes().size(); s++){
          if ( (graph.getRoutes().get(s).getSource().equals(sourceVertex))  && (graph.getRoutes().get(s).getTarget().equals(targetVertex)) ){
                  distancia = (graph.getRoutes().get(s).getDistance());
                  distanciaTotal = distancia + distanciaTotal;
                  
          }
          }
      

        }





        System.out.println(distanciaTotal);

       

        return new String[] {Integer.toString(distanciaTotal), resposta};
     
     }
    
}


