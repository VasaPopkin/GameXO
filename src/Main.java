import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args){

        int i,size, maxCountOfSteps, line, row;
        boolean gmr = true;

        Scanner input=new Scanner(System.in);
        Field gameField;
        System.out.println("input size of game field:");
        size = input.nextInt();
        gameField = new Field(size);
        maxCountOfSteps = size*size;
        gameField.fillField();
        gameField.printField();

        Gamer gamerx;
        Gamer gamer1 = new Gamer();
        Gamer gamer2 = new Gamer();

        System.out.println();
        System.out.println("Gamer 1: ");
        System.out.print("input name: ");
        gamer1.setName(input.next());

        gamer1.setFigure('x');
        gamer2.setFigure('0');

        System.out.println(gamer1.getFigure());
        System.out.println();
        System.out.println("Gamer 2: ");
        System.out.print("input name:");

        gamer2.setName(input.next());

        for (i = 0; i < maxCountOfSteps; i++){
            for (int j = 0; j<30; j++)
            System.out.println();

            if (gmr)
                gamerx = gamer1;
            else
                gamerx = gamer2;

            gameField.printField();
            System.out.println("Gamer " + gamerx.getName());
            System.out.println("input i:");
            line = input.nextInt();
            System.out.println("input j:");
            row = input.nextInt();


            if (gameField.setCell(--line,--row,gamerx.getFigure()))
            {
            gmr = !gmr;
            }
            if (gameField.checkForAWin()){

                System.out.println(gamerx.getName() + "wins!");
                break;
            }


        }

        if (i == maxCountOfSteps){

            gameField.printField();
            System.out.println("Draw");
        }
    }
}
