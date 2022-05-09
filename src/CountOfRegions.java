public class CountOfRegions {
	public static void main(String[] args) {
		int testArea1[][] = {
				{ 0, 1, 0, 0, 1 },
				{ 0, 1, 0, 0, 1 },
				{ 1, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0 },
				{ 1, 1, 0, 0, 1 } };
		// Класс Regions - только лишь контейнер методов
		Regions regions = new Regions(testArea1);
		int regionCounts = regions.count();
		System.out.println("The count of the regions = " + regionCounts);
		
		int testArea2[][] = {
				{ 0, 1, 0, 0, 1 },
				{ 0, 1, 0, 0, 0 },
				{ 1, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0 },
				{ 1, 1, 0, 0, 1 } };
		Regions regions2 = new Regions(testArea2);
		int regionCounts2 = regions2.count();
		System.out.println("The count of the regions = " + regionCounts2);
	}
}
