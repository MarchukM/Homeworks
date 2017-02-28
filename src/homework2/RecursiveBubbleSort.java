package homework2;

public class RecursiveBubbleSort {

    private Integer[] array;

    public void setArray(Integer[] array){
        this.array = array;
    }

    public Integer[] getArray(){
        return array;
    }

    public void sort(int size, int counter){
        if(counter != size-1){
            if(array[counter+1] < array[counter]){
                Integer temp = array[counter];
                array[counter] = array[counter+1];
                array[counter+1] = temp;
            }
            sort(size, ++counter);
        }
        if(size <= 1){
            return;
        } else{
            sort(size - 1, 0);
        }
    }

    public static void main(String[] args) {
        RecursiveBubbleSort rbs = new RecursiveBubbleSort();
        Integer[] array = {4, 12, 8, 1, 3, 5, 5};
        rbs.setArray(array);
        rbs.sort(array.length, 0);

        for(Integer i : rbs.getArray()){
            System.out.print(i + " ");
        }
    }


}