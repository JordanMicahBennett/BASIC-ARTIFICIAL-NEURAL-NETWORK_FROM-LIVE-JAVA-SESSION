import java.util.ArrayList;

//This is a simple way to describe the structure of the neural network

public class Topology extends ArrayList <Integer>
{
    //features
    private String description;
    
    //constructor 
    public Topology ( String description )
    {
        String [ ] items = description.split ( "," );
        
        //where iI signifies items iteration index
        for ( int iI = 0; iI < items.length; iI ++ )
            add ( Integer.parseInt ( items [ iI ] ) );
    }
}
