package projeto08.com.br.projeto08;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    //declarar os atributos da Classe
    EditText edtProduto, edtData, edtValorCompra, edtQtdParcelas;
    Button btnCalcular, btnLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Atribuir os componentes visuais da activity_main
         * nos atributos da classe
         */

        edtProduto = (EditText) findViewById(R.id.edtProduto);
        edtData = (EditText) findViewById(R.id.edtData);
        edtValorCompra = (EditText) findViewById(R.id.edtValorCompra);
        edtQtdParcelas = (EditText) findViewById(R.id.edtQtdParcelas);

        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnLimpar = (Button) findViewById(R.id.btnLimpar);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtProduto.getText().length() <= 0 ||
                        edtData.getText().length() <= 0 ||
                        edtValorCompra.getText().length() <= 0 ||
                        edtQtdParcelas.getText().length() <= 0) {
                    Toast.makeText(getBaseContext(), "Informe TODOS os campos!!!",
                            Toast.LENGTH_SHORT).show();
                    edtProduto.requestFocus();
                } else {

                    Double valorCompra = Double.parseDouble(edtValorCompra.getText().toString());
                    Double qtdParcelas = Double.parseDouble(edtQtdParcelas.getText().toString());

                    Double valorParcela = (valorCompra / qtdParcelas);

                    AlertDialog.Builder alerta = new
                            AlertDialog.Builder(MainActivity.this);

                    alerta.setTitle("PARCELAS");
                    alerta.setMessage("A compra no valor de : "
                            + new DecimalFormat("0.00").format(valorCompra)
                            + ("\n dividida em  :")
                            + new DecimalFormat("0.00").format(qtdParcelas)
                            + ("\n terá o valor de cada parcela em : ")
                            + new DecimalFormat("0.00").format(valorParcela));
                    alerta.setNeutralButton("Fechar", null);
                    alerta.show();
                }
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtProduto.setText("");
                edtData.setText("");
                edtValorCompra.setText("");
                edtQtdParcelas.setText("");
                edtProduto.requestFocus();
            }
        });

    }
}
