import java.util.Random;

public class Car implements Runnable {
    private String name;
    public Car(String name){
        this.name = name;
    }
    @Override
    public void run() {
        int runDistance = 0;
        long startTime = System.currentTimeMillis();
         while (runDistance < Main.DISTANCE){

             try {
                 // Random Speed KM/H
                 int speed = (new Random()).nextInt(20);
                 // Calculate traveled distance
                 runDistance += speed;
                 // Build result graphic
                 String log = "|";
                 int percentTravel = (runDistance * 100) / Main.DISTANCE;
                 for (int i = 0; i < Main.DISTANCE; i += Main.STEP) {
                     if (percentTravel >= i + Main.STEP) {
                         log += "=";
                     } else if (percentTravel >= i && percentTravel < i + Main.STEP) {
                         log += "o";
                     } else {
                         log += "-";
                     }
                 }
                 log += "|";
                 System.out.println("Car" + this.name + ": " + log + " " + Math.min(Main.DISTANCE, runDistance) + "KM");
                 Thread.sleep(1000);
             } catch (InterruptedException e) {
                 System.out.println("Car" + this.name + " broken...");
                 break;
             }
         }
        long endTime = System.currentTimeMillis();
        System.out.println("Car" + this.name + " Finish in " + (endTime - startTime) / 1000 + "s");

         }
    }


class Main{
    public static int DISTANCE = 1000;
    public static int STEP = 200;

    public static void main(String[] args) {
        Car carA = new Car("A");
        Car carB = new Car("B");
        Car carC = new Car("C");
        Car carD = new Car("D");

        Thread thread1 = new Thread(carA);
        Thread thread2 = new Thread(carB);
        Thread thread3 = new Thread(carC);
        Thread thread4 = new Thread(carD);

        System.out.println("Distance:100");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
    }
