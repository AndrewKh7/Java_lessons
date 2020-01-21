import javafx.scene.shape.Box;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.Flow;

public class SwingMainClass {
    public static void main(String[] args){
        MainFrame wind = new MainFrame();
//        EnterNameFrame enter_name = new EnterNameFrame();
    }
}

class MainFrame extends JFrame{
    public MainFrame(){
        setTitle("Name Surname ");
        setBounds(700,100,240,135);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10));

        JLabel jtl_sur = new JLabel("Фамилия", SwingConstants.CENTER);
        JLabel jtl_name = new JLabel("Имя", SwingConstants.CENTER );
        JLabel jtl_mid = new JLabel("Отчество", SwingConstants.CENTER);
        JPanel panel = new JPanel();
        JButton btn1 = new JButton("Ввести данные");

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                EnterNameFrame enter_name = new EnterNameFrame(jtl_name, jtl_sur, jtl_mid);
            }
        });

        panel.add(jtl_sur, BorderLayout.CENTER);
        panel.add(jtl_name, BorderLayout.CENTER);
        panel.add(jtl_mid, BorderLayout.CENTER);
        add(panel, BorderLayout.NORTH);
        add(btn1, BorderLayout.SOUTH);

        setVisible(true);
    }
}

class EnterNameFrame extends JFrame{
    public EnterNameFrame(JLabel name, JLabel surname, JLabel midlsname ) {
        setTitle("Ввод личных данныъ");
        setBounds(750,150,400,200);
        setResizable(false);
        getRootPane().setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
        setLayout(new BorderLayout());

        JLabel jlb = new JLabel("Введите Фамилию, имя и отчество:",SwingConstants.CENTER);
        JLabel jlb_name = new JLabel("Имя:",SwingConstants.CENTER);
        JLabel jlb_sur = new JLabel("Фамилию:",SwingConstants.CENTER);
        JLabel jlb_mid = new JLabel("Отчество:",SwingConstants.CENTER);
        JTextField jtf_name = new JTextField();
        JTextField jtf_sur = new JTextField();
        JTextField jtf_mid = new JTextField();
        JPanel panel_center = new JPanel(new GridLayout(3,2));
        panel_center.setBorder(BorderFactory.createEmptyBorder(5,0,5,0));
        JButton btn_ok = new JButton("OK");

        btn_ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                name.setText( jtf_name.getText() );
                surname.setText( jtf_sur.getText() );
                midlsname.setText( jtf_mid.getText() );
                dispose();
            }
        });
        

        panel_center.add(jlb_name);
        panel_center.add(jtf_name);
        panel_center.add(jlb_sur);
        panel_center.add(jtf_sur);
        panel_center.add(jlb_mid);
        panel_center.add(jtf_mid);
        add(jlb, BorderLayout.NORTH);
        add(panel_center,BorderLayout.CENTER);
        add(btn_ok, BorderLayout.SOUTH);

        setVisible(true);
    }
}
