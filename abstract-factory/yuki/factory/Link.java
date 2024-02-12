package factory;

// 抽象的な部品の一つ
public abstract class Link extends Item{

    protected String url;

    public Link(String caption, String url) {
        super(caption);
        this.url = url;
    }
    
}
