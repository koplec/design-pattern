//問題9-2
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileDisplayImpl extends DisplayImpl{
    private String filename;
    private BufferedReader reader;
    private final int MAX_READHEAD_LIMIT = 4096;

    public FileDisplayImpl(String filename){
        this.filename = filename;
    }
    @Override
    public void rawOpen(){
        System.out.println("==========" + filename + "==========");
        try{
            reader = new BufferedReader(new FileReader(filename));
            //markメソッドでマーク位置を設定
            //reader.mark(MAX_READHEAD_LIMIT)で、ファイルの先頭位置にマークを設定します。
            //これにより、`rawPrint()` メソッドが複数回呼び出されても、ファイルの内容を最初から再度読み取ることができます。 
            reader.mark(MAX_READHEAD_LIMIT);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void rawPrint() {
        try{
            String line;
            //reader.reset() を呼び出して、ファイルの読み取り位置をマークされた先頭位置に戻します
            reader.reset();
            while((line = reader.readLine()) != null){
                System.out.println("> " + line);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    @Override
    public void rawClose() {
        System.out.println("==========END==========");
        try{
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    
}
