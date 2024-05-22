
class Employee {
    private static int idCounter = 1;

    private final int employeeId;
    private final double salary;
    private final String experience;
    private final Person person;

    public Employee(double salary, String experience, Person person) {
        this.employeeId = idCounter++;
        this.salary = salary;
        this.experience = experience;
        this.person = person;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public double getSalary() {
        return salary;
    }

    public String getExperience() {
        return experience;
    }

    public Person getPerson() {
        return person;
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeId + ", Name: " + person.getName() + ", Surname: " + person.getSurname() + ", Age: " + person.getAge() + ", Salary: " + getSalary() + ", Experience: " + getExperience();
    }
}