package br.com.grafo.controllers.grafo;

import javax.management.loading.ClassLoaderRepository;
import java.util.ArrayList;

public class Faculdade {

    public static void main(String[] args) {

        ArrayList<Amigo> amigos = new ArrayList<Amigo>();

   /*      amigos.add(new Amigo("João"));  // 0
        amigos.add(new Amigo("Clarisse"));
        amigos.add(new Amigo("Edivaldo"));
        amigos.add(new Amigo("Maria"));
        amigos.add(new Amigo("Pedro"));
        amigos.add(new Amigo("Gabriella")); // 5
        amigos.add(new Amigo("Marcos"));
        amigos.add(new Amigo("Benedita"));
        amigos.add(new Amigo("Sara"));
        amigos.add(new Amigo("Fernando")); // 9 */


        amigos.add(new Amigo("a"));  // 0 // o ponto que esta buscando sempre vai ser o primeiro
        amigos.add(new Amigo("b")); //1
        amigos.add(new Amigo("c")); //2
        amigos.add(new Amigo("d")); //3
        amigos.add(new Amigo("e")); //4
       /*  amigos.add(new Amigo("Gabriella")); // 5
        amigos.add(new Amigo("Marcos"));
        amigos.add(new Amigo("Benedita"));
        amigos.add(new Amigo("Sara"));
        amigos.add(new Amigo("Fernando")); */

        GrafoDeAmigos gda = new GrafoDeAmigos();
      //  ab 0,1  bc 12  cd 23 dc 32 de 34 ad 03 ce 24 eb 41 ae 04
        gda.criarAmizadeEntre(amigos.get(3), amigos.get(2));
        gda.criarAmizadeEntre(amigos.get(4), amigos.get(1));
        gda.criarAmizadeEntre(amigos.get(2), amigos.get(3));
        gda.criarAmizadeEntre(amigos.get(3), amigos.get(4)); 
        gda.criarAmizadeEntre(amigos.get(0), amigos.get(1));
        gda.criarAmizadeEntre(amigos.get(1), amigos.get(2));
        gda.criarAmizadeEntre(amigos.get(0), amigos.get(4));
        gda.criarAmizadeEntre(amigos.get(0), amigos.get(3));       
        gda.criarAmizadeEntre(amigos.get(2), amigos.get(4));
        
        
        
        
        
        
        //gda.criarAmizadeEntre(amigos.get(2), amigos.get(8));
        
        


    //    gda.DFS(amigos.get(0)); //busca em profundidade
        gda.BFS(amigos.get(0)); //busca em largura - vai sempre pra direita - menor caminho entre os vertices mas ignorando o peso das arestas
    }
}