import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainFrame {
    private JButton adminLoginButton;
    private JPanel panel1;
    private JPanel libraryManagementPanel;
    private JButton librarianLoginButton;
    private JPanel adminLogin;
    private JTextField adminTextField;
    private JPasswordField adminPasswordField;
    private JButton loginButton;
    private JPanel adminSectionPanel;
    private JButton addLibrarianButton;
    private JButton viewLibrarianButton;
    private JButton deleteLibrarianButton;
    private JButton logoutButton;
    private JPanel addLibrarianPanel;
    public JTextField librarianNameTextField;
    private JTextField librarianEmailTextField;
    private JTextField librarianAdressTextField;
    private JTextField librarianCityTextField;
    private JTextField librarianContactNumberTextField;
    private JButton addLibrarianButton1;
    private JButton backButton;
    private JPasswordField librarianPasswordField1;
    private JPanel viewLibrarianPanel;
    private JButton viewBackButton;
    private JPanel deleteLibrarianPanel;
    private JButton deleteButton;
    private JButton backDeleteButton;
    private JLabel enterIDLabel;
    private JTable table1;
    private JTextField enterIDTextField;
    private JPanel librarianLoginPanel;
    private JPasswordField librarianPasswordField;
    private JLabel librarianNameLabel;
    private JLabel librarianPasswordLabel;
    private JTextField librarianUserNameTextField;
    private JButton librarianAccessButton;
    private JPanel librarianSectionPanel;
    private JButton addBookButton;
    private JButton viewBooksButton;
    private JButton issueBookButton;
    private JButton viewIssuedBooksButton;
    private JButton returnBookButton;
    private JButton logoutLibrarianButton;
    private JPanel addBookPanel;
    private JTextField callNoTextField;
    private JTextField bookNameTextField;
    private JTextField authorTextField;
    private JTextField publisherTextField;
    private JTextField quantityTextField;
    private JButton addBookButton1;
    private JButton backButton1;
    private JPanel viewBooksPanel;
    private JButton backButton2;
    private JPanel issueBookPanel;
    private JTextField bookCallNoTextField;
    private JTextField studentContactTextField;
    private JTextField studentNameID;
    private JTextField studentIDTextField;
    private JButton issueBookButton1;
    private JButton backButton3;
    private JPanel viewIssuedBooksPanel;
    private JButton backButton4;
    private JPanel returnBookPanel;
    private JTextField returnBookIdTextField;
    private JTextField returnStudentIDTextField;
    private JButton returnBookButton1;
    private JButton backButton5;
    private JTextField issuedBookIDTextField;

    public void switchPanels(JPanel panel){
        libraryManagementPanel.setVisible(false);
        adminLogin.setVisible((false));
        adminSectionPanel.setVisible(false);
        addLibrarianPanel.setVisible(false);
        viewLibrarianPanel.setVisible(false);
        deleteLibrarianPanel.setVisible(false);
        librarianLoginPanel.setVisible(false);
        librarianSectionPanel.setVisible(false);
        addBookPanel.setVisible(false);
        viewBooksPanel.setVisible(false);
        issueBookPanel.setVisible(false);
        viewIssuedBooksPanel.setVisible(false);
        returnBookPanel.setVisible(false);
        panel.setVisible(true);
    }

    public boolean checkNamePassword(JTextField textField, JPasswordField passwordField, String name, char[] pass){
        if (textField.getText().equals(name) && Arrays.equals(passwordField.getPassword(), pass)){
            return true;
        }else{
            return false;
        }
    }

    public MainFrame(){
        adminLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanels(adminLogin);
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] pass = {'a', 'd', 'm', 'i', 'n', '1', '2', '3'};
                if (checkNamePassword(adminTextField, adminPasswordField, "admin", pass)){
                    switchPanels(adminSectionPanel);
                }else{
                    JOptionPane.showMessageDialog(null, "Nombre o contraseña incorrectos!");
                }
                adminTextField.setText("");
                adminPasswordField.setText("");
                pass = null;
            }
        });
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanels(libraryManagementPanel);
            }
        });
        addLibrarianButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanels(addLibrarianPanel);
            }
        });
        addLibrarianButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
                ManagementLibrarian obj = context.getBean(ManagementLibrarian.class);
                boolean res = obj.addLibrarian(librarianNameTextField.getText(), String.valueOf(librarianPasswordField1.getPassword()), librarianEmailTextField.getText(), librarianAdressTextField.getText(), librarianCityTextField.getText(), librarianContactNumberTextField.getText());
                if(res){
                    librarianNameTextField.setText(""); librarianPasswordField1.setText(""); librarianEmailTextField.setText("");
                    librarianAdressTextField.setText(""); librarianCityTextField.setText(""); librarianContactNumberTextField.setText("");
                    String message = "Bibliotecario agregado satisfactoriamente!";
                    JOptionPane.showMessageDialog(null, message);
                }
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanels(adminSectionPanel);
            }
        });
        viewLibrarianButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
                ManagementLibrarian obj = context.getBean(ManagementLibrarian.class);
                String[] columnNames = {"Id", "Nombre_Apellido", "Contraseña", "Email", "Dirección", "Ciudad", "Contacto"};

                table1 = new JTable(obj.viewLibrarian(), columnNames);
                JOptionPane.showMessageDialog(null, new JScrollPane(table1));

            }
        });
        viewBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanels(adminSectionPanel);
            }
        });
        deleteLibrarianButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanels(deleteLibrarianPanel);
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
                ManagementLibrarian obj = context.getBean(ManagementLibrarian.class);
                obj.deleteLibrarian(enterIDTextField.getText());
                enterIDTextField.setText("");
            }
        });
        backDeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanels(adminSectionPanel);
            }
        });
        librarianLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanels(librarianLoginPanel);
            }
        });
        librarianAccessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
                ManagementLibrarian obj = context.getBean(ManagementLibrarian.class);
                if(obj.checkLibrarianPassword(librarianUserNameTextField.getText(), String.valueOf(librarianPasswordField.getPassword()))){
                    switchPanels(librarianSectionPanel);
                }else{
                    JOptionPane.showMessageDialog(null, "Nombre o contraseña incorrectos!");
                }
            }
        });
        addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanels(addBookPanel);
            }
        });
        addBookButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
                ManagementBook obj = context.getBean(ManagementBook.class);
                boolean result = obj.addBook(Integer.valueOf(callNoTextField.getText()), bookNameTextField.getText(), authorTextField.getText(), publisherTextField.getText(), Integer.valueOf(quantityTextField.getText()));
                callNoTextField.setText(""); bookNameTextField.setText(""); authorTextField.setText(""); publisherTextField.setText(""); quantityTextField.setText("");
                if (result){
                    JOptionPane.showMessageDialog(null, "Libro agregado correctamente!");
                }
            }
        });
        backButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanels(librarianSectionPanel);
            }
        });
        viewBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
                ManagementBook obj = context.getBean(ManagementBook.class);
                String[] columnNames = {"Id", "N° Llamado", "Nombre", "Autor", "Editor", "Cantidad", "Prestados", "Fecha_préstamo"};

                table1 = new JTable(obj.viewBook(), columnNames);
                JOptionPane.showMessageDialog(null, new JScrollPane(table1));

            }
        });
        backButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanels(librarianSectionPanel);
            }
        });
        issueBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanels(issueBookPanel);
            }
        });
        issueBookButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
                ManagementIssuedBook obj = context.getBean(ManagementIssuedBook.class);
                boolean res = obj.addIssuedBook(Integer.valueOf(issuedBookIDTextField.getText()), Integer.valueOf(bookCallNoTextField.getText()), Integer.valueOf(studentIDTextField.getText()), studentNameID.getText(), studentContactTextField.getText());
                if (res){
                    JOptionPane.showMessageDialog(null, "Libro prestado correctamente!");
                } else{
                    JOptionPane.showMessageDialog(null, "Ha habido un error con la información ingresada.");
                }

                ManagementBook obj1 = context.getBean(ManagementBook.class);
                obj1.issueBook(Integer.valueOf(issuedBookIDTextField.getText()));
            }
        });
        backButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanels(librarianSectionPanel);
            }
        });
        viewIssuedBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
                ManagementIssuedBook obj = context.getBean(ManagementIssuedBook.class);
                String[] columnNames = {"ID", "N° Llamado", "ID Estudiante", "Nombre Estudiante", "Contacto"};

                table1 = new JTable(obj.viewIssuedBook(), columnNames);
                JOptionPane.showMessageDialog(null, new JScrollPane(table1));
            }
        });
        backButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanels(librarianSectionPanel);
            }
        });
        returnBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanels(returnBookPanel);
            }
        });
        returnBookButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
                ManagementIssuedBook obj = context.getBean(ManagementIssuedBook.class);
                boolean result = obj.deleteIssuedBook(Integer.valueOf(returnBookIdTextField.getText()));
                if (result){
                    JOptionPane.showMessageDialog(null, "Libro devuelto correctamente!");
                }else{
                    JOptionPane.showMessageDialog(null, "No fue posible devolver el libro.");
                }

                ManagementBook obj1 = context.getBean(ManagementBook.class);
                obj1.returnBook(Integer.valueOf(returnBookIdTextField.getText()));
            }
        });
        backButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanels(librarianSectionPanel);
            }
        });
        logoutLibrarianButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanels(libraryManagementPanel);
            }
        });

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Administración Biblioteca");
        frame.setContentPane(new MainFrame().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }



}
