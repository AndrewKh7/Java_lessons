import javax.swing.*;

public class WindowClass extends JFrame {
    WindowClass(){
        setTitle("Test Windiw");
        setBounds(500,500,400,400);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(true);

    }
}

class MainWindowClass{
    public static void main(String[] args) {
        WindowClass my_window = new WindowClass();
    }
}
