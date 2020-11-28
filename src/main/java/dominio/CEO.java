/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;
import java.sql.Date;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
/**
 *
 * @author edu_p
 */
public class CEO {
    
    private  String nome;
    private String senha;
   
    private String email;
    private String telefone;
    private String empresa;
     private Date dataN;
     private List<Departamento>Departamentos=new ArrayList<Departamento>();
     private List<Funcionario>Funcionarios=new ArrayList<Funcionario>();
    public  String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getData() {
        return dataN;
    }

    public void setData(Date data) {
        this.dataN = data;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }
  public static void main(String[] args) {
     
  }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

        
    public void Cadastrar_Funcionario(String nome,String senha,String email,String RG,boolean status,String departamento){
         int limite=Funcionarios.size();
         for(int i=0;i<limite;i++){
             if(Funcionarios.get(i).getEmail().equals(email)){
                 
                 System.out.println("Email já cadastrado");
                 return;
               }
         }
         Funcionario funcionario=new Funcionario();
         funcionario.setEmail(email);
         funcionario.setNome(nome);
         funcionario.setRG(RG);
         funcionario.setSenha(senha);
         funcionario.setStatus_GERENTE(status);
         int limite_Departamento=Departamentos.size();
         for(int j=0;j<limite_Departamento;j++){
             
             if(Departamentos.get(j).getNome().equals(departamento)){
                 funcionario.setDepartamento(Departamentos.get(j));
                 Departamentos.get(j).setFuncionario(funcionario);
                 Funcionarios.add(funcionario);
             }
                 
         }
         
        }
    public void Promover_Funcionario(String email){
        int limite=Funcionarios.size();
        for(int i=0;i<limite;i++){
            if(Funcionarios.get(i).getEmail().equals(email)){
                Funcionarios.get(i).setStatus_GERENTE(true);
                return;
            }
        }
    }
    public void Criar_Projeto(String nome,String prazo,String departamento){
        int limite=Departamentos.size();
        for(int i=0;i<limite;i++){
            if(Departamentos.get(i).getNome().equals(departamento)){
                Departamentos.get(i).criar_projeto(nome, prazo);
                return;
            }
        }
    }
    public void Deletar_Projeto(String nome,String departamento){
        int limite=Departamentos.size();
        for(int i=0;i<limite;i++){
            if(Departamentos.get(i).getNome().equals(departamento)){
                Departamentos.get(i).deletar_Projeto(nome);
                Departamentos.get(i).setCoodenador(nome);
                return;
            }
        }
    }
    public void printtt(){
        
        int limite=Departamentos.size();
        for(int i=0;i<limite;i++){
            Departamentos.get(i).printt();
        }
    }
    public void Criar_Departamento(String id,String nome,String Coordenador){
        Departamento departamento=new Departamento();
        departamento.setCoodenador(Coordenador);
        departamento.setID(id);
        departamento.setNome(nome);
        Departamentos.add(departamento);
    }
    public void Criar_Equipe(int ID,String nome,String representante){
        
        Funcionario gerente=new Funcionario();
        gerente.setStatus_GERENTE(true);
        gerente.criar_equipe(ID, nome, representante);
               
    }
    public void Deletar_Equipe(){}
    public void Atribuir_Funcionario_Equipe(String nome,String email,Funcionario funcionario){
        int limite=Funcionarios.size();
        for(int i=0;i<limite;i++){
            if(Funcionarios.get(i).getEmail().equals(email)){
                Funcionarios.get(i).Atribuir_Funcionario_Equipe(funcionario, nome);
            }
        }
    } 
    public void Deletar_Departamento(String departamento){
        int limite_departamento=Departamentos.size();
        int limite_funcionario=Funcionarios.size();
        for(int i=0;i<limite_funcionario;i++){
            if(Funcionarios.get(i).getDepartamento().getNome().equals(departamento)){
                Funcionarios.remove(Funcionarios.get(i));
            }
        
        }
        for(int j=0;j<limite_departamento;j++){
            if(Departamentos.get(j).getNome().equals(departamento)){
                Departamentos.remove(Departamentos.get(j));
            }
        
        }
    
    }
    public void Criar_Tarefa(String departamento,String projeto,String tarefa){
        int limite=Departamentos.size();
        for(int i=0;i<limite;i++){
            if(Departamentos.get(i).getNome().equals(departamento)){
                Departamentos.get(i).Criar_Tarefa_Departamento(projeto, tarefa);
            
            }
                
        
        }
        
    }
    public void Deletar_Tarefa(String departamento,String projeto,String tarefa){
        int limite=Departamentos.size();
        for(int i=0;i<limite;i++){
            if(Departamentos.get(i).getNome().equals(departamento)){
                Departamentos.get(i).Deletar_Tarefa(projeto, tarefa);
            
            }
                
        
        }
        
    }
}
 