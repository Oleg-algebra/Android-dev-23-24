import java.util.Objects;



public class Main {
    private  class  Employee1{
        private String firstName;
        private String lastName;
        private String position;

        public Employee1(String firstName, String lastName, String position) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.position = position;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee1 employee = (Employee1) o;
            return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(position, employee.position);
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstName, lastName, position);
        }
    }

    public static void main(String[] args) {
        Employee employee = new Employee("Jack","Oneel","CEO");
        employee.hashCode();
        String text = "dhkfgd";
        text.hashCode();
    }
}
