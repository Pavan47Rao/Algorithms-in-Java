/**
 * Time complexity: O(nlogn)
 * to construct heap: nlogn, to sort: nlogn 
 * => 2nlogn ~ O(nlogn)
 */

import java.lang.Math;

class HeapSort{

    private static int[] array = new int[] {4,1,3,2,16,9,10,14,8,7};

    private static int left_child(int i) {
        return (2*i) + 1 ;
    }

    private static int right_child(int i) {
        return (2*i) + 2;
    }

    private static void exchange(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void print_array() {
        for(int j=0;j < array.length;j++) {
            System.out.print(array[j]+ " ");
        }
        System.out.println();
    }

    private static void max_heapify(int i, int n) {

        int l = left_child(i);
        int r = right_child(i);
        int largest;

        // if parent is less than its children, pick the largest child and swap
        if( l < n && array[l] > array[i]) {
            largest = l;
        }
        else
            largest = i;

        if( r < n && array[r] > array[largest]) {
            largest = r;
        }

        //heapify until parent is greater than its children
        if(largest != i) {
            exchange(i, largest);
            max_heapify(largest, n);
        }

    }

    private static void build_heap() {

        //bottom to top approach and hence start from last but one level which means non leaf nodes
        for(double i = Math.floor((array.length)/2)-1 ; i >= 0 ; i--) {

            System.out.println(array[(int)i]);
            max_heapify((int)i, array.length);

        }

        System.out.println("After constructing heap: ");
        print_array();

    }

    private void heap_sort() {

        build_heap();
        for(int i=array.length-1; i>=0; i--) {
            // pick the maximum element and move it to the other side of array
            exchange(i, 0);
            /**
             * Array elements in positions >= i are sorted and should be untouched
             * Hence perform heapify only to the elemets to the left side of i
             */
            max_heapify(0, i);
        }

    }
    public static void main(String[] args) {
        
        HeapSort heapSort = new HeapSort();
        heapSort.heap_sort();

        System.out.println("After applying heap sort: ");
        print_array();

    }

}