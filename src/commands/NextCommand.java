
package commands;
import ui.ImageDisplay;
public class NextCommand implements Command {
    private final ImageDisplay img;
    public NextCommand(ImageDisplay img) {
        this.img = img;
    }

    @Override
    public void execute() {
        img.show(img.current().next());
    }
    
}
