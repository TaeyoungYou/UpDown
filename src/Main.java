import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws InterruptedException, IOException{
        Scanner scan = new Scanner(System.in);
        String name;
        boolean stop = false;

        System.out.print("What is your name?");
        name = scan.next();
        Player user = new Player(name);
        UpDown n = new UpDown();

        System.out.format("Hello, %s\n",user.getName());
        System.out.println("Game Start! Guess the number (1~100) - "+user.getName());
        loadingScreen();
        clearScreen();
        while(!stop){

            System.out.println("Game Start! Guess the number (1~100) - "+user.getName());
            System.out.println("-----------------------------------------------------------");
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
            Thread.sleep(1500);
            clearScreen();
        }
        clearScreen();
        System.out.println("Total:");
        System.out.format("\t User Name: %s\n",user.getName());
        System.out.format("\t User Attempt: %d\n",user.getAttempt());
        Thread.sleep(1000);
    }
    public static void clearScreen() throws IOException, InterruptedException{
        new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
    }
    public static void loadingScreen() throws InterruptedException {
        System.out.print("\tLoading");
        for(int i=0;i<5;i++){
            System.out.print("..");
            Thread.sleep(500);
        }
        System.out.println("Start!");
        Thread.sleep(1000);
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