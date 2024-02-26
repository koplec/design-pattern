package sort;

/**
 * BubbleSorter 
 * バブルソートを行うクラス
 */
public class BubbleSorter<T> implements Sorter<T>{
    @Override
    public void sort(Comparable<T>[] data) {
        for(int i=0; i<data.length-1; i++){
            for(int j=data.length-1; j>i; j--){
                if(data[j].compareTo((T)data[j-1]) < 0){
                    Comparable<T> passingplace = data[j];
                    data[j] = data[j-1];
                    data[j-1] = passingplace;
                }
            }
        }
        
    }
}
