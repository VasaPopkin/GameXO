
public class Comp extends Gamer {

    public  Comp(){

        setName("Computer");

    }

    @Override
    public  int[] setCell(Field field){

        int[] cellCoords = new int[2];

        cellCoords = findWinSequence(field, getFigure());
            if (cellCoords[0] == -1)
            {
                cellCoords = findDrawSequence(field);

                if (cellCoords[0] == -1)
                    cellCoords = findFineSequence(field);
            }

        ++cellCoords[0];
        ++cellCoords[1];
        return cellCoords;


    }

    private int[] findWinSequence(Field field, char fig){

        int i, j, fieldSize = field.getSize();

        int[] cellCoord = new int[2];
        char emptyCell = ' ';

        cellCoord[0] = -1;
        cellCoord[1] = cellCoord[0];

        for (i = 0; i < fieldSize; i++){

            for (j =0; j < fieldSize; j++){

                if (field.getField()[i][j] == emptyCell){

                    field.setCell(i, j, fig);
                    if (field.checkForAWin()){

                        field.setEmptyCell(i, j);
                        cellCoord[0] = i;
                        cellCoord[1] = j;
                        break;
                    }
                    field.setEmptyCell(i, j);

                }

            }
            if (j < fieldSize)
                break;

        }

        return cellCoord;
    }

    private int[] findDrawSequence(Field field){

        return findWinSequence(field, getOpponentFigure());

    }

    private int[] findFineSequence(Field field){

        int[] cellcoord = new int[2];
        cellcoord[0] = -1;
        cellcoord[1] = cellcoord[0];

        for (int i = 0; i < field.getSize(); i++)
            for (int j = 0; j < field.getSize(); j++)

                if(field.getCell(i, j) == ' '){
                    cellcoord[0] = i;
                    cellcoord[1] = j;
                }

        return cellcoord;
    }

    private char getOpponentFigure(){

        if (getFigure() == 'x')
        {
            System.out.println('o');
            return 'o';
        }
        System.out.println('x');
        return 'x';

    }
}
