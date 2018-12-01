public class NeuralNetwork
{
    //features or "hyperparameters" of neural network
    private double eta = 0.2; //learning rate
    private double alpha = 0.5; //momentum
    private Topology topology = new Topology ( "2,2,1" ); //signifies a neural network with 2 input neurons, 2 middle or hidden neurons and 1 output neuron 
    private Layers layers = new Layers ( );
    

    //constructor
    public NeuralNetwork ( )
    {
        //let's define the layers and neurons
        //where lsI signifies layers iteration index
        for ( int lsI = 0; lsI < topology.size ( ); lsI ++ )
        {
            //define layers container
            layers.add ( new Layer ( ) );
            
            //define each layer in terms of neurons, including a bias neuron
            //where lI signifies layer iteration index
            for ( int lI = 0; lI <= topology.get ( lsI ); lI ++ )
            {
                //a one line if statement to grab numberOfWeightsFromNextNeurons
                int numberOfWeightsFromNextNeurons = lsI + 1 < topology.size ( ) ? topology.get ( lsI + 1 ) : 0;
                
                layers.get ( lsI ).add ( new Neuron ( eta, alpha, numberOfWeightsFromNextNeurons, lI ) );
            }
            
            //define bias neuron value with constant value of 1
            Neuron lastNeuronInEachLayer = layers.get ( lsI ).get ( layers.get ( lsI ).size ( ) - 1 );
            lastNeuronInEachLayer.setOutcome ( 1.0 );
        }
    }
    
    public void doForwardPropagation ( int [ ] inputs )
    {
        //attach input values to receiver nodes/neurons
        //where iI signifies inputs iteration index
        for ( int iI = 0; iI < inputs.length; iI ++ )
            layers.get ( 0 ).get ( iI ).setOutcome ( inputs [ iI ] ); 
            
        //forward propgate input signal from the second layer to output layer, based on input signals in input layer
        //where lsI signifies layers iteration index
        for ( int lsI = 1; lsI < topology.size ( ); lsI ++ )
        {
            Layer priorLayer = layers.get ( lsI - 1 ); 
            
            //where lI layer signifies layer iteration index
            for ( int lI = 0; lI < topology.get ( lsI ); lI ++ )
                layers.get ( lsI ).get ( lI ).doForwardPropagation ( priorLayer );
        }
    }
    
    public void doBackwardPropagation ( int target )
    {
        Neuron outputNeuron = layers.get ( layers.size ( ) - 1 ).get ( 0 );
        
        outputNeuron.setOutcomeGradient ( target );
        
        //where lsI signifies layers iteration index
        for ( int lsI = layers.size ( ) - 2; lsI > 0; lsI -- )
        {
            Layer currentLayer = layers.get ( lsI );
            Layer nextLayer = layers.get ( lsI + 1 );
            
            //where lI layer signifies layer iteration index
            for ( int lI = 0; lI < currentLayer.size ( ); lI ++ )
                currentLayer.get ( lI ).setHiddenGradient ( nextLayer );
        }
        
        //where lsI signifies layers iteration index
        for ( int lsI = layers.size ( ) - 1; lsI > 0; lsI -- )
        {
            Layer currentLayer = layers.get ( lsI );
            Layer priorLayer = layers.get ( lsI - 1 );
            
            //where lI layer signifies layer iteration index
            for ( int lI = 0; lI < currentLayer.size ( ) - 1; lI ++ )
                currentLayer.get ( lI ).updateWeights ( priorLayer );
        }
    }
    
    public double getOutcome ( )
    {
        return layers.get ( layers.size ( ) - 1 ).get ( 0 ).getOutcome ( );
    }
}
