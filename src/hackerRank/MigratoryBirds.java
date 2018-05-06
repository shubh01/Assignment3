package hackerRank;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.*;


public class MigratoryBirds {

    // Complete the migratoryBirds function below.
    static int migratoryBirds(int n, int[] ar) {

        HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
        for(int i=0;i<n;i++){
            if(map.containsKey(ar[i])){
                Integer freq=1+map.get(ar[i]);
                map.put(ar[i],freq);
            }else{
                map.put(ar[i],1);
            }
        }
        
        List<Entry<Integer, Integer>> entryList=new ArrayList<Entry<Integer,Integer>>(map.entrySet());
        
        entryList.sort(new Comparator<Entry<Integer, Integer>>() {
        	public int compare(Entry<Integer, Integer> e1, Entry<Integer, Integer> e2) {
        		int result =e1.getValue().compareTo(e2.getValue());
        		if(result==0)
        			return e2.getKey().compareTo(e1.getKey());
        		return result;
        	}
		});
        return entryList.get(entryList.size()-1).getKey();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int arItr = 0; arItr < arCount; arItr++) {
            int arItem = Integer.parseInt(arItems[arItr]);
            ar[arItr] = arItem;
        }

        int result = migratoryBirds(arCount, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
