package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Originator 
public class Gamer {
    private int money;
    private List<String> fruits = new ArrayList<>();
    private Random random = new Random();
    
    private static String[] fruitsname = {
        "リンゴ", "ぶどう", "バナナ", "みかん",
    };

    public Gamer(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void bet() {
        int dice = random.nextInt(6) + 1;
        if (dice == 1) {
            money += 100;
            System.out.println("所持金が増えました。");
        } else if (dice == 2) {
            money /= 2;
            System.out.println("所持金が半分になりました。");
        } else if (dice == 6) {
            String f = getFruit();
            System.out.println("フルーツ(" + f + ")をもらいました。");
            fruits.add(f);
        } else {
            System.out.println("何も起こりませんでした。");
        }
    }

    private String getFruit(){
        //prefixは、おいしいかどうかを表す文字列
        String prefix = "";
        if (random.nextBoolean()) { // 乱数でtrueかfalseを返す
            prefix = "おいしい";
        }
        return prefix + fruitsname[random.nextInt(fruitsname.length)];
    }

    // Mementoを使って、スナップショットを撮る
    public Memento createMemento() {
        Memento m = new Memento(money);
        // fruitsの要素をコピーして、Mementoを作成する
        // コンストラクタで渡したい気もするけど。。。
        for (String f : fruits) {
            m.addFruit(f);
        }
        return m;
    }

    // 以前のMememtoを渡されて、状態を戻す
    public void restoreMemento(Memento memento) {
        this.money = memento.money; //getMoney()は使わないのは、なぜ？

        this.fruits = memento.getFruits();
    }
    public String toString() {
        return "[money = " + money + ", fruits = " + fruits + "]";
    }
}
