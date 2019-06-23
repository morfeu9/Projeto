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

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public LocalDateTime getDataHoraEntrada() {
        return dataHoraEntrada;
    }

    public void setDataHoraEntrada(LocalDateTime dataHoraEntrada) {
        this.dataHoraEntrada = dataHoraEntrada;
    }

    public LocalDateTime getDataHoraSaida() {
        return dataHoraSaida;
    }

    public void setDataHoraSaida(LocalDateTime dataHoraSaida) {
        this.dataHoraSaida = dataHoraSaida;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Movimentacao(Veiculo veiculo, LocalDateTime dataHoraEntrada) {
        this.veiculo = veiculo;
        this.dataHoraEntrada = dataHoraEntrada;
    }
}
