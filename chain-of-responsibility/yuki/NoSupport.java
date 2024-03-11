public class NoSupport extends Support{
    public NoSupport(String name){
        super(name);
    }

    @Override
    /**
     * 解決できないので、falseを返す
     * 
     * @param trouble
     */
    protected boolean resolve(Trouble trouble) {
        return false;
    }

    
}
