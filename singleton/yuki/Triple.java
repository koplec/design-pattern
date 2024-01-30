//問題5-2
public class Triple {
    private static Triple[] triples = new Triple[]{
        new Triple(0), new Triple(1), new Triple(2)
    };

    private int id;
    private Triple(int id){
        this.id = id;
    }

    public static Triple getInstance(int id){
        return triples[id];
    }

    public String toString(){
        return "[Triple id=" + id + "]";
    }

    public static void main(String[] args) {
        System.out.println("BEGIN");
        Triple t1 = Triple.getInstance(0);
        Triple t2 = Triple.getInstance(1);
        Triple t3 = Triple.getInstance(2);
        Triple t4 = Triple.getInstance(0);
        Triple t5 = Triple.getInstance(1);
        Triple t6 = Triple.getInstance(2);

        if(t1 == t4){
            System.out.println("t1とt4は同じインスタンスです。");
        }else{
            System.out.println("t1とt4は同じインスタンスではありません。");
        }

        if(t2 == t5){
            System.out.println("t2とt5は同じインスタンスです。");
        }else{
            System.out.println("t2とt5は同じインスタンスではありません。");
        }

        if (t3 == t6) {
            System.out.println("t3とt6は同じインスタンスです。");
        }else{
            System.out.println("t3とt6は同じインスタンスではありません。");
        }

        System.out.println("END");
    }
}
