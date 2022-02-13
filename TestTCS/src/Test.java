import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		List<Integer> array=new ArrayList<>();
		
		array.add(10);
		array.add(20);
		array.add(10);
		array.add(50);
		array.add(60);
		array.add(20);
		
//		List<Integer> sortedNumber=Arrays.sort(array);
		List<Integer> sorted= array.stream().sorted().collect(Collectors.toList());
		System.out.println(sorted);
	}
}
