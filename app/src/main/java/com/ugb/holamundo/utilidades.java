package com.ugb.holamundo;

import java.util.Base64;

public class utilidades {
    static String url_consulta = "http://192.168.1.2:5984/agenda/_design/agenda/_view/agenda";
    static String url_mto = "http://192.168.1.2:5984/agenda";
    static String url_delete = "http://192.168.1.2:5984/agenda/_purge";
    static String user = "admin";
    static String clave = "admin";
    static String credencialesCodificadas = Base64.getEncoder().encodeToString((user + ":" + clave).getBytes());
    public String generarUnicoId(){
        return java.util.UUID.randomUUID().toString();
    }

}
