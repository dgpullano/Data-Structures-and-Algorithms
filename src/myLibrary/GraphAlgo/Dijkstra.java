package myLibrary.GraphAlgo;

/**
 * Implementation of a Dijkstra algorithm.
 * @author Dillon Pullano
 *
 */
public class Dijkstra {

	// Apply Dijkstras algorithm
	public void Dijkstra_Algo(int[][] graph, int source) 
	{
		// Initialize parameters:
		int numNodes = graph.length;
		int[] dists = new int[numNodes];
		boolean[] visited = new boolean[numNodes];
		
		// Set initial values for parameters:
		for(int i = 0; i < numNodes; i++) {
			dists[i] = Integer.MAX_VALUE;
			visited[i] = false;
		}
		
		// Set distance from source to source:
		dists[source] = 0;
		
		// Find next Nodes:
		for(int i = 0; i < numNodes - 1; i++) {
			int minNode = -1;
			
			// Get next min node:
			for(int j = 0; j < dists.length; j++) {
				if(!visited[j] && (minNode == -1 || dists[j] < dists[minNode])) {
					minNode = j;
				}
			}
			
			// Mark current node as true:
			visited[minNode] = true;
			
			// Update distances:
			for(int j = 0; j < numNodes; j++) {
				
				if(!visited[j] && graph[minNode][j] != 0) {
					
					int nextDist = dists[minNode] + graph[minNode][j];
					
					if(nextDist < dists[j]) {
						dists[j] = nextDist;
					}
				}
			}
		}
		
		// Print out distances from source to each node:
		for(int i = 0; i < dists.length; i++) {
			System.out.println("Distance from " + source + " to " + i + " is " + dists[i]);
		}
	}
}
