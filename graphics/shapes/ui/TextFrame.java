package graphics.shapes.ui;

 
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.util.Date;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
 
public class TextFrame extends JFrame {
    /**
     * The text area which is used for displaying Shape description
     */
    private JTextArea textArea;
    private ShapeDescriptor desc;
  
    private JButton buttonClear = new JButton("Clear");
    public TextFrame() {
        super("Shape description Area");
       // this.desc = desc;
        textArea = new JTextArea(50, 10);
        textArea.setEditable(false);
        PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));       
      
        System.setOut(printStream);
       System.setErr(printStream);
 
        // creates the GUI
        //cf. https://docs.oracle.com/javase/7/docs/api/java/awt/GridBagConstraints.html
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
     
        constraints.gridy = 0;
    	
        add(buttonClear,constraints);
        //selects the 2nd cell vertically cf. https://docs.oracle.com/javase/7/docs/api/java/awt/GridBagConstraints.html
        constraints.gridy = 1;
        constraints.fill = GridBagConstraints.BOTH;
        //distributes vertical and horizontal space
       	constraints.weightx = 1.0;
        constraints.weighty = 1.0;
       
       
        add(new JScrollPane(textArea),constraints);
         
     
        // clears the text area
        buttonClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               
                try {
                    textArea.getDocument().remove(0,
                            textArea.getDocument().getLength());
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
            }
        });
         
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480, 320);
        setLocationRelativeTo(null);    // centers on screen
    }
     
   
  
     
   
        
    
}