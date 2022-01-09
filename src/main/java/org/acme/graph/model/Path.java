package org.acme.graph.model;

import java.util.ArrayList;
import java.util.List;

public class Path  {

    /**
     * edges: List<Edge>
     */
    protected  List<Edge> edges = new ArrayList<Edge>();


    /**
     * constructeur 
     */
    public Path(List<Edge> edges){
        this.edges = edges;
    }

    /**
     * @return
     */
    public List<Edge> getEdges(){
        return this.edges;
    }


    /**
     * somme des longueurs des edges
     * @return
     */
    public double getLength(){
        double l = 0 ;
        for(Edge edge : this.edges){
            l+=edge.getCost();
        }
        return l;
    }
    
}
