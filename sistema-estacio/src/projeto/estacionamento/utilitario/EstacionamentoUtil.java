package projeto.estacionamento.utilitario;

import projeto.estacionamento.negocios.Movimentacao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Representa apoio ao demais sistema
 *
 * @author morfeu9
 */
public class EstacionamentoUtil {

    public static boolean validarPlaca(String placa){
        String padrao = "[A_Z][A_Z][A_Z]-\\d\\d\\d\\d";
        Pattern p = Pattern.compile(padrao);
        Matcher m = p.matcher(placa);
        return m.matches();
    }
    public void calcularPagamento(Movimentacao movimentacao){
        //TODO implementar
    }
}
