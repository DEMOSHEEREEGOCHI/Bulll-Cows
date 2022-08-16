package com.company;

import java.util.Scanner;

public class Game {
    static int tryCount; //текущее кол-во попыток
    int goal; //целевое число
    int attempt; //число которое вводит игрок
    int bullCount=0;
    int cowCount=0;
    static int goals[] = new int[4];
    int attempts[] = new int[4];
    final int COUNTCAP = 10;
    Scanner playturn = new Scanner(System.in);


    public void start(){
        tryCount = 0;
        goal = (int)(Math.random()*10000);
        int bla = goal;
        for (int i = 3; i > -1; i--) {
            goals[i] = bla%10;
            bla/=10;
        }
    }

    public void turn(){
        while (true){
            tryCount++;
            System.out.println("enter the number");
            this.attempt = playturn.nextInt();

            System.out.println(attempt);
            for (int i = 3; i > -1; i--) {
                attempts[i] = attempt%10;
                if (attempts[i] == goals[i]) bullCount++;
                else
                    for (int j = 3; j > -1; j--) {
                        if (attempts[i]==goals[j]) {cowCount++; break;}
                    }
                attempt/=10;
            }

            if (bullCount==4) {
                this.finish(true);
                break;
            }
            if (tryCount==COUNTCAP) {
                this.finish(false);
                break;
            }
            System.out.println("b:"+bullCount+" "+"c:"+cowCount);
            bullCount=0;
            cowCount=0;

        }
    }

    public void finish(boolean result){
        if (result) System.out.println("Congratulations!"+"\nTotal count:"+ tryCount);
        else System.out.println("You lose!");

    }
}
