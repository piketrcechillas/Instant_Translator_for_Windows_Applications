import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.FlavorEvent;
import java.awt.datatransfer.FlavorListener;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.awt.Color;
import java.awt.Component;
import java.awt.GraphicsConfiguration;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.JTextComponent;

public class UI {
	static GraphicsConfiguration gc;
	public static String copied = null;
	
	public UI() throws UnsupportedEncodingException {
        GUI gui = new GUI();
        System.setOut(new PrintStream(new RedirectingOutputGui(gui), true, "UTF-8"));
        gui.start();
    }
	
    public static void eventListener() throws Exception { 
        Toolkit.getDefaultToolkit().getSystemClipboard().addFlavorListener(new FlavorListener() { 
            @Override 
            public void flavorsChanged(FlavorEvent e) {
            	
            	try {
					Thread.sleep(200);
				} catch (InterruptedException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
                Clipboard c =Toolkit.getDefaultToolkit().getSystemClipboard();
                try {
                	
                	String copied = c.getData(DataFlavor.stringFlavor).toString();
                	if(!copied.equals("")) {
                		GUI.clear.doClick();
                		System.out.println(copied);
                		GUI.translate.doClick();}
                		
                		
	                
	                StringSelection stringSelection = new StringSelection("");
	                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(
	                            stringSelection, null);
	                
	                
				} catch (UnsupportedFlavorException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            } 
        }); 
        Thread.sleep(100000L); 
    }
    
    
    
}