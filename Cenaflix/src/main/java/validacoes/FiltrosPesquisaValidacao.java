package validacoes;

//Pacotes Swing
import javax.swing.JTextField;
import javax.swing.JOptionPane;
//Pacotes util
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public class FiltrosPesquisaValidacao {
    
    private LinkedHashMap<String, String> validador = new LinkedHashMap();
    private final String[] chaveDosFiltros = {"txtId", "txtNomeFilme", "txtCategoria", "txtDataInicio", "txtDataFim"};
    private final String[] esprecaoRegex = {"^([\\d]+|)$", "^(([\\w]|[\\w\\s\\w])+|)$", "^(([\\w]|[\\w\\s\\w])+[;]|)$", "^(([0][1-9]|[1][0-9]|[2][0-9]|[3][01])[/]([0][1-9]|[1][0-2])[/][\\d]{4}|)$",
        "^(([0][1-9]|[1][0-9]|[2][0-9]|[3][01])[/]([0][1-9]|[1][0-2])[/][\\d]{4}|)$"};
    private final String[] mensagensDeErro = {"Por favor, informar um ID do filme", "Por favor, informar o nome do filme", "Por favor, informar uma categoria", "Por favor, informar uma data de início",
    "Por favor, informar uma data fim"};
    
    public FiltrosPesquisaValidacao(){
        this.setValidador();
    }
    
    private void setValidador(){
        for(int contador = 0; contador < this.chaveDosFiltros.length; contador++){
            this.validador.put(this.chaveDosFiltros[contador], this.esprecaoRegex[contador]);
        }
    }
    
    public boolean verificarValores(LinkedHashMap<String, JTextField> valoresParaValidar){
        
        int contador = 0;
        
        for(Map.Entry <String, JTextField> entry: valoresParaValidar.entrySet()){
            String chave = entry.getKey();
            String valor = entry.getValue().getText().trim();
            if(this.validador.containsKey(chave)){
                if(!Pattern.matches(this.validador.get(chave), valor)){
                    JOptionPane.showMessageDialog(null, this.mensagensDeErro[contador]);
                    return false;
                }
            }
            else{
                return false;
            }
            contador++;
        }
        return true;
    }
    
}
