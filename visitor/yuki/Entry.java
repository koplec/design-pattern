public abstract class Entry implements Element{
    private Entry parent;
    public abstract String getName();
    public abstract int getSize();

    public Entry getParent() {
        return parent;
    }
    public void setParent(Entry parent) {
        this.parent = parent;
    }
    public String getFullPath() {
        if (parent == null) {
            return getName();
        } else {
            return parent.getFullPath() + "/" + getName();
        }
    }

    public Entry add(Entry entry) throws FileTreatmentException {
        throw new FileTreatmentException();
    }
    public void printList() {
        printList("");
    }
    protected abstract void printList(String prefix);

    public String toString() {
        return getName() + " (" + getSize() + ")";
    }
}