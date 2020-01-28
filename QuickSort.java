/**
 * Time complexity:
 * Worst case - first element is pivot: O(n^2)
 * Best case - middle element is pivot and partition always in center: O(nlogn)
 * (logn levels and n comparisions at each level)
 */

class QuickSort{
 
    private static int[] array = new int[]{10,16,8,12,15,6,3,9,5,Integer.MAX_VALUE};

    private static void exchange(int i, int j) {

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    
    }

    private static int partition(int low, int high) {

        int pivot = array[low];
        int i=low, j=high;
        while(i < j) {
            
            //move forward until an element greater than pivot is found
            do {
                i++;
            } while(array[i] <= pivot);

            //move backward until an element lesser than pivot is found
            do {
                j--;
            } while(array[j] > pivot);

            if(i<j) {
                exchange(i,j);
            }
        }
        exchange(low, j);
        return j;
    }

    private void quick_sort(int low, int high) {

        if(low < high) {
            int j = partition(low, high);
            quick_sort(low, j);
            quick_sort(j+1, high);
        }

    }

    private void print_array() {

		for(int i=0; i<array.length ;i++) {
			System.out.print(array[i]+ " ");
		}
		System.out.println();

    }
    
    public static void main(String[] args) {

        QuickSort qs = new QuickSort();

        System.out.println("Array before sorting");
        qs.print_array();
        
        int low = 0, high = array.length-1;
        qs.quick_sort(low, high);

        System.out.println("Array after applying quick sort");
        qs.print_array();
        
    }
}