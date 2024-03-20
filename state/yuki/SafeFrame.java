import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//金庫警備システム
public class SafeFrame extends Frame implements ActionListener, Context{
    private TextField textClock = new TextField(60); //現在の時刻表示
    private TextArea textScreen = new TextArea(10, 60); //警備センター出力
    private Button buttonUse  = new Button("金庫使用"); //金庫使用ボタン
    private Button buttonAlarm  = new Button("非常ベル"); //非常ベルボタン
    private Button buttonPhone  = new Button("通常通話"); //通常通話ボタン
    private Button buttonExit  = new Button("終了"); //終了ボタン

    private State state = DayState.getInstance(); //現在の状態

    //コンストラクタ
    public SafeFrame(String title){
        super(title);
        setBackground(java.awt.Color.lightGray);
        setLayout(new BorderLayout());
        add(textClock, BorderLayout.NORTH);
        textClock.setEditable(false);
        add(textScreen, BorderLayout.CENTER);
        textScreen.setEditable(false);
        //パネルにボタンを追加
        Panel panel = new Panel();
        panel.add(buttonUse);
        panel.add(buttonAlarm);
        panel.add(buttonPhone);
        panel.add(buttonExit);
        //そのパネルを配置
        add(panel, BorderLayout.SOUTH);
        //表示
        pack();
        setVisible(true);

        //リスナーの設定
        buttonUse.addActionListener(this);
        buttonAlarm.addActionListener(this);
        buttonPhone.addActionListener(this);
        buttonExit.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        Button source = (Button)e.getSource();
        if(source == buttonUse){
            state.doUse(this);
        }else if(source == buttonAlarm){
            state.doAlarm(this);
        }else if(source == buttonPhone){
            state.doPhone(this);
        }else if(source == buttonExit){
            System.exit(0);
        }else{
            System.out.println("?");
        }
    }

    
    @Override
    public void setClock(int hour) {
        //自分自身の仕事はここでやる
        String clockstring = "現在時刻は";
        if(hour < 10){
            clockstring += "0" + hour + ":00";
        }else{
            clockstring += hour + ":00";
        }
        System.out.println(clockstring);
        textClock.setText(clockstring);
        //stateにまかせること
        state.doClock(this, hour);
    }

    @Override
    public void changeState(State state) {
        System.out.println(this.state + "から" + state + "へ状態が変化しました。");
        this.state = state;
    }

    @Override
    public void callSecurityCenter(String msg) {
        textScreen.append("call! " + msg + "\n");
    }



    @Override
    public void recordLog(String msg) {
        textScreen.append("record ... " + msg + "\n");
    }

    
}
