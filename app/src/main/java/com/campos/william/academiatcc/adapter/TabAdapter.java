package com.campos.william.academiatcc.adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.campos.william.academiatcc.fragment.DietaFragment;
import com.campos.william.academiatcc.fragment.PerfilFragment;
import com.campos.william.academiatcc.fragment.TreinoFragment;
import java.util.HashMap;

public class TabAdapter  extends FragmentPagerAdapter {

    private String [] tituloAbas = {"PERFIL","TREINO" , "DIETA"};
    private HashMap<Integer, Fragment> fragmentosUtilizados = new HashMap<>();
    private int fragmentAtual;

    public  TabAdapter(FragmentManager fm){

        super(fm);

    }





    @Override
    public Fragment getItem(int position) {
       Fragment fragment = null;

       switch (position){
           case 0:
           fragment = new PerfilFragment();
           fragmentosUtilizados.put(position,fragment);
           break;

           case 1:
               fragment = new TreinoFragment();
               fragmentosUtilizados.put(position,fragment);
               break;
           case 2:
               fragment = new DietaFragment();
               fragmentosUtilizados.put(position,fragment);
               break;
       }

       return fragment;

    }


    public Fragment getFragment(Integer indice){
        return fragmentosUtilizados.get(indice);
    }


    @Override
    public int getCount() {
        return tituloAbas.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return  tituloAbas[position];
    }
}
