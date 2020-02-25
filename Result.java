// import java.util.*;

// class Result {
//     /*
//      * Complete the 'minimumOperations' function below.
//      *
//      * The function is expected to return a LONG_INTEGER.
//      * The function accepts INTEGER_ARRAY numbers as parameter.
//      */
//     public static int searchInsert(List<Integer> li, Integer target) {
        
//         if(li.contains(target)) {
//             int size = li.size();
            
//             if(size - li.lastIndexOf(target) < li.indexOf(target)) {
//                 return li.lastIndexOf(target) +1 ;
//             } else {
//                 return li.indexOf(target);
//             }
//         }
//         int l = 0, h = li.size();
//         while (l<h) {
//             int mid = l + (h-l) / 2;
//             if (li.get(mid) < target) {
//                 l = mid+1;
//             }
//             else {
//                 h = mid;
//             }
//         }
//         return l;
//     }
    
//     public static long minimumOperations(List<Integer> numbers) {
//     // Write your code here
//         long response = 0;
//         List<Integer> list = new ArrayList<Integer>();
//         for(Integer el: numbers) {
//             int pos = searchInsert(list,el);
//             int size = list.size();
//             if(pos > size / 2) {
//                 response += (2 * (size - pos))+1;
//             }
//             else if (pos <= size / 2) {
//                 response += (2*pos)+1; 
//             }
//             list.add(pos,el);
//         }
//         return response;
//     }

//     public static void main(String[] args) {
//         List<Integer> num = new ArrayList<Integer>();
//         num.add(2);
//         num.add(4);
//         num.add(1);
//         num.add(3);
//         System.out.println(minimumOperations(num));
//     }
// }

import java.io.*;
import java.util.*;

public class Result {
    private int age;	
	public Result(int initialAge) {
        if(initialAge < 0) {
            System.out.print("Age is not valid, setting age to 0.");
            initialAge = 0;
        }
        this.age = initialAge;
  		// Add some more code to run some checks on initialAge
	}

	public void amIOld() {
  		// Write code determining if this person's age is old and print the correct statement: 21oo 17to 12yt 
        System.out.println();
        if(this.age < 13) {
            System.out.print("You are young.");
        }
        else if(this.age>=13 && this.age<18) {
            System.out.print("You are a teenager.");
        }
        else {
            System.out.print("You are old.");
        }
        
	}

	public void yearPasses() {
  		// Increment this person's age.
          this.age++;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int age = sc.nextInt();
			Result p = new Result(age);
			p.amIOld();
			for (int j = 0; j < 3; j++) {
				p.yearPasses();
			}
			p.amIOld();
			System.out.println();
        }
		sc.close();
    }
}