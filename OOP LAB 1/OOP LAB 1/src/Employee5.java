public class Employee5 {
    double pay= 3000;
    double calculatePay(){return pay;}
}
class Manager extends Employee5{
    @Override
    double calculatePay(){ return pay+ 1500;}
}
class Intern extends Employee5{  // the new class
    @Override
    double calculatePay(){return  800;}
}
class Payroll {
    public static void main(String[] args) {
        Employee5[] staff = {new Employee5(), new Manager(), new Intern()};

        double total = 0;
        for (Employee5 e : staff) { // loop never mentions Intern
            total += e.calculatePay();
        }

        System.out.println("Total payroll: " + total);  // 9300.0

    }
}
