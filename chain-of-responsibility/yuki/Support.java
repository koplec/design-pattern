public abstract class Support {
    private String name; //トラブル解決者の名前
    private Support next; //たらい回し先
    public Support(String name){
        this.name = name;
    }

    public Support setNext(Support next){
        this.next = next;
        return next;
    }

    /**
     * トラブル解決の手順
     * 
     * template methodパターンが使われている
     * @param trouble
     */
    public final void support(Trouble trouble){
        if(resolve(trouble)){
            done(trouble);
        }else if(next != null){
            next.support(trouble);
        }else{
            fail(trouble);
        }
    }

    protected abstract boolean resolve(Trouble trouble); //解決できれば、true でなければfalkse

    /**
     * 解決できたことを報告
     * @param trouble
     */
    protected void done(Trouble trouble){
        System.out.println(trouble + " is resolved by " + this + ".");
    } 

    /**
     * 解決できなかったことを報告
     * @param trouble
     */
    protected void fail(Trouble trouble){
        System.out.println(trouble + " cannot be resolved.");
    }

    @Override
    public String toString() {
        return "[" + name + "]";
    }
}
