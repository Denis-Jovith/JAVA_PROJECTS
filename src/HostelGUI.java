

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class HostelGUI {
    private HostelManagement hostelManagement;

    public HostelGUI() {
        hostelManagement = new HostelManagement();
        createGUI();
    }

    private void createGUI() {
        JFrame frame = new JFrame("Hostel Management System");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1));

        JButton addButton = new JButton("Add Student");
        JButton removeButton = new JButton("Remove Student");
        JButton viewStudentsButton = new JButton("View Students");
        JButton viewRoomsButton = new JButton("View Rooms");
        JButton allocateRoomButton = new JButton("Allocate Room");

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(viewStudentsButton);
        buttonPanel.add(viewRoomsButton);
        buttonPanel.add(allocateRoomButton);

        // Text area to display results
        JTextArea textArea = new JTextArea(20, 40);
        textArea.setEditable(false);

        // Add panel to the frame
        panel.add(buttonPanel, BorderLayout.WEST);
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        frame.add(panel);
        frame.setVisible(true);

        // Button actions
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog(frame, "Enter student name:");
                String gender = JOptionPane.showInputDialog(frame, "Enter student gender (Male/Female):");
                String id = JOptionPane.showInputDialog(frame, "Enter student ID:");

                hostelManagement.addStudent(name, gender, id);
                textArea.setText("Student " + name + " with ID " + id + " added.\n");
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = JOptionPane.showInputDialog(frame, "Enter student ID to remove:");
                hostelManagement.removeStudent(id);
                textArea.setText("Student with ID " + id + " removed.\n");
            }
        });

        viewStudentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Student> students = hostelManagement.getStudents();
                StringBuilder studentsText = new StringBuilder();
                for (Student student : students) {
                    studentsText.append(student.toString()).append("\n");
                }
                textArea.setText(studentsText.toString());
            }
        });

        viewRoomsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Room> rooms = hostelManagement.getRooms();
                StringBuilder roomsText = new StringBuilder();
                for (Room room : rooms) {
                    roomsText.append(room.toString()).append("\n");
                }
                textArea.setText(roomsText.toString());
            }
        });

        allocateRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = JOptionPane.showInputDialog(frame, "Enter student ID to allocate room:");
                hostelManagement.allocateRoomToStudent(id);
                textArea.setText("Room allocation process completed.\n");
            }
        });
    }

    public static void main(String[] args) {
        new HostelGUI();
    }
}
