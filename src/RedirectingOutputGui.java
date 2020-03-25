import java.io.IOException;
import java.io.OutputStream;

public class RedirectingOutputGui extends OutputStream {

    private GUI gui;

    public RedirectingOutputGui(GUI gui) {
        this.gui = gui;
    }

    @Override
    public void write(int b) throws IOException {
        gui.appendText(String.valueOf((char) b));
    }

	
}