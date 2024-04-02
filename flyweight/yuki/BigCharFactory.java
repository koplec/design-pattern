import java.util.HashMap;
import java.util.Map;

public class BigCharFactory {
    private Map<String, BigChar> pool = new HashMap<>();

    private static BigCharFactory singleton = new BigCharFactory();
    private BigCharFactory(){}

    public static BigCharFactory getInstance(){
        return singleton;
    }
    public BigChar getBigChar(char charname){
        BigChar bc = pool.get("" + charname);
        if(bc != null) return bc;
        //synchronizedの範囲をpool程度に狭めることで、他のスレッドがgetInstance()を呼び出す際に、getInstance()の処理を待たずに、pool.get()を呼び出すことができる
        synchronized(pool){
            bc = pool.get("" + charname);
            if(bc == null){
                bc = new BigChar(charname);
                pool.put("" + charname, bc);
            }
        }
        return bc;
    }
}
