package factory;

import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public abstract class Page {
    protected String title;
    protected String author;
    protected List<Item> content = new ArrayList<>();

    public Page(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void add(Item item) {
        content.add(item);
    }

    // template method pattern 
    public void output(){
        String filename = title + ".html";
        try(Writer writer = new java.io.FileWriter(filename)){
            writer.write(this.makeHTML());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(filename + "を作成しました。");
    }

    public abstract String makeHTML();
    
}
