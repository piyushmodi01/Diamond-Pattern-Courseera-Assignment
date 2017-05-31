package mooc.vandy.java4android.diamonds.logic;

import android.util.Log;
import mooc.vandy.java4android.diamonds.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
       implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    public void process(int size) {

        // TODO -- add your code here
        this.printHorizontalBorder(size);
        mOut.print("\n");
        this.printTopTriangle(size);
        this.printMiddleLine(size);

        this.printBottomTriangle(size);
        this.printHorizontalBorder(size);

    }



    public void printHorizontalBorder(int size){


        mOut.print("+");
        for(int i = 1;i<=(size*2);i++)
            mOut.print("-");

        mOut.print("+");

    }




    String printSymbol="=";


    public void printTopTriangle(int size){

        printSymbol="=";   //Reseting the Symbol Value to =


        int width=(size*2)+2;
        int widthConsumed;



        for (int i=1; i<=(size-1);i++){
            //Top Most Loop
            widthConsumed=0;

            mOut.print("|"); widthConsumed++;

            //loop for topLeft Spaces
            for(int j=size-1; j>=i; j--){

                mOut.print(" ");
                widthConsumed++;

            }


            //lop for triangle Print

            mOut.print("/"); widthConsumed++;

            //checking remaining spaces left in total width
            int remaining_width=width-(widthConsumed*2);
            for(int j=1; j<=remaining_width;j++){
                mOut.print(printSymbol);
                widthConsumed++;
            }

            if(printSymbol.equals("-"))
                printSymbol="=";
            else if(printSymbol.equals("="))
                printSymbol="-";


            mOut.print("\\");

            //Remaining Spaces printing
            for(int j=size-1; j>=i; j--){

                mOut.print(" ");
                widthConsumed++;

            }

            mOut.println("|"); widthConsumed++;



        }





    }


    public void printMiddleLine(int size){
        mOut.print("|<");
        for(int i=1;i<=(size*2)-2;i++){
            mOut.print(printSymbol);
        }

        if(printSymbol.equals("-"))
            printSymbol="=";
        else if(printSymbol.equals("="))
            printSymbol="-";

        mOut.println(">|");

    }


    public void printBottomTriangle(int size){

        int width=(size*2)+2;
        int widthConsumed;

        for (int i=(size-1); i>=1;i--){
            //Top Most Loop
            widthConsumed=0;

            mOut.print("|"); widthConsumed++;


            //bottomLeft Spaces
            for(int j=size;j>i;j--){
                mOut.print(" "); widthConsumed++;
            }

            //Bottom Triangle
            mOut.print("\\"); widthConsumed++;;
            int remainingSpace=width-(widthConsumed*2);
            for(int k=1;k<=remainingSpace;k++){
                mOut.print(printSymbol); widthConsumed++;
            }

            if(printSymbol.equals("-"))
                printSymbol="=";
            else
                printSymbol="-";


            mOut.print("/"); widthConsumed++;;


            //bottomRight Spaces
            //bottomLeft Spaces
            for(int j=size;j>i;j--){
                mOut.print(" "); widthConsumed++;
            }


            mOut.println("|"); widthConsumed++;



        }





    }
}
