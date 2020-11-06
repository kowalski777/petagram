package com.estebangarriga.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.estebangarriga.petagram.adapter.MascotaAdaptador;
import com.estebangarriga.petagram.adapter.PageAdapter;
import com.estebangarriga.petagram.contacto.About;
import com.estebangarriga.petagram.contacto.FormularioContacto;
import com.estebangarriga.petagram.fragment.PerfilFragment;
import com.estebangarriga.petagram.fragment.RecyclerViewFragment;
import com.estebangarriga.petagram.pojo.Mascota;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.miActionBar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar); //barra de navegacion
        setSupportActionBar(miActionBar);

        if (toolbar != null){
            setSupportActionBar(toolbar);
        }
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.mipmap.ic_home_page);
        tabLayout.getTabAt(1).setIcon(R.mipmap.ic_my_page);
    }

    public void irSegundaActividad(View v){
        Intent intent = new Intent(this, MascotasFavoritas.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {

            case R.id.icono_estrella:
                Toast.makeText(this, "Entrando al Top 5",Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(this, MascotasFavoritas.class);
                startActivity(intent1);
                break;
            case R.id.Mcontacto:
                Toast.makeText(this, "Seleccionado Contacto",Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(this, FormularioContacto.class);
                startActivity(intent2);
                break;
            case R.id.Mabout:
                Toast.makeText(this, "Seleccionado About",Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(this, About.class);
                startActivity(intent3);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}