import java.util.Random;
import java.util.Arrays;

public class QuickSortAndSelect{

    public static int partition(int[] arr, int low, int high){

       int pivot = arr[high];
       int i = (low - 1);
       for(int j = low; j < high; j++){
           if(arr[j] < pivot){
               i++;

               swap(arr, i, j);
           }
       }
        swap(arr, i + 1, high);
        return i + 1;
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int quickSelect(int[] arr, int low, int high, int k){
        if(k <= 0){
            return Integer.MAX_VALUE;
        }

        int partition = partition(arr, low, high);

        if(partition == k){
            return arr[partition];
        } else if(partition < k) {
            return quickSelect(arr, partition + 1, high, k);
        } else {
            return quickSelect(arr, low, partition-1, k);
        }
    }

    public static void quickSort(int[] arr, int low, int high){
        if(low < high){
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }


    public static void main(String[] args){
        int[] test = {7,4,8,3,9,2,10,1};
        int pivot_index = partition(test, 0, test.length - 1);
        System.out.println("Testing partition, pivot_index at: " + pivot_index);
        for(int num : test){
            System.out.print(num + ", ");
        }
        System.out.println();

        int[] test2 = Arrays.copyOf(test, test.length);

        quickSort(test, 0, test.length - 1);
        System.out.println("After quicksort: ");
        for(int num : test){
            System.out.print(num + ", ");
        }

        System.out.println();

        int secondSmallest = quickSelect(test2, 0, test2.length - 1, 2);
        System.out.println("Second smallest element: " + secondSmallest);

        int n = 10000001;
        int[] arr = new int[n];
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        for (int i=0; i<n; i++) {
            arr[i] = rand.nextInt(n) + 1;
        }

        int[] arr2 = Arrays.copyOf(arr, arr.length);

        int k = arr.length / 2;
        long startTime = System.nanoTime();
        quickSort(arr, 0, arr.length - 1);

        int kth_smallest = arr[k-1];
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1000000000.0;

        System.out.println(k + "th smallest number: " + kth_smallest);
        System.out.println("Running Time of QuickSort and Select: " + duration + "\n");
        startTime = System.nanoTime();
        kth_smallest = quickSelect(arr2, 0, arr2.length - 1, k);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000000.0;
        System.out.println(k + "th smallest number: " + kth_smallest);
        System.out.println("Running Time of QuickSelect: " + duration + "\n");
    }
}
