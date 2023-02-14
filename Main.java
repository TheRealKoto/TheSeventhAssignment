import java.util.Random;

public class Main{
    public static void main(String[] args) throws Exception {
        int[] a = new int[100_000];
        int[] b = new int[100_000];
        int[] c = new int[100_000];
        randomizeArray(a,100_000);
        randomizeArray(b, 100_000);
        randomizeArray(c, 100_000);
        long start_time = System.currentTimeMillis();
        System.out.println("is a sorted yet? " + isSorted(a));
        mergeSort(a);
        long end_time = System.currentTimeMillis();
        long TimeTaken = end_time - start_time;
        System.out.println("is a sorted yet? " + isSorted(a));
        System.out.println("time taken merge: " + TimeTaken + " ms");
        System.out.println("is b sorted yet? " + isSorted(b));
        start_time = System.currentTimeMillis();
        insertionSort(b);
        end_time = System.currentTimeMillis();
        TimeTaken = end_time - start_time;
        System.out.println("is b sorted yet? " + isSorted(b));
        System.out.println("time taken insertion: " + TimeTaken+ " ms");
        System.out.println("is c sorted yet? " + isSorted(c));
        start_time = System.currentTimeMillis();
        bubbleSort(c);
        end_time = System.currentTimeMillis();
        TimeTaken = end_time - start_time;
        System.out.println("is c sorted yet? " + isSorted(c));
        System.out.println("time taken bubble: " + TimeTaken+ " ms");
        }
    public static void mergeSort(int[] a, int start, int end){
        int middle = (start + end)/2;
        if (end - start <= 1){
            return;
        }
        mergeSort(a,start, middle);
        mergeSort(a,middle, end);
        mergeArray(a,start,middle,end);
    }
    public static void mergeSort(int[] a){
        int start = 0;
        int end = a.length;
        int middle = (start + end)/2;
        if (end - start <= 1){
            return;
        }
        mergeSort(a,start, middle);
        mergeSort(a,middle, end);
        mergeArray(a,start,middle,end);

    }
    public static void mergeArray(int[] a, int start, int middle, int end){
        int i = start;
        int j = middle;
        int k = 0;
        int[] tempArray = new int[end - start];

        while(i < middle && j < end){
            if (a[i] <= a[j]){
                tempArray[k] = a[i];
                i++;
                k++;
            }else{
                tempArray[k] = a[j];
                j++;
                k++;
            }
            
        }
        while (i < middle){
            tempArray[k] = a[i];
            i++;
            k++;
        }
        while (j < end){
            tempArray[k] = a[j];
            j++;
            k++;
        }
        for (i = start; i < end; i++){
            a[i] = tempArray[i - start];
        }
    }
    public static void randomizeArray(int[] array, int upperBounds){
        Random random = new Random();
        for (int i = 0; i < array.length; i++){
            array[i] = random.nextInt(upperBounds);
        }
    }
    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i]>array[i+1]){return false;}
        }
        return true;
    }
    public static void bubbleSort(int[] array){
        for (int j = array.length; j >= 1; j --){
                for (int i = 0; i<array.length-1; i++){
                if (array[i] > array[i+1]) {
                    swap(array, i ,i+1);
                }
            }
        }
    }
    public static void insertionSort(int[] array){
        for (int i = 0; i < array.length - 1;) {
            if((i == 0) && array[0] > array[1]){
                swap(array,0,1);
                i++;
            }else if(array[i]>array[i+1]){
                swap(array, i, i+1);
                i--;
            }else{i++;}
            }
    }
    public static void swap(int[] array, int i, int j){
        int arrayPlaceHolder;
        arrayPlaceHolder = array[i];
        array[i] = array[j];
        array[j] = arrayPlaceHolder;
    }
}