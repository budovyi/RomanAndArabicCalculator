package mergesort;

public class MergeSort {
    public static int[] sort(int[] array) {
        array = divideArray(array);
        return array;
    }

    private static int[] divideArray(int[] array) {
        if (1 == array.length) {
            return array;
        } else if (2 >= array.length) {
            if (array[0] > array[1]) {
                int t = array[1];
                array[1] = array[0];
                array[0] = t;
            }
            return array;
        }
        int m = array.length / 2;
        int[] arrayL = new int[m];
        int[] arrayR = new int[array.length - m];

        for (int i = 0; i < array.length; i++) {
            if (i < m) {
                arrayL[i] = array[i];
            }
            if (i >= m) {
                arrayR[i - m] = array[i];
            }
        }
        arrayL = divideArray(arrayL);
        arrayR = divideArray(arrayR);
        array = mergeArrays(arrayL, arrayR);

        return array;
    }

    private static int[] mergeArrays(int[] arrayL, int[] arrayR) {
        int[] mergedArray = new int[arrayL.length + arrayR.length];
        int leftIndex = 0;
        int rightIndex = 0;
        boolean bool;
        int i = 0;
        while (leftIndex < arrayL.length && rightIndex < arrayR.length) {
            bool = arrayL[leftIndex] <= arrayR[rightIndex];
            if (bool) {
                mergedArray[i] = arrayL[leftIndex];
                leftIndex++;
            } else {
                mergedArray[i] = arrayR[rightIndex];
                rightIndex++;
            }
            i++;
        }

        while (leftIndex < arrayL.length) {
            mergedArray[i] = arrayL[leftIndex];
            leftIndex++;
            i++;
        }
        while (rightIndex < arrayR.length) {
            mergedArray[i] = arrayR[rightIndex];
            rightIndex++;
            i++;
        }
        return mergedArray;
    }
}
