import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CricGui extends JFrame implements ActionListener {
    
    public JTextArea scoreBoard = new JTextArea(15,19);
    public CricGui() {
        super("CricInfo");
        setSize(350,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        BorderLayout bl = new BorderLayout();
        setLayout(bl);
        
        //first panel
        JPanel firstPanel=new JPanel();
        FlowLayout fl = new FlowLayout(FlowLayout.CENTER,5,5);
        firstPanel.setLayout(fl);
        JLabel noti = new JLabel("SCORE BOARD");
        firstPanel.add(noti);
        add(firstPanel,BorderLayout.NORTH);
        
        
        
        //second panel
        JPanel secPanel = new JPanel();
        FlowLayout fl1 = new FlowLayout(FlowLayout.CENTER,21,21);
        CricPanel cp = new CricPanel();
        scoreBoard.setText(cp.getScores());
        scoreBoard.setEditable(false);
        secPanel.add(scoreBoard);
        secPanel.setLayout(fl1);
        add(secPanel,BorderLayout.CENTER);
        
        //third panel
        JPanel thirdPanel = new JPanel();
        FlowLayout fl2 = new FlowLayout(FlowLayout.CENTER,5,5);
        thirdPanel.setLayout(fl2);
        JButton Reload=new JButton("Reload");
        JButton exit = new JButton(" Exit ");
        Reload.addActionListener(this);
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            System.exit(0);
           }
         });
        thirdPanel.add(Reload);
        thirdPanel.add(exit);
        add(thirdPanel,BorderLayout.SOUTH);

               
        setVisible(true);
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception ex) {
            //nothing to do
        }
    }
    public static void main(String[] args) {
        CricGui cg=new CricGui();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //reload scores
        
        CricPanel cp = new CricPanel();
        scoreBoard.setText(cp.getScores());
        scoreBoard.repaint();
        
        
    }

 }