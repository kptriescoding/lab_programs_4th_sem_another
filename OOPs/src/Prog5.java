import java.util.Scanner;

interface Animal{
    void eat();
    void sound();
}
class Snake implements TiredAnimal{
    int length;
    boolean isTired;
    Snake(int length){
        this.length=length;
    }
    public void eat() {
        System.out.println("Eats rabbits");
    }

    public void sound() {
        System.out.println("Hissss");
    }

    public void getLength() {
        System.out.println("Length is "+length);
    }
    public void becomesTired(){
        isTired=true;
    }
    public void Sleep() {
        if(isTired) System.out.println("Goes to sleep");
        else System.out.println("Is Hungry");
    }
}
interface TiredAnimal extends Animal{
    void Sleep();
    void becomesTired();
}
class Lion implements Animal{
    String gender;
    Lion(String gender){
        this.gender=gender;
    }
    public void checkGender() {
        System.out.println("Gender is "+gender);
    }
    public void eat() {
        System.out.println("Eats deer");
    }

    public void sound() {
        System.out.println("Roar");
    }
}
public class Prog5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Lion Class");
        System.out.println("Enter Gender");
        String gender=sc.nextLine();
        Lion l=new Lion(gender);
        l.checkGender();
        l.eat();
        l.sound();
        System.out.println("Snake Class");
        System.out.println("Enter Length");
        int length=sc.nextInt();
        Snake s=new Snake(length);
        s.getLength();
        s.Sleep();
        s.eat();
        s.sound();
        s.becomesTired();
        s.Sleep();
    }
}
