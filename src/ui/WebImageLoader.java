package ui;

import model.Image;
import persistence.ImageLoader;

public class WebImageLoader implements ImageLoader {
    private String url;

    public WebImageLoader(String url) {
        this.url = url;
    }
    
    @Override
    public Image load() {
        return null;
    }
    
}
