import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

import javax.swing.JOptionPane;

/* Instant Translator
 * Author: piketrcechillas
 * Using Microsoft Azure
 */

public class Main {
	public static void main(String[] args) throws Exception {
        while (Processor.getKey().equals("YOUR_SUBSCRIPTION_KEY") || Processor.getKey().equals("")) {
        	String APIKey = JOptionPane.showInputDialog("Please enter your Microsoft Azure API key");
        	Processor.setKey(APIKey);
        	
        	if(!Processor.getKey().equals("YOUR_SUBSCRIPTION_KEY") || !Processor.getKey().equals(""))
        	{ StringSelection stringSelection = new StringSelection("");
        	  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(
                      stringSelection, null);}
        	
        }
        
        UI ui = new UI();
        ui.eventListener();
    }
}