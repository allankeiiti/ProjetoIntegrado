package calcinsulina.FMU.projetointegrado.View;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import java.util.ArrayList;
//import calcinsulina.FMU.projetointegrado.Model.Usuario;

public class MainActivity extends Activity {
    //private ArrayList<Usuario> aUsuario = new ArrayList<>();
    //TelaPrincipal tela_principal;
    //TelaCalculadoraNew tela_calculadora;
    //TelaConfig tela_config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void ExibirMensagem(String msg){
        AlertDialog.Builder d = new AlertDialog.Builder(MainActivity.this);
        d.setTitle("Aviso");
        d.setMessage(msg);
        d.setNeutralButton("OK",null);
        d.show();
    }
}
