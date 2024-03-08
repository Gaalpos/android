package com.example.ejercicio_4b;

import java.util.ArrayList;
import java.util.List;

public class DatosElemento {
    private String nombreComunidad;
    private String datosComunidad;

    public String getNombreComunidad() {
        return nombreComunidad;
    }

    public String getDatosComunidad() {
        return datosComunidad;
    }

    public DatosElemento(String nombreComunidad, String datosComunidad) {
        this.nombreComunidad = nombreComunidad;
        this.datosComunidad = datosComunidad;
    }

    public static List<DatosElemento> poblarLista() {
        String[] ESTADOS =
                {
                        "Andalucía",
                        "Cataluña",
                        "Comunidad de Madrid",
                        "Comunidad Valenciana",
                        "Galicia",
                        "Castilla y León",
                        "País Vasco",
                        "Canarias",
                        "Castilla-La Mancha",
                        "Región de Murcia",
                        "Aragón",
                        "Islas Baleares",
                        "Extremadura",
                        "Principalidad de Asturias",
                        "Comunidad Foral de Navarra",
                        "La Rioja",
                };
        String[] DATOS = {
                "Sevilla 8 500 187 87 599",
                "Barcelona 7 792 611 32 113",
                "Madrid 6 750 336 8028",
                "Valencia 5 097 967 23 255",
                "Santiago de Compostela 2 690 464 29 575",
                "Valladolid 2 372 640 94 224",
                "Vitoria 2 208 174 7234",
                "Las Palmas de Gran Canaria y Santa Cruz de Tenerife 2 2 177 701 7447nota 3",
                "Toledo  2 053 328 79 461",
                "Murcia 1 531 878 11 314",
                "Zaragoza 1 326 315 47 720",
                "Palma 1 176 659 4992",
                "Mérida 1 054 776 41 634",
                "Oviedo 1 004 686 10 604",
                "Pamplona 664 117 10 391",
                "antander 585 402 5321",
                "Logroño 319 892 5045"
        };

        List<DatosElemento> list = new ArrayList<>();
        for (int i = 0; i < ESTADOS.length; i++) {
            DatosElemento elemento = new DatosElemento(ESTADOS[i], DATOS[i]);
            list.add(elemento);
        }
        return list;
    }

}
