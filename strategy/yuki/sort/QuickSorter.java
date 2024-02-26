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
            //highの値を基準にして、それよりも低いものを左に、高いものを右に分ける
            if(data[j].compareTo((T)x) <= 0){ //data[j]はx以下
                i++;
                //i番目とj番目を交換
                //i番目までがx以下になる
                Comparable<T> passingplace = data[i];
                data[i] = data[j];
                data[j] = passingplace;
            }
        }
        //i+1番目とhighを交換
        Comparable<T> passingplace = data[i+1];
        data[i+1] = data[high];
        data[high] = passingplace;
        return i+1;
    }
}
