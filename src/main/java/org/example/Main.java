package org.example;

import org.example.Entities.Attendance;
import org.example.Entities.AttendanceStatus;
import org.example.Entities.Employee;
import org.example.Entities.LeaveRequest;
import org.example.Entities.User;
import org.example.Interfaces.AttendanceService;
import org.example.Interfaces.EmployeeService;
import org.example.Interfaces.LeaveService;
import org.example.Interfaces.PayrollService;
import org.example.Interfaces.UserService;
import org.example.Services.AttendanceServiceImpl;
import org.example.Services.AuthService;
import org.example.Services.EmployeeServiceImpl;
import org.example.Services.LeaveServiceImpl;
import org.example.Services.PayrollServiceImpl;
import org.example.Services.UserServiceImpl;
import org.example.Utils.ConsoleReader;

import java.util.List;

/**
 * Console entry point for the Nexora Enterprise Management System.
 * Handles sign-in and dispatches to a role-specific dashboard.
 */
public class Main {

    private final ConsoleReader console;
    private final AuthService auth = new AuthService();
    private final UserService userService = new UserServiceImpl();
    private final EmployeeService employeeService = new EmployeeServiceImpl();
    private final LeaveService leaveService;
    private final AttendanceService attendanceService = new AttendanceServiceImpl();
    private final PayrollService payrollService = new PayrollServiceImpl();

    private Main(ConsoleReader console) {
        this.console = console;
        this.leaveService = new LeaveServiceImpl(employeeService);
    }

    public static void main(String[] args) {
        try (ConsoleReader console = new ConsoleReader()) {
            new Main(console).run();
        }
    }

    private void run() {
        System.out.println("========================================");
        System.out.println("  Nexora Enterprise Management System");
        System.out.println("========================================");

        while (true) {
            if (!auth.isLoggedIn()) {
                if (!showLoginMenu()) {
                    System.out.println("Goodbye.");
                    return;
                }
            } else {
                showDashboard();
            }
        }
    }

    // ------------------------------------------------------------------ login

    /**
     * Returns {@code false} when the user chooses to exit the application.
     */
    private boolean showLoginMenu() {
        System.out.println();
        System.out.println("1. Sign In");
        System.out.println("2. Forgot Password");
        System.out.println("3. Exit");

        switch (console.readInt("Select an option: ")) {
            case 1 -> signIn();
            case 2 -> forgotPassword();
            case 3 -> {
                return false;
            }
            default -> System.out.println("Invalid option.");
        }
        return true;
    }

    private void signIn() {
        String username = console.readLine("Email: ");
        String password = console.readLine("Password: ");

        String passwordError = validatePassword(password);

        if (passwordError != null) {
            System.out.println(passwordError);
            return;
        }

        User user = userService.authenticate(username, password);

        if (user != null) {
            auth.login(user);
            System.out.println("Login successful. Welcome, "
                    + user.getUsername() + " [" + user.getRole() + "]");
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private String validatePassword(String password) {

        StringBuilder missing = new StringBuilder();

        if (password.length() < 8) {
            missing.append("• At least 8 characters\n");
        }

        if (!password.matches(".*[a-z].*")) {
            missing.append("• Lowercase letter (a-z)\n");
        }

        if (!password.matches(".*[A-Z].*")) {
            missing.append("• Uppercase letter (A-Z)\n");
        }

        if (!password.matches(".*\\d.*")) {
            missing.append("• Number (0-9)\n");
        }

        if (!password.matches(".*[@#$%^&+=!].*")) {
            missing.append("• Special character (@#$%^&+=!)\n");
        }

        if (!missing.isEmpty()) {
            return "Password does not meet the requirements:\n" + missing;
        }

        return null;
    }

    private void forgotPassword() {
        String username = console.readLine("Username: ");
        String newPassword = console.readLine("New password: ");


        if (userService.resetPassword(username, newPassword)) {
            System.out.println("Password updated. You can now sign in.");
        } else
            System.out.println("Username not found.");
        }


    // -------------------------------------------------------------- dashboards

    private void showDashboard() {
        switch (auth.getCurrentUser().getRole()) {
            case ADMIN -> adminDashboard();
            case HR -> hrDashboard();
            case EMPLOYEE -> employeeDashboard();
        }
    }

    private void adminDashboard() {
        System.out.println("\n--- Admin Panel (" + auth.getCurrentUser().getUsername() + ") ---");
        System.out.println("1. List employees");
        System.out.println("2. Add employee");
        System.out.println("3. Remove employee");
        System.out.println("4. View all leave requests");
        System.out.println("5. View attendance log");
        System.out.println("6. Logout");

        switch (console.readInt("Select an option: ")) {
            case 1 -> listEmployees();
            case 2 -> addEmployee();
            case 3 -> removeEmployee();
            case 4 -> printLeaveRequests(leaveService.findAll());
            case 5 -> printAttendance(attendanceService.findAll());
            case 6 -> logout();
            default -> System.out.println("Invalid option.");
        }
    }

    private void hrDashboard() {
        System.out.println("\n--- HR Dashboard (" + auth.getCurrentUser().getUsername() + ") ---");
        System.out.println("1. List employees");
        System.out.println("2. Review pending leave requests");
        System.out.println("3. Mark attendance");
        System.out.println("4. View attendance log");
        System.out.println("5. Logout");

        switch (console.readInt("Select an option: ")) {
            case 1 -> listEmployees();
            case 2 -> reviewLeaveRequests();
            case 3 -> markAttendance();
            case 4 -> printAttendance(attendanceService.findAll());
            case 5 -> logout();
            default -> System.out.println("Invalid option.");
        }
    }

    private void employeeDashboard() {
        User user = auth.getCurrentUser();
        Employee me = requireLinkedEmployee(user);
        if (me == null) {
            logout();
            return;
        }

        System.out.println("\n--- Employee Portal (" + me.getName() + ") ---");
        System.out.println("1. My profile");
        System.out.println("2. Request leave");
        System.out.println("3. My leave requests");
        System.out.println("4. My attendance");
        System.out.println("5. My payslip");
        System.out.println("6. Logout");

        switch (console.readInt("Select an option: ")) {
            case 1 -> printProfile(me);
            case 2 -> requestLeave(me);
            case 3 -> printLeaveRequests(leaveService.findByEmployee(me.getId()));
            case 4 -> printAttendance(attendanceService.findByEmployee(me.getId()));
            case 5 -> printPayslip(me);
            case 6 -> logout();
            default -> System.out.println("Invalid option.");
        }
    }

    // ------------------------------------------------------------- operations

    private void listEmployees() {
        List<Employee> employees = employeeService.findAll();
        if (employees.isEmpty()) {
            System.out.println("No employees on record.");
            return;
        }
        System.out.printf("%-4s %-16s %-20s %-16s %-8s%n", "ID", "Name", "Department", "Position", "Leave");
        for (Employee e : employees) {
            System.out.printf("%-4d %-16s %-20s %-16s %-8.1f%n",
                    e.getId(), e.getName(), e.getDepartment(), e.getPosition(), e.getLeaveBalance());
        }
    }

    private void addEmployee() {
        String name = console.readLine("Name: ");
        String email = console.readLine("Email: ");
        String department = console.readLine("Department: ");
        String position = console.readLine("Position: ");

        Employee employee = employeeService.add(name, email, department, position);
        System.out.println("Employee added with ID " + employee.getId() + ".");
    }

    private void removeEmployee() {
        int id = console.readInt("Employee ID to remove: ");
        if (employeeService.remove(id)) {
            System.out.println("Employee removed.");
        } else {
            System.out.println("No employee found with ID " + id + ".");
        }
    }

    private void reviewLeaveRequests() {
        List<LeaveRequest> pending = leaveService.findPending();
        if (pending.isEmpty()) {
            System.out.println("No pending leave requests.");
            return;
        }

        printLeaveRequests(pending);
        int id = console.readInt("Request ID to review (0 to cancel): ");
        if (id == 0) {
            return;
        }

        String decision = console.readLine("Approve or reject? (a/r): ");
        boolean approve = decision.equalsIgnoreCase("a");
        if (leaveService.decide(id, approve)) {
            System.out.println("Request " + (approve ? "approved." : "rejected."));
        } else {
            System.out.println("Request " + id + " is not pending.");
        }
    }

    private void markAttendance() {
        int employeeId = console.readInt("Employee ID: ");
        if (employeeService.findById(employeeId).isEmpty()) {
            System.out.println("No employee found with ID " + employeeId + ".");
            return;
        }

        System.out.println("Status: 1. Present  2. Absent  3. Late");
        AttendanceStatus status = switch (console.readInt("Select status: ")) {
            case 2 -> AttendanceStatus.ABSENT;
            case 3 -> AttendanceStatus.LATE;
            default -> AttendanceStatus.PRESENT;
        };

        attendanceService.mark(employeeId, status);
        System.out.println("Attendance recorded as " + status + ".");
    }

    private void requestLeave(Employee me) {
        String type = console.readLine("Leave type (e.g. Annual, Sick): ");
        int days = console.readInt("Number of days: ");

        if (days <= 0) {
            System.out.println("Days must be greater than zero.");
            return;
        }
        if (days > me.getLeaveBalance()) {
            System.out.println("Requested days exceed your balance of " + me.getLeaveBalance() + ".");
            return;
        }

        LeaveRequest request = leaveService.submit(me.getId(), type, days);
        System.out.println("Leave request #" + request.getId() + " submitted (status: "
                + request.getStatus() + ").");
    }

    // ------------------------------------------------------------- formatting

    private void printProfile(Employee me) {
        System.out.println("Name       : " + me.getName());
        System.out.println("Email      : " + me.getEmail());
        System.out.println("Department : " + me.getDepartment());
        System.out.println("Position   : " + me.getPosition());
        System.out.println("Leave left : " + me.getLeaveBalance() + " day(s)");
    }

    private void printLeaveRequests(List<LeaveRequest> requests) {
        if (requests.isEmpty()) {
            System.out.println("No leave requests.");
            return;
        }
        System.out.printf("%-4s %-8s %-12s %-6s %-10s%n", "ID", "Emp", "Type", "Days", "Status");
        for (LeaveRequest r : requests) {
            System.out.printf("%-4d %-8d %-12s %-6d %-10s%n",
                    r.getId(), r.getEmployeeId(), r.getType(), r.getDays(), r.getStatus());
        }
    }

    private void printAttendance(List<Attendance> records) {
        if (records.isEmpty()) {
            System.out.println("No attendance records.");
            return;
        }
        System.out.printf("%-4s %-8s %-12s %-8s%n", "ID", "Emp", "Date", "Status");
        for (Attendance a : records) {
            System.out.printf("%-4d %-8d %-12s %-8s%n",
                    a.getId(), a.getEmployeeId(), a.getDate(), a.getStatus());
        }
    }

    private void printPayslip(Employee me) {
        payrollService.findByEmployee(me.getId()).ifPresentOrElse(
                p -> {
                    System.out.println("Base salary : " + p.getBaseSalary());
                    System.out.println("Allowances  : " + p.getAllowances());
                    System.out.println("Deductions  : " + p.getDeductions());
                    System.out.println("Net salary  : " + p.getNetSalary());
                },
                () -> System.out.println("No payroll record found."));
    }

    // ---------------------------------------------------------------- helpers

    private Employee requireLinkedEmployee(User user) {
        if (user.getEmployeeId() == null) {
            System.out.println("This account is not linked to an employee record.");
            return null;
        }
        Employee employee = employeeService.findById(user.getEmployeeId()).orElse(null);
        if (employee == null) {
            System.out.println("Linked employee record no longer exists.");
        }
        return employee;
    }

    private void logout() {
        System.out.println("Logged out.");
        auth.logout();
    }
}
