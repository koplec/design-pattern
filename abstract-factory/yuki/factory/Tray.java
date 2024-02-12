package factory;

import java.util.ArrayList;
import java.util.List;

// 抽象的な部品の一つ
public abstract class Tray extends Item{
    protected List<Item> tray = new ArrayList<>();
    public Tray(String caption) {
        super(caption);
    }

    public void add(Item item) {
        tray.add(item);
    }

}
