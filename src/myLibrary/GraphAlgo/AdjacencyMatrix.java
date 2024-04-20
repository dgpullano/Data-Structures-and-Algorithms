package myLibrary.GraphAlgo;

/**
 * Implementation of an adjacency matrix.
 * @author Dillon Pullano
 *
 */
public class AdjacencyMatrix {
	
	// Define adjacency matrix
	public int numNodes;
	private int[][] matrixData;
	
	// Constructor
	public AdjacencyMatrix(int numNodes) {
		
		// Initialize class parameters:
		this.numNodes = numNodes;
		this.matrixData = new int[numNodes][numNodes];
		
		// Populate initial values in adjacency matrix to 0:
		for(int i = 0; i < numNodes; i++) {
			for(int j = 0; i < numNodes; i++) {
				this.matrixData[i][j] = 0;
			}
		}
	}
	
	// Add new edges
    public void addEdge(int source, int destination, int cost) 
    {
    	this.matrixData[source][destination] = cost;
    	this.matrixData[destination][source] = cost;
    }
    
    // return adjacency matrix
    public int[][] getAdjacencyMatrix() 
    {
    	return this.matrixData;
    }

    // Display adjacency matrix
    public void displayAdjacencyMatrix() 
    {	        
    	
    	for(int i = 0; i < this.matrixData.length; i++) {
    		System.out.print("\nNode " + i + ": ");
    		
    		for(int j = 0; j < this.matrixData[i].length; j++) {
    			System.out.print(this.matrixData[i][j] + " ");
    		}
    	}
    	System.out.println("");
    }
}