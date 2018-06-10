package calculadoracorrigido;

public class Operações {
    
    private String operações;
    private boolean binario;
    
    public Operações(String operações,boolean binario) {
        this.operações = operações;
        this.binario= binario;
    }
    
    public boolean getBinario() {
        return binario;
    }
    
    public void setBinario(boolean binario) {
        this.binario = binario;
    }
    
    public String getOperações() {
        return operações;
    }
    
    public void setOperações(String operações) {
        this.operações = operações;
    }
    
    @Override
    public String toString() {
        return operações;
    }
}
