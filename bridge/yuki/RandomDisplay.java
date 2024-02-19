public class RandomDisplay extends Display{
    public RandomDisplay(DisplayImpl impl){
        super(impl);
    }
    
    public void randomDisplay(int times){
        open();
        for(int i = 0; i < (int)(Math.random() * times); i++){
            print();
        }
        close();
    }
}
