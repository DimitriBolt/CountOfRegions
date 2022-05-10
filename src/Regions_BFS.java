import java.util.ArrayDeque;
import java.util.Queue;

public class Regions_BFS {
	// private Instance variable
	int numberOfColumns;
	int numberOfRows;
	int initialTable[][];

	// Constructors
	Regions_BFS(int[][] initialTable) {
		// Width and height of the initial table.
		this.numberOfColumns = initialTable.length;
		this.numberOfRows = initialTable[0].length;
		this.initialTable = initialTable;
	}

	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	// Methods
	// We must check that the node is inside the area. Also must check that the node belongs to the current region and does not belong
	// previously considered region.
	boolean isSafe(int initialTable[][], int i, int j, boolean featureTable[][]) {
		return (i >= 0) && (i < this.numberOfRows) && (j >= 0) && (j < this.numberOfColumns)
				&& (initialTable[i][j] == 1 && !featureTable[i][j]);
	}

	// Implementation of " Breadth-first search" algorithm using a queue.
	void breadthFirstSearch(int initialTable[][], boolean featureTable[][], int si, int sj) {

		// The way to walk around all neighbors.
		int rowOfNeibour[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int colOfNeibour[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

		// First step of BFS. Put the initial node into the empty queue.
		Queue<Node> queue = new ArrayDeque<Node>();
		queue.add(new Node(si, sj));
		// marking that the node belongs to some region.
		featureTable[si][sj] = true;

		// Second steps-loop of the classic BFS algorithm
		while (!queue.isEmpty()) {

			int i = queue.peek().x;
			int j = queue.peek().y;
			queue.remove();

			// Loop over all 8 neighbors.
			for (int k = 0; k < 8; k++) {
				if (isSafe(initialTable, i + rowOfNeibour[k], j + colOfNeibour[k], featureTable)) {
					featureTable[i + rowOfNeibour[k]][j + colOfNeibour[k]] = true;
					queue.add(new Node(i + rowOfNeibour[k], j + colOfNeibour[k]));
				}
			}
		}
	}

	// It is the method where we count the number of connected regions. This method is called from the main outside program.
	int count() {
		// The auxiliary table consists of the features of each node and shows whether the node belongs to some connected region or not.
		boolean[][] featureTable = new boolean[this.numberOfRows][this.numberOfColumns];

		// A loop over all elements. of the area.
		int count = 0;
		for (int i = 0; i < this.numberOfRows; i++) {
			for (int j = 0; j < this.numberOfColumns; j++) {
				if (this.initialTable[i][j] == 1 && !featureTable[i][j]) { // We found a new region and we are going over all of its neighbors for finding vertices.
					breadthFirstSearch(this.initialTable, featureTable, i, j);
					count++;
				}
			}
		}
		return count;
	}
} 