package wmich.edu.CS5310.A2.AWahyudiono;

import java.util.Arrays;

/**
 * Dijkstra
 * Implementation of Dijkstra Algorithm, depicted from the book
 * "Fundamental of Computer Algorithm", by E. Horowitz, S. Sahni. 
 * Chapter 4 Page 245
 * @author agung wahyudiono
 *
 */

public class Dijkstra {
	
	private int Size; 		// Array Size
	private int n; 			// max index 
	private float[][] cost;	// Graph represent as cost 2D Array 
	private float[] dist;	// Array of distance 
	private int v;			// Start Vertex
	private boolean[] S;	// Boolean flag array
	private final int NO_PARENT = -1;
	private int[] parents;

	/**
	 * Constructor
	 * @param v , int starting vertex
	 * @param cost, 2D floats array represent the adjacency matrix 
	 * @param dist, Array of floats the distance between v to another vertex
	 */
	public Dijkstra(int v, float cost[][], float dist[]) {
		
		// Set the field
		this.v = v;
		this.cost = cost;
		this.dist = dist;
		this.Size = cost.length;
		this.n = this.Size - 1;
		this.S = new boolean[this.Size];
		this.parents = new int[this.Size];
	}
	
	/**
	 * Dijkstra short path algorithm implementation
	 * @return , float array of distance 
	 */
	public float[] shortPath() {
		
		// define u as integer
		int u;
		
		// Setup S and dist[]
		for (int i=0 ; i <= this.n ; i++) {
			
			// Set all S element into false
			S[i] = false;
			
			// Set value of dist[]
			// This part is different from the book 
			// This will help to determine min value to get the "u"
			if(cost[this.v][i] != 0.0) {
				// set the distance of reachable vertex from v as the value on cost matrix
				dist[i] = cost[this.v][i];
			} else {
				// set unreached vertex from v to unlimited ( represent on Max Value of float )
				dist[i] = Float.MAX_VALUE;
			}
		}
		
		// Set v into true, so it will not be examined for the next step
		S[this.v] = true;
		
		// Set dist v to v into 0
		dist[this.v] = (float) 0.0;
		
		/**
		 * Modification to print the path
		 */
		parents[v] = this.NO_PARENT;
		
		// Begin iteration from the nearest vertex
		for(int num = 1 ; num < this.n ; num++) {
			
			// get the index of the nearest vertex
			u = minDistance(this.dist,this.S);
			
			// Set this index to True, so it will not re examined on next iteration
			this.S[u] = true;
			
			if(num==1) {
				parents[u] = v;
			}
			
			
			for(int w = 0; w <= this.n ; w++) {
				
				// Exchange the distance which is previously unreachable from v
				// than become reachable through u
				// adding the condition cost[u][w] != 0
				if((S[w] == false) && (dist[w]>dist[u]+cost[u][w]) && (cost[u][w] != 0.0)) {
					parents[w] = u;
					dist[w] = dist[u]+cost[u][w];
				}	
			}
		}
		
		// return dist
		return dist;
	}
	
	/**
	 * 
	 * @param dist, floats array of distance
	 * @param S, boolean array 
	 * @return, return the index of nearest reacheable vertex
	 */
	private int minDistance(float[] dist, boolean S[]) {
		float min = Float.MAX_VALUE;
		int min_index = -1;
		
		// iterate to find shortest distance 
		for(int v = 0; v < this.Size; v++) {
			if(S[v] == false && dist[v] <= min) {
				min = dist[v];
				min_index = v;
			}
		}
		
		// return the index
		return min_index;
	}
	
	/**
	 * Get start vertex
	 * @return
	 */
	public int getStartVertex() {
		return this.v;
	}
	
	/**
	 * Print path recursively 
	 * @param v current vertex
	 */
	public void printPath(int v) {
		if(this.parents[v] == this.NO_PARENT) {
			return;
		}
		
		this.printPath(this.parents[v]);
		System.out.printf("- %d ",v+1);
	}
}
