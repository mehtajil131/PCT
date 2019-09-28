package lab2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Lab2 {

	public static String find_num(List<Integer> alist, int li, int ui, int num, String res) {
		


		int mid = 0 ;
		mid = (li + ui) / 2;
		//System.out.println("Debug" + res);
		
		
		 if (li == ui) {
				if (alist.get(li) == num) {
					res = res + "found";
					return res;
				} else {
					
					if (alist.get(li) > num) {
						 res = res + "-1 ";
						res = res + "notfound";
					} else {
						 res = res + "1 ";
						res = res + "notfound";
					}
					return res;
				}
					
			}
		 else {

			if(alist.get(mid) == num) {
				res = res + "found";
				return res;
			} else if (num < alist.get(mid)) {
				res = res + "-1 ";
				res = find_num( alist , li, mid-1, num, res);
				
			} else if (num > alist.get(mid)) {
				res = res + "1 ";
				res = find_num( alist , mid+1, ui, num, res);
			}
			
	}
		
		 return res;
		
	}
	
	public static void main(String[] args) {
		
		ArrayList<Integer> alist = new ArrayList<>();
		String res = "";
		int li=0,ui=0;
		Scanner in = new Scanner(System.in);
		
		String set = "";
		set = in.nextLine();
		
		String[] tokens = set.split(" ");
		
		for(String c : tokens) {
			
			alist.add(Integer.parseInt(c));
		}
		
		Collections.sort(alist);
		
/*		for(Integer i : alist) {
			System.out.println(i);
		}
		*/
		
		int num = Integer.parseInt(in.nextLine());
		
		ui = alist.size()-1;
		
		res = find_num(alist,li, ui, num,res);
		
		System.out.println(res);
		
		
		
	}
}
