package persistence;

import java.io.*;
import model.Image;

public class FileImageLoader implements ImageLoader {
    private final File[] files;

    public FileImageLoader(File folder) {
        this.files = folder.listFiles(imageTypes());
    }

    private FileFilter imageTypes() {
        return new FileFilter() {
            
            private final String[] formats = {".JPG",".BMP",".PNG"};
            
            @Override
            public boolean accept(File pathname) {
                for (String format : formats) {
                    if(pathname.getName().toUpperCase().endsWith(format))
                        return true;
                }
                return false;
            }
        };
    }
    
    @Override
    public Image load() {
        return imageAt(0);
    }

    private Image imageAt(int i) {
        return new Image() {
            @Override
            public String name() {
                return files[i].getName();
            }

            @Override
            public InputStream stream() {
                try {
                    return new BufferedInputStream(
                            new FileInputStream(files[i]));
                } catch (FileNotFoundException e) {
                    return null;
                }
            }

            @Override
            public Image next() {
                return i == files.length - 1 ? imageAt(0) : imageAt(i+1);
            }

            @Override
            public Image prev() {
                return i == 0 ? imageAt(files.length - 1) : imageAt(i-1);
            }

            
        };
    }
    
}
