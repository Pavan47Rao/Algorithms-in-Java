/**
 * Time complexity: O(nlogn)
 * logn : for number of passes
 * n : to merge
 */

class MergeSort {

	private static int[] array = new int[]{2,9,1,4,5};

	private void print_array() {

		for(int i=0; i<array.length ;i++) {
			System.out.print(array[i]+ " ");
		}
		System.out.println();

	}
	
	private void sort(int l, int m, int h) {

		int n1 = m-l+1; //no of elements in the left part of array
		int n2 = h-m; //no of elements in the right part of array

		int array1[] = new int[n1];
		int array2[] = new int[n2];

		for(int i=0;i<n1;i++) {
			array1[i] = array[l+i]; //initialize array1 to contain left part of elements from main array
		}
		
		for(int j=0;j<n2;j++) {
			array2[j] = array[m+j+1]; //initialize array1 to contain right part of elements from main array
		}

		int i = 0, j = 0, k = l;

		while(i < n1 && j < n2) {
			//compare and sort
			if(array1[i] <= array2[j]) {
				array[k] = array1[i];
				i++;
			}
			else {
				array[k] = array2[j];
				j++;
			}
			k++;
		}

		//Copy the remaining elements
		while(i < n1) {
			array[k] = array1[i];
			i++;
			k++;
		}

		while(j < n2) {
			array[k] = array2[j];
			j++;
			k++;
		}

	}

	private void divide_and_merge(int l, int h) {

		if(l < h) {
			int mid = (l+h)/2;

			//Compute mid and divide until granular elements are formed
			divide_and_merge(l, mid);
			divide_and_merge(mid+1, h);

			//merge by sorting every left and right part of the array
			sort(l, mid, h);
		}

	}

	public static void main(String[] args) {
		
		MergeSort ms = new MergeSort();
		
		System.out.println("Array before sorting");
		ms.print_array();

		ms.divide_and_merge(0, array.length-1);

		System.out.println("Array after merge sorting");
		ms.print_array();
	}
}