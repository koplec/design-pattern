package sort;

public class SortAndPrint<T> {
    Comparable<T>[] data;
    Sorter<T> sorter;

    public SortAndPrint(Comparable<T>[] data, Sorter<T> sorter) {
        this.data = data;
        this.sorter = sorter;
    }

    public void execute() {
        print();
        sorter.sort(data);
        print();
    }

    public void print(){
        for(Comparable<T> d : data){
            System.out.print(d + ", ");
        }
        System.out.println();
    }
}
