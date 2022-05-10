import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Regions_BFS {
	// private Instance variable
	int numberOfColumns;
	int numberOfRows;
	int initialTable[][];

	// Constructors
	Regions_BFS(int[][] initialTable) {
		// Высота и ширина изначальной таблицы
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
	// Проверяем можно ли/нужно ли просматривать соседние ячейки, есть ли еще неучтенные вершины.
	boolean isSafe(int initialTable[][], int i, int j, boolean featureTable[][]) {
		return (i >= 0) && (i < this.numberOfRows) && (j >= 0) && (j < this.numberOfColumns) && (initialTable[i][j] == 1 && !featureTable[i][j]);
	}
	
	// Реализация поиска в ширину через добавление в очередь.
	void breadthFirstSearch(int initialTable[][], boolean featureTable[][], int si, int sj) {

		// Подсмотрел на SOF, как красиво перебрать всех соседей.
		int rowOfNeibour[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int colOfNeibour[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

		// First step of BFS. Put the initial node into the empty queue. 
		Queue<Node> queue = new ArrayDeque<Node>();
		queue.add(new Node(si, sj));
		// Присваиваем элементу таблицы свойство, что он уже принадлежит какому-то региону.
		featureTable[si][sj] = true;

		// TODO add comment about second steps of BFS algorithm.
		while (!queue.isEmpty()) {

			int i = queue.peek().x;
			int j = queue.peek().y;
			queue.remove();

			// Перебор всех 8-ми соседей.
			for (int k = 0; k < 8; k++) {
				if (isSafe(initialTable, i + rowOfNeibour[k], j + colOfNeibour[k], featureTable)) {
					featureTable[i + rowOfNeibour[k]][j + colOfNeibour[k]] = true;
					queue.add(new Node(i + rowOfNeibour[k], j + colOfNeibour[k]));
				}
			}
		}
	}

	// Подсчет регионов, вызывается из основной программы.
	int count() {
		// Вспомогательная таблица с признаком каждого элемента, который показывает, учли ли мы этот элемент при подсчете регионов.
		boolean[][] featureTable = new boolean[this.numberOfRows][this.numberOfColumns];

		// Перебор всех ячеек исходной таблицы
		int count = 0;
		for (int i = 0; i < this.numberOfRows; i++) {
			for (int j = 0; j < this.numberOfColumns; j++) {
				if (this.initialTable[i][j] == 1 && !featureTable[i][j]) {
					breadthFirstSearch(this.initialTable, featureTable, i, j);
					count++;
				}
			}
		}
		return count;
	}
}