public class DiverseArray {
    public static int arraySum(int[] arr) {
        int sum = 0;
        for (int i: arr) {
            sum += i;
        }
        return sum;
    }


    public static int[] rowSums(int[][] array) {
        int[] sums = new int[array.length];
        for (int row = 0; row < array.length; row++) {
            sums[row] = arraySum(array[row]);
        }
        return sums;
    }


    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);

            // Recursively sort the two partitions
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static boolean isDiverse(int[][] array2d) {
        int[] sums = rowSums(array2d);

        quickSort(sums, 0, sums.length - 1); // O(n log n), better than nested for-loop :)

        for (int i = 0; i < sums.length - 1; i++) { // O(n)
            if (sums[i] == sums[i+1]) {
                return false;
            }
        }
        return true;
    }
}
