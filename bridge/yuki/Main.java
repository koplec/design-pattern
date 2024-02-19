public class Main {
    public static void main(String[] args) {
        Display d1 = new Display(new StringDisplayImpl("Hello Japan!"));
        Display d2 = new CountDisplay(new StringDisplayImpl("Hello, World"));
        CountDisplay d3 = new CountDisplay(new StringDisplayImpl("Hello, Univeres"));
        CountDisplay d4 = new CountDisplay(new FileDisplayImpl("abc.txt"));
        d1.display();
        d2.display();
        d3.display();
        d4.display();

        System.out.println("-----------------");
        //こういう使い方は危ない？
        ((CountDisplay)d2).multiDisplay(5);

        d3.multiDisplay(5);
        d4.multiDisplay(10);


    }
}
