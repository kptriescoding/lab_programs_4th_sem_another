import java.util.*;
class Farmer implements Runnable{
    Market m;
    int capacity;
    Thread t;
    Random r= new Random();
    public  Farmer(Market m,int capacity){
        this.m=m;
        this.capacity=capacity;
        t=new Thread(this,"Farmer Thread");
    }
    public void run() {
        try{
            while (capacity!=0)
                capacity=m.farmer(m.farmerFruit[r.nextInt(5)],capacity);
        }
        catch (Exception e){
            System.out.println(""+e);
        }
    }
}
class Consumer implements Runnable{
    Market m;
    int capacity;
    Thread t;
    public Consumer(Market m,int capacity){
        this.m=m;
        this.capacity=capacity;
        t=new Thread(this,"Consumer Thread");
    }
    public void run() {
        try{
            while (capacity!=0)
                capacity=m.consumer(capacity);
        }
        catch (Exception e){
            System.out.println(""+e);
        }
    }
}
class Market{
    int ttfruitNumber, fruitNumber=0;
    ArrayList<String> fruits=new ArrayList<>();
    String[] farmerFruit={"Apple","Orange","Mango","Grapes","Banana"};
    public Market(int fruitNumber) {
        ttfruitNumber = fruitNumber;
    }

    synchronized boolean isFull() {
        return ( fruitNumber == ttfruitNumber );
    }

    synchronized boolean isEmpty() {
        return( fruitNumber == 0 );
    }

    synchronized int farmer(String fruit,int capacity) throws InterruptedException {

        if ( isFull() ) {
            System.out.println("Waiting for consumer to consume");
            wait();
        } else {
            System.out.println("Farmer produces " + fruit);
            fruits.add(fruit);
            fruitNumber++;
            capacity--;
            notify();
            if(capacity==0)System.out.println("Farmer finished Producing");
        }
        Thread.sleep(500);
        return capacity;
    }

    synchronized int consumer(int capacity) throws InterruptedException {
        if ( isEmpty() ) {
            System.out.println("Waiting for farmer to produce");
            wait();
        } else {
            System.out.println("Consumer consumes " + fruits.get(0));
            fruits.remove(0);
            fruitNumber--;
            capacity--;
            if(capacity==0)System.out.println("Consumer finished consuming");
            notify();
        }
        Thread.sleep(500);
        return capacity;
    }
}
public class Prog7 {
    public static void main(String[] args) throws InterruptedException {
        int fruitCapacity,capacity;
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter Capacity of Farmer");
        fruitCapacity=sc.nextInt();
        System.out.println("Enter the Total Producing Capacity of the Farmer");
        capacity=sc.nextInt();
        Market m=new Market(fruitCapacity);
        Farmer f=new Farmer(m,capacity);
        Consumer c=new Consumer(m,capacity);
        f.t.start();
        c.t.start();
    }
}

