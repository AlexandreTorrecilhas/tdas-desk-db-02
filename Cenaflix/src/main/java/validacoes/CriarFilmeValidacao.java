package validacoes;

//Pacotes Swing
import javax.swing.JTextField;
import javax.swing.JOptionPane;
//Pacotes Util
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class CriarFilmeValidacao {
    private LinkedHashMap<String, String> validador = new LinkedHashMap();
    private LinkedHashMap<String, JTextField> paraVerificar;
    private final String[] mensagenVerificacao = {"Por favor, inserir um nome válido para filme", "Inserir a data no formato dd/mm/aaaa", "Selecione um Gênero"};

    public CriarFilmeValidacao(LinkedHashMap<String, JTextField> paraVerificar){
        this.setValidador();
        this.paraVerificar = paraVerificar;
    }
    
    private void setValidador(){
        this.validador.put("txtNomeFilme", "^([\\w]|[\\w\\s\\w])+$");
        this.validador.put("txtDataLancamento", "^([0][1-9]|[1][0-9]|[2][0-9]|[3][01])[/]([0][1-9]|[1][0-2])[/][\\d]{4}$");
        this.validador.put("txtCategoria", "^([\\w]+[;]|[\\w]+[\\s][\\w]+[;])+$");
    }
    
    public boolean verificarValores(){
        int contador = 0;
        for(Map.Entry<String, JTextField> entry: this.paraVerificar.entrySet()){
            String chave = entry.getKey();
            String valor = entry.getValue().getText();
            if(!Pattern.matches(validador.get(chave), valor)){
                JOptionPane.showMessageDialog(null, this.mensagenVerificacao[contador]);
                return false;
            }
            contador++;
        }
        return true;
    }
}
