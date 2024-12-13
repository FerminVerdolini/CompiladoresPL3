
import enums.ExpOperations;
import enums.FinalFactors;
import java.util.List;

public class MyExpression {
    List<MyTerm> terms;
    List<ExpOperations> operations;
    FinalFactors type;
    private Boolean hadIdentifier;


    public MyExpression(List<MyTerm> terms, List<ExpOperations> operations, FinalFactors type, Boolean hadIdentifier) {
        this.terms = terms;
        this.operations = operations;
        this.type = type;
        this.hadIdentifier = hadIdentifier;
    }

    public List<MyTerm> getTerms() {
        return terms;
    }

    public List<ExpOperations> getOperations() {
        return operations;
    }

    public Object getIdentifier() { return terms.get(0).getfactors().get(0).getValue(); }

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
        Object resultado = terms.get(0).evaluar(); // Evalúa el primer término
        for (int i = 0; i < operations.size(); i++) {
            ExpOperations operador = operations.get(i);
            Object siguiente = terms.get(i + 1).evaluar();
            switch (operador) {
                case PLUS:
                    switch (type) {
                        case NUMBER:
                            resultado = (Integer)resultado + (Integer)siguiente ;
                            break;
                        case FLOAT:
                            resultado = (Float)resultado + (Float)siguiente ;
                            break;
                        case STRING:
                            resultado = (String)resultado + (String)siguiente;
                            break;
                        case BOOLEAN:     
                        case CHAR:    
                            //TODO trow exeption 
                            //todo (quizas el char deberia concatenarse)
                            break;
                        default:
                    }
                    break;
                case MINUS:
                    switch (type) {
                        case NUMBER:
                            resultado = (Integer)resultado - (Integer)siguiente ;
                            break;
                        case FLOAT:
                            resultado = (Float)resultado - (Float)siguiente ;
                            break;
                        case STRING:
                        case BOOLEAN:     
                        case CHAR:    
                            //TODO trow exeption 
                            break;
                        default:
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Operador no válido: " + operador);
            }
        }
        return resultado;
    }
}

