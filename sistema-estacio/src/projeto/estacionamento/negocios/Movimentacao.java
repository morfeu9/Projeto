package projeto.estacionamento.negocios;

import java.time.LocalDateTime;

/**
 * Representa o fluxo de veiculos dentro do sistema e o valor a ser pago na entrada
 *
 * @author morfeu9
 */
public class Movimentacao {
    private Veiculo veiculo;
    private LocalDateTime dataHoraEntrada;
    private LocalDateTime dataHoraSaida;
    private double valor;
}
