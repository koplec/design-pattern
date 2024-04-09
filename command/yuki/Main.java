import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import command.Command;
import command.MacroCommand;
import drawer.DrawCanvas;
import drawer.DrawCommand;

public class Main extends JFrame implements ActionListener, MouseMotionListener, WindowListener{
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    private MacroCommand history = new MacroCommand();
    private DrawCanvas canvas = new DrawCanvas(WIDTH, HEIGHT, history);
    private JButton clearBtn = new JButton("消去");
    private JButton undBtn = new JButton("取り消し");

    public Main(String title){
        super(title);

        this.addWindowListener(this);
        canvas.addMouseMotionListener(this);
        clearBtn.addActionListener(this);
        undBtn.addActionListener(this);

        Box btnBox = new Box(BoxLayout.X_AXIS);
        btnBox.add(clearBtn);
        btnBox.add(undBtn);
        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(btnBox);
        mainBox.add(canvas);
        getContentPane().add(mainBox); // ここでaddしているのは、JFrameのコンテンツペインにaddしている

        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == clearBtn) {
            history.clear();
            canvas.repaint();
        }
        if(e.getSource() == undBtn){
            history.undo();
            canvas.repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //do nothing
    }


    @Override
    public void mouseDragged(MouseEvent e) {
       Command cmd = new DrawCommand(canvas, e.getPoint());
       history.append(cmd);
       cmd.execute();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }


    @Override
    public void windowDeactivated(WindowEvent e) {
        
    }

    @Override
    public void windowOpened(WindowEvent e) {
        // TODO Auto-generated method stub
       
    }

    @Override
    public void windowIconified(WindowEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        // TODO Auto-generated method stub
        
    }


    public static void main(String[] args) {
        new Main("Command Pattern Sample");
    }
}
