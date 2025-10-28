import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class App1ICE {
    private JFrame mainFrame;
    private HashMap<String, ArrayList<String[]>> courseStudents = new HashMap<>();
    private HashMap<String, HashMap<String, Integer>> attendance = new HashMap<>();
    private HashMap<String, Integer> totalAttendanceDays = new HashMap<>();

    private final String[] courseList = {
            // Year 1 Term 1 (Old Curriculum)
            "ICE1101", "Information Technology Fundamentals",
            "ICE1102", "Information Technology Fundamentals Lab",
            "ICE1103", "Structured Programming Language",
            "ICE1104", "Structured Programming Language Sessional",
            "ICE1105", "Basic Electrical and Electronic Engineering",
            "ICE1106", "Basic Electrical and Electronic Engineering Sessional",
            "MATH1111", "Differential and Integral Calculus, and Coordinate Geometry",
            "ICE1108", "Engineering Drawing and CAD",
            "PHY1103", "Physics",
            "PHY1104", "Physics Sessional",
            "ICE1110", "Viva–Voce",

            // Year 1 Term 2 (Old Curriculum)
            "ICE1201", "Object Oriented Programming Language",
            "ICE1202", "Object Oriented Programming Language Sessional",
            "ICE1203", "Discrete Mathematics",
            "ICE1205", "Data Structures and Algorithms",
            "ICE1206", "Data Structures and Algorithms Sessional",
            "HUM1207", "Industrial Management and Accounting",
            "MATH1211", "Differential Equations and Linear Algebra",
            "HUM1209", "Technical & Communication English",
            "HUM1210", "Developing English Skills Sessional",
            "ICE1210", "Viva–Voce",

            // Year 2 Term 1 (Old Curriculum)
            "ICE2101", "Computer Architecture",
            "ICE2103", "Digital Logic Design",
            "ICE2104", "Digital Logic Design Sessional",
            "ICE2105", "Data Communication",
            "ICE2106", "Data Communication Sessional",
            "ICE2107", "Electronic Devices and Circuits",
            "ICE2108", "Electronic Devices and Circuits Sessional",
            "ICE2110", "Software Development Project",
            "MATH2111", "Vector Analysis and Numerical Analysis",
            "HUM2109", "Bangladesh Studies (History of Independence)",
            "ICE2112", "Viva–Voce",
            "ICE2114", "Field Trip",

            // Year 2 Term 2 (Old Curriculum)
            "ICE2201", "Operating System",
            "ICE2202", "Operating System Sessional",
            "ICE2203", "Microprocessors and Microcontrollers",
            "ICE2204", "Microprocessors and Microcontrollers Sessional",
            "ICE2205", "Database Management Systems",
            "ICE2206", "Database Management Systems Sessional",
            "ICE2208", "Advance Programming Sessional",
            "MATH2211", "Laplace Transformation and Fourier Analysis",
            "HUM2209", "Professional Ethics and Environmental Protection",
            "ICE2210", "Viva–Voce",

            // Year 3 Term 1 (Old Curriculum)
            "ICE3103", "Digital Signal Processing",
            "ICE3104", "Digital Signal Processing Sessional",
            "ICE3105", "Web Programming",
            "ICE3106", "Web Programming Sessional",
            "ICE3107", "Microwave Engineering",
            "ICE3108", "Microwave Engineering Sessional",
            "MATH3111", "Complex Variables and Statistics",
            "HUM1105", "Engineering Economics",
            "ICE3110", "Viva–Voce",

            // Year 3 Term 2 (Old Curriculum)
            "ICE3201", "Artificial Intelligence",
            "ICE3202", "Artificial Intelligence Sessional",
            "ICE3203", "Embedded Systems and Internet of Things",
            "ICE3204", "Embedded Systems and Internet of Things Sessional",
            "ICE3205", "Computer Networks",
            "ICE3206", "Computer Networks Sessional",
            "ICE3207", "Wireless and Mobile Communication",
            "ICE3208", "Wireless and Mobile Communication Sessional",
            "ICE3210", "Research Methodology and Technical Writing Sessional",
            "ICE3212", "Viva – Voce",
            "ICE3214", "Industrial Training",

            // Year 4 Term 1 (Old Curriculum + Option I)
            "ICE4101", "Software Engineering",
            "ICE4102", "Software Engineering Sessional",
            "ICE4103", "Antenna and Satellite Communication",
            "ICE4104", "Antenna and Satellite Communication Sessional",
            "ICE4105", "Simulation and Modeling",
            "ICE4106", "Simulation and Modeling Sessional",
            "ICE4107", "Machine Learning",
            "ICE4108", "Machine Learning Sessional",
            "ICE4109", "Robotics",
            "ICE4110", "Robotics Sessional",
            "ICE4111", "Data Mining",
            "ICE4112", "Data Mining Sessional",
            "ICE4113", "Computer Graphics",
            "ICE4114", "Computer Graphics Sessional",
            "ICE4115", "VLSI Design",
            "ICE4116", "VLSI Design Sessional",
            "ICE4117", "Bioinformatics",
            "ICE4118", "Bioinformatics Sessional",
            "ICE4119", "Peripheral and Interfacing",
            "ICE4120", "Peripheral and Interfacing Sessional",
            "ICE4121", "Mobile Applications Development",
            "ICE4122", "Mobile Applications Development Sessional",
            "ICE4123", "Data Science",
            "ICE4124", "Data Science Sessional",
            "ICE4126", "Project and Thesis",
            "ICE4128", "Viva–Voce",

            // Year 4 Term 2 (Old Curriculum + Option II)
            "ICE4201", "Optical Communication",
            "ICE4202", "Optical Communication Sessional",
            "ICE4203", "Information Security and Cryptography",
            "ICE4204", "Information Security and Cryptography Sessional",
            "ICE4205", "Multimedia Communication",
            "ICE4206", "Multimedia Communication Sessional",
            "ICE4207", "Digital Image Processing",
            "ICE4208", "Digital Image Processing Sessional",
            "ICE4209", "Information System and Design",
            "ICE4210", "Information System and Design Sessional",
            "ICE4211", "E-commerce and E-governance",
            "ICE4212", "E-commerce and E-governance Sessional",
            "ICE4213", "Distributed and Parallel Computing",
            "ICE4214", "Distributed and Parallel Computing Sessional",
            "ICE4215", "Nanoscience and Nanotechnology",
            "ICE4216", "Nanoscience and Nanotechnology Sessional",
            "ICE4217", "Natural Language Processing",
            "ICE4218", "Natural Language Processing Sessional",
            "ICE4219", "Biomedical Engineering",
            "ICE4220", "Biomedical Engineering Sessional",
            "ICE4222", "Project and Thesis",
            "ICE4224", "Viva–Voce",
    };

    public App1ICE() {
        mainFrame = new JFrame("ICE Classroom App");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1000, 600);
        mainFrame.setLocationRelativeTo(null);
        showPortalSelection();
        mainFrame.setVisible(true);
    }

    private void showPortalSelection() {
        JPanel outerPanel = new JPanel(new GridBagLayout());
        outerPanel.setBackground(Color.WHITE);

        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 230, 200), 2),
                BorderFactory.createEmptyBorder(30, 40, 30, 40)
        ));

        JLabel title = new JLabel("\uD83C\uDF3F ICE Classroom Portal");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setForeground(new Color(34, 139, 34));
        title.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        card.add(title);

        RoundedButton teacherBtn = new RoundedButton("\uD83D\uDC68‍\uD83C\uDFEB Teacher Portal");
        teacherBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        teacherBtn.addActionListener(e -> showTeacherPortal());

        RoundedButton studentBtn = new RoundedButton("\uD83D\uDC69‍\uD83C\uDF93 Student Portal");
        studentBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        studentBtn.addActionListener(e -> showStudentPortal());

        card.add(teacherBtn);
        card.add(Box.createVerticalStrut(20));
        card.add(studentBtn);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        outerPanel.add(card, gbc);

        mainFrame.setContentPane(outerPanel);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    private static class RoundedButton extends JButton {
        private final Color backgroundColor = new Color(0, 100, 0);
        private final Color hoverColor = new Color(0, 140, 0);
        private boolean hover = false;

        public RoundedButton(String text) {
            super(text);
            setContentAreaFilled(false);
            setFocusPainted(false);
            setForeground(Color.WHITE);
            setFont(new Font("Segoe UI", Font.BOLD, 20));
            setCursor(new Cursor(Cursor.HAND_CURSOR));
            setPreferredSize(new Dimension(300, 60));
            setMaximumSize(new Dimension(300, 60));
            setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));

            addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e) {
                    hover = true;
                    repaint();
                }
                public void mouseExited(MouseEvent e) {
                    hover = false;
                    repaint();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            int shadowOffset = 4;
            int arc = 30;
            g2.setColor(new Color(0, 0, 0, 80));
            g2.fillRoundRect(shadowOffset, shadowOffset, getWidth() - shadowOffset * 2, getHeight() - shadowOffset * 2, arc, arc);
            g2.setColor(hover ? hoverColor : backgroundColor);
            g2.fillRoundRect(0, 0, getWidth() - shadowOffset, getHeight() - shadowOffset, arc, arc);
            g2.dispose();
            super.paintComponent(g);
        }

        @Override
        public void paintBorder(Graphics g) {}
    }

    private void showTeacherPortal() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));

        JComboBox<String> courseCombo = new JComboBox<>(courseList);
        panel.add(courseCombo, BorderLayout.NORTH);

        DefaultTableModel model = new DefaultTableModel(new String[]{"Roll", "Name", "Mark Present", "Present Days", "Total Classes"}, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 2 ? Boolean.class : String.class;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 2;
            }
        };

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel();
        JButton add = new JButton("Add Student");
        JButton remove = new JButton("Remove Student");
        JButton submit = new JButton("Submit Attendance");
        JButton back = new JButton("Back");

        btnPanel.add(add);
        btnPanel.add(remove);
        btnPanel.add(submit);
        btnPanel.add(back);
        panel.add(btnPanel, BorderLayout.SOUTH);

        courseCombo.addActionListener(e -> {
            String course = (String) courseCombo.getSelectedItem();
            loadAttendanceTable(course, model);
        });

        add.addActionListener(e -> {
            String course = (String) courseCombo.getSelectedItem();
            String roll = JOptionPane.showInputDialog("Roll:");
            String name = JOptionPane.showInputDialog("Name:");
            if (roll != null && name != null && !roll.isBlank() && !name.isBlank()) {
                addStudent(course, roll.trim(), name.trim());
                loadAttendanceTable(course, model);
            }
        });

        remove.addActionListener(e -> {
            String course = (String) courseCombo.getSelectedItem();
            int row = table.getSelectedRow();
            if (row != -1) {
                String roll = (String) model.getValueAt(row, 0);
                courseStudents.get(course).removeIf(s -> s[0].equals(roll));
                if (attendance.containsKey(course)) attendance.get(course).remove(roll);
                loadAttendanceTable(course, model);
            }
        });

        submit.addActionListener(e -> {
            String course = (String) courseCombo.getSelectedItem();
            if (course == null) return;
            HashMap<String, Integer> courseAtt = attendance.getOrDefault(course, new HashMap<>());
            for (int i = 0; i < model.getRowCount(); i++) {
                if ((Boolean) model.getValueAt(i, 2)) {
                    String roll = (String) model.getValueAt(i, 0);
                    courseAtt.put(roll, courseAtt.getOrDefault(roll, 0) + 1);
                }
            }
            totalAttendanceDays.put(course, totalAttendanceDays.getOrDefault(course, 0) + 1);
            attendance.put(course, courseAtt);
            JOptionPane.showMessageDialog(mainFrame, "Attendance submitted.");
            loadAttendanceTable(course, model);
        });

        back.addActionListener(e -> showPortalSelection());

        courseCombo.setSelectedIndex(0);
        loadAttendanceTable((String) courseCombo.getSelectedItem(), model);

        mainFrame.setContentPane(panel);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    private void showStudentPortal() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));

        JPanel topPanel = new JPanel();
        JTextField rollField = new JTextField(10);
        JComboBox<String> courseCombo = new JComboBox<>();
        JButton check = new JButton("Check Attendance");
        JButton back = new JButton("Back");

        topPanel.add(new JLabel("Roll:"));
        topPanel.add(rollField);
        topPanel.add(courseCombo);
        topPanel.add(check);
        topPanel.add(back);

        JTextArea result = new JTextArea();
        result.setEditable(false);
        result.setFont(new Font("Consolas", Font.PLAIN, 14));
        JScrollPane scroll = new JScrollPane(result);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(scroll, BorderLayout.CENTER);

        // ✅ Fixed logic: now only uses course codes (every 2nd element)
        rollField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String roll = rollField.getText().trim();
                courseCombo.removeAllItems();
                for (int i = 0; i < courseList.length; i += 2) {
                    String code = courseList[i];
                    String name = courseList[i + 1];
                    ArrayList<String[]> students = courseStudents.get(code);
                    if (students != null) {
                        for (String[] s : students) {
                            if (s[0].equalsIgnoreCase(roll)) {
                                courseCombo.addItem(code + " - " + name);
                                break;
                            }
                        }
                    }
                }
            }
        });

        check.addActionListener(e -> {
            String roll = rollField.getText().trim();
            String selected = (String) courseCombo.getSelectedItem();
            if (roll.isEmpty() || selected == null) {
                result.setText("Enter roll and select course.");
                return;
            }

            // Extract course code before " - "
            String course = selected.split(" - ")[0];
            loadStudentAttendance(roll, course, result);
        });

        back.addActionListener(e -> showPortalSelection());

        mainFrame.setContentPane(panel);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    private void loadAttendanceTable(String course, DefaultTableModel model) {
        model.setRowCount(0);
        ArrayList<String[]> students = courseStudents.get(course);
        int total = totalAttendanceDays.getOrDefault(course, 0);
        HashMap<String, Integer> att = attendance.getOrDefault(course, new HashMap<>());
        if (students != null) {
            for (String[] s : students) {
                String roll = s[0];
                String name = s[1];
                int present = att.getOrDefault(roll, 0);
                model.addRow(new Object[]{roll, name, false, present, total});
            }
        }
    }

    private void addStudent(String course, String roll, String name) {
        courseStudents.putIfAbsent(course, new ArrayList<>());
        courseStudents.get(course).add(new String[]{roll, name});
    }

    private void loadStudentAttendance(String roll, String course, JTextArea area) {
        int total = totalAttendanceDays.getOrDefault(course, 0);
        int present = attendance.containsKey(course) ? attendance.get(course).getOrDefault(roll, 0) : 0;
        area.setText("Course: " + course +
                "\nRoll: " + roll +
                "\nTotal Classes: " + total +
                "\nDays Present: " + present +
                "\nAttendance: " + (total > 0 ? (present * 100 / total) + "%" : "N/A"));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(App1ICE::new);
    }
}
