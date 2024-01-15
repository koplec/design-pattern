package adapter.yuki.chap02;

import adapter.yuki.Banner;

public class PrintBanner extends Print{

    private Banner banner;
    
    public PrintBanner(String string) {
        this.banner = new Banner(string);
    }
    @Override
    public void printStrong() {
        banner.showWithParen();
    }

    @Override
    public void printWeak() {
        banner.showWithAster();
    }
    
}
