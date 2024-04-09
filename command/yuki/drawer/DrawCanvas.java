package drawer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import command.MacroCommand;

public class DrawCanvas extends Canvas implements Drawable{
    private Color color = Color.red;
    private int radius = 6; // 描画する点の半径
    // 描画履歴
    // historyを持っているので、具体的なコマンドの操作が、ほかのコンポーネントが作用するとそれを参照できる
    // いつのまにか自分自身の持っているhistoryが更新されるのは、気持ちが悪い
    private MacroCommand history;

    public DrawCanvas(int width, int height, MacroCommand history) {
        this.setSize(width, height);
        this.setBackground(Color.white);
        this.history = history;
    }

    //履歴全体を再描画
    public void paint(Graphics g) {
        history.execute();
    }
    
    public void draw(int x, int y){
        Graphics g = getGraphics();
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
    
}
