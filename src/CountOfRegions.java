
public class CountOfRegions {

	public static void main(String[] args) {
		int testArea1[][] = {
				{ 0, 1, 0, 0, 1 },
				{ 0, 1, 0, 0, 1 },
				{ 1, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0 },
				{ 1, 1, 0, 0, 1 } };
		// Только лишь контейнер методов
		Regions regions = new Regions(testArea1);
		int regionCounts = regions.count();
		System.out.println("The count of the regions = " + regionCounts);

	}

}
