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
        CEOBD.Inserir(ceo);
    }
}
