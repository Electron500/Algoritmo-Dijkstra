//Algoritmo Dijkstra - Estructuras de Datos
//Benavides_Jose

package com.ssaurel.dijkstra;

public class algoritmo_Dijkstra{

    private int fromNodeIndex;
    private int toNodeIndex;
    private int lenght;

    public edge (int fromNodeIndex, int toNodeIndex, int lenght) {
        this.fromNodeIndex = fromNodeIndex;
        this.toNodeIndex = toNodeIndex;
        this.lenght = lenght;
    }

    public int getFromNodeIndex() {
        return fromNodeIndex;
    }

    public int getToNodeIndex() {
        return toNodeIndex;
    }

    public int getLenght() {
        return lenght;
    }

    //Este determina el nodo vecino de un nodo suministrado, que se basa en los dos nodos conectados por este borde

}

package com.ssaurel.dijkstra;

//Un nodo debe tener una lista edge vinculada al mismo y de la misma forma un campo por definir lo que facilitara la implementacion del algoritmo

import java.util.ArrayList;

public class Node {

    private int distanceFromSource = integer.MAX_VALUE;
    private boolean visited;
    private ArrayList<Edge> edges = new Arraylist<Edge>(); 

    //Definimos ahora el campo distanceFromSource que va a ser donde estara el resultado para el nodo del algoritmo
    //Ahora hacemos los bordes

    public int getDistanceFromSource() {
        return distanceFromSource;
    }

    public void setDistanceFromSource(int distanceFromSource) {
        this.distanceFromSource = distanceFromSource;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public void setEdges(ArrayList<Edge> edges) {
        this.edges = edges;
    }

}

//Ya con los limites y los nodos, representamos el grafico que debe contenerlos, toma la matriz con los datos correpondientes y se elavora teniendo en cuenta el algoritmo
//Se implementa con el metodo calculateShortestDistances 

package com.ssaurel.dijkstra;

import java.util.ArrayList;

//Creamos un grafo e implementamos el algoritmo dijkstra

private Node[] nodes;
private int noOfNodes;
private Edge[] edges;
private int noOfEdges;

public Graph(Edge[] edges) {
    this.edges = edges;
    this.noOfNodes = calculateNoOfNodes(edges);
    this.nodes = new Node[this.noOfNodes];

    for (int n = 0; n <this.noOfNodes; n++) {
        this.nodes[n] = new Node();
    }
    // Agregamos todos los limites a los nodos, cada limite agregado hacia dos nodos (to and from)
    this.noOfEdges = edges.length;

    for (int edgeToAdd = 0; edgeToAdd < this.noOfEdges; edgetoAdd++)

    {
        this.nodes[edges[edgeToAdd].getFromNodeIndex()].getEdges().add(edges[edgeToAdd]);
        this.nodes[edges[edgeToAdd].getToNodeIndex()].getEdges().add(edges[edgeToAdd]);
    }
}

private int calculateNoOfNodes (Edge[] edges) {
    int noOfNodes = 0;

    for (Edge e : edges) {
        if (e.getToNodeIndex() > noOfNodes)
        noOfNodes = e.getToNodeIndex();
        if (e.getFromNodeIndex() > noOfNodes)
        noOfNodes = e.getFromNodeIndex();
    }

    noOfNodes++;

    return noOfNodes;
}

//Implementar el algoritmo Dijkstra

public void calculateShortestDistances() {
    //comenzando por 0
    this.nodes[0].setDistanceFromSource(0);
    int nextNode = 0;

    for (int i = 0; i < this.nodes.length; i++) {
        //bucle alrededor de los limites del actual nodo
        ArrayList<Edge> currentNodeEdges = this.nodes[nextNode].getEdges();

        for (int joinedEdge = 0; joinedEdge < currentNodeEdges.size(); joinedEdge++) {
            int neighbourIndex = currentNodeEdges.get(joinedEdge).getNeighbourIndex(nextNode);

            if (!this.nodes[neighbourIndex].isVisited()) {
                int tentative = this.nodes[nextNode].getDistanceFromSource() + currentNodeEdges.get(joinedEdge).getLenght();

                if (tentative < nodes[neighbourIndex].getDistanceFromSource()) {
                    nodes[neighbourIndex].setDistanceFromSource(tentative);
                }
            }
        }
        nodes[nextNode].setVisited(true);
        nextNode = getNodeShortestDistanced();

    }
}

//Seguiremos implementando este metodo en la parte siguiente

private int getNodeShortestDistanced() {
    int storedNodeIndex = 0;
    int storedDist = integer,MAX_VALUE;

    for (int i = 0; i < this.nodes.lenght; i++) {
        int currentDist = this.nodes[i].getDistanceFromSource();

        if (!this.nodes[i].isVisited() && currentDist < storedDist) {
            storedDist = currentDist;
            storedNodeIndex = i;
        }
    }

    return storedNodeIndex;

}

//Ejecutar el resultado

public void printResult() {
    string output = "Numero de Nodos = " + this.noOfNodes;
    output += "/nNumero de Limites = " + this.noOfEdges;

    for (int i = 0; i < this.nodes.lenght; i++) {
        output += ("/nLa distancia mas corta del nodo 0 al nodo " + i + "es " + nodes[i].getDistanceFromSource());
    }

    System.out.println(output);
}

public Node[] getNodes() {
    return nodes;
}

public int getNoOfNodes() {
    return noOfNodes;
}

public Edge[] getEdges() {
    return edges;
}

public int getNoOfEdges() {
    return noOfEdges;
}

//En el metodo printResult solo tenemos que iterar en la matriz de nodos y con ello mostrar el valor de la propiedad

//Definimos el siguiente grafico en la clase main y despues solo es llamar al metodo calculateshortestdistance
//Por ultimo calcular el resultado

package com.ssaurel.dijkstra;

public class Main {

    public static void main (String[] args) {
        Edge[] edges = {
            new Edge(0, 2, 1), new Edge(0, 3, 4), new Edge(0, 4, 2), new Edge(0, 1, 3), new Edge(1, 3, 2), new Edge(1, 4, 3), new Edge(1, 5, 1), new Edge(2, 4, 1), new Edge(3, 5, 4), new Edge(4, 5, 2), new Edge(4, 6, 7), new Edge(4, 7, 2), new Edge(5, 6, 4), new Edge(6, 7, 5)
        };

        Graph g = new Graph(edges);
        g.calculateShortestDistances();
        g.printResult();
    }

}
