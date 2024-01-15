package adapter.yuki.chap02;

public class Main {
    public static void main(String[] args) {
        Print p = new PrintBanner("Hello"); //こちらもPrintとして利用
        p.printWeak();
        p.printStrong();
    }
}
