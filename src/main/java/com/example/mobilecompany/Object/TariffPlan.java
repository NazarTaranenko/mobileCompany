package com.example.mobilecompany.Object;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TariffPlan {



    public static List<Tariff> sortTarifffunc(List<Tariff> tar) {
        Collections.sort(tar,new ValueComparator());

        return tar;
    }

}

class  ValueComparator implements Comparator<Tariff> {



    @Override
    public int compare(Tariff tar1,  Tariff tar2 ){
        if(tar1.getPrice()==tar2.getPrice()) {
            return 0;
        } else if (tar1.getPrice()<tar2.getPrice()) {
            return -1;
        }
        else {
            return 1;
        }
    }

}