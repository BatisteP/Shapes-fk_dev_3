package graphics.shapes.ui;

 
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;

 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

 
public class TextFrame extends JFrame {
    /**
     * The text area which is used for displaying Shape description
     */
    private JTextArea textArea;
    
  
    private JButton buttonClear = new JButton("Clear");
    private JButton buttonEdit = new JButton("Edit");
    public TextFrame() {
        super("Shape description Area");
        textArea = new JTextArea(50, 10);
        textArea.setEditable(false);
        PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));       
        System.setOut(printStream);
        System.setErr(printStream);
       
        //setting up buttons layout using GridBagLayout
        //cf. https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        //external-padding
       
        c.ipadx=10;
       
       
        //Clear Button on first cell 
        c.gridx=0;
        c.gridy = 0;
        add(buttonClear,c);
        c.anchor = GridBagConstraints.PAGE_END; 
        c.gridy=2;
        c.gridx=0;
        add(buttonEdit,c);
      
        //JTextArea on 2nd cell vertically takes all remaining space
        //external padding
        c.insets = new Insets(5,5,5,5);
        c.gridx=0;
        c.gridy = 1;
        c.fill = GridBagConstraints.BOTH; 
        c.weightx = 1.0;
        c.weighty = 1.0;
       
       
        add(new JScrollPane(textArea),c);
        
     
        //clears the text area
        buttonClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               
                try {
                    textArea.getDocument().remove(0,
                            textArea.getDocument().getLength());
                } 
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        //makes the text area editable
        buttonEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               
                try {
                    textArea.setEditable(true);
                } 
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
         
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setSize(320,600);
        setLocation(900,0);
       
    }
     
   
  
     
   
        
    
}