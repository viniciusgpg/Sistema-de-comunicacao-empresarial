/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author Thiago
 */
public class Equipe {
    private String ID_departamento;
    private int ID;
    private String nome;
    private String Representante;
    private List<String>Chat_Equipe =  new ArrayList<String>();
    private List<Projeto>projeto_Equipe = new ArrayList<Projeto>();
    private List<Funcionario>Funcionarios = new ArrayList<Funcionario>();

    public String getID_departamento() {
        return ID_departamento;
    }

    public void setID_departamento(String ID_departamento) {
        this.ID_departamento = ID_departamento;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRepresentante() {
        return Representante;
    }

    public void setRepresentante(String Representante) {
        this.Representante = Representante;
    }
    
    
    public String getProjeto(String Projeto) {
        int aux = projeto_Equipe.size();
        if(aux >=0 ){
            for(int anda=0;anda < aux;anda++){
                if(projeto_Equipe.get(anda).getNome().equals(Projeto)){
                    return projeto_Equipe.get(anda).getNome();
                }
            }
        }
        return "Vazio";
    }  
    
    public void criar_projeto(String nome,String prazo){
        Projeto novo = new Projeto();
        novo.setNome(nome);
        novo.setPrazo(prazo);
        projeto_Equipe.add(novo);
        
    }

    
    public void deletar_Projeto(String Projeto){
        int acha = 0;
        int limite = projeto_Equipe.size();
        String projeto;
        for(;acha < limite;acha++){
            projeto = projeto_Equipe.get(acha).getNome();
            if(projeto.equals(projeto_Equipe)){
                projeto_Equipe.remove(acha);
                break;
            }
        }
    }
   
    public void Criar_Tarefa_Equipe(String nome_projeto,String tarefa){
        int limite = projeto_Equipe.size();
        String projeto;
        for(int acha = 0;acha < limite;acha++){
            projeto = projeto_Equipe.get(acha).getNome();
            if(projeto.equals(nome_projeto)){
                projeto_Equipe.get(acha).Criar_Tarefa(tarefa);
                break;
            }
        }
    }
    
    
    public void Colocar_Funcionario(Funcionario Funcionario){
        Funcionarios.add(Funcionario);
    }
    
    public void Remove_Funcionario(Funcionario Funcionario){
       if(Funcionarios.size() == 0){
           System.out.println("Lista Tarefa vazia");
           return;
       }
       Funcionarios.remove(Funcionario);
       return;
    }
    
    public Funcionario getFuncionario(Funcionario Funcionario){
        int posicao = Funcionarios.indexOf(Funcionario);
        if(posicao >= 0){
          return Funcionarios.get(posicao);
        }else{
          return null;
        }
    }
    
}
