import enums.FinalFactors;

public class MyFactor {
    
    private Object value;
    private FinalFactors type;
    
    public MyFactor(Object value, FinalFactors type) {
        this.value = value;
        this.type = type;
    }
    
    public Object getValue() {
        return value;
    }

    public FinalFactors getType() {
        return type;
    }
}
