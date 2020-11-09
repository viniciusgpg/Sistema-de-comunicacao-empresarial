package dominio;

/**
 *
 * @author Thiago
 */
import java.util.ArrayList;
import java.util.List;

public class Funcionario {
    
    private String nome;
    private String senha;
    private String email;
    private String RG;
    private boolean status_GERENTE;
    private String ID_departamento;
    private Departamento departamento ;
    private String empresa;
    private List<Equipe>Funcionario_Equipe = new ArrayList<Equipe>();

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    

    public String getID_departamento() {
        return ID_departamento;
    }

    public void setID_departamento(String ID_departamento) {
        this.ID_departamento = ID_departamento;
    }
    
    public Departamento getDepartamento() {
        return departamento;
    }
   
    public String getNome() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public boolean isStatus_GERENTE() {
        return status_GERENTE;
    }

    public void setStatus_GERENTE(boolean status_GERENTE) {
        this.status_GERENTE = status_GERENTE;
    }
 
    /*public void criar_departamento(String ID,String nome,String coordenador){
        if(status_GERENTE == true){
            Departamento novo = new Departamento();
            novo.setID(ID);
            novo.setNome(nome);
            novo.setCoodenador(coordenador);
            Funcionario_Departamento.add(novo);
        }
    }*/
    public void setDepartamento(Departamento Departamento){
        
        departamento=Departamento;
    }
    
    
    public void criar_equipe(int ID,String nome,String representante){
        if(status_GERENTE == true){
            Equipe novo = new Equipe();
            novo.setID(ID);
            novo.setNome(nome);
            novo.setRepresentante(representante);
            Funcionario_Equipe.add(novo);
        }
    }

    public void criar_projeto_Departamento(String nome,String prazo,String Departamento,String Equipe){
        Projeto novo = new Projeto();
        novo.setNome(nome);
        novo.setPrazo(prazo);
        if(status_GERENTE == true){
            departamento.criar_projeto(nome, prazo);
            criar_projeto_Equipe(nome,prazo,Equipe);
            
                }
            
        
    }
 
    public void criar_projeto_Equipe(String nome,String prazo,String Equipe){
        Projeto novo = new Projeto();
        novo.setNome(nome);
        novo.setPrazo(prazo);
        int aux = Funcionario_Equipe.size();
        if(aux >=0 ){
            for(int anda=0;anda < aux;anda++){
                if(Funcionario_Equipe.get(anda).getNome().equals(Equipe)){
                    Funcionario_Equipe.get(anda).criar_projeto(nome, prazo);
                    return;
                }
            }
        }
    }
    
    public void  criar_Tarefa(String nome_projeto,String tarefa){
        if(status_GERENTE == true){
            departamento.Criar_Tarefa_Departamento(nome_projeto, tarefa);
          
            
        }
    }
    
    
    public void  deletar_Equipe(String Equipe){
        if(status_GERENTE == true){
            int aux = Funcionario_Equipe.size();
            if(aux >=0 ){
                for(int anda=0;anda < aux;anda++){
                    if(Funcionario_Equipe.get(anda).getNome().equals(Equipe)){
                        Funcionario_Equipe.remove(anda);
                        return;
                    }
                }
                System.out.println("Não encontrou a Equipe ");
            }else{
                System.out.println("Lista Equipe vazia");
            }
        }
    }
    
    
    public void  deletar_Tarefa(String nome_projeto,String tarefa){
        
        if(departamento.getProjeto(nome_projeto).equals(nome_projeto)){
                departamento.Deletar_Tarefa(nome_projeto, tarefa);
            }
        
    }
    
    public void  Atribuir_Funcionario_Equipe(Funcionario funcionario,String Equipe){
        int limite_Equipe = Funcionario_Equipe.size();
        for(int acha =0;acha < limite_Equipe;acha++){
            if(Funcionario_Equipe.get(acha).getNome().equals(Equipe)){
                Funcionario_Equipe.get(acha).Colocar_Funcionario(funcionario);
                break;
            }
        }
        
    }
    public void Printt(){
        
        System.out.printf("funcionario=%s status=%b email=%s\n",nome,status_GERENTE,email );
    }
    public static void main(String[] args){} 
}
