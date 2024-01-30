public class Singleton {
    private static Singleton instance;

    private Singleton() {
        System.out.println("Singletonのインスタンスを作りました。");
    }

    public static Singleton getInstance() {
        if (instance == null) {//最初に呼び出されたときだけインスタンスを生成する
            synchronized (Singleton.class) {// Singletonクラスにだけロックをかけて、ロックする範囲を最小限にする
                if (instance == null) { // 二重チェックするのは、他のスレッドがロックを解除した後にもう一度チェックするため
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
