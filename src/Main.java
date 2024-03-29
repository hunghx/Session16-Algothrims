import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random ran = new Random();
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = ran.nextInt(1000);
        }


//        Arrays.sort(array);
//        long t1 =System.currentTimeMillis();
//        System.out.println(t1);
//
//        System.out.println(linearSearch(array,11111));
//        long t2 =System.currentTimeMillis();
//        System.out.println(t2);
//        System.out.println("Thoi gian tim kiem = "+(t2-t1));
//        System.out.println(linearSearch(array,12));


        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }
    // tim kiem tuyen tinh
    public static int linearSearch(int[] arr , int value){ // -> Generic
        for (int i = 0; i < arr.length; i++) {
//            System.out.printf("Duyet vong lap thu %d , gia tri laf %d \n",i,arr[i]);
            if (arr[i]==value){
                return i;
            }
        }
        return -1;
    }

    // tim kiem nhi phan
    public static int binarySearchNoRecursive(int[] arr , int value){
        int start = 0;
        int end = arr.length-1;
        while (start <= end){
            // tim kiem gia tri
            int mid = start+(end - start)/2; // tran vung nho
            if (arr[mid]>value){
                end = mid-1;
            }else if (arr[mid]<value){
                start = mid+1;
            }else {
                // tim ra vi tri
                return mid;
            }
        }
        return -1;
    }
    public static void bubbleSort(int[] arr){
        boolean isNextPass = true;
        for (int i = 1; i < arr.length && isNextPass; i++) {  // i-> 1 den length-1
            for (int j = 0; j < arr.length - i ; j++) { // i = 1 ; j -> 0->length -2
                // gia su da sap xep roi
                isNextPass = false;
                if (arr[j] > arr[j+1]){
                    isNextPass = true;
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] =temp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
//            gia su vij tri vaf gia trij nho nhat
            int indexMin = i;
            int valueMin = arr[i];
            // tim gia tri nho nhat
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < valueMin){
                    indexMin = j;
                    valueMin = arr[j];
                }
            }

            // doi cho voi gia tri dau tien
            arr[indexMin] = arr[i]; // doi vi tri index min truoc
            arr[i] = valueMin;
        }
    }

    // sap xep chen
    public static void insertionSort(int[] arr){
        for (int i = 1; i < arr.length ; i++) {
            int currentValue = arr[i];
            int j;
            for ( j= i-1; j >= 0 && currentValue <= arr[j] ; j--) {
                arr[j+1] = arr[j];
            }
            arr[j+1] = currentValue;
        }
    }

}