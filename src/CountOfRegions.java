public class CountOfRegions {
	public static void main(String[] args) {
		//TODO remove all Russian speaking comments and add English comments. 
		// "Depth-first search" testing.
		int testArea1[][] = {
				{ 0, 1, 0, 0, 1 },
				{ 0, 1, 0, 0, 1 },
				{ 1, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0 },
				{ 1, 1, 0, 0, 1 } };
		// "Regions_DFS_Recursion" class uses only as method storage.
		Regions_DFS_Recursion regions1 = new Regions_DFS_Recursion(testArea1);
		int regionCounts1 = regions1.count();
		System.out.printf("The count of the regions = %s (DFS)\n", regionCounts1);
		
		int testArea2[][] = {
				{ 0, 1, 0, 0, 1 },
				{ 0, 1, 0, 0, 0 },
				{ 1, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0 },
				{ 1, 1, 0, 0, 1 } };
		Regions_DFS_Recursion regions2 = new Regions_DFS_Recursion(testArea2);
		int regionCounts2 = regions2.count();
		System.out.printf("The count of the regions = %s (DFS)\n\n", regionCounts2);
		
		// " Breadth-first search" testing.
		Regions_BFS regions_BFS1 = new Regions_BFS(testArea1);
		int regionCounts_BFS1 = regions_BFS1.count(); 
		System.out.printf("The count of the regions = %s (BFS)\n", regionCounts_BFS1);	
		
		Regions_BFS regions_BFS2 = new Regions_BFS(testArea2);
		int regionCounts_BFS2 = regions_BFS2.count(); 
		System.out.printf("The count of the regions = %s (BFS)\n", regionCounts_BFS2);	

	}
}
