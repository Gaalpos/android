package com.example.joaquinlib4bt2;

import java.util.ArrayList;
import java.util.List;

public class DatosElemento {
    private String nombreEstado;
    private String datosEstado;

    public String getNombreEstado() {
        return nombreEstado;
    }

    public String getDatosEstado() {
        return datosEstado;
    }

    public DatosElemento(String nombreEstado, String datosEstado) {
        this.nombreEstado = nombreEstado;
        this.datosEstado = datosEstado;
    }

    public static List<DatosElemento> poblarLista() {
        String[] ESTADOS =
                {
                        "Grecia",
                        "Hungría",
                        "Irlanda",
                        "Italia",
                        "Lituania",
                        "Holanda",
                        "Polonia",
                        "Portugal",
                        "Rumania",
                        "Suecia"
                };
        String[] DATOS = {
            "10,682,547  131,990 km2 Atenas",
            "9,730,772  93,030 km2 Budapest",
            "5,006,907  70,273 km2 Dublín",
            "59,257,566  301,338 km2 Roma",
            "2,795,680  65,200 km2 Vilna",
            "17,475,415  41,543 km2 Amsterdam",
            "37,840,001  312,685 km2 Varsovia",
            "10,298,252  92,390 km2 Lisboa",
            "19,186,201  238,391 km2 Bucarest",
            "10,379,295  449,964 km2 Estocolmo"
        };

        List<DatosElemento> list = new ArrayList<>();
        for (int i = 0; i < ESTADOS.length; i++) {
            DatosElemento elemento = new DatosElemento(ESTADOS[i], DATOS[i]);
            list.add(elemento);
        }
        return list;
    }

}
