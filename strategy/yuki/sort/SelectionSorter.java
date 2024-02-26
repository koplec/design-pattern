package sort;

/**
 * SelectionSorter
 * 挿入ソートを行うクラス
 */
public class SelectionSorter<T> implements Sorter<T>{

    @Override
    public void sort(Comparable<T>[] data) {
        for(int i=0; i<data.length-1; i++){
            //最小値を探す
            int min = i;
            for(int j=i+1; j<data.length; j++){
                if(data[j].compareTo((T)data[min]) < 0){
                    min = j;
                }
            }
            //最小値を先頭であるi番目の要素と交換する
            //左側が小さくなる　ソート済みになる
            Comparable<T> passingplace = data[min];
            data[min] = data[i];
            data[i] = passingplace;
        }
    }
    
}
