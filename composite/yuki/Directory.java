import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry{
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
        this.entries.add(entry);
        return this;
    }
    
}
