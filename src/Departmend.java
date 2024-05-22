class  Department {
    private static int departmentCounter = 1;

    private final int departmentNo;
    private final String name;
    private final int employeeCount;
    private final Employee[] employees;

    public  Department(String name, int employeeCount) {
        this.departmentNo = departmentCounter++;
        this.name = name;
        this.employeeCount = employeeCount;
        this.employees = new Employee[employeeCount];
    }

    public int getDepartmentNo() {
        return departmentNo;
    }

    public String getName() {
        return name;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public boolean addEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                return true;
            }
        }
        return false;
    }

    public boolean removeEmployee(int employeeId) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getEmployeeId() == employeeId) {
                employees[i] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Department No: " + departmentNo + ", Name: " + name + ", Employee Count: " + employeeCount;
    }
}

