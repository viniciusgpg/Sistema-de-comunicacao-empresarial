/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TESTE;
import banco.CEOBD;
import dominio.CEO;
import java.sql.Date;
/**
 *
 * @author edu_p
 */
public class teste {
    public static void main(String[] args){
        CEO ceo=new CEO();
        ceo.setEmail("xxx.gmail.com");
        ceo.setNome("xuxa");
        ceo.setEmpresa("xuxaaa");
        ceo.setTelefone("1233445");
        ceo.setSenha("xxxxx");
        Date data = Date.valueOf("1997-03-31");
        ceo.setData(data);
        //CEOBD.Inserir(ceo);
        ceo.Criar_Departamento("1", "cc", "bia");
        ceo.Criar_Departamento("2", "fci", "edu");
        ceo.Criar_Departamento("3", "mack", "gomes");
        ceo.Cadastrar_Funcionario("bia", "1", "bia!@hotmal.com","3", true, "cc");
        ceo.Cadastrar_Funcionario("edu", "2", "edu!@hotmal.com","3", true, "fci");
        ceo.Cadastrar_Funcionario("gomes", "3", "gomes!@hotmal.com","3", true, "mack");
        
        ceo.Criar_Projeto("sof", "18/10", "cc");
        ceo.Criar_Tarefa("cc", "sof", "banco de dados");
        ceo.printtt();
        
    }
}
