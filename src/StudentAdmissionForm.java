import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class StudentAdmissionForm {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Student Admission Form");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel mainPanel = new JPanel(new CardLayout());

        // padding
        JPanel paddedMainPanel = new JPanel(new BorderLayout());
        paddedMainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        paddedMainPanel.add(mainPanel);

        // Create the form panel
        JPanel formPanel = new JPanel(new BorderLayout());

        // Create a panel to hold the two images
        JPanel imagePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        //  first image
        JLabel firstImageLabel = new JLabel();
        String desktopPath = System.getProperty("user.home") + File.separator + "Desktop";
        File firstImageFile = new File(desktopPath + File.separator + "banner.png");

        if (firstImageFile.exists()) {
            ImageIcon firstIcon = new ImageIcon(firstImageFile.getAbsolutePath());
            Image scaledFirstImage = firstIcon.getImage().getScaledInstance(300, 150, Image.SCALE_SMOOTH);
            firstImageLabel.setIcon(new ImageIcon(scaledFirstImage));
        } else {
            firstImageLabel.setText("Image 1 not found");
            firstImageLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        }

        //  second image
        JLabel secondImageLabel = new JLabel();
        File secondImageFile = new File(desktopPath + File.separator + "Student.jpg");

        if (secondImageFile.exists()) {
            ImageIcon secondIcon = new ImageIcon(secondImageFile.getAbsolutePath());
            Image scaledSecondImage = secondIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            secondImageLabel.setIcon(new ImageIcon(scaledSecondImage));
        } else {
            secondImageLabel.setText("Image 2 not found");
            secondImageLabel.setHorizontalAlignment(SwingConstants.LEFT);
        }

        // Add both image labels to the image panel
        imagePanel.add(firstImageLabel);
        imagePanel.add(secondImageLabel);

        // Add the image panel to the top of the form
        formPanel.add(imagePanel, BorderLayout.NORTH);

        // Form fields
        JPanel fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new GridLayout(9, 2, 10, 10));


        fieldsPanel.add(new JLabel("Name:"));
        JTextField nameField = new JTextField();
        fieldsPanel.add(nameField);

        fieldsPanel.add(new JLabel("Father's Name:"));
        JTextField fatherNameField = new JTextField();
        fieldsPanel.add(fatherNameField);

        fieldsPanel.add(new JLabel("Gender:"));
        JPanel genderPanel = new JPanel(new FlowLayout());
        JRadioButton maleButton = new JRadioButton("Male");
        JRadioButton femaleButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        fieldsPanel.add(genderPanel);

        fieldsPanel.add(new JLabel("Email:"));
        JTextField emailField = new JTextField();
        fieldsPanel.add(emailField);

        fieldsPanel.add(new JLabel("City:"));
        String[] cities = {"Lahore", "Karachi", "Islamabad", "Multan", "Quetta"};
        JComboBox<String> cityDropdown = new JComboBox<>(cities);
        fieldsPanel.add(cityDropdown);

        fieldsPanel.add(new JLabel("Address:"));
        JTextArea addressField = new JTextArea(3, 20);
        fieldsPanel.add(addressField);

        // Buttons
        JButton submitButton = new JButton("Submit");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submitButton);

        // Combine fields and buttons
        JPanel formFieldsContainer = new JPanel(new BorderLayout());
        formFieldsContainer.add(fieldsPanel, BorderLayout.CENTER);
        formFieldsContainer.add(buttonPanel, BorderLayout.SOUTH);


        formFieldsContainer.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        formPanel.add(formFieldsContainer, BorderLayout.CENTER);


        mainPanel.add(formPanel, "Form");

        // Create next screen
        JPanel successPanel = new JPanel(new BorderLayout());
        JLabel successLabel = new JLabel("Form Submitted Successfully!", SwingConstants.CENTER);
        successLabel.setFont(new Font("Arial", Font.BOLD, 18));
        successPanel.add(successLabel, BorderLayout.CENTER);



        // Add the success screen to the main panel
        mainPanel.add(successPanel, "Success");

        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();

        // Action performed by buttons
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Success");
            }
        });


        frame.add(paddedMainPanel);
        frame.setVisible(true);
    }
}
