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
public class Departamento {
    private String empresa;
    private String ID;
    private String nome;
    private String coodenador;
    private List<String>Chat_Equipe = new ArrayList<String>();
    private List<Funcionario>Funcionario_departamento=new ArrayList<Funcionario>(); 
    private List<Projeto>projeto_departamento = new ArrayList<Projeto>();
    private List<String>Gerentes = new ArrayList<String>();
    private List<Equipe>Funcionario_Equipe = new ArrayList<Equipe>();

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    
    public void setFuncionario(Funcionario funcionario){
        
        Funcionario_departamento.add(funcionario);
    }
    public void Atribuir_Funcionario_Equipe(Funcionario funcionario,String Equipe){
        int limite_Equipe = Funcionario_Equipe.size();
        for(int acha =0;acha < limite_Equipe;acha++){
            if(Funcionario_Equipe.get(acha).getNome().equals(Equipe)){
                Funcionario_Equipe.get(acha).Colocar_Funcionario(funcionario);
                break;
            }
        }
}
    public void printt(){
        System.out.println("nome="+nome);
        int limite=Funcionario_departamento.size();
        for(int i=0;i<limite;i++){
            
            Funcionario_departamento.get(i).Printt();
        }
       System.out.println("projetos ");
       for(int i=0;i<projeto_departamento.size();i++){
           projeto_departamento.get(i).print_projeto();
       }
    }
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCoodenador() {
        return coodenador;
    }

    public void setCoodenador(String Coodenador) {
        this.coodenador = Coodenador;
    }

    public void criar_projeto(String nome,String prazo){
        Projeto novo = new Projeto();
        novo.setNome(nome);
        novo.setPrazo(prazo);
        projeto_departamento.add(novo);
        
    }
    public String getProjeto(String Projeto) {
        int aux = projeto_departamento.size();
        if(aux >=0 ){
            for(int anda=0;anda < aux;anda++){
                if(projeto_departamento.get(anda).getNome().equals(Projeto)){
                    return projeto_departamento.get(anda).getNome();
                }
            }
        }
        return "Vazio";
    }
    
    public void deletar_Projeto(String nome_projeto){
        int limite = projeto_departamento.size();
        System.out.println("Limite: "+limite);
        String projeto;
        for(int acha = 0;acha < limite;acha++){
            projeto = projeto_departamento.get(acha).getNome();
            if(projeto.equals(nome_projeto)){
                projeto_departamento.remove(acha);
                break;
            }
        }
    }

    public void Criar_Tarefa_Departamento(String nome_projeto,String tarefa){
        int limite = projeto_departamento.size();
        String projeto;
        for(int acha = 0;acha < limite;acha++){
            projeto = projeto_departamento.get(acha).getNome();
            if(projeto.equals(nome_projeto)){
                projeto_departamento.get(acha).Criar_Tarefa(tarefa);
                break;
            }
        }
    }
    
    public void Deletar_Tarefa(String nome_projeto,String tarefa){
        int limite = projeto_departamento.size();
        String projeto;
        for(int acha = 0;acha < limite;acha++){
            projeto = projeto_departamento.get(acha).getNome();
            if(projeto.equals(nome_projeto)){
                projeto_departamento.get(acha).Deletar_Tarefa(tarefa);
                break;
            }
        }
    }
    public String getTarefa(String nome_projeto,String tarefa) {
        int limite = projeto_departamento.size();
        String projeto;
        for(int acha = 0;acha < limite;acha++){
            projeto = projeto_departamento.get(acha).getNome();
            if(projeto.equals(nome_projeto)){
                return projeto_departamento.get(acha).getTarefas(tarefa);
            }
        }
        return "Vazio";
    }
    
    public void Colocar_Gerente(String Funcionario){
        Gerentes.add(Funcionario);
    }
    
    public void Remove_Gerente(String Funcionario){
       if(Gerentes.isEmpty()){
           System.out.println("Lista Tarefa vazia");
           return;
       }
       Gerentes.remove(Funcionario);
       return;
    }

    
}
