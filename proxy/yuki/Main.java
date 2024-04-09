public class Main {
    public static void main(String[] args) {
        Printable p = new PrinterProxy("Alice");
        System.out.println("現在の名前は" + p.getPrinterName() + "です。");
        p.setPrinterName("Bob");
        System.out.println("現在の名前は" + p.getPrinterName() + "です。");
        p.print("Hello, world.");
    }
}
