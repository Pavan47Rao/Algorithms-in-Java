/**
 * Minimum time complexity: O(1)
 * Maximum time complexity: O(logn)
 */

class IterativeBinarySearch {

    private static int index, key;

    private int BinarySearch(int[] array, int n, int key) {

        int low = 0;
        int high = n-1;
        int mid;

        while(low <= high) {
            mid = (low + high) / 2;
            if(key == array[mid]) {
                return mid;
            }
            if(key < array[mid]) {
                high = mid-1;
            }
            else
                low = mid+1;
        }
        return 0;

    }

    private static void printResult(int index) {

        if(index!=0) {
            System.out.println("Key " + key + " is found in index " + index);
        }
        else {
            System.out.println("Key not found!");
        }

    }

    public static void main(String[] args) {

        int[] inputArray = new int[]{2,5,8,9,10,13,17};

        IterativeBinarySearch ibs = new IterativeBinarySearch();

        key = 17;
        index = ibs.BinarySearch(inputArray, inputArray.length, key);
        printResult(index);

        key = 90;
        index = ibs.BinarySearch(inputArray, inputArray.length, key);
        printResult(index);
    }
}

