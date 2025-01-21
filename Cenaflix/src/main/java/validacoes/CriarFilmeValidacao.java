package validacoes;

//Pacotes Swing
import javax.swing.JTextField;
import javax.swing.JOptionPane;
//Pacotes Util
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Classe para validação de campos do formulário de criação de filme.
 * Esta classe verifica se os valores inseridos nos campos do formulário seguem os formatos esperados.
 *
 * @author (Seu Nome)
 * @version 1.0
 * @since 1.0
 */

public class CriarFilmeValidacao {
    private LinkedHashMap<String, String> validador = new LinkedHashMap();
    private LinkedHashMap<String, JTextField> paraVerificar;
    private final String[] mensagenVerificacao = {"Por favor, inserir um nome válido para filme", "Inserir a data no formato dd/mm/aaaa", "Selecione um Gênero"};

    /**
     * Construtor da classe CriarFilmeValidacao.
     *
     * @param paraVerificar Mapa contendo os campos de texto a serem validados, onde a chave é o nome do campo e o valor é o componente JTextField.
     */
    
    public CriarFilmeValidacao(LinkedHashMap<String, JTextField> paraVerificar){
        this.setValidador();
        this.paraVerificar = paraVerificar;
    }
    
        /**
     * Define as expressões regulares para validação de cada campo.
     */
    
    private void setValidador(){
        this.validador.put("txtNomeFilme", "^([\\w]|[\\w\\s\\w])+$");
        this.validador.put("txtDataLancamento", "^([0][1-9]|[1][0-9]|[2][0-9]|[3][01])[/]([0][1-9]|[1][0-2])[/][\\d]{4}$");
        this.validador.put("txtCategoria", "^([\\w]+[;]|[\\w]+[\\s][\\w]+[;])+$");
    }
    
        /**
     * Valida os valores dos campos do formulário.
     *
     * @return {@code true} se todos os campos forem válidos, {@code false} caso contrário.
     */
    
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
