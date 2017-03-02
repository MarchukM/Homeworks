package homework3;

public class RecursiveQuickSort {
    private int[] numbers;
    private int number;

    public void sort(int[] values) {
        if (values ==null || values.length==0){
            return;
        }
        this.numbers = values;
        number = values.length;
        sort(0, number - 1);
    }

    private void sort(int low, int high) {
        int i = low;
        int j = high;
        int pivot = numbers[low + (high-low)/2];
        while (i <= j) {
            while (numbers[i] < pivot) {
                i++;
            }
            while (numbers[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        if (low < j)
            sort(low, j);
        if (i < high)
            sort(i, high);
    }

    private void exchange(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2, 8, 12 ,5, 6, 7, 1, 2};
        RecursiveQuickSort quickSort = new RecursiveQuickSort();
        quickSort.sort(arr);

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}