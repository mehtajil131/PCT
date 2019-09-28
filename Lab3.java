package lab3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;

public class Lab3 {

	
	public static void main(String[] args) {
		int n_gram = 0;
		int no_lines =0;
		ArrayList<String> alist = new ArrayList<>();
		ArrayList<String> allmax = new ArrayList<>();
		String type = "";
		
		Scanner in = new Scanner(System.in);

		no_lines = Integer.parseInt(in.nextLine());
		
		for(int i=0;i<no_lines;i++) {
			String[] temp_str = in.nextLine().trim().split("");
			
			for(int j=0;j<temp_str.length;j++) {
				alist.add(temp_str[j]);
			}
			
			alist.add("0");
			
			
		}
		
		n_gram = in.nextInt();
		HashMap< String, Integer> hmap = new HashMap<>();
		int count =0;
		Object[] seq;
		Object[] vals;
		int max1 = 0;
		
		switch(n_gram) {
		
		case 1: 
			type = "Unigram";

			for(int i=0;i<alist.size();i++) {
				
				if(hmap.containsKey(alist.get(i))) {
					count = hmap.get(alist.get(i));
					count = count + 1;
					hmap.put(alist.get(i), count);
				} else {
					if((!alist.get(i).contentEquals(" ")) && (!alist.get(i).contentEquals(".")) && (!alist.get(i).contentEquals(",")) && (!alist.get(i).contentEquals("0")) && (!alist.get(i).contentEquals("")) )  {
						String temp_str = alist.get(i);
						count = 1;
						hmap.put(temp_str, count);
					}
				}

			}
			
			seq = hmap.keySet().toArray();
			vals = hmap.values().toArray();
			
			Arrays.sort(vals);
			max1 = (int) vals[vals.length-1];
			


			for(int j=0;j<hmap.size();j++) {
				if(hmap.get(seq[j]) == max1) {
					allmax.add((String) seq[j]);
				}
			}
			
			Collections.sort(allmax);
			break;
			
		case 2:
			type = "Bigram";
			for(int i=0;i<alist.size()-1;i++) {
				
				String st1 = alist.get(i);
				String st2 = alist.get(i+1);
				st1 = st1 + st2;
				st1 = st1.replace(".", "0");
				st1 = st1.replace(" ", "0");
				st1 = st1.replace(",", "0");
				//System.out.println(st1);
				
				if(hmap.containsKey(st1)) {
					count = hmap.get(st1);
					count = count + 1;
					hmap.put(st1, count);
				} else {
					if((!st1.contains("0")) )  {
						//String temp_str = alist.get(i);
						count = 1;
						hmap.put(st1, count);
					}
				}

			}
			
/*			System.out.println(allmax);
			
			System.out.println(alist);
			System.out.println(hmap.keySet());
			System.out.println(hmap.values());*/
			seq = hmap.keySet().toArray();
			vals = hmap.values().toArray();
			
			Arrays.sort(vals);
			max1 = (int) vals[vals.length-1];
			


			for(int j=0;j<hmap.size();j++) {
				if(hmap.get(seq[j]) == max1) {
					allmax.add((String) seq[j]);
				}
			}
			
			Collections.sort(allmax);
			break;
			
			
		case 3:
			type = "Trigram";
			for(int i=0;i<alist.size()-2;i++) {
				
				String st1 = alist.get(i);
				String st2 = alist.get(i+1);
				String st3 = alist.get(i+2);
				st1 = st1 + st2 + st3;
				st1 = st1.replace(".", "0");
				st1 = st1.replace(" ", "0");
				st1 = st1.replace(",", "0");
				//System.out.println(st1);
				
				if(hmap.containsKey(st1)) {
					count = hmap.get(st1);
					count = count + 1;
					hmap.put(st1, count);
				} else {
					if((!st1.contains("0")) )  {
						//String temp_str = alist.get(i);
						count = 1;
						hmap.put(st1, count);
					}
				}

			}
			
/*			System.out.println(allmax);
			
			System.out.println(alist);
			System.out.println(hmap.keySet());
			System.out.println(hmap.values());*/
			seq = hmap.keySet().toArray();
			vals = hmap.values().toArray();
			
			Arrays.sort(vals);
			max1 = (int) vals[vals.length-1];
			


			for(int j=0;j<hmap.size();j++) {
				if(hmap.get(seq[j]) == max1) {
					allmax.add((String) seq[j]);
				}
			}
			
			Collections.sort(allmax);
			break;
		
		}
		
		
		
		System.out.println(type + " " +  allmax.get(0));
		

	}

}
