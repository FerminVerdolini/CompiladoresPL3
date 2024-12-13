import enums.FinalFactors;
import enums.TermOperations;

import java.util.List;

public class MyTerm {
    
    private List<MyFactor> factors;
    private List<TermOperations> operations;
    private FinalFactors type;
    private Boolean hadIdentifier;
    
    public MyTerm(List<MyFactor> factors, List<TermOperations> operations,FinalFactors type, Boolean hadIdentifier) {
        this.factors = factors;
        this.operations = operations;
        this.type = type;
        this.hadIdentifier = hadIdentifier;
    }
    
    public List<MyFactor> getfactors() {
        return factors;
    }

    public List<TermOperations> getOperations() {
        return operations;
    }

    public FinalFactors getType() {
        return type;
    }

    public Boolean getHadIdentifier() {
        return hadIdentifier;
    }

    public void setHadIdentifier(Boolean hadIdentifier) {
        this.hadIdentifier = hadIdentifier;
    }

    public Object evaluar() {
        if (factors.isEmpty()) {
            throw new IllegalArgumentException("La lista de números no puede estar vacía");
        }

        Object resultado = factors.get(0).getValue(); // Inicializa con el primer número
        for (int i = 0; i < operations.size(); i++) {
            TermOperations operador = operations.get(i);
            Object siguiente = factors.get(i + 1).getValue();

            switch(operador) {
                case MULT:
                    switch (type) {
                        case NUMBER:
                            resultado = (Integer)resultado * (Integer)siguiente ;
                            break;
                        case FLOAT:
                            resultado = (Float)resultado * (Float)siguiente ;
                            break;
                        case STRING:
                        case BOOLEAN:     
                        case CHAR:    
                            //TODO trow exeption
                            break;
                        default:
                    }
                    break;
                case DIV:
                    switch (type) {
                        case NUMBER:
                            if((Integer)siguiente == 0){
                                //TODO trow exeption
                            }
                            resultado = (Integer)resultado / (Integer)siguiente ;
                            break;
                        case FLOAT:
                            if((Float)siguiente == 0){
                                //TODO trow exeption
                            }
                            resultado = (Float)resultado / (Float)siguiente ;
                            break;
                        case STRING:
                        case BOOLEAN:     
                        case CHAR:    
                            //TODO trow exeption
                            break;
                        default:
                    }
                    break;
                case MOD:
                    switch (type) {
                        case NUMBER:
                            resultado = (Integer)resultado % (Integer)siguiente ;
                            break;
                        case FLOAT:
                            resultado = (Float)resultado % (Float)siguiente ;
                            break;
                        case STRING:
                        case BOOLEAN:     
                        case CHAR:    
                            //TODO trow exeption
                            break;
                        default:
                    }
                    break;
            }
        }
        return resultado;
    }
}