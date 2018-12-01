//Author: Jordan Micah Bennett

import java.util.ArrayList;
import java.util.Random;

public class Neuron
{
    //features or "hyperparameters" of neuron
    private double eta; //learning rate
    private double alpha; //momentum
    private double outcome; //neuron output
    private double gradient; //enables error minimization
    private int numberOfWeightsFromNextNeurons;
    private int neuronId;
    private ArrayList <Synapse> weights = new ArrayList <Synapse> ( );
    
    //constructor, allows neuron's features to be initialized
    public Neuron ( double eta, double alpha, int numberOfWeightsFromNextNeurons, int neuronId )
    {
        this.eta = eta;
        this.alpha = alpha;
        this.neuronId = neuronId;
        this.numberOfWeightsFromNextNeurons = numberOfWeightsFromNextNeurons;
        gradient = 0;
        
        //where sI signifies synapse iteration index
        for ( int sI = 0; sI < numberOfWeightsFromNextNeurons; sI ++ )
        {
            weights.add ( new Synapse ( ) );
            weights.get ( sI ).setWeight ( new Random ( ).nextDouble ( ) );
        }
    }
    
    //getters
    public double getOutcome  ( )
    {
        return outcome;
    }
    public double getGradient ( )
    {
        return gradient;
    }
    public ArrayList <Synapse> getWeights ( )
    {
        return weights;
    }
    public double getDistributedWeightSigma  ( Layer nextLayer )
    {
        double sigma = 0;
        
        //where nI signifies next layer iteration index
        for ( int nI = 0; nI < nextLayer.size ( ) - 1; nI ++ )
            sigma += getWeights ( ).get ( nI ).getWeight ( ) * nextLayer.get ( nI ).getGradient ( ); 
        
        return sigma;
    }
    public double getActivation ( double value )
    {
        return Math.tanh ( value );
    }
    public double getPrimeActivation ( double value )
    {
        return 1 - Math.pow ( Math.tanh ( value ), 2 );
    }
    
    //setters
    public void setOutcome ( double value )
    {
        outcome = value;
    }
    public void setGradient ( double value )
    {
        gradient = value;
    }   
    public void doForwardPropagation ( Layer priorLayer ) 
    {
        double sigma = 0;
        
        //where pI signifies prior layer iteration index
        for ( int pI = 0; pI < priorLayer.size ( ); pI ++ )
            sigma += priorLayer.get ( pI ).getWeights ( ).get ( neuronId ).getWeight ( ) * priorLayer.get ( pI ).getOutcome ( );
            
        setOutcome ( getActivation ( sigma ) );
    }
    public void setOutcomeGradient ( double target )
    {
        double delta = target - outcome;
        
        setGradient ( delta * getPrimeActivation ( outcome ) );
    }
    public void setHiddenGradient ( Layer nextLayer )
    {
        setGradient ( getDistributedWeightSigma ( nextLayer ) * getPrimeActivation ( outcome ) );
    }
    public void updateWeights ( Layer priorLayer )
    {
        //where pI signifies prior layer iteration index
        for ( int pI = 0; pI < priorLayer.size ( ); pI ++ )  
        {
            double priorDeltaWeight = priorLayer.get ( pI ).getWeights ( ).get ( neuronId ).getDeltaWeight ( );
            
            double newDeltaWeight = ( eta * getGradient ( ) * priorLayer.get ( pI ).getOutcome ( ) ) + ( alpha * priorDeltaWeight );
            
            priorLayer.get ( pI ).getWeights ( ).get ( neuronId ).setDeltaWeight ( newDeltaWeight );
            
            priorLayer.get ( pI ).getWeights ( ).get ( neuronId ).setWeight ( priorLayer.get ( pI ).getWeights ( ).get ( neuronId ).getWeight ( ) + newDeltaWeight );
        }
    }
}
