
package commands;
import ui.ImageDisplay;
public class PrevCommand implements Command {
    private final ImageDisplay img;
    public PrevCommand(ImageDisplay img) {
        this.img = img;
    }
    @Override
    public void execute() {
        img.show(img.current().prev());
    }
}
