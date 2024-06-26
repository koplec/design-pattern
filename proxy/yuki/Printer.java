public class Printer implements Printable{
    private String name;
    public Printer(){
        heavyJob("Printerのインスタンスを生成中。。");
    }
    public Printer(String name){
        this.name = name;
        heavyJob("Printerのインスタンス(" + name + ")を生成中。。");
    }

    @Override
    public String getPrinterName() {
        return this.name;
    }

    @Override
    public void print(String string) {
        System.out.println("=== " + this.name + " ===");
        System.out.println(string);
    }

    @Override
    public void setPrinterName(String name) {
        this.name = name;
    }


    private void heavyJob(String msg){
        System.out.print(msg);
        for(int i = 0; i < 5; i++){
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.print(".");
        }
        System.out.println("完了。");
    }
}
