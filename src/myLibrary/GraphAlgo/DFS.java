package myLibrary.GraphAlgo;

/**
 * Implementation of a DFS graph traversal of a graph stored using an adjacency matrix.
 * @author Dillon Pullano
 *
 */
public class DFS {

	// Define DFS 
	public int numNodes;
	private int[][] adMat;
	 
	// Constructor
	public DFS(int numNodes) {
		
		// Initialize class parameters:
		this.numNodes = numNodes;
		this.adMat = new int[numNodes][numNodes];
		
		// Populate initial values in adjacency matrix to 0:
		for(int i = 0; i < numNodes; i++) {
			for(int j = 0; j < numNodes; j++) {
				this.adMat[i][j] = 0;
			}
		}
	}
		
	// Add edge to graph
    public void addEdge(int v, int w)
    {
    	this.adMat[v][w] = 1;
    	this.adMat[w][v] = 1;
    }
 
    // Apply DFS algorithm and display the nodes visited and the visit array values
    public void DFS_Algo(int v)
    {
    	// Create 'visited' tracker and populate values to be false:
    	boolean[] visited = new boolean[this.numNodes];
    	for(int i = 0; i < visited.length; i++) {
    		visited[i] = false;
    	}
    	
    	// Run start node through recursive DFS algorithm:
    	DFS_Recursive(v, visited);
    	
    	// Output visited nodes to console:
		System.out.print("\nVisited Nodes: [");
		
		for(int i = 0; i < visited.length - 1; i++) {
			System.out.print(visited[i] + ", ");
		}
		
		System.out.print(visited[visited.length - 1] + "]\n");
    	
    }
    
    // NOTE: - This algorithm produces a different result than the sample output but it is still a valid DFS traversal.
    //       - If multiple nodes can be visited next and still be valid, it follows the path with the lowest node # first.
    public void DFS_Recursive(int v, boolean[] visited) {
    	
    	// Output that node has been visited to the console:
    	System.out.print(v + " - ");
    	
    	// Set start node as visited:
    	visited[v] = true;
    	
    	// For all nodes:
    	for(int i = 0; i < this.adMat[v].length; i++) {
    		
    		// Recursively call for each next node:
    		if(this.adMat[v][i] == 1 && !visited[i]) {
    			DFS_Recursive(i, visited);
    		}
    	}
    }
}