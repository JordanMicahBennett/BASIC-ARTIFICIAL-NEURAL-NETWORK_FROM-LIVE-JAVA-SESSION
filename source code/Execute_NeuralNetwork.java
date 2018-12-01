//This is where the neural network will be trained, tested, and executed
import java.util.ArrayList;
import java.util.Scanner;


public class Execute_NeuralNetwork
{
    //features
    static Scanner scanner = new Scanner ( System.in );
    static NeuralNetwork neuralNetwork = new NeuralNetwork ( );
    
    
    public static void main ( String [ ] stuff )
    {
        trainNeuralNetwork ( );
        testNeuralNetwork ( );
    }
    
    
    public static void trainNeuralNetwork ( )
    {
        for ( int tI = 0; tI < getTrainingSpace ( ).size ( ); tI ++ )
        {
            //do forward propagation on the input signals
            String [ ] eachTrainingSpace = getTrainingSpace ( ).get ( tI ).split ( ":" );
            int firstPartOfInput = Integer.parseInt ( eachTrainingSpace [ 0 ].split ( "," ) [ 0 ] );
            int secondPartOfInput = Integer.parseInt ( eachTrainingSpace [ 0 ].split ( "," ) [ 1 ] );
            int [ ] inputs = new int [ ] { firstPartOfInput, secondPartOfInput };
            neuralNetwork.doForwardPropagation ( inputs );
            
            
            //do backward propagation on the label or target
            int eachLabel = Integer.parseInt ( getTrainingSpace ( ).get ( tI ).split ( ":" ) [ 1 ] );
            neuralNetwork.doBackwardPropagation ( eachLabel );
        }
    }
    
    public static void testNeuralNetwork ( )
    {
        System.out.println ( "Welcome to basic neural network by Jordan Bennett" );
        System.out.println ( "1. Make neural net guess what ouput should be for input 1, 1" );
        System.out.println ( "2. Make neural net guess what ouput should be for input 0, 1" );
        System.out.println ( "3. Make neural net guess what ouput should be for input 1, 0" );
        System.out.println ( "4. Make neural net guess what ouput should be for input 0, 0" );
        System.out.println ( "5. Exit program." );
        
        int input = Integer.parseInt ( scanner.nextLine ( ) );
        
        switch ( input )
        {
            case 1:
            {
                int [ ] inputs = new int [ ] { 1, 1 };
                neuralNetwork.doForwardPropagation ( inputs );
                System.out.println ( "Neural network guesses output to be " + neuralNetwork.getOutcome ( ) + " at input ( 1,1 )" );
                returnToTestingMenu ( );
            }
            break;
            
            case 2:
            {
                int [ ] inputs = new int [ ] { 0, 1 };
                neuralNetwork.doForwardPropagation ( inputs );
                System.out.println ( "Neural network guesses output to be " + neuralNetwork.getOutcome ( ) + " at input ( 0,1 )" );
                returnToTestingMenu ( );
            }
            break;
            
            case 3:
            {
                int [ ] inputs = new int [ ] { 1, 0 };
                neuralNetwork.doForwardPropagation ( inputs );
                System.out.println ( "Neural network guesses output to be " + neuralNetwork.getOutcome ( ) + " at input ( 1,0 )" );
                returnToTestingMenu ( );  
            }
            break;
            
            case 4:
            {
                int [ ] inputs = new int [ ] { 0, 0 };
                neuralNetwork.doForwardPropagation ( inputs );
                System.out.println ( "Neural network guesses output to be " + neuralNetwork.getOutcome ( ) + " at input ( 0,0 )" );
                returnToTestingMenu ( ); 
            }
            break;
            
            case 5:
            {
                System.exit ( 0 );
            }
            break;
        }
    }
    
    
    public static void returnToTestingMenu ( )
    {
        scanner.nextLine ( );
        System.out.println ( "\f" ); //clear screen
        testNeuralNetwork ( ); //re-display test screen
    }
    

    
    
    
    
    
    
    
    
    //This contains sequence of collected input/label pairs aka training data
    //I'll make a dataset of about 760 examples, because this number of examples is known to produce a good neural network for x-or prediction,
    //which is what this neural network is all about. I'll replicate the 4 xor gate items, many times until I get 700+ examples.
    public static ArrayList <String> getTrainingSpace ( )
    {
        ArrayList <String> returnValue = new ArrayList <String> ( );
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0		
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0		
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0		
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0		
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0		
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0		
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0		
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0		
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0		
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0		
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0		
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0		
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0		
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0		
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0		
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0		
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0		
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0		
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0		
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0		
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0		
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0		
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0		
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0		
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1
        returnValue.add ( "0,0:0" ); //xorgate item 4, given input 0,0, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "1,1:0" ); //xorgate item 1, given input 1,1, output should be 0
        returnValue.add ( "1,0:1" ); //xorgate item 2, given input 1,0, output should be 1
        returnValue.add ( "0,1:1" ); //xorgate item 3, given input 0,1, output should be 1

        
        return returnValue;
    }
}

