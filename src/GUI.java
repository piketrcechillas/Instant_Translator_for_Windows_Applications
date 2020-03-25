import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GUI extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea textArea;
    private JFrame frame;
    public static JButton clear = new JButton("Clear");
    public static JButton translate = new JButton("Translate");

    public GUI() {
        frame = new JFrame("Instant Translator");
        JPanel p = new JPanel();
        clear.addActionListener(new OpenL());
        p.add(clear);
        translate.addActionListener(new Trans());
        p.add(translate);
        frame.setBounds(0, 0, 400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textArea = new JTextArea();
        frame.getContentPane().add(textArea, BorderLayout.CENTER);
        frame.getContentPane().add(p, BorderLayout.SOUTH);
        frame.setAlwaysOnTop(true);
        frame.setResizable(true);
    }

    public void start() {
        frame.setVisible(true);
    }

    public void appendText(String text) throws UnsupportedEncodingException  {
        textArea.append(text);
    }
    
    class OpenL implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	textArea.setText(null);
        }
      }
    
    class Trans implements ActionListener {
    	 public void actionPerformed(ActionEvent e) {
    		String contents = textArea.getText();
    		String translated = Processor.Translator(contents);
    		StringBuilder sb = new StringBuilder(translated);
    		int i = 0;
    		while ((i = sb.indexOf(" ", i + 60)) != -1) {
    		    sb.replace(i, i + 1, "\n");
    		}
    		
         	textArea.setText(sb.toString());
         	
         }
    }
}