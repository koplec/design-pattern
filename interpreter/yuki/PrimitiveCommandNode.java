// <primitve command> ::= go | right | left
public class PrimitiveCommandNode extends Node{
    private String name;
   
    @Override
    public void parse(Context context) throws ParseException {
        //PrimitiveCommandNodeは、TerminalExpressionなので、
        //contextからトークンを取り出して、それがgo, right, leftのいずれかであるかをチェックし、
        //さらに先のNodeを呼び出したりはしない
        name = context.currentToken();
        context.skipToken(name);
        if (!name.equals("go") && !name.equals("right") && !name.equals("left")) {
            throw new ParseException(name + " is undefined");
        }
    }

    public String toString(){
        return name;
    }

}
