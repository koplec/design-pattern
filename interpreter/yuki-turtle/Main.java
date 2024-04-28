import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import language.InterpreterFacade;
import turtle.TurtleCanvas;

public class Main extends Frame implements ActionListener{
    private TurtleCanvas canvas = new TurtleCanvas(400, 400);
    private InterpreterFacade facade = new InterpreterFacade(canvas);
    private TextField programTextField = new TextField("program repeat 3 go right go end end");


    public Main(String title){
        super(title);
        canvas.setExecutor(facade);
        programTextField.addActionListener(this);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        //layout
        setLayout(new BorderLayout());
        add(programTextField, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        pack();

        parseAndExecute();
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == programTextField){
            parseAndExecute();
        }
    }

    private void parseAndExecute(){
        String programText = programTextField.getText();
        System.out.println("programText = " + programText);
        facade.parse(programText); //MVCのM的な
        canvas.repaint(); //MVCのView的な
    }
    

    public static void main(String[] args) {
        new Main("Interpreter Pattern Sample");
    }
}
