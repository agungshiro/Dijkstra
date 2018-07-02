package wmich.edu.CS5310.A2.AWahyudiono;

import java.io.IOException;
import java.util.Arrays;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		
		ReadTXT readTXT = new ReadTXT("Michigan.txt");
		float theCost[][] = readTXT.getCost();
		//System.out.println(Arrays.toString(theCost[0]));
		
		// TODO Auto-generated method stub
		/*
		float cost[][] = new float[][]{{0,0,0,0,0,0,0,0},
			   						   {300,0,0,0,0,0,0,0},
			   						   {1000,800,0,0,0,0,0,0},
			   						   {0,0,1200,0,0,0,0,0},
			   						   {0,0,0,1500,0,250,0,0},
			   						   {0,0,0,1000,0,0,900,1400},
			   						   {0,0,0,0,0,0,0,1000},
			   						   {1700,0,0,0,0,0,0,0}};
			   						   */
		
		String cities[] = {"Kalamazoo",
				"Lansing",
				"Detroit",
				"Battle Creek",
				"Grand Rapids",
				"Fremont",
				"Holland",
				"Muskegon",
				"South Haven",
				"Benton Harbor",
				"Dowagiac",
				"Three Rivers",
				"Sturgis",
				"Jackson",
				"Ann Arbor",
				"Monroe",
				"Coldwater",
				"Hillsdale",
				"Adrian",
				"Greenville",
				"Alma",
				"Midland",
				"Mt. Pleasant",
				"Big Rapids",
				"Saginaw",
				"Bay City",
				"Flint",
				"Caro",
				"Marlette",
				"Port Huron",
				"Owosso City",
				"Ionia",
				"Bad Axe",
				"Clare",
				"Gladwin",
				"West Branch",
				"Tawas City",
				"Cadillac",
				"Standish",
				"Ludington",
				"Manistee",
				"Allegan"};
			   						   
		
	    float dist[] = new float[theCost.length];
			   						   
        Dijkstra dj = new Dijkstra(0,theCost,dist);
        
        long startTime = System.nanoTime();
        float[] res = dj.shortPath();
        long endTime = System.nanoTime();
        
        
        long diffTime = endTime - startTime;
        
        double second = (double)diffTime/1000000000.0;
        
        System.out.printf("%-23s %-20s %s\n", "vertex","distance","path");
        System.out.println("--------------------------------------------------------------");
        
        for(int i = 0;i < theCost.length;i++) {
        	System.out.printf("%-3d %-20s %-20.1f %d ", (i+1), cities[i],res[i], dj.getStartVertex()+1);
        	dj.printPath(i);
        	System.out.println("");
		}
        
        System.out.println("--------------------------------------------------------------");
        System.out.printf("%s : %f second \n","Execution time",second);
        System.out.println("--------------------------------------------------------------");
	}

}
