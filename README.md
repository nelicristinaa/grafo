
## Em todas as requisições onde deveria estar "DATA" deve ser substituido por "ROUTES"

## Run
Para iniciar a aplicação execute o comando: mvn spring-boot:run


## Salvar Grafo
Para salvar o Grafo é necessário o seguinte payload: 
{
  "data":[
    { 
      "source": "A", "target": "B", "distance":6
    },
    { 
      "source": "A", "target": "E", "distance":4
    },
    { 
      "source": "B", "target": "A", "distance":6
    }]
}
## Determinar distância de um caminho específico

É necessário alterar o "date" por "routes" no payload. Exemplo:
{
  "path":["A", "B", "C", "D"],
  "data":[
    { 
      "source": "A", "target": "B", "distance":6 0
    },
    { 
      "source": "A", "target": "E", "distance":4 1
    }]
}

## Determinar a distância mínima entre dois bairros

É necessário alterar o "date" por "routes" no payload. Exemplo:
o	Request payload
{
  "data":[
    { 
      "source": "A", "target": "B", "distance":6
    },
    { 
      "source": "A", "target": "E", "distance":4
    }]
}



