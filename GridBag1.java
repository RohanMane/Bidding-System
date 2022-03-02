package credit;

import java.awt.*;
import java.awt.event.*;
import java.net.Socket;
import java.sql.*;
import java.time.Year;
import java.util.ResourceBundle;
import javax.swing.*;

public class GridBag1 extends JPanel{
    JFrame frame;
    Connection connection;
    JTextField textField;
    JTextField textField1;
    public void paintComponent(Graphics g){
        Image image=new ImageIcon("C:/Users/pushk/Desktop/java/i5.jpg").getImage();
        g.drawImage(image,3,4,this);
    }
    public java.awt.Dimension getPreferredSize() {

        return new Dimension(1080,650);
    }
    public static void main(String[] args) {
        GridBag1 gridBag1 = new GridBag1();
        gridBag1.go();
    }
    public void go(){
        String url="";
        String user="";
        String password="";
        ResourceBundle reader = null;
        try{
            reader = ResourceBundle.getBundle("dbconfig.properties");
            url=reader.getString("db.url");
            user=reader.getString("db.username");
            password=reader.getString("db.password");
        }catch(Exception e){
        }
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Cooo1");
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        GridBag1 gridBag1 = new GridBag1();
        gridBag1.setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints=new GridBagConstraints();
        JPanel panel1=new JPanel(new GridBagLayout());
        frame=new JFrame();
        JPanel panel=new JPanel(new GridBagLayout());
        JLabel label=new JLabel("USERNAME");
        JLabel label1=new JLabel("PASSWORD");
        label.setFont(new Font("SERIF", Font.BOLD,20));
        label.setForeground(Color.white);
        label1.setForeground(Color.white);
        label1.setFont(new Font("SERIF", Font.BOLD,20));
        textField=new JTextField(15);
        textField.setBackground(Color.BLACK);
        textField.setForeground(Color.YELLOW);
        textField.setFont(new Font(Font.SANS_SERIF,Font.BOLD,14));
        textField1=new JTextField(15);
        textField1.setBackground(Color.BLACK);
        textField1.setForeground(Color.YELLOW);
        textField1.setFont(new Font(Font.SANS_SERIF,Font.BOLD,14));
        JButton button=new JButton("Login");
        JButton button1=new JButton("Register");
        textField.setCaretColor(Color.YELLOW);
        textField1.setCaretColor(Color.YELLOW);
        button1.addActionListener(new buttonlisten());
        button.addActionListener(new button1listen());
        gridBagConstraints.insets=new Insets(70,0,20,30);
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=0;
        panel.add(label,gridBagConstraints);
        gridBagConstraints.gridx=1;
        gridBagConstraints.gridy=0;
        gridBagConstraints.ipady=3;
        panel.add(textField,gridBagConstraints);
        gridBagConstraints.insets=new Insets(0,0,40,30);
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=1;
        panel.add(label1,gridBagConstraints);
        gridBagConstraints.gridx=1;
        gridBagConstraints.gridy=1;
        panel.add(textField1,gridBagConstraints);
        gridBagConstraints.insets=new Insets(0,0,70,0);
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=2;
        button.setBackground(Color.BLACK);
        button.setForeground(Color.YELLOW);
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.YELLOW);
        panel.add(button,gridBagConstraints);
        gridBagConstraints.gridx=1;
        gridBagConstraints.gridy=2;
        panel.add(button1,gridBagConstraints);
        bug h=new bug(button);
        bug h1=new bug(button1);
        panel.setBackground(new Color(0,0,0,50));
        // panel.setOpaque(false);
        JLabel label2=new JLabel("AUCTION");
        label2.setFont(new Font(Font.SERIF,Font.BOLD,40));
        label2.setForeground(Color.YELLOW );
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=0;
        gridBagConstraints.insets=new Insets(10,20,10,20);
        panel1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.WHITE,1,true),BorderFactory.createLineBorder(Color.WHITE,1,true)));
        panel1.add(label2,gridBagConstraints);
        panel1.setBackground(Color.BLACK);
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=0;
        gridBag1.add(panel1,gridBagConstraints);
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=1;
        gridBagConstraints.insets=new Insets(40,0,0,0);
        gridBag1.add(panel,gridBagConstraints);
        JPanel panel2=new JPanel();
        panel2.setOpaque(false);
        frame.getContentPane().add(gridBag1);
        frame.setSize(1080,650);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    class buttonlisten implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            frame.dispose();
            Register.main(new String[0]);
        }
    }
    class button1listen implements ActionListener{
        public void actionPerformed(ActionEvent event) {
            try{
                String user=textField.getText();
                String pass=textField1.getText();
                String login="select * from Customer where C_id=? and Pass=?";
                PreparedStatement preparedStatement=connection.prepareStatement(login);
                preparedStatement.setString(1,user);
                preparedStatement.setString(2,pass);
                ResultSet resultSet=preparedStatement.executeQuery();
                if(!resultSet.next()){
                    JOptionPane.showMessageDialog(frame,"Invalid login or password.Please Register first");
                }
                else{
                    Sell.getter(textField.getText());
                    credit.Buy.getter(textField.getText());
                    credit.prod_dis3.getter(textField.getText());
                    frame.dispose();
                    credit.prod_dis3.main(new String[0]);
                }
            }catch(Exception e){
                e.printStackTrace();
            }

        }
    }
    class bug extends JButton implements MouseListener{
        JButton button;
        public bug(JButton button2) {
            button=button2;
            button.addMouseListener(this);
        }
        public void mousePressed(MouseEvent e) {
            button.setForeground(Color.WHITE);
        }
        public void mouseReleased(MouseEvent e) {
            button.setBackground(Color.BLUE);
        }
        public void mouseEntered(MouseEvent e) {
            button.setForeground(Color.black);
            button.setBackground(Color.yellow);
        }
        public void mouseExited(MouseEvent e) {
            button.setBackground(Color.BLACK);
            button.setForeground(Color.yellow);
        }
        public void mouseClicked(MouseEvent e) {
            button.setBackground(Color.BLACK);
            button.setForeground(Color.WHITE);
        }
    }
}
