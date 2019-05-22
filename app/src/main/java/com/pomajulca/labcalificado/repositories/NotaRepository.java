package com.pomajulca.labcalificado.repositories;

import com.orm.SugarRecord;
import com.pomajulca.labcalificado.models.Nota;
import com.pomajulca.labcalificado.models.User;

public class NotaRepository {
    public static void create(String titulo,String comentario){
        Nota nota = new Nota();
        nota.setTitulo(titulo);
        nota.setComentario(comentario);
        SugarRecord.save(nota);
    }
    public static Nota load(Long date){
        Nota nota=SugarRecord.findById(Nota.class,date);
        return nota;
    }
}
