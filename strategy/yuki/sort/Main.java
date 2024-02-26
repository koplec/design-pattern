package sort;

public class Main {
    public static void main(String[] args) {
        SortAndPrint<String> sap;
        String[] data = {
            "Dumpty", "Bowman", "Carroll", "Elfland", "Alice",
        };

        System.out.println("SelectionSorter");
        sap = new SortAndPrint<String>(data.clone(), new SelectionSorter<String>());
        sap.execute();

        System.out.println("BubbleSorter");
        sap = new SortAndPrint<String>(data.clone(), new BubbleSorter<String>());
        sap.execute();

        System.out.println("QuickSorter");
        sap = new SortAndPrint<String>(data.clone(), new QuickSorter<String>());
        sap.execute();
    }
}
