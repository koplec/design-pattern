package sort;

public class QuickSorter<T> implements Sorter<T>{
    @Override
    public void sort(Comparable<T>[] data) {
        quickSort(data, 0, data.length-1);
    }

    private void quickSort(Comparable<T>[] data, int low, int high){
        if(low < high){
            int partition = partition(data, low, high);
            quickSort(data, low, partition-1);
            quickSort(data, partition+1, high);
        }
    }

    private int partition(Comparable<T>[] data, int low, int high){
        Comparable<T> x = data[high];
        int i = low-1;
        for(int j=low; j<high; j++){
            if(data[j].compareTo((T)x) <= 0){
                i++;
                Comparable<T> passingplace = data[i];
                data[i] = data[j];
                data[j] = passingplace;
            }
        }
        Comparable<T> passingplace = data[i+1];
        data[i+1] = data[high];
        data[high] = passingplace;
        return i+1;
    }
}
