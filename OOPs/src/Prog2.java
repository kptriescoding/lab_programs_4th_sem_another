import java.util.Scanner;

class Address {
    public int Street_num;
    public String City, State, Country;

    public Address(int street_num, String city, String state, String country) {
        this.Street_num=street_num;
        this.City=city;
        this.Country=country;
        this.State=state;
    }
}

class Student {
    String USN, Name;
    Address addr;

    Student(String USN, String Name, Address addr) {
        this.USN = USN;
        this.Name = Name;
        this.addr = addr;
    }

    public void display() {
        System.out.printf("%20s%20s%20s%20s%20s%20s\n",USN,Name,addr.Street_num,addr.City,addr.State,addr.Country);
    }
}

class College {
    String Name;
    Address addr;

    College(String Name, Address addr) {
        this.Name = Name;
        this.addr = addr;
    }
    public void display() {
        System.out.printf("%20s%20s%20s%20s%20s\n",Name,addr.Street_num,addr.City,addr.State,addr.Country);
    }
}

class Employee {
    String EmpID, Name;
    Address addr;

    Employee(String EmpID, String Name, Address addr) {
        this.EmpID = EmpID;
        this.Name = Name;
        this.addr = addr;
    }
    public void display() {
        System.out.printf("%20s%20s%20s%20s%20s%20s\n",EmpID,Name,addr.Street_num,addr.City,addr.State,addr.Country);
    }
}

public class Prog2 {
    static Scanner sc=new Scanner(System.in);
    public static Address getAddress() {
        int Street_num;
        String City,State,Country;
        System.out.println("Enter the Street Number");
        Street_num=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the City");
        City=sc.nextLine();
        System.out.println("Enter the State");
        State=sc.nextLine();
        System.out.println("Enter the Country");
        Country=sc.nextLine();
        return new Address(Street_num,City,State,Country);
    }
    public static Student[] getStudent() {
        int n;
        System.out.println("Enter the Number of Students");
        n= sc.nextInt();
        sc.nextLine();
        Student[] st=new Student[n];
        String USN,Name;
        System.out.println("Enter the Student Details");
        for(int i=0;i<n;i++) {
            System.out.printf("Enter the Student %d USN\n", i + 1);
            USN = sc.nextLine();
            System.out.printf("Enter the Student %d Name\n", i + 1);
            Name = sc.nextLine();
            System.out.printf("Enter the Student %d Address details\n",i+1);
            Address addr=getAddress();
            st[i]=new Student(USN,Name,addr);
        }
        return st;
    }
    public static College[] getCollege() {
        int n;
        System.out.println("Enter the Number of Colleges");
        n= sc.nextInt();
        sc.nextLine();
        College[] co=new College[n];
        String Name;
        System.out.println("Enter the College Details");
        for(int i=0;i<n;i++) {
            System.out.printf("Enter the College %d Name\n", i + 1);
            Name = sc.nextLine();
            System.out.printf("Enter the College %d Address details\n",i+1);
            Address addr=getAddress();
            co[i]=new College(Name,addr);
        }
        return co;
    }
    public static Employee[] getEmployee() {
        int n;
        System.out.println("Enter the Number of Employees");
        n= sc.nextInt();
        sc.nextLine();
        Employee[] em=new Employee[n];
        String EmpID,Name;
        System.out.println("Enter the Employee Details");
        for(int i=0;i<n;i++) {
            System.out.printf("Enter the Employee %d EmpID\n", i + 1);
            EmpID = sc.nextLine();
            System.out.printf("Enter the Employee %d Name\n", i + 1);
            Name = sc.nextLine();
            System.out.printf("Enter the Employee %d Address details\n",i+1);
            Address addr=getAddress();
            em[i]= new Employee(EmpID,Name,addr);
        }
        return em;
    }
    public static void printStudent(Student[] st){
        System.out.println("The Student Details are");
        System.out.printf("%20s%20s%20s%20s%20s%20s\n","USN","Name","Street_num","City","State","Country");
        for (Student student : st) {
            student.display();
        }
    }
    public static void printCollege(College[] co){
        System.out.println("The College Details are");
        System.out.printf("%20s%20s%20s%20s%20s\n","Name","Street_num","City","State","Country");
        for (College college : co) {
            college.display();
        }
    }
    public static void printEmployee(Employee[] em){
        System.out.println("The Employee Details are");
        System.out.printf("%20s%20s%20s%20s%20s%20s\n","EmpID","Name","Street_num","City","State","Country");
        for (Employee employee : em) {
            employee.display();
        }
    }
    public static void main(String[] args) {
        Student[] st_array=getStudent();
        College[] col_array=getCollege();
        Employee[] emp_array=getEmployee();
        printStudent(st_array);
        printCollege(col_array);
        printEmployee(emp_array);
    }
}
