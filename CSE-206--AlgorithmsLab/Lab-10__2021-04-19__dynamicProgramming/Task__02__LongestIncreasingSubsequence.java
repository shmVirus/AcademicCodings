public class Task__02__LongestIncreasingSubsequence {
    public void findSubsequence(int[] array) {
        
        int[] LIS = new int[array.length];
        for (int i=0; i<array.length; i++) {
            int max = -1;
            for (int j=0; j<i; j++) {
                if (array[i] > array[j] && max == -1 || array[i] > array[j] && max < LIS[j]+1) max = 1 + LIS[j];
            }
            if (max == -1) max = array[0];
            LIS[i] = max;
        }

        int result = -1;
        int index = -1;
        for (int i=0; i<LIS.length; i++) {
            if (result < LIS[i]) {
                result = LIS[i];
                index = i;
            }
        }

        String path = "" + array[index];
        int res = result - 1;
        for (int i=index-1; i>= 0; i--) {
            if (LIS[i] == res) {
                path = array[i] + " " + path;
                res--;
            }
        }
        
        System.out.println("Longest Increasing Subsequence: " + result);
        System.out.println("Elements in Subsequence: " + path);
    }
    public static void main(String[] args) {
        int[] array = {1, 12, 7, 0, 23, 11, 52, 31, 61, 69, 70, 2};
        Task__02__LongestIncreasingSubsequence object = new Task__02__LongestIncreasingSubsequence();
        object.findSubsequence(array);
    }
}