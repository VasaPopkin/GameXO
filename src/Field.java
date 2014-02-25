
public class Field {

    private static final int DEFAULT_FIELD_SIZE = 3;

    public static final int MIN_FIELD_SIZE = DEFAULT_FIELD_SIZE;

    public static final int MAX_FIELD_SIZE = 10;

    public static final int LENGTH_OF_SEQUENCE = 3;

    private static final char DEFAULT_CELL_VAL = ' ';

    private int fieldSize;

    private final char[][] field;

    public Field(){
        this(DEFAULT_FIELD_SIZE);
    }

    public Field(int size){
        if (size > MAX_FIELD_SIZE || size < MIN_FIELD_SIZE)
            fieldSize = DEFAULT_FIELD_SIZE;
        else
        fieldSize = size;
        field = new char[fieldSize][fieldSize];
    }

    public void fillField(){
        for (int i=0; i < fieldSize; i++)
            for (int j=0; j < fieldSize; j++)
                field[i][j] = DEFAULT_CELL_VAL;

    }

    public void printField(){

        for (int i = 0; i < fieldSize; i++)
            System.out.print("    " + (i + 1));
        System.out.println();

        for (int i = 0; i < fieldSize; i++){
            System.out.print(i + 1 + " |");
            for (int j = 0; j < fieldSize; j++){
                System.out.print(" "+field[i][j] + " | ");
            }
            System.out.println();
        }

        System.out.println();
    }

    public boolean setCell(int i,int j,char gamerFigure){
        if (field[i][j]==' ')
        {
            field[i][j] = gamerFigure;
            return true;
        }
        else
        {
            System.out.println("This cell is already chosen");
            return false;
        }
    }

    public boolean findHorizontalSequence(){
        boolean a = false;

        for (int i=0; i<fieldSize; i++)
            for (int j=0; j <= fieldSize - LENGTH_OF_SEQUENCE; j++)

                if ((field[i][j] == field[i][j+1])&&(field[i][j] == field[i][j+2])&&(field[i][j]!=' '))
                    a=true;
        return a;
    }

    public boolean findVerticalSequence(){
        boolean a=false;

        for (int j=0; j < fieldSize; j++)
            for (int i=0; i <= fieldSize - LENGTH_OF_SEQUENCE; i++)

                if ((field[i][j] == field[i+1][j])&&(field[i][j] == field[i+2][j])&&(field[i][j]!=' '))
                    a=true;
        return a;
    }

    public boolean findDiagonalSequence1(){
        boolean a=false;

        for (int i=0; i <= fieldSize - LENGTH_OF_SEQUENCE; i++)
            for (int j=0; j <= fieldSize - LENGTH_OF_SEQUENCE; j++)

                if ((field[i][j] == field[i+1][j+1])&&(field[i][j] == field[i+2][j+2])&&(field[i][j]!=' '))
                    a=true;
        return a;
    }

    public boolean findDiagonalSequence2(){
        boolean a=false;

        for (int i=0; i <= fieldSize - LENGTH_OF_SEQUENCE; i++)
            for (int j=2; j < fieldSize; j++)

                if ((field[i][j] == field[i+1][j-1])&&(field[i][j] == field[i+2][j-2])&&(field[i][j]!=' '))
                    a=true;
        return a;
    }
    public boolean checkForAWin(){

        boolean a = false;
        if(findHorizontalSequence() || findVerticalSequence() || findDiagonalSequence1() || findDiagonalSequence2()){

            a = true;

        }
        return a;
    }

    public char getCell(int i, int j){

        return field[i][j];

    }

}
