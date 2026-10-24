package com.example.agenda_contatos;


import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = {Contato.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract ContatoDAO contatoDAO();
}
