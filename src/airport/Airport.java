/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author vinay
 */
public class Airport {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        PassengerQueue mq = new PassengerQueue();
        Scanner input = new Scanner(System.in);

        Passenger PassengerArray[] = new Passenger[30];
        for (int a = 0; a < PassengerArray.length; a++) {
            PassengerArray[a] = new Passenger();
        }

        String menu;
        do {
            System.out.println("Enter A to add to Queue");
            System.out.println("Enter V to View the Queue");
            System.out.println("Enter D to Delete the first customer from the queue");
            System.out.println("Enter Q to Exit");
            menu = input.next();
            switch (menu) {
                case "A":
                    mq.addqueue();
                    break;
                case "V":
                    mq.Viewqueue();
                    break;
                case "D":
                    mq.Deletequeue();
                    break;
                case "L":
                    mq.LoadQueue();
                    break;
                case "S":
                    mq.SaveQueue();
                    break;
                case "R":
                    Running(PassengerArray, mq);
                    break;
            }
        } while (!"Q".equals(menu));
    }

    public static void Running(Passenger[] PassengerArray, PassengerQueue mq) throws FileNotFoundException {
        int linecount = 0;
        System.out.println("Input file name: ");
        String inputFileName = "passengers.dat";//console.next();
        String fileLine;
        String fileLine1;
        Scanner in = new Scanner(new File(inputFileName));
        int count1 = 0;
        while (in.hasNext()) {
            fileLine = in.next();
            PassengerArray[linecount].setFirstName(fileLine);
            fileLine1 = in.next();
            PassengerArray[linecount].setSurName(fileLine1);
            System.out.println(linecount + " " + PassengerArray[linecount].getFirstName() + " " + PassengerArray[linecount].getSurName());
            linecount++;
        }
        in.close();
        System.out.println("--------------------------------------");
        int NumberOfPeople = 0;
        NumberOfPeople = D6();

        int TotalPeople = 0;
        if (TotalPeople > 27) {
            NumberOfPeople = 1;
        }
        
        System.out.println("Number Of People: " + NumberOfPeople);
        int linecount2 = 0;
        int linecount1 = 0;
        int Delay = 0;
        while (TotalPeople < 31) {
            int count = 0;

            while (count < NumberOfPeople) {

                String fn = PassengerArray[linecount1].getFirstName();
                String fn1 = PassengerArray[linecount1].getSurName();
                //mq.qitems[count].setFirstName(PassengerArray[linecount1].getFirstName());
                //mq.qitems[count].setSurName(PassengerArray[linecount1].getSurName());
                mq.addqueue(fn, fn1);
                //System.out.println(mq.qitems[linecount1].getFirstName() + " " + mq.qitems[linecount1].getSurName());
                linecount1++;
                count++;
            }
            System.out.println("--------------------------------------");
            int whiteDie, redDie, blueDie, sum = 0;
            int totalDelay = 0;
            count = 0;
            while (count < NumberOfPeople) {
                whiteDie = D6();
                redDie = D6();
                blueDie = D6();
                sum = whiteDie + redDie + blueDie;
//                System.out.println(mq.qitems[count1].getFirstName() + " " + mq.qitems[count1].getSurName());
                mq.Viewqueue();
                System.out.println("Individual Passengers waiting time was: " + sum + " Sec");

                totalDelay = totalDelay + sum;
                System.out.println("This Passengers waiting time was: " + totalDelay + " Sec");
                mq.Deletequeue();
                count++;
            }
            System.out.println("--------------------------------------");
            System.out.println("The Total Delay Was: " + totalDelay + " Sec");
            System.out.println("--------------------------------------");

            Delay = Delay + totalDelay;

            String outputFileName = "Report.dat";
            try (PrintWriter outputFile = new PrintWriter(outputFileName)) {
                outputFile.println("The Passengers List: ");
                for (int j = 0; j < PassengerArray.length; j++) {
                    outputFile.println(PassengerArray[j].getFirstName() + " " + PassengerArray[j].getSurName());
                }
                outputFile.println("------------------------------------");
                outputFile.println("The Total Number Of People: " + TotalPeople);
                outputFile.println("The maximum waiting time: " + Delay + " Sec");
                outputFile.println("The Average waiting time: " + Delay / 30 + " Sec");
            }

            if (count1 >= 20) {
                count1 = 0;
            }
            TotalPeople = TotalPeople + NumberOfPeople;
        }
        
    }

    public static int D6() {
        return (int) (1 + 6 * Math.random());
    }

}
