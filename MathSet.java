import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

public class MathSet {
	
	private File file;
	private BufferedReader in;
	TreeSet<Integer> numSet1;
	TreeSet<Integer> numSet2;
	String[] line1;
	String[] line2;
	
	public MathSet() {
		try {
			//sortedFile = new File("/home/compsci/eclipse-workspace/015BabyNames/src/names/yob" + year + "sorted.txt");
			file = new File("/home/isen/eclipse-workspace/020SetsLab3/src/mathsetdata.txt");
			in = new BufferedReader(new FileReader(file));
		} catch (Exception e) {
			System.out.println("file not found, exiting program");
			System.exit(0);
		}
	}
	
	public void setOperations() throws IOException {		
		for (int i = 0; i < 3; i++) {
			line1 = in.readLine().split(" ");
			line2 = in.readLine().split(" ");
			final TreeSet<Integer> numSet1 = createSets(line1);
			final TreeSet<Integer> numSet2 = createSets(line2);
			
			TreeSet<Integer> unionSet = (TreeSet<Integer>) numSet1.clone();
			unionSet.addAll(numSet2);
			TreeSet<Integer> intersectionSet = (TreeSet<Integer>) numSet1.clone();
			intersectionSet.retainAll(numSet2);
			TreeSet<Integer> differenceSet1 = (TreeSet<Integer>) numSet1.clone();
			differenceSet1.removeAll(numSet2);
			TreeSet<Integer> differenceSet2 = (TreeSet<Integer>) numSet2.clone();
			differenceSet2.removeAll(numSet1);
			TreeSet<Integer> symmetricDifferenceSet = (TreeSet<Integer>) unionSet.clone();
			symmetricDifferenceSet.removeAll(intersectionSet);
			
			System.out.println("Set one: " + numSet1);
			System.out.println("Set two: " + numSet2);
			System.out.println("Union: " +  unionSet);
			System.out.println("Intersection: " +  intersectionSet);
			System.out.println("Difference (1-2): " + differenceSet1);
			System.out.println("Difference (2-1): " + differenceSet2);
			System.out.println("Symmetric Difference: " + symmetricDifferenceSet + "\n");

			
		}
		
	}
	
	public TreeSet<Integer> createSets(String[] aLine) {
		
		TreeSet<Integer> temp = new TreeSet<Integer>();
		for (int i = 0; i < aLine.length; i++) {
			temp.add(Integer.parseInt(aLine[i]));
		}
		return temp;
		
	}

}
