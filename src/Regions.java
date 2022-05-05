public class Regions {
	// private Instance variable
	int numberOfColumns;
	int numberOfRows;
	int initialTable[][];

	// Constructors
	Regions(int[][] initialTable) {
		// Высота и ширина изначальной таблицы
		this.numberOfColumns = initialTable.length;
		this.numberOfRows = initialTable[0].length;
		this.initialTable = initialTable;
	}

	// Methods
	// Проверяем можно ли/нужно ли просматривать соседние ячейки, есть ли еще неучтенные вершины.
	boolean isSafe(int initialTable[][], int row, int col, boolean featureTable[][]) {
		return (row >= 0) && (row < this.numberOfRows) && (col >= 0) && (col < this.numberOfColumns) && (initialTable[row][col] == 1 && !featureTable[row][col]);
	}

	// Рекурсивная функция для поиска в глубину
	void depthFirstSearch(int initialTable[][], int row, int column, boolean featureTable[][]) {
		// Подсмотрел на SOF, как красиво перебрать всех соседей.
		int rowOfNeibour[] = new int[] { -1, -1, -1, -0, +0, +1, 1, 1 };
		int colOfNeibour[] = new int[] { -1, -0, +1, -1, +1, -1, 0, 1 };

		// Присваиваем элементу таблицы свойство, что он уже принадлежит какому-то региону.
		featureTable[row][column] = true;

		// Перебор всех 8-ми соседей.
		for (int k = 0; k < 8; ++k)
			if (isSafe(initialTable, row + rowOfNeibour[k], column + colOfNeibour[k], featureTable))
				depthFirstSearch(initialTable, row + rowOfNeibour[k], column + colOfNeibour[k], featureTable);
	}

	// Подсчет регионов, вызывается из основной программы
	int count() {
		// Вспомогательная таблица с признаком каждого элемента, который показывает, учли ли мы этот элемент при подсчете регионов.
		boolean featureTable[][] = new boolean[this.numberOfRows][this.numberOfColumns];

		// Перебор всех ячеек исходной таблицы
		int count = 0;
		for (int i = 0; i < this.numberOfRows; ++i)
			for (int j = 0; j < this.numberOfColumns; ++j)
				if (this.initialTable[i][j] == 1 && !featureTable[i][j]) // Нашли новый регион и начинает ходить по всем его вершинам
				{
					depthFirstSearch(this.initialTable, i, j, featureTable);
					++count;
				}

		return count;
	}

}
