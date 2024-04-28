package language;

// <primitive command> ::= go | right | left 
public class PrimitiveCommandNode extends Node{
    private String name;
    private Executor executor;

    @Override
    public void parse(Context context) throws ParseException {
        name = context.currentToken();
        context.skipToken(name);
        executor = context.createExecutor(name);
    }

    @Override
    public void execute() throws ExecuteException {
        if (executor == null) {
            throw new ExecuteException(name + ": is not defined");
        }
        executor.execute();
    }

    public String toString(){
        return name;
    }
}