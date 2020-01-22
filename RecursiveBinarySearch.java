
class RecursiveBinarySearch {

    private static int[] array = new int[] {2,4,7,9,12,16,19};
    private static int key;

    private static int RecursiveBS(int low, int high, int key) {
        
        int mid;
        if(low == high) {
            if(array[low] == key) {
                return low;
            }
            else {
                return 0;
            }
        }
        else {
            mid = (low + high) / 2;
            if( key == array[mid])
                return mid;
            if( key < array[mid])
                return RecursiveBS(low, mid-1, key);
            else
                return RecursiveBS(mid+1, high, key);
        }

    }

    private static void printResult(int index, int key) {

        if(index!=0) {
            System.out.println("Key " + key + " is found in index " + index);
        }
        else {
            System.out.println("Key not found!");
        }

    }

    public static void main(String[] args) {
        
        int index;

        key = 7;
        index = RecursiveBS(0, array.length-1, key);
        printResult(index, key);

        key = 70;
        index = RecursiveBS(0, array.length-1, key);
        printResult(index, key);
    }

}