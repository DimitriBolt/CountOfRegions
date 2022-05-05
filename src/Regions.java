public class Regions {
	// private Instance variable
	int numberOfColumns;
	int numberOfRows;
	int initialTable[][];

	// Constructors
	Regions(int[][] initialTable) {
		// ������ � ������ ����������� �������
		this.numberOfColumns = initialTable.length;
		this.numberOfRows = initialTable[0].length;
		this.initialTable = initialTable;
	}

	// Methods
	// ��������� ����� ��/����� �� ������������� �������� ������, ���� �� ��� ���������� �������.
	boolean isSafe(int initialTable[][], int row, int col, boolean featureTable[][]) {
		return (row >= 0) && (row < this.numberOfRows) && (col >= 0) && (col < this.numberOfColumns) && (initialTable[row][col] == 1 && !featureTable[row][col]);
	}

	// ����������� ������� ��� ������ � �������
	void depthFirstSearch(int initialTable[][], int row, int column, boolean featureTable[][]) {
		// ���������� �� SOF, ��� ������� ��������� ���� �������.
		int rowOfNeibour[] = new int[] { -1, -1, -1, -0, +0, +1, 1, 1 };
		int colOfNeibour[] = new int[] { -1, -0, +1, -1, +1, -1, 0, 1 };

		// ����������� �������� ������� ��������, ��� �� ��� ����������� ������-�� �������.
		featureTable[row][column] = true;

		// ������� ���� 8-�� �������.
		for (int k = 0; k < 8; ++k)
			if (isSafe(initialTable, row + rowOfNeibour[k], column + colOfNeibour[k], featureTable))
				depthFirstSearch(initialTable, row + rowOfNeibour[k], column + colOfNeibour[k], featureTable);
	}

	// ������� ��������, ���������� �� �������� ���������
	int count() {
		// ��������������� ������� � ��������� ������� ��������, ������� ����������, ���� �� �� ���� ������� ��� �������� ��������.
		boolean featureTable[][] = new boolean[this.numberOfRows][this.numberOfColumns];

		// ������� ���� ����� �������� �������
		int count = 0;
		for (int i = 0; i < this.numberOfRows; ++i)
			for (int j = 0; j < this.numberOfColumns; ++j)
				if (this.initialTable[i][j] == 1 && !featureTable[i][j]) // ����� ����� ������ � �������� ������ �� ���� ��� ��������
				{
					depthFirstSearch(this.initialTable, i, j, featureTable);
					++count;
				}

		return count;
	}

}
