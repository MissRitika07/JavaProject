import java.awt.*;
import javax.swing.*;

class Dashboard {

    public static void main(String[] args) {

        JFrame f = new JFrame("Smart College Assistant");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));
        panel.setBackground(new Color(40, 40, 80));

        JButton addBtn = new JButton("Add Student");
        JButton viewBtn = new JButton("View Students");
        JButton updateBtn = new JButton("Update Student");
        JButton deleteBtn = new JButton("Delete Student");

        JButton[] btns = {addBtn, viewBtn, updateBtn, deleteBtn};

        for (JButton b : btns) {
            b.setFont(new Font("Arial", Font.BOLD, 16));
            b.setBackground(new Color(70, 130, 180));
            b.setForeground(Color.WHITE);
        }

        // 👉 ADD
        addBtn.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Enter Name:");
            String id = JOptionPane.showInputDialog("Enter ID:");

            try {
                int numId = Integer.parseInt(id);
                Student s = new Student(name, numId);
                FileHandler.saveStudent(s);
                JOptionPane.showMessageDialog(f, "Student Saved");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(f, "Enter numeric ID!");
            }
        });

        // 👉 VIEW
        viewBtn.addActionListener(e -> {
            String data = FileHandler.readStudents();
            JTextArea area = new JTextArea(data);
            JOptionPane.showMessageDialog(f, new JScrollPane(area));
        });

        // 👉 UPDATE
        updateBtn.addActionListener(e -> {
            String id = JOptionPane.showInputDialog("Enter ID:");
            String name = JOptionPane.showInputDialog("New Name:");
            FileHandler.updateStudent(id, name);
            JOptionPane.showMessageDialog(f, "Updated");
        });

        // 👉 DELETE
        deleteBtn.addActionListener(e -> {
            String id = JOptionPane.showInputDialog("Enter ID:");
            FileHandler.deleteStudent(id);
            JOptionPane.showMessageDialog(f, "Deleted");
        });

        for (JButton b : btns) panel.add(b);

        f.add(panel);
        f.setSize(400, 350);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}