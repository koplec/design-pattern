import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Directory extends Entry implements Iterable<Entry>{
    private List<Entry> entries = new ArrayList<Entry>();
    private String name;

    public Directory(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getSize() {
        int size = 0;
        for (Entry entry : entries) {
            size += entry.getSize();
        }
        return size;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        for (Entry entry : entries) {
            entry.printList(prefix + "/" + name);
        }
    }

    @Override
    public Entry add(Entry entry) throws FileTreatmentException {
        entry.setParent(this);
        this.entries.add(entry);
        return this;
    }
    

    @Override
    public Iterator<Entry> iterator() {
        return entries.iterator();
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
