public class ListVisitor extends Visitor {
    private String currentdir = "";
    @Override
    public void visit(File file) {
        System.out.println(currentdir + "/" + file);
    }

    @Override
    public void visit(Directory directory) {
        System.out.println(currentdir + "/" + directory);
        String savedir = currentdir;
        currentdir = currentdir + "/" + directory.getName();
        //ここでdirectoryの中身を見に行くので、構造がわかっている前提がある
        //ここでFileを取得していなくて、Entryの処理というのが抽象度が大きい
        //FileとDirectoryとかくと、if文が入ってしまう
        //if文を書かないことが、デザインパターンの大事なところ
        for (Entry entry : directory) {
            entry.accept(this);
        }
        currentdir = savedir;
    }
    
}
