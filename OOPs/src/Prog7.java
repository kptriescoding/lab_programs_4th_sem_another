import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Market{
    public void runf() {
        try {
            while (true) farmer(farmerFruit[r.nextInt(5)]);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void runc(){
        try {
            while (true) consumer();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
   int ttfruitNumber, fruitNumber=0;
   ArrayList<String> fruits=new ArrayList<>();
  String[] farmerFruit={"Apple","Orange","Mango","Grapes","Banana"};
  boolean fwait=false,cwait=false;
   Thread t1=new Thread(this::runf);
   Thread t2=new Thread(this::runc);
   Random r= new Random();
   public Market(int fruitNumber) {
       ttfruitNumber = fruitNumber;
   }
   public void start() throws InterruptedException {
       t1.start();
       t2.start();
   }

   synchronized boolean isFull() {
       return ( fruitNumber == ttfruitNumber );
   }

   synchronized boolean isEmpty() {
       return( fruitNumber == 0 );
   }

   synchronized void farmer(String fruit) throws InterruptedException {

       if ( isFull() ) {
          if(!fwait) System.out.println("Waiting for consumer to consume");
           fwait=true;
       } else {
           fwait=false;
           System.out.println("Farmer produces " + fruit);
           fruits.add(fruit);
           fruitNumber++;
       }
       Thread.sleep(500);

   }

   synchronized void consumer() throws InterruptedException {
       if ( isEmpty() ) {
           if(!cwait)System.out.println("Waiting for farmer to produce");
           Thread.sleep(1);
           cwait=true;
       } else {
           cwait=false;
           System.out.println("Consumer consumes " + fruits.get(0));
           fruits.remove(0);
            fruitNumber--;
       }
       Thread.sleep(500);
   }
}
public class Prog7 {
   public static void main(String[] args) throws InterruptedException {
       int fruitCapacity;
       Scanner sc= new Scanner(System.in);
       System.out.println("Enter Capacity of Farmer");
       fruitCapacity=sc.nextInt();
       Market m=new Market(fruitCapacity);
       m.start();
   }
}