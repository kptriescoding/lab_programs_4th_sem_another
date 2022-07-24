import java.util.Scanner;

class Market{
   int ttfruitNumber, fruitNumber=0;
   ArrayList<String> fruits=new ArrayList<>();
  String[] farmerFruit={"Apple","Orange","Mango","Grapes","Banana"};
  boolean hasStarted=true;
   Thread t1=new Thread();
   Thread t2=new Thread();
   Random r= new Random();
   public Market(int fruitNumber) {
       ttfruitNumber = fruitNumber;
   }
   public void start() throws InterruptedException {
       t1.start();
       t2.start();
      if(hasStarted)
      {
          hasStarted=false;
          while(true)farmer(farmerFruit[r.nextInt(5)]);
      }
       else while(true)consumer();
   }

   synchronized boolean isFull() {
       return ( fruitNumber == ttfruitNumber );
   }

   synchronized boolean isEmpty() {
       return( fruitNumber == 0 );
   }

   synchronized void farmer(String fruit) throws InterruptedException {

       if ( isFull() ) {
           System.out.println("Waiting for consumer to consume");
           wait();
       } else {
           System.out.println("Farmer produces " + fruit);
           fruits.add(fruit);
           fruitNumber++;
       }

   }

   synchronized void consumer() throws InterruptedException {
       if ( isEmpty() ) {
           System.out.println("Waiting for farmer to produce");
           wait();
       } else {
           System.out.println("Consumer consumes " + fruits.get(0));
           fruits.remove(0);
            fruitNumber--;
       }

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