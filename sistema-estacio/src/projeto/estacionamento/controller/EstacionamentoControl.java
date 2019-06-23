package projeto.estacionamento.controller;

import projeto.estacionamento.estadia.DAOEstacionamento;
import projeto.estacionamento.negocios.Movimentacao;
import projeto.estacionamento.negocios.Vaga;
import projeto.estacionamento.negocios.Veiculo;
import projeto.estacionamento.utilitario.EstacionamentoUtil;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Com a entrada de dedos do usuario essa class controla o fluxo de entrada
 * de veiculos no estacionamento
 *
 * @throws EstacionamentoException Quando estiver com lotação maxima
 * @throws VeiculoException Quando o padrao da placa for invalida
 * @author morfeu9
 */

public class EstacionamentoControl {

    public void processarEntrada(String placa, String marca, String modelo, String cor) throws EstacionamentoException, VeiculoException {
        //avaliar se ha vagas disponiveis
        if (!Vaga.vagaLivre()){
           throw new EstacionamentoException("Estacionamento lotado!");
        }

        //verificar se esta correto o padrao da placa
        if (!EstacionamentoUtil.validarPlaca(placa)){
            throw new VeiculoException("Entrada Invalida!");

        }

        //criar uma instancia do veiculo
        Veiculo veiculo = new Veiculo(placa,marca,modelo,cor);

        //criar a movimentaçao vinculando com veiculo e data de entrada
        Movimentacao movimentacao = new Movimentacao(veiculo, LocalDateTime.now());

        //registrar na base de dados a informação
        DAOEstacionamento dao = new DAOEstacionamento();
        dao.criar(movimentacao);

        //atualizar o numero de vagas
        Vaga.entrou();

    }
    public Movimentacao processarSaida(String placa){
        //TODO implementar
        return null;
    }
    public List<Movimentacao> emitirRelatorio(LocalDateTime date){
        //TODO implementar
        return null;
    }
}
