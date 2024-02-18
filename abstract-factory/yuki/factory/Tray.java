package factory;

import java.util.ArrayList;
import java.util.List;

// 抽象的な部品の一つ
public abstract class Tray extends Item{
    // この中にItemを入れる
    // protectedにしたのは、サブクラスからもアクセスできるようにするため
    // このメリットは、サブクラスからもアクセスできるため、サブクラスでの実装が楽になる
    // このデメリットは、サブクラスからもアクセスされてしまうので、カプセル化ができない
    protected List<Item> tray = new ArrayList<>();
    public Tray(String caption) {
        super(caption);
    }

    public void add(Item item) {
        tray.add(item);
    }

}
