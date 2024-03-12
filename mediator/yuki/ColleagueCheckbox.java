import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ColleagueCheckbox extends Checkbox implements Colleague, ItemListener {
    private Mediator mediator;

    public ColleagueCheckbox(String caption, CheckboxGroup group, boolean state){
        super(caption, group, state);
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        //状態が変化したらMediatorに相談する
        //引数にeventとかを入れないのが、Observerパターンと違うところらしい
        mediator.colleagueChanged();
    }
    
}
