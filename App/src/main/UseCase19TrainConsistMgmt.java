package main;

import java.util.Arrays;

public class UseCase19TrainConsistMgmt {

    public static boolean binarySearch(String[] arr, String key) {
        Arrays.sort(arr);
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = arr[mid].compareTo(key);

            if (cmp == 0) return true;
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
}