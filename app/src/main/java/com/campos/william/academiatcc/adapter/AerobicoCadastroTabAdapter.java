package com.campos.william.academiatcc.adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.campos.william.academiatcc.fragment.AerobicoFragment;
import com.campos.william.academiatcc.fragment.AlimentosFragment;
import com.campos.william.academiatcc.fragment.BatimentosFragment;
import com.campos.william.academiatcc.fragment.DietaCadastroFragment;
import java.util.HashMap;

public class AerobicoCadastroTabAdapter extends FragmentPagerAdapter {//FragmentPagerAdapter{


    private String [] tituloAbas = {"AEROBICO","BATIMENTOS"};
    private HashMap<Integer, Fragment> fragmentosUtilizados = new HashMap<>();
    private int fragmentAtual;

    public  AerobicoCadastroTabAdapter(FragmentManager fm){

        super(fm);

    }





    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        switch (position){
            case 0:
                fragment = new AerobicoFragment();
                fragmentosUtilizados.put(position,fragment);
                break;

            case 1:
                fragment = new BatimentosFragment();
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
