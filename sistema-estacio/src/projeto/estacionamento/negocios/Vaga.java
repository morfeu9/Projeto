package projeto.estacionamento.negocios;

/**
 * Representa o total de vagas e a disponibilidade delas
 *
 * @author morfeu9
 */
public class Vaga {

    public static int total_vagas = 100;
    private static int vagasOcupadas = 0;

    private Vaga(){}

    /**
     * Verificar se ha alguma vaga livre
     * @return true se tiver vaga ou false se não
     */
    public static boolean vagaLivre(){
        //TODO  implementar
        return false;
    }

    /**
     * Buscar os dados atuais quando inicializar o sistema
     */
    public static void inicializarOcupadas(){
        //TODO implementar
    }

    /**
     * retorna o numero de vagas ocupadas
     * @return o numero total de vagas ocupadas quando necessario
     */
    public static int ocupadas(){
        return Vaga.vagasOcupadas;
    }

    /**
     * retorna o numero de vagas livres
     * @return o numero total de vagas disponiveis quando necessario
     */
    public static int livres(){
        return total_vagas - Vaga.vagasOcupadas;
    }

    /**
     * atualiza o numero de vagas ocupadas apos entrada de veiculos
     */
    public static void entrou(){
        Vaga.vagasOcupadas ++;
    }
}
