package game;

import java.util.ArrayList;
import java.util.List;

// 主人公の状態を表現する
public class Memento {
    //gameパッケージの外からはMementoの内部を変更できないようにする
    int money;
    List<String> fruits;
    
    // narrow interface
    // 狭いインターフェース
    // このクラスの外部からは、このクラスの内部の状態を変更できないためのもの
    public int getMoney() {
        return money;
    }

    // wide interface
    // 広いインターフェース
    // このクラスの外部からも、このクラスの内部の状態を変更できるようにする
    // Originatorからしか、すなわちpackage内部からしか使えないようにする
    Memento(int money) {
        this.money = money;
        this.fruits = new ArrayList<>();
    }

    // wide interface
    // game package内部からしか使えないようにする
    void addFruit(String fruit) {
        fruits.add(fruit);
    }

    // wide interface
    // 内部の状態をさらけ出すものなので、publicをつけない
    List<String> getFruits() {
        // cloneメソッドは、使えないので、新しいArrayListを作成して、fruitsの要素をコピーする
        return new ArrayList<>(fruits);
    }
}