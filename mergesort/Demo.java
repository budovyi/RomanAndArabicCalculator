package mergesort;

public class Demo {
    public static void main(String[] args) {
        int[] array = {5, 3, 8, 12, 25, 1, 0, 45, 33, 4, 6, 7, 9, 14, 15, 58, 0};
        System.out.println("inc array: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        array = MergeSort.sort(array);
        System.out.println("\nsorted array :");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
