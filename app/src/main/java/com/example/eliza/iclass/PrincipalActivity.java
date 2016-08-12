package com.example.eliza.iclass;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PrincipalActivity extends AppCompatActivity {
    Toolbar toolbar;
    private DrawerLayout NavDrawerLayout;
    private ListView NavList;
    private String[] titulos;
    private TypedArray NavIcons;
    NavigationAdapter NavAdapter;
    ActionBarDrawerToggle drawerToggle;
    private ArrayList<item_objct> NavItms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        toolbar =  (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavList = (ListView) findViewById(R.id.left_drawer);
        titulos = getResources().getStringArray(R.array.nav_options);
        NavItms = new ArrayList<item_objct>();
        for(int g=0; g<titulos.length; g++)
            NavItms.add(new item_objct(titulos[g]));
        NavAdapter = new NavigationAdapter(this, NavItms);
        NavList.setAdapter(NavAdapter);
        Fragment fragment = new Avisos_completo();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

        setTitle(titulos[1]);
        NavList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id){
                Fragment fragment = null;
                switch (position){
                    case 0:
                        fragment =  new Eventos_completo();
                        break;
                    case 1:
                        fragment =  new Avisos_completo();
                        break;
                    case 3:
                        fragment =  new Tareas_completo();
                        break;
                    case 4:
                        fragment =  new Contingencias_completo();
                        break;
                    default:
                        position = 1;
                        fragment = new Avisos_completo();
                        break;
                }
                if(fragment != null){
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

                    setTitle(titulos[position]);

                    NavDrawerLayout.closeDrawer(NavList);
                }
            }
        });
        drawerToggle = new ActionBarDrawerToggle(
                this,
                NavDrawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );
    }
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

}
