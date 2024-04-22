public class ProgramNode extends Node{
    private Node commandListNode; 


    @Override
    public void parse(Context context) throws ParseException {
        context.skipToken("program"); //最初のprogramという単語を読み飛ばす
        //あとのparseはCommandListNodeに任せる
        commandListNode = new CommandListNode();
        commandListNode.parse(context);

    }

    @Override
    public String toString() {
        return "[program " + commandListNode + "]";
    }
    
}
