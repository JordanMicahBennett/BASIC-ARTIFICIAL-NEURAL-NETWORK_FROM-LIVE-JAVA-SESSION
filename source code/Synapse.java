//This represents the connections or weights between neurons

public class Synapse
{
    
    //features of the synapse
    private double deltaWeight;
    private double weight;
    
    //getters
    public double getWeight ( )
    {
        return weight;
    }
    public double getDeltaWeight ( )
    {
        return deltaWeight;
    }
    
    //setters
    public void setWeight ( double value )
    {
        weight = value;
    }
    public void setDeltaWeight ( double value )
    {
        deltaWeight = value;
    }
}
