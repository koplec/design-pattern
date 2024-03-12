import java.awt.Button;
import java.awt.event.ActionListener;

public class ColleagueButton extends Button implements Colleague{
    private Mediator mediator;

    public ColleagueButton(String caption){
        super(caption);
    }

    @Override
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
    
}
