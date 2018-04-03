/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author vinay
 */
public class PassengerQueue {

    int count = 0;
    Passenger qitems[];
    int front = 0;
    int end = 0;

    public PassengerQueue() {
        this.qitems = new Passenger[20];
        for (int a = 0; a < qitems.length; a++) {
            qitems[a] = new Passenger();
            qitems[a].setFirstName(" ");
            qitems[a].setSurName(" ");
        }
    }

    void addqueue() {
        String name;
        String Surname;

        Scanner input = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        if (count <= qitems.length) {
            System.out.println("Enter Queue Items:");

            System.out.println("First Name:");
            name = input.next();
            qitems[end].setFirstName(name);

            System.out.println("SurName:");
            Surname = in.next();
            qitems[end].setSurName(Surname);

            System.out.println(count + ". " + qitems[end].getFirstName() + " " + qitems[end].getSurName());
            end = (end + 1) % qitems.length;
            count++;
        } else {
            System.out.println("The Queue is full");
        }
    }

    void addqueue(String Name, String Surname) {

        if (count <= qitems.length) {
            qitems[end].setFirstName(Name);
            qitems[end].setSurName(Surname);
            System.out.println(end + ". " + qitems[end].getFirstName() + " " + qitems[end].getSurName());
            end = (end + 1) % qitems.length;
            count++;

        } else {
            System.out.println("The Queue is full");
        }
    }

    void Viewqueue() {
        System.out.println("Count: " + count);
        System.out.println("Front position: " + front);
        System.out.println("End position: " + end);

        for (int a = 0; a < qitems.length; a++) {
            if (!qitems[a].FirstName.contentEquals(" ")) {
                System.out.println(qitems[a].getFirstName() + " " + qitems[a].getSurName());
            }
        }
    }

    void Deletequeue() {
        if (count != 0) {
            System.out.println("Item taken :" + qitems[front].getFirstName() + " " + qitems[front].getSurName());
            qitems[front].setFirstName(" ");
            qitems[front].setSurName(" ");
            front = (front + 1) % qitems.length;
            count--;
        } else {
            System.out.println("Empty queue");
        }
    }

    void LoadQueue() throws FileNotFoundException {
        Scanner console = new Scanner(System.in);

        int linecount = 0;
        System.out.println("Input file name: ");
        String inputFileName = console.next();

        String fileLine;
        String fileLine1;
        Scanner in = new Scanner(new File(inputFileName));
        while (in.hasNext()) {
            fileLine = in.next();
            qitems[linecount].setFirstName(fileLine);
            fileLine1 = in.next();
            qitems[linecount].setSurName(fileLine1);
            System.out.println(linecount + " " + fileLine + " " + fileLine1);
            linecount++;
        }
        in.close();
    }

    void SaveQueue() throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        System.out.println("Output file: ");
        String outputFileName = console.next();
        try (PrintWriter outputFile = new PrintWriter(outputFileName)) {
            for (int j = 0; j < qitems.length; j++) {
                outputFile.println(qitems[j].getFirstName() + " " + qitems[j].getSurName());
            }
        }
    }

}
