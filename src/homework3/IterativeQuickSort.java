package homework3;

import java.util.Stack;

class IterativeQuickSort {
    private int numbers[];
    private int number;
    private Stack<Integer> stack = new Stack<>();

    void exchange(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    int partition(int low, int high) {
        int x = numbers[high];
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            if (numbers[j] <= x) {
                i++;
                exchange(i, j);
            }
        }
        exchange(i + 1, high);
        return (i + 1);
    }

    void sort(int[] values) {
        if (values == null || values.length == 0) {
            return;
        }
        this.numbers = values;
        number = values.length;
        int low = 0;
        int high = number - 1;
        stack.add(low);
        stack.add(high);

        while (!stack.isEmpty()) {
            high = stack.pop();
            low = stack.pop();

            int pivot = partition(low, high);

            if (pivot - 1 > low) {
                stack.add(low);
                stack.add(pivot - 1);
            }
            if (pivot + 1 < high) {
                stack.add(pivot + 1);
                stack.add(high);
            }
        }
    }

    public static void main(String args[]) {
        IterativeQuickSort qs = new IterativeQuickSort();
        int[] arr = {4, 3, 5, 2, 1, 3, 2, 3};
        qs.sort(arr);

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}