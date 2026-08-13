package org.example.MainClass;

import org.example.Entities.HREmployee;
import org.example.Entities.PerformanceHR;
import org.example.Interfaces.EmployeeServiceHR;
import org.example.Interfaces.PerformanceServiceHR;
import org.example.Services.EmployeeServiceImplHR;
import org.example.Services.PerformanceServiceImplHR;
import org.example.Utils.PerformanceChartPanelHR;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.time.LocalDate;
import java.util.List;
public class Main extends JFrame{

    private final EmployeeServiceHR employees =
            new EmployeeServiceImplHR();

    private final PerformanceServiceHR performances =
            new PerformanceServiceImplHR();

    private final JPanel content =
            new JPanel(new BorderLayout());

    private final Color NAVY =
            new Color(18, 34, 58);

    private final Color LIGHT =
            new Color(244, 247, 252);

    private final JLabel total =
            new JLabel();

    private final JLabel average =
            new JLabel();

    private final JLabel evaluations =
            new JLabel();

    public Main() {

        setTitle(
                "HRS Enterprise - People Operations"
        );

        setDefaultCloseOperation(
                EXIT_ON_CLOSE
        );

        setSize(1280, 800);

        setLocationRelativeTo(null);

        seedData();

        setLayout(
                new BorderLayout()
        );

        add(
                createTopBar(),
                BorderLayout.NORTH
        );

        content.setBackground(LIGHT);

        content.setBorder(
                new EmptyBorder(
                        20,
                        28,
                        20,
                        28
                )
        );

        add(
                content,
                BorderLayout.CENTER
        );

        dashboard();
    }

    // ==========================================
    // TOP MENU
    // ==========================================

    private JPanel createTopBar() {

        JPanel bar =
                new JPanel(
                        new BorderLayout()
                );

        bar.setBackground(Color.WHITE);

        bar.setBorder(
                new EmptyBorder(
                        14,
                        20,
                        14,
                        20
                )
        );

        JPanel header =
                new JPanel(
                        new BorderLayout()
                );

        header.setOpaque(false);

        JLabel title =
                new JLabel(
                        "People Operations"
                );

        title.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        22
                )
        );

        title.setForeground(NAVY);

        header.add(
                title,
                BorderLayout.NORTH
        );

        JPanel menu =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.LEFT,
                                6,
                                8
                        )
                );

        menu.setOpaque(false);

        createMenuButton(
                menu,
                "📊 Dashboard",
                e -> dashboard()
        );

        createMenuButton(
                menu,
                "👥 Employees",
                e -> employeesPage()
        );

        createMenuButton(
                menu,
                "🕐 Attendance",
                e -> simplePage("🕐 Attendance")
        );

        createMenuButton(
                menu,
                "🏖️ Leave",
                e -> simplePage("🏖️ Leave")
        );

        createMenuButton(
                menu,
                "💰 Payroll",
                e -> simplePage("💰 Payroll")
        );

        createMenuButton(
                menu,
                "📈 Performance",
                e -> performancePage()
        );

        createMenuButton(
                menu,
                "📋 Reports",
                e -> reportsPage()
        );

        createMenuButton(
                menu,
                "🔐 User & Access",
                e -> simplePage("🔐 User & Access")
        );

        createMenuButton(
                menu,
                "⚙️ Organization Rules",
                e -> simplePage("⚙️ Organization Rules")
        );

        createMenuButton(
                menu,
                "🔔 Notifications",
                e -> simplePage("🔔 Notifications")
        );

        header.add(
                menu,
                BorderLayout.SOUTH
        );

        bar.add(
                header,
                BorderLayout.CENTER
        );

        JLabel profile =
                new JLabel("AH");

        profile.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        18
                )
        );

        bar.add(
                profile,
                BorderLayout.EAST
        );

        return bar;
    }

    private void createMenuButton(
            JPanel panel,
            String text,
            java.awt.event.ActionListener action) {

        JButton button =
                new JButton(text);

        button.setFocusPainted(false);

        button.setBackground(Color.WHITE);

        button.setBorder(
                BorderFactory.createLineBorder(
                        new Color(225, 230, 238)
                )
        );

        button.addActionListener(action);

        panel.add(button);
    }

    // ==========================================
    // PAGE
    // ==========================================

    private JPanel createPage(
            String title,
            String subtitle) {

        JPanel panel =
                new JPanel(
                        new BorderLayout(
                                0,
                                15
                        )
                );

        panel.setBackground(LIGHT);

        JLabel titleLabel =
                new JLabel(title);

        titleLabel.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        28
                )
        );

        titleLabel.setForeground(NAVY);

        JLabel subtitleLabel =
                new JLabel(subtitle);

        subtitleLabel.setForeground(
                Color.GRAY
        );

        JPanel header =
                new JPanel(
                        new BorderLayout()
                );

        header.setOpaque(false);

        header.add(
                titleLabel,
                BorderLayout.NORTH
        );

        header.add(
                subtitleLabel,
                BorderLayout.SOUTH
        );

        panel.add(
                header,
                BorderLayout.NORTH
        );

        return panel;
    }

    // ==========================================
    // DASHBOARD
    // ==========================================

    private void dashboard() {

        JPanel page =
                createPage(
                        "Good afternoon, Ahmed",
                        "Live workforce health across attendance, leave, payroll and performance."
                );

        JPanel cards =
                new JPanel(
                        new GridLayout(
                                1,
                                3,
                                15,
                                0
                        )
                );

        cards.setOpaque(false);

        cards.add(
                createCard(
                        "TOTAL EMPLOYEES",
                        total,
                        "Active workforce"
                )
        );

        cards.add(
                createCard(
                        "AVERAGE PERFORMANCE",
                        average,
                        "Across evaluations"
                )
        );

        cards.add(
                createCard(
                        "PERFORMANCE EVALUATIONS",
                        evaluations,
                        "Recorded evaluations"
                )
        );

        updateDashboardCards();

        HREmployee employee =
                employees
                        .getAllEmployees()
                        .get(0);

        PerformanceChartPanelHR chart =
                new PerformanceChartPanelHR();

        chart.setData(
                performances.getEmployeePerformance(
                        employee.getEmployeeId()
                )
        );

        JPanel chartBox =
                new JPanel(
                        new BorderLayout()
                );

        chartBox.setBackground(
                Color.WHITE
        );

        chartBox.setBorder(
                new EmptyBorder(
                        15,
                        15,
                        15,
                        15
                )
        );

        JLabel chartTitle =
                new JLabel(
                        "📈 "
                                + employee.getFullName()
                                + " — Performance Trend"
                );

        chartTitle.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        17
                )
        );

        chartBox.add(
                chartTitle,
                BorderLayout.NORTH
        );

        chartBox.add(
                chart,
                BorderLayout.CENTER
        );

        JPanel center =
                new JPanel(
                        new BorderLayout(
                                0,
                                15
                        )
                );

        center.setOpaque(false);

        center.add(
                cards,
                BorderLayout.NORTH
        );

        center.add(
                chartBox,
                BorderLayout.CENTER
        );

        page.add(
                center,
                BorderLayout.CENTER
        );

        showPage(page);
    }

    private JPanel createCard(
            String title,
            JLabel value,
            String subtitle) {

        JPanel panel =
                new JPanel(
                        new BorderLayout(
                                5,
                                5
                        )
                );

        panel.setBackground(
                Color.WHITE
        );

        panel.setBorder(
                new EmptyBorder(
                        18,
                        18,
                        18,
                        18
                )
        );

        JLabel titleLabel =
                new JLabel(title);

        titleLabel.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        11
                )
        );

        value.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        28
                )
        );

        JLabel subtitleLabel =
                new JLabel(subtitle);

        subtitleLabel.setForeground(
                new Color(
                        60,
                        160,
                        110
                )
        );

        panel.add(
                titleLabel,
                BorderLayout.NORTH
        );

        panel.add(
                value,
                BorderLayout.CENTER
        );

        panel.add(
                subtitleLabel,
                BorderLayout.SOUTH
        );

        return panel;
    }

    private void updateDashboardCards() {

        total.setText(
                String.valueOf(
                        employees.getTotalEmployees()
                )
        );

        double sum = 0;

        for (PerformanceHR performance :
                performances.getAllPerformance()) {

            sum += performance.getScore();
        }

        int count =
                performances.getEvaluationCount();

        if (count == 0) {

            average.setText("0%");

        } else {

            average.setText(
                    String.format(
                            "%.1f%%",
                            sum / count
                    )
            );
        }

        evaluations.setText(
                String.valueOf(count)
        );
    }

    // ==========================================
    // EMPLOYEES
    // ==========================================

    private void employeesPage() {

        JPanel page =
                createPage(
                        "👥 Employees",
                        "Manage your workforce."
                );

        DefaultTableModel model =
                new DefaultTableModel(
                        new Object[]{
                                "ID",
                                "Name",
                                "Department",
                                "Job Title",
                                "Salary",
                                "Status"
                        },
                        0
                );

        for (HREmployee employee :
                employees.getAllEmployees()) {

            model.addRow(
                    new Object[]{
                            employee.getEmployeeId(),
                            employee.getFullName(),
                            employee.getDepartment(),
                            employee.getJobTitle(),
                            String.format(
                                    "%.2f OMR",
                                    employee.getSalary()
                            ),
                            employee.getEmploymentStatus()
                    }
            );
        }

        JTable table =
                new JTable(model);

        table.setRowHeight(28);

        JButton add =
                new JButton(
                        "＋ Add Employee"
                );

        add.addActionListener(
                e -> addEmployee()
        );

        JPanel bottom =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT
                        )
                );

        bottom.add(add);

        page.add(
                new JScrollPane(table),
                BorderLayout.CENTER
        );

        page.add(
                bottom,
                BorderLayout.SOUTH
        );

        showPage(page);
    }

    private void addEmployee() {

        JTextField id =
                new JTextField();

        JTextField firstName =
                new JTextField();

        JTextField lastName =
                new JTextField();

        JTextField email =
                new JTextField();

        JTextField job =
                new JTextField();

        JTextField department =
                new JTextField();

        JTextField salary =
                new JTextField();

        JPanel panel =
                new JPanel(
                        new GridLayout(
                                0,
                                2,
                                7,
                                7
                        )
                );

        String[] labels = {
                "ID",
                "First name",
                "Last name",
                "Email",
                "Job title",
                "Department",
                "Salary"
        };

        JTextField[] fields = {
                id,
                firstName,
                lastName,
                email,
                job,
                department,
                salary
        };

        for (int i = 0;
             i < labels.length;
             i++) {

            panel.add(
                    new JLabel(labels[i])
            );

            panel.add(
                    fields[i]
            );
        }

        int result =
                JOptionPane.showConfirmDialog(
                        this,
                        panel,
                        "Add Employee",
                        JOptionPane.OK_CANCEL_OPTION
                );

        if (result ==
                JOptionPane.OK_OPTION) {

            try {

                HREmployee employee =
                        new HREmployee(
                                Integer.parseInt(
                                        id.getText()
                                ),
                                firstName.getText(),
                                lastName.getText(),
                                email.getText(),
                                "",
                                job.getText(),
                                department.getText(),
                                LocalDate.now(),
                                Double.parseDouble(
                                        salary.getText()
                                ),
                                "ACTIVE"
                        );

                employees.addEmployee(
                        employee
                );

                employeesPage();

            } catch (Exception exception) {

                JOptionPane.showMessageDialog(
                        this,
                        "Invalid employee data.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    // ==========================================
    // PERFORMANCE PAGE
    // ==========================================

    private void performancePage() {

        JPanel page =
                createPage(
                        "📈 Employee Performance",
                        "HR can view performance and add new evaluations."
                );

        List<HREmployee> employeeList =
                employees.getAllEmployees();

        JComboBox<String> employeeBox =
                new JComboBox<>();

        for (HREmployee employee :
                employeeList) {

            employeeBox.addItem(
                    employee.getEmployeeId()
                            + " - "
                            + employee.getFullName()
            );
        }

        PerformanceChartPanelHR chart =
                new PerformanceChartPanelHR();

        JLabel information =
                new JLabel();

        JButton add =
                new JButton(
                        "＋ Add Evaluation"
                );

        add.addActionListener(
                e -> addPerformance(
                        employeeBox
                )
        );

        JPanel controls =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.LEFT
                        )
                );

        controls.add(
                new JLabel("Employee:")
        );

        controls.add(
                employeeBox
        );

        controls.add(add);

        controls.add(information);

        employeeBox.addActionListener(
                e -> {

                    int index =
                            employeeBox.getSelectedIndex();

                    if (index >= 0) {

                        HREmployee employee =
                                employeeList.get(index);

                        double averageScore =
                                performances
                                        .getAveragePerformance(
                                                employee.getEmployeeId()
                                        );

                        information.setText(
                                String.format(
                                        "Average: %.1f%% — %s",
                                        averageScore,
                                        PerformanceHR.calculateRating(
                                                averageScore
                                        )
                                )
                        );

                        chart.setData(
                                performances
                                        .getEmployeePerformance(
                                                employee.getEmployeeId()
                                        )
                        );
                    }
                }
        );

        JPanel wrapper =
                new JPanel(
                        new BorderLayout()
                );

        wrapper.setBackground(
                Color.WHITE
        );

        wrapper.setBorder(
                new EmptyBorder(
                        15,
                        15,
                        15,
                        15
                )
        );

        wrapper.add(
                controls,
                BorderLayout.NORTH
        );

        wrapper.add(
                chart,
                BorderLayout.CENTER
        );

        page.add(
                wrapper,
                BorderLayout.CENTER
        );

        showPage(page);

        if (!employeeList.isEmpty()) {
            employeeBox.setSelectedIndex(0);
        }
    }

    // ==========================================
    // ADD PERFORMANCE
    // ==========================================

    private void addPerformance(
            JComboBox<String> employeeBox) {

        int index =
                employeeBox.getSelectedIndex();

        if (index < 0) {
            return;
        }

        HREmployee employee =
                employees
                        .getAllEmployees()
                        .get(index);

        JTextField period =
                new JTextField();

        JTextField score =
                new JTextField();

        JTextField comments =
                new JTextField();

        JPanel panel =
                new JPanel(
                        new GridLayout(
                                0,
                                2,
                                7,
                                7
                        )
                );

        panel.add(
                new JLabel("Employee")
        );

        panel.add(
                new JLabel(
                        employee.getFullName()
                )
        );

        panel.add(
                new JLabel("Period")
        );

        panel.add(period);

        panel.add(
                new JLabel("Score 0-100")
        );

        panel.add(score);

        panel.add(
                new JLabel("Comments")
        );

        panel.add(comments);

        int result =
                JOptionPane.showConfirmDialog(
                        this,
                        panel,
                        "Add Performance Evaluation",
                        JOptionPane.OK_CANCEL_OPTION
                );

        if (result ==
                JOptionPane.OK_OPTION) {

            try {

                double scoreValue =
                        Double.parseDouble(
                                score.getText()
                        );

                if (scoreValue < 0
                        || scoreValue > 100
                        || period.getText().isBlank()) {

                    throw new Exception();
                }

                PerformanceHR performance =
                        new PerformanceHR(
                                performances
                                        .getEvaluationCount()
                                        + 1,

                                employee.getEmployeeId(),

                                period.getText(),

                                scoreValue,

                                PerformanceHR.calculateRating(
                                        scoreValue
                                ),

                                comments.getText(),

                                LocalDate.now()
                        );

                performances.addPerformance(
                        performance
                );

                JOptionPane.showMessageDialog(
                        this,
                        "Evaluation added.\n"
                                + "Graph and dashboard updated."
                );

                performancePage();

            } catch (Exception exception) {

                JOptionPane.showMessageDialog(
                        this,
                        "Score must be 0-100 and period is required.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    // ==========================================
    // REPORTS
    // ==========================================

    private void reportsPage() {

        JPanel page =
                createPage(
                        "📋 Reports",
                        "HR performance summary."
                );

        JTextArea area =
                new JTextArea();

        area.setEditable(false);

        StringBuilder report =
                new StringBuilder();

        report.append(
                "HRS ENTERPRISE - PERFORMANCE REPORT\n"
        );

        report.append(
                "========================================\n\n"
        );

        for (HREmployee employee :
                employees.getAllEmployees()) {

            double score =
                    performances
                            .getAveragePerformance(
                                    employee.getEmployeeId()
                            );

            report.append(
                    String.format(
                            "%-20s %.1f%%  %s%n",
                            employee.getFullName(),
                            score,
                            PerformanceHR.calculateRating(
                                    score
                            )
                    )
            );
        }

        area.setText(
                report.toString()
        );

        page.add(
                new JScrollPane(area),
                BorderLayout.CENTER
        );

        showPage(page);
    }

    // ==========================================
    // OTHER MODULES
    // ==========================================

    private void simplePage(String title) {

        JPanel page =
                createPage(
                        title,
                        "People Operations"
                );

        JLabel label =
                new JLabel(
                        "Module ready for the next HR requirement."
                );

        label.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        18
                )
        );

        page.add(
                label,
                BorderLayout.CENTER
        );

        showPage(page);
    }

    // ==========================================
    // SHOW PAGE
    // ==========================================

    private void showPage(JPanel page) {

        content.removeAll();

        content.add(page);

        content.revalidate();

        content.repaint();
    }

    // ==========================================
    // SAMPLE DATA
    // ==========================================

    private void seedData() {

        employees.addEmployee(
                new HREmployee(
                        1001,
                        "Ahmed",
                        "Hassan",
                        "ahmed@hrs.com",
                        "99123456",
                        "Software Developer",
                        "IT",
                        LocalDate.of(
                                2024,
                                1,
                                10
                        ),
                        1200,
                        "ACTIVE"
                )
        );

        employees.addEmployee(
                new HREmployee(
                        1002,
                        "Sarah",
                        "Ahmed",
                        "sarah@hrs.com",
                        "99123457",
                        "HR Specialist",
                        "Human Resources",
                        LocalDate.of(
                                2023,
                                6,
                                15
                        ),
                        1100,
                        "ACTIVE"
                )
        );

        String[] months = {
                "Jan",
                "Feb",
                "Mar",
                "Apr",
                "May",
                "Jun",
                "Jul"
        };

        double[] scores = {
                65,
                72,
                78,
                84,
                91,
                87,
                95
        };

        for (int i = 0;
             i < months.length;
             i++) {

            performances.addPerformance(
                    new PerformanceHR(
                            i + 1,
                            1001,
                            months[i],
                            scores[i],
                            "",
                            "Monthly evaluation",
                            LocalDate.now()
                    )
            );
        }
    }

    // ==========================================
    // MAIN
    // ==========================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                () -> {

                    Main main =
                            new Main();

                    main.setVisible(true);
                }
        );
    }
}