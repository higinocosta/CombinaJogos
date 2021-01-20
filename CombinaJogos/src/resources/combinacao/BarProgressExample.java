package resources.combinacao;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;  
  
public class BarProgressExample extends JPanel {  
  
    private static final long serialVersionUID = -3510692886926771783L;  
  
    JProgressBar pbar;  
  
    static final int MY_MINIMUM = 0;  
  
    static final int MY_MAXIMUM = 100;  
  
    public BarProgressExample() {  
        pbar = new JProgressBar();  
        pbar.setMinimum(MY_MINIMUM);  
        pbar.setMaximum(MY_MAXIMUM);  
        add(pbar);  
    }  
  
    public void atualizaBarra(int valor) {  
        pbar.setValue(valor);  
    }  
  
    public static void ativaBarra() {  
  
       //final BarProgressExample barraex = new BarProgressExample();  
  
        JFrame frame = new JFrame("Progress Bar Example src= http://javafree.uol.com.br/forum/images/smiles/icon_wink.gif");  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        //frame.setContentPane(BarProgressExample());  
        frame.pack();  
        frame.setSize(400, 75);
        frame.setLocation(400, 300);  
        frame.setVisible(true);  
    }  
}  
