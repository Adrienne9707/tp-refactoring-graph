package org.acme.graph.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.locationtech.jts.geom.Coordinate;

/**
 * 
 * Un sommet dans un graphe
 * 
 * @author MBorne
 *
 */
public class Vertex {

	/**
	 * Identifiant du sommet
	 */
	private String id;

	/**
	 * Position du sommet
	 */
	private Coordinate coordinate;

	/**
	 * dijkstra - coût pour atteindre le sommet
	 */
	private double cost;


	/**
	 * dijkstra - arc entrant avec le meilleur coût
	 */
	private Edge reachingEdge;


	/**
	 * dijkstra - indique si le sommet est visité
	 */
	private boolean visited;


	/**
	 * inEdges et outEdges
	 */
	@JsonIgnore
	List<Edge> inEdges = new ArrayList<Edge>();
	@JsonIgnore
	List<Edge> outEdges = new ArrayList<Edge>();



	/**
	 * mask
	 */

	/*public Vertex() {

	}*/
	protected Vertex(){}




	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	@JsonIgnore
	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@JsonIgnore
	public Edge getReachingEdge() {
		return reachingEdge;
	}

	public void setReachingEdge(Edge reachingEdge) {
		this.reachingEdge = reachingEdge;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	@Override
	public String toString() {
		return id;
	}

	
	public List<Edge> getInEdges(){
		return this.inEdges;
	}

	
	public List<Edge> getOutEdges(){
		return this.outEdges;
	}

}
