package calcinsulina.FMU.projetointegrado.View;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import calcinsulina.FMU.projetointegrado.Model.Alimento;
import calcinsulina.FMU.projetointegrado.Model.Calculo;
import calcinsulina.FMU.projetointegrado.Model.DAO;
import calcinsulina.FMU.projetointegrado.Model.TipoMedida;
import calcinsulina.FMU.projetointegrado.Model.Usuario;

public class MainActivity extends Activity {
    List<Usuario> aUsuario = new ArrayList<Usuario>();
    List<Calculo> aCalculo = new ArrayList<Calculo>();
    List<TipoMedida> aTipoMedida = new ArrayList<TipoMedida>();
    List<Alimento> aAlimento = new ArrayList<Alimento>();
    TelaPrincipal tela_principal;
    TelaCalculadora tela_calculadora;
    TelaConfig tela_config;
    TelaCadastro tela_cadastro;
    TelaCarregando tela_carregando;
    TelaResultado tela_resultado;
    SplashScreen splashScreen;
    TelaPesquisa tela_pesquisa;
    TelaDetalhe tela_detalhe;
    TelaSelecionados tela_selecionados;

    private DAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tela_principal = new TelaPrincipal(this, "MainActicity");
        tela_cadastro = new TelaCadastro(this, "MainActicity");
        tela_calculadora = new TelaCalculadora(this, tela_principal);
        tela_config = new TelaConfig(this, tela_principal);
        tela_carregando = new TelaCarregando(this, tela_principal);
        splashScreen = new SplashScreen(this, tela_principal);
        tela_resultado = new TelaResultado(this, "TelaCalculadora");
        tela_principal.setTelaCadastro(tela_cadastro);
        tela_principal.setTelaCalculadora(tela_calculadora);
        tela_principal.setTelaConfig(tela_config);
        tela_principal.setTelaCarregando(tela_carregando);
        tela_principal.setSplashScreen(splashScreen);
        tela_pesquisa = new TelaPesquisa(this,"TelaCalculadora");
        tela_detalhe = new TelaDetalhe(this,"TelaPesquisa");
        tela_selecionados = new TelaSelecionados(this,"TelaCalculadora");

        dao = new DAO(this);
        //Em caso de erro de tabela criada
        //dao.dropTables();
        //dao.Recreate();

        //Inserindo Valores do DB para as ArrayList
        aAlimento = dao.recuperaAlimentos();
        aCalculo = dao.recuperaCalculo();
        aTipoMedida = dao.recuperaTipoMedida();
        aUsuario = dao.recuperaUsuarios();

        //Alimentos inclusos manualmente para fins de teste
//        Alimento a1 = new Alimento("Arroz",1,"G","100","300","100");
//        Alimento a2 = new Alimento("Feijão","Colher")


        splashScreen.CarregarTela();

    }

    @Override
    protected void onStop() {
        super.onStop();
        for (int i = 0; i < aUsuario.size(); i++) {
            dao.limpaUsuario();
            dao.insereUsuario(aUsuario);
        }
        for (int i = 0; i < aAlimento.size(); i++) {
            dao.limpaAlimento();
            dao.insereAlimento(aAlimento);
        }
        for (int i = 0; i < aCalculo.size(); i++) {
            dao.limpaCalculo();
            dao.insereCalculo(aCalculo);
        }
        for (int i = 0; i < aTipoMedida.size(); i++) {
            dao.limpaTipoMedida();
            dao.insereTipoMedida(aTipoMedida);
        }
    }

    protected void onRestart() {
        super.onRestart();


    }

    protected void onDestroy() {
        super.onDestroy();
        for (int i = 0; i < aUsuario.size(); i++) {
            dao.limpaUsuario();
            dao.insereUsuario(aUsuario);
        }
        for (int i = 0; i < aAlimento.size(); i++) {
            dao.limpaAlimento();
            dao.insereAlimento(aAlimento);
        }
        for (int i = 0; i < aCalculo.size(); i++) {
            dao.limpaCalculo();
            dao.insereCalculo(aCalculo);
        }
        for (int i = 0; i < aTipoMedida.size(); i++) {
            dao.limpaTipoMedida();
            dao.insereTipoMedida(aTipoMedida);
        }
    }

    public List<Usuario> getaUsuario() {
        return aUsuario;
    }

    public List<Calculo> getaCalculo() {
        return aCalculo;
    }

    public List<TipoMedida> getaTipoMedida() {
        return aTipoMedida;
    }

    public List<Alimento> getaAlimento() {
        return aAlimento;
    }

    public void dropBD() {
        dao.dropTables();
    }
}
