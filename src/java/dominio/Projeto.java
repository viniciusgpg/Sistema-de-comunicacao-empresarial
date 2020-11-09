/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.sql.*;
/**
 *
 * @author Thiago
 */
public class Projeto {
    private int id;
    private String ID_Departamento;
    private String nome;
    private String prazo;
    private Date prazoD;
    private List<String> tarefas = new ArrayList<String>();
    private List<Equipe>Equipe_projeto=new ArrayList<Equipe>();

    public String getID_Departamento() {
        return ID_Departamento;
    }

    public void setID_Departamento(String ID_Departamento) {
        this.ID_Departamento = ID_Departamento;
    }

    public List<String> getTarefas() {
        return tarefas;
    }

    

    public Date getPrazoD() {
        return prazoD;
    }

    public void setPrazoD(Date prazoD) {
        this.prazoD = prazoD;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void print_projeto(){
        System.out.println("nome= "+nome+" prazo= "+prazo);
        for(int i=0;i<tarefas.size();i++){
            System.out.println("tarefa"+i+"= "+tarefas.get(i) ) ;
        
        }
    
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPrazo() {
        return prazo;
    }

    public void setPrazo(String prazo) {
        this.prazo = prazo;
    }

    public String getTarefas(String tarefa) {
        int posicao = tarefas.indexOf(tarefa);
        if(posicao >= 0){
          return tarefas.get(posicao);
        }else{
          return "Vazio";
        }
    }

    public void Criar_Tarefa(String tarefa) {
        System.out.println("Limite de Tarefas: "+tarefas.size());
        tarefas.add(tarefa);
    }
    
    public void Deletar_Tarefa(String tarefa){
        
       if(tarefas.size() == 0){
           System.out.println("Lista Tarefa vazia");
           return;
       }
       tarefas.remove(tarefa);
       return;
   }
}


