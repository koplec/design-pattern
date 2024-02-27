public class Main {
    public static void main(String[] args) {
        try{
            System.out.println("Making root entries...");
            Directory root = new Directory("root");
            Directory bin = new Directory("bin");
            Directory tmp = new Directory("tmp");
            Directory usr = new Directory("usr");
            root.add(bin);
            root.add(tmp);
            root.add(usr);
            bin.add(new File("vi", 10000));
            bin.add(new File("latex", 20000));
            root.printList();

            System.out.println("");
            System.out.println("Making user entries...");
            Directory yuki = new Directory("yuki");
            Directory hanako = new Directory("hanako");
            Directory tomura = new Directory("tomura");

            yuki.add(new File("diary.html", 123));
            yuki.add(new File("Composite.java", 456));

            hanako.add(new File("memo.tex", 789));

            tomura.add(new File("game.doc", 111));
            tomura.add(new File("junk.mail", 222));

            usr.add(yuki);
            usr.add(hanako);
            usr.add(tomura);

            root.printList();

        }catch (FileTreatmentException e){
            e.printStackTrace();
        }
    }
}
