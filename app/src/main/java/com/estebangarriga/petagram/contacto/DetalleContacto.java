package com.estebangarriga.petagram.contacto;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.estebangarriga.petagram.R;

/*
import android.view.View;
import android.net.Uri;
*/
public class DetalleContacto extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvTelefono;
    private TextView tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        Bundle parametros = getIntent().getExtras();
        String nombre       = parametros.getString(getResources().getString(R.string.pnombre));//nombre
        String telefono     = parametros.getString(getResources().getString(R.string.ptelefono));//telefono
        String email        = parametros.getString(getResources().getString(R.string.pemail));//email

        tvNombre   = (TextView) findViewById(R.id.tvNombre);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail    = (TextView) findViewById(R.id.tvEmail);

        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
    }

    public void llamar(View v){
        String telefono = tvTelefono.getText().toString();
/*
       if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            // TODO: Consider calling
            //  ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //  public void onRequestPermissionResult(int requestCode, String[] permissions,
            //                                        int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for activityCompat#requestPermissions for more details.
            return;
        }*/

        Intent llamadaIntent = new Intent(Intent.ACTION_CALL);
        llamadaIntent.setData(Uri.parse("tel:" +telefono));

        startActivity(llamadaIntent);

        //startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" +telefono)));
    }

    public void enviarMail(View v){
        String email = tvEmail.getText().toString();
        Intent emailIntent = new Intent((Intent.ACTION_SEND));
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, email);
        emailIntent.setType("menssage/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Email "));
    }
}