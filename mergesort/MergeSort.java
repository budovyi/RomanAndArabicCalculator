package mergesort;

public class MergeSort {
    public static void sort(int[] array) {
        divideArray(array, 0, array.length - 1);
    }

    public static void divideArray(int[] array, int leftStart, int rightEnd) {
        if (leftStart == rightEnd) {
            return;
        }
        int mid = (leftStart + rightEnd) / 2;

        divideArray(array, leftStart, mid);
        divideArray(array, mid + 1, rightEnd);

        mergeArrays(array, leftStart, mid, rightEnd);
    }

    private static void mergeArrays(int[] array, int leftStart, int mid, int rightEnd) {
        int rightStart = mid + 1;
        while (leftStart < rightEnd && rightStart <= rightEnd) {
            boolean bool = array[leftStart] < array[rightStart];

            if (bool) {
                leftStart++;
            } else {
                int t = array[rightStart];
                int i = rightStart;

                while (i > leftStart) {
                    array[i] = array[i - 1];
                    i--;
                }
                array[leftStart] = t;
                leftStart++;
                rightStart++;
            }
        }
    }
}
