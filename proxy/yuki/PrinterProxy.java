//proxyをつかうと思い処理と軽い処理を分離できる
//実際の本物の処理クラスは、Proxyのことを知っていてはいけない
public class PrinterProxy implements Printable{
    private String name;
    private Printer real;

    public PrinterProxy(){

    }

    public PrinterProxy(String name){
        this.name = name;
    }

    @Override
    public String getPrinterName() {
        //realがnullでないとき、realのgetPrinterNameメソッドを呼び出すと思うんだけど、どうして呼び出さないのかな？
        return this.name;
    }

    @Override
    public synchronized void setPrinterName(String name) {
        if(real != null){
            real.setPrinterName(name);
        }
        this.name = name;
    }

    @Override
    public void print(String string) {
        realize(); //printメソッドが呼ばれた時にrealizeメソッドを呼び出す
        real.print(string);
    }

    private synchronized void realize(){
        if(real == null){
            real = new Printer(this.name);
        }
    }
}
