import java.util.Scanner;

class DemonetizationExeption extends Exception{
    int balance;
    DemonetizationExeption(int balance){
        this.balance=balance;
    }
    public String toString(){
        return "Deposit of Old currency of (Rs"+balance+") crosses Rs. 5,000 and cannot be Deposited";
    }
}
class Account{
    private int balance;
    public Account(){
        balance=500;
    }

    public void deposit(int amount,String currencyType){
        try{
            if(currencyType.equals("OLD")&&amount>5000)throw new DemonetizationExeption(amount);
            balance+=amount;
            System.out.println("Rs. "+amount+" Deposited");
        }
        catch (DemonetizationExeption e){
            System.out.println(""+e);
        }
    }
    public void withdraw(int amount){
        if(balance<amount+500)
            System.out.println("Balance Insufficient");
        else {
            balance -= amount;
            System.out.println("Rs. " + amount + " Withdrawn");
        }
    }
    public void currBalance(){
        System.out.println("Current Balance is "+balance);
    }
}
public class Prog6 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Account ac=new Account();
        int ch=0;
        int currencyType,amount;
        System.out.println("What would you like to do\n1. Deposit\n2. Withdraw\n3. Check Current Balance\n4. Exit");
        while(ch!=4){
            System.out.println("Enter choice");
            ch= sc.nextInt();
            switch (ch){
                case 1:
                    System.out.println("Is the currency type new(1) or old(0)");
                    currencyType= sc.nextInt();
                    System.out.println("Enter the amount to be deposited");
                    amount= sc.nextInt();
                    if(currencyType==0)ac.deposit(amount,"OLD");
                    else ac.deposit(amount,"NEW");
                    break;
                case 2:
                    System.out.println("Enter the amount to be withdrawn");
                    amount= sc.nextInt();
                    ac.withdraw(amount);
                    break;
                case 3:
                    ac.currBalance();
                    break;
                case 4:
                    System.out.println("Exited Successfully");
                    break;
                default:
                    System.out.println("Invalid Input!!!");
            }
        }
    }
}
