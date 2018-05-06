package datastructure;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class TwoDArray {

	/*
     * Complete the array2D function below.
     */
    static int array2D(int[][] a) {
    	Integer finalSum=Integer.MIN_VALUE;
    	for(int i=0;i<=5;i++) {
    		for(int j=0;j<=3;j++) {
				int sum=0;
    			for(int k=j;k<=j+2 && i+2<=5;k++) {
    				sum+=a[i][k];
    				if(k>j && k<j+2) {
    					sum+=a[i+1][k];
    				}
    				sum+=a[i+2][k];
    			}
    			if(sum>finalSum)
    				finalSum=sum;
    		}
    	}
    	return finalSum.intValue();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        int[][] arr = new int[6][6];

        for (int arrRowItr = 0; arrRowItr < 6; arrRowItr++) {
            String[] arrRowItems = scanner.nextLine().split(" ");

            for (int arrColumnItr = 0; arrColumnItr < 6; arrColumnItr++) {
                int arrItem = Integer.parseInt(arrRowItems[arrColumnItr].trim());
                arr[arrRowItr][arrColumnItr] = arrItem;
            }
        }

        int result = array2D(arr);

    }
	
	
}
