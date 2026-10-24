package com.example.agenda_contatos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface ContatoDAO {
    @Insert
    public void inserirContato(Contato contato); //CREATE
    @Query("SELECT * FROM contatos ORDER BY id DESC LIMIT 1")
    public Contato selecionarContatoMaisRecente(); //READ
    @Query("SELECT * FROM contatos")
    public List<Contato> selecionarTodosContatos(); //READ
    @Update
    public void atualizarContato(Contato contato); //UPDATE
    @Delete
    public void removerContato(Contato contato);//DELETE
}
