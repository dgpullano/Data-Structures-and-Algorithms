package myLibrary.GraphAlgo;
import myLibrary.DataStructures.Linear.Queue;

/**
 * Implementation of a BFS graph traversal of a graph stored using an adjacency matrix.
 * @author Dillon Pullano
 *
 */
public class BFS 
{

	// Define BFS 
	public int numNodes;
	private int[][] adMat;
	
	// Constructor
	public BFS(int numNodes) {
		
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
    public void addEdge(int v,int w)
    {
    	this.adMat[v][w] = 1;
    	this.adMat[w][v] = 1;
    }
 
    // NOTE: - This algorithm produces a different result than the sample output but it is still a valid BFS traversal.
    public void BFS_Algo(int n)
    {
    	// Initialize queue with max possible length:
    	Queue queue = new Queue(100);
    	
    	// Initialize to keep track of nodes that have been visited
    	boolean[] visited = new boolean[this.numNodes];
    	for(int i = 0; i < visited.length; i++) {
    		visited[i] = false;
    	}
    	
    	// Enqueue source (starting point):
    	queue.enqueue(n);	
    	
    	// Mark first node as visited:
    	visited[n] = true;
    	
    	// Until queue is empty:
		while(!(queue.head < 0 || queue.head > queue.tail)) {
			
			// Remove vertex from queue, who's neighbors will be visited now:
			int vertex = queue.dequeue();
			
			// Output dequeued node from queue to console:
			System.out.print(vertex + " - ");
			
			// To account for how queue is implemented:
			if(vertex == -1) {
				break;
			}
			
			else {
				for(int j = 0; j < this.numNodes; j++) {
					
					if(this.adMat[vertex][j] == 1 && (!visited[j])) {
						queue.enqueue(j);
						visited[j] = true;
					}
				}
			}	
		}
		
		// Output visited nodes to console:
		System.out.print("\nVisited Nodes: [");
		
		for(int i = 0; i < visited.length - 1; i++) {
			System.out.print(visited[i] + ", ");
		}
		
		System.out.print(visited[visited.length - 1] + "]\n");
    }
}