package com.if4b.alfamartina;

import java.util.ArrayList;

public class DataAlfamart {

    public static String[][] data = new String[][]{
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
    };

    public static ArrayList<Alfamart> ambilAlfamart() {
        ArrayList<Alfamart> dataAlfamart = new ArrayList<>();
        for (String[] varData : data) {
            Alfamart model = new Alfamart();
            model.setNama(varData[0]);
            model.setAlamat(varData[1]);
            model.setFoto(varData[3]);
            model.setNomor(varData[2]);

            dataAlfamart.add(model);
        }

        return dataAlfamart;
    }
}
