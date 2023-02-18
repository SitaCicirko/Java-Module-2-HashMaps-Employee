import java.util.*;
import java.lang.*;
import java.io.*;

class Employee{
    String firstName;
    String lastName;
    String peselId;

    public Employee(String firstName, String lastName, String peselId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.peselId = peselId;
    }

    @Override
    public boolean equals(Object o) {
        Employee e = (Employee) o;
        return this.firstName.equals(e.firstName) && this.lastName.equals(e.lastName) && this.peselId.equals(e.peselId);
    }

    @Override
    public int hashCode() {

        return Integer.parseInt(peselId.substring(0, 5));
    }
    public String toString() {
        return firstName + " + " + lastName + " + " +
                peselId;
    }
}
class SalaryParameters {
    Double baseSalary;
    Double regulatedBonus;
    Double chefBonus;
    Double functionAddSalary;

    public SalaryParameters(Double baseSalary, Double regulatedBonus, Double chefBonus, Double functionAddSalary) {
        this.baseSalary = baseSalary;
        this.regulatedBonus = regulatedBonus;
        this.chefBonus = chefBonus;
        this.functionAddSalary = functionAddSalary;
    }

    public String toString() {
        return baseSalary + " + " + regulatedBonus + " + " +
                chefBonus + " + " + functionAddSalary;
    }
}

/* Name of the class has to be "Main" only if the class is public. */
class HashMapTest {

    public static void main (String[] args){
        Employee worker1 = new Employee("Jennifer", "Nowak", "12345678901");
        Employee worker2 = new Employee("Sarah", "Taylor", "12345612345");
        Employee worker3 = new Employee("Laura", "Pinelli", "12345698765");
        Employee worker4 = new Employee("Laura", "Pinelli", "12345045678");

        SalaryParameters params1 = new SalaryParameters(5000.0, 3000.0, 0.0, 0.0);
        SalaryParameters params2 = new SalaryParameters(4000.0, 2000.0, 1000.0, 0.0);
        SalaryParameters params3 = new SalaryParameters(4500.0, 3500.0, 0.0, 0.0);
        SalaryParameters params4 = new SalaryParameters(11000.0, 0.0, 2000.0, 1000.0);

        Map<Employee, SalaryParameters> paymentParameters = new HashMap<>();

        paymentParameters.put(worker1, params1);
        paymentParameters.put(worker2, params2);
        paymentParameters.put(worker3, params3);
        paymentParameters.put(worker4, params4);

        System.out.println("Salary of Jennifer Nowak equals: " + paymentParameters.get(worker1));


       for (Map.Entry<Employee, SalaryParameters> entry : paymentParameters.entrySet()) {
            System.out.println("Employee: " + entry.getKey());
            System.out.println("Salary Parameters: " + entry.getValue());
        }
        System.out.println(paymentParameters.containsKey(worker1));
        System.out.println(paymentParameters.containsValue(params2));
        System.out.println(paymentParameters.keySet());
        System.out.println(paymentParameters.values());

    }
}