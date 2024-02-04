import framework.Product;

public class MessageBox implements Product{
    private char decorator;
    public MessageBox(char decorator) {
        this.decorator = decorator;
    }

    //cloneメソッドは、Java言語仕様で規定されている、自分自身の複製を作成するためのメソッドです。
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public Product createClone() {
        Product p = null;
        try {
            p = (Product)clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public void use(String s) {
        int length = s.getBytes().length;
        for(int i=0; i<length+4; i++) {
            System.out.print(decorator);
        }
        System.out.println("");
        System.out.println(decorator + " " + s + " " + decorator);
        for(int i=0; i<length+4; i++) {
            System.out.print(decorator);
        }
        System.out.println("");
    }
    
    
}
