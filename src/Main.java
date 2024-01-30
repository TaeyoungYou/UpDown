import java.util.Random;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String name;
        boolean stop = false;

        System.out.print("What is your name?");
        name = scan.next();
        Player user = new Player(name);
        UpDown n = new UpDown();

        System.out.println("Game Start! Guess the number (1~100) - "+user.getName());
        System.out.println("-----------------------------------------------------------");
        while(!stop){
            user.addAttempt();
            System.out.format("%d\n\n",user.getAttempt());
            System.out.print("Guess Number: ");
            int num = scan.nextInt();
            if(n.getNumber()==num){
                System.out.println("You get it! The number is "+n.getNumber());
                stop=true;
            }else if(n.getNumber()>num){
                System.out.println("Up");
            }else{
                System.out.println("Down");
            }
            System.out.println("-----------------------------------------------------------");
        }
        System.out.println("Total:");
        System.out.format("\t User Name: %s\n",user.getName());
        System.out.format("\t User Attempt: %d\n",user.getAttempt());
    }
}

class Player{
    private String name;
    private int attempt;

    public Player(String n){
        super();
        this.name=n;
        this.attempt=0;
    }
    public String getName(){
        return this.name;
    }
    public int getAttempt(){
        return this.attempt;
    }
    public void addAttempt(){
        this.attempt++;
    }
}
class UpDown{
    private int number;
    public UpDown(){
        super();
        this.number = new Random().nextInt(1,101);
    }
    public int getNumber(){
        return this.number;
    }
}