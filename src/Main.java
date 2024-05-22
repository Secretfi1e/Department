import java.util.Scanner;

public class Main {
    private final static Scanner scanner = new Scanner(System.in);
    private static Department[] departments;

    public static void main(String[] args) {
        System.out.println("Kaç departman eklemek istiyorsunuz?");
        int departmentCount = scanner.nextInt();
        scanner.nextLine();

        departments = new Department[departmentCount];

        for (int i = 0; i < departmentCount; i++) {
            System.out.println("Departman adını girin:");
            String name = scanner.nextLine();
            System.out.println("Çalışan sayısını girin:");
            int employeeCount = scanner.nextInt();
            scanner.nextLine();

            Department department = new Department(name, employeeCount);
            departments[i] = department;
        }

        menu();
    }

    public static void menu() {
        while (true) {
            System.out.println("\nMenü:");
            System.out.println("1. Departman numarası ile departmana çalışan ekle");
            System.out.println("2. Departmandan çalışan sil (departman numarasıyla)");
            System.out.println("3. Tüm çalışanları görüntüle");
            System.out.println("4. Departman numarasına göre çalışanları görüntüle");
            System.out.println("5. İsimle çalışan ara");
            System.out.println("6. Secilen Departman'daki çalışanlarda ara");
            System.out.println("7. Çıkış");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addEmployeeToDepartment();
                    break;
                case 2:
                    removeEmployeeFromDepartment();
                    break;
                case 3:
                    displayAllEmployees();
                    break;
                case 4:
                    displayEmployeesByDepartment();
                    break;
                case 5:
                    searchEmployeeByName();
                    break;
                case 6:
                    searchEmployeeInDepartment();
                    break;
                case 7:
                    System.out.println("Programdan çıkılıyor...");
                    return;
                default:
                    System.out.println("Geçersiz seçim. Tekrar deneyin.");
            }
        }
    }

    public static void addEmployeeToDepartment() {
        System.out.println("Departman numarasını girin:");
        int departmentNo = scanner.nextInt();
        scanner.nextLine();

        Department department = findDepartment(departmentNo);
        if (department != null) {
            if (department.getEmployeeCount() == 0) {
                System.out.println("Bu departman maksimum çalışan sayısına ulaştı.");
                return;
            }

            System.out.println("Çalışanın adını girin:");
            String name = scanner.nextLine();
            System.out.println("Çalışanın soyadını girin:");
            String surname = scanner.nextLine();
            System.out.println("Çalışanın yaşını girin:");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Çalışanın maaşını girin:");
            double salary = scanner.nextDouble();
            System.out.println("Çalışanın deneyimini girin:");
            scanner.nextLine();
            String experience = scanner.nextLine();


            Person person = new Person(name, surname, age);
            Employee employee = new Employee(salary, experience, person);

            if (department.addEmployee(employee)) {
                System.out.println("Çalışan başarıyla eklendi.");
            } else {
                System.out.println("Bu departman maksimum çalışan sayısına ulaştı.");
            }
        } else {
            System.out.println("Bu departman bulunamadı.");
        }
    }

    public static void removeEmployeeFromDepartment() {
        System.out.println("Departman numarasını girin:");
        int departmentNo = scanner.nextInt();
        scanner.nextLine();

        Department department = findDepartment(departmentNo);
        if (department != null) {
            System.out.println("Çalışan ID'sini girin:");
            int employeeId = scanner.nextInt();
            scanner.nextLine();

            if (department.removeEmployee(employeeId)) {

                System.out.println("Çalışan başarıyla silindi.");
            } else {
                System.out.println("Bu ID ile bir çalışan bu departmanda bulunamadı.");
            }
        } else {
            System.out.println("Bu departman bulunamadı.");
        }
    }

    public static void displayAllEmployees() {
        System.out.println("Tüm çalışanlar:");
        for (Department department : departments) {
            System.out.println(department.getName() + " departmanındaki çalışanlar:");
            for (Employee employee : department.getEmployees()) {
                if (employee != null) {
                    System.out.println(employee);
                }
            }
        }
    }

    public static void displayEmployeesByDepartment() {
        System.out.println("Departman numarasını girin:");
        int departmentNo = scanner.nextInt();
        scanner.nextLine();

        Department department = findDepartment(departmentNo);
        if (department != null) {
            System.out.println(department.getName() + " departmanındaki çalışanlar:");
            for (Employee employee : department.getEmployees()) {
                if (employee != null) {
                    System.out.println(employee);
                }
            }
        } else {
            System.out.println("Bu departman bulunamadı.");
        }
    }

    public static void searchEmployeeByName() {
        System.out.println("Aranacak çalışanın adını girin:");
        String searchName = scanner.nextLine();

        System.out.println("Aranacak çalışanın soyadını girin:");
        String searchSurname = scanner.nextLine();

        boolean found = false;
        for (Department department : departments) {
            for (Employee employee : department.getEmployees()) {
                if (employee != null && employee.getPerson().getName().equals(searchName) && employee.getPerson().getSurname().equals(searchSurname)) {
                    System.out.println("Aranan çalışan bulundu:");
                    System.out.println(employee);
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("Aranan çalışan bulunamadı.");
        }
    }

    public static void searchEmployeeInDepartment() {
        System.out.println("Departman numarasını girin:");
        int departmentNo = scanner.nextInt();
        scanner.nextLine();

        Department department = findDepartment(departmentNo);
        if (department != null) {
            System.out.println("Aranacak çalışanın adını girin:");
            String searchName = scanner.nextLine();

            System.out.println("Aranacak çalışanın soyadını girin:");
            String searchSurname = scanner.nextLine();

            boolean found = false;
            for (Employee employee : department.getEmployees()) {
                if (employee != null && employee.getPerson().getName().equals(searchName) && employee.getPerson().getSurname().equals(searchSurname)) {
                    System.out.println("Aranan çalışan bulundu:");
                    System.out.println(employee);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Aranan çalışan bulunamadı.");
            }
        } else {
            System.out.println("Bu departman bulunamadı.");
        }
    }

      static Department findDepartment(int departmentNo) {
        for (Department department : departments) {
            if (department.getDepartmentNo() == departmentNo) {
                return department;
            }
        }
        return null;
    }
}
