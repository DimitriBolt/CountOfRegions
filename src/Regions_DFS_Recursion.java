public class Regions_DFS_Recursion {
	// private Instance variable
	int numberOfColumns;
	int numberOfRows;
	int initialTable[][];

	// Constructors
	Regions_DFS_Recursion(int[][] initialTable) {
		// Width and height of the initial table.
		this.numberOfColumns = initialTable.length;
		this.numberOfRows = initialTable[0].length;
		this.initialTable = initialTable;
	}

	// Methods
	// We must check that the node is inside the area. Also must check that the node belongs to the current region and does not belong previously considered region.
	boolean isSafe(int initialTable[][], int row, int col, boolean featureTable[][]) {
		return (row >= 0) && (row < this.numberOfRows) && (col >= 0) && (col < this.numberOfColumns) && (initialTable[row][col] == 1 && !featureTable[row][col]);
	}

	// Implementation of the "Depth-first search" algorithm using recursion.
	void depthFirstSearch(int initialTable[][], int row, int column, boolean featureTable[][]) {
		// The way to walk around all neighbors.
		int rowOfNeibour[] = new int[] { -1, -1, -1, -0, +0, +1, 1, 1 };
		int colOfNeibour[] = new int[] { -1, -0, +1, -1, +1, -1, 0, 1 };

		// marking that the node belongs to some region.
		featureTable[row][column] = true;

		// Loop over all 8 neighbors.
		for (int k = 0; k < 8; ++k)
			if (isSafe(initialTable, row + rowOfNeibour[k], column + colOfNeibour[k], featureTable))
				depthFirstSearch(initialTable, row + rowOfNeibour[k], column + colOfNeibour[k], featureTable);
	}

	// It is the method where we count the number of connected regions. This method is called from the main outside program.
	int count() {
		// The auxiliary table consists of the features of each node and shows whether the node belongs to some connected region or not. 
		boolean featureTable[][] = new boolean[this.numberOfRows][this.numberOfColumns];

		// A loop over all elements. of the area.
		int count = 0;
		for (int i = 0; i < this.numberOfRows; ++i)
			for (int j = 0; j < this.numberOfColumns; ++j)
				if (this.initialTable[i][j] == 1 && !featureTable[i][j]) // We found a new region and we are going over all of its neighbors for finding vertices. 
				{
					//  recursive "Depth-first search" method.
					depthFirstSearch(this.initialTable, i, j, featureTable);
					++count;
				}

		return count;
	}

}
