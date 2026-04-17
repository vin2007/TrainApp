package main;

public class UseCase18TrainConsistMgmt {

    public static boolean linearSearch(String[] arr, String key) {
        for (String s : arr) {
            if (s.equals(key)) {
                return true;
            }
        }
        return false;
    }
}