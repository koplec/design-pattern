package adapter.yuki.chap01;

import adapter.yuki.Banner;

public class PrintBanner extends Banner implements Print{

    public PrintBanner(String string) {
        super(string);
    }
    @Override
    public void printStrong() {
        showWithParen();
    }

    @Override
    public void printWeak() {
        showWithAster();
    } 
    
    
}
