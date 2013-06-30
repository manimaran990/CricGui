import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CricGui extends JFrame implements ActionListener {
    public CricGui() {
        super("CricInfo");
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        CricPanel cp=new CricPanel();
        FlowLayout fl=new FlowLayout();
        setLayout(fl);
        JLabel noti=new JLabel("CURRENT MATCHES");
        JButton Reload=new JButton("Reload");
        Reload.addActionListener(this);
        add(noti);
        add(cp);
        add(Reload);
               
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
    }

 }