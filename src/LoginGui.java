import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class LoginGui implements ActionListener {
  private static JLabel passwordLabel;
  private static JButton loginButton;
  //private static JButton cancelButton;
  private static JLabel emailLabel;
  private static JPasswordField passwordField;
  private static JTextField email;
  private static JLabel success;
  private boolean filledOut;
  private int loginRights;


  public void setFilledOut(boolean filledOut) {
    this.filledOut = filledOut;
  }

  public JFrame createFrame() {

    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    //Size of the GUI
    frame.setSize(350, 200);
    //Exit button
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Add to frame
    frame.add(panel);
    panel.setLayout(null);

    //Email field.
    emailLabel = new JLabel("E-mail: ");
    email = new JTextField(20);
    email.setBounds(100, 20, 165, 25);
    panel.add(email);
    emailLabel.setBounds(10, 20, 80, 25);
    panel.add(emailLabel);

    //Password field.
    passwordLabel = new JLabel("Password: ");
    passwordField = new JPasswordField(20);
    passwordLabel.setBounds(10, 50, 165, 25);
    panel.add(passwordLabel);
    passwordField.setBounds(100, 50, 165, 25);
    panel.add(passwordField);

    //Button
    loginButton = new JButton("Login");
    loginButton.setBounds(10, 80, 80, 25);
    loginButton.addActionListener(new LoginGui());
    panel.add(loginButton);

/*
    cancelButton = new JButton("Cancel");
    cancelButton.setBounds(100, 80, 80, 25);
    loginButton.addActionListener(new LoginGUI());
    panel.add(cancelButton);
*/

    success = new JLabel("");
    success.setBounds(10, 110, 300, 25);
    panel.add(success);

    frame.setVisible(true);
    frame.toFront();
    frame.requestFocus();
    frame.setVisible(true);

    return frame;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String user = email.getText().toLowerCase(Locale.ROOT);
    String password = passwordField.getText();

    if (e.getActionCommand().equals("Login")) {
      if (user.equals("chairman@dolphin.com") && password.equals("1234")) {
        setFilledOut(true);
        setLoginRights(1);
        success.setText("Login successful!");
      } else if (user.equals("finance@dolphin.com") && password.equals("1234")) {
        success.setText("Login successful!");
        setLoginRights(2);
        setFilledOut(true);
      } else if (user.equals("coach@dolphin.com") && password.equals("1234")) {
        success.setText("Login successful!");
        setLoginRights(3);
        setFilledOut(true);
      } else
        success.setText("Wrong E-mail or Password");
    }
  }


  public void setLoginRights(int loginRights) {
    this.loginRights = loginRights;
  }

  public int getLoginRights() {
    return loginRights;
  }

  public boolean isFilledOut() {
    return filledOut;
  }

  public boolean listenForLogin(){
    boolean check = true;


    while(check){
      //Java dosnt know shit is changing!!!! WHAT TO DO????
      check = checkIfLoggedIn();
    }


    System.out.println("awesomesauce");
    return true;
  }

  public boolean checkIfLoggedIn(){
    System.out.println(isFilledOut());
    if(isFilledOut()){
      return false;
    }
    return true;
  }


}