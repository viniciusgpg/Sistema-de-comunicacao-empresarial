/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import dominio.CEO;
import dominio.Departamento;
import dominio.Equipe;
import dominio.Funcionario;
import dominio.Projeto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vinye
 */
public class CEOBDIT {
    
    public CEOBDIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of Inserir method, of class CEOBD.
     */
    @Test
    public void testInserir() {
        System.out.println("Inserir");
        CEO ceoNew = null;
        CEOBD.Inserir(ceoNew);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of excluir method, of class CEOBD.
     */
    @Test
    public void testExcluir() {
        System.out.println("excluir");
        String email = "";
        CEOBD.excluir(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alterar method, of class CEOBD.
     */
    @Test
    public void testAlterar() {
        System.out.println("alterar");
        CEO c = null;
        CEOBD.alterar(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarEmail method, of class CEOBD.
     */
    @Test
    public void testValidarEmail() {
        System.out.println("validarEmail");
        String email = "";
        boolean expResult = false;
        boolean result = CEOBD.validarEmail(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of procurarPorLoginSenha method, of class CEOBD.
     */
    @Test
    public void testProcurarPorLoginSenha() {
        System.out.println("procurarPorLoginSenha");
        String email = "";
        String senha = "";
        CEO expResult = null;
        CEO result = CEOBD.procurarPorLoginSenha(email, senha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of procurarCodDep method, of class CEOBD.
     */
    @Test
    public void testProcurarCodDep() {
        System.out.println("procurarCodDep");
        String nomeD = "";
        String empresa = "";
        String expResult = "";
        String result = CEOBD.procurarCodDep(nomeD, empresa);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Cadastrar_Funcionario method, of class CEOBD.
     */
    @Test
    public void testCadastrar_Funcionario() {
        System.out.println("Cadastrar_Funcionario");
        Funcionario novo = null;
        CEOBD.Cadastrar_Funcionario(novo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Cadastrar_Departamento method, of class CEOBD.
     */
    @Test
    public void testCadastrar_Departamento() {
        System.out.println("Cadastrar_Departamento");
        Departamento novo = null;
        CEOBD.Cadastrar_Departamento(novo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Criar_Equipe method, of class CEOBD.
     */
    @Test
    public void testCriar_Equipe() {
        System.out.println("Criar_Equipe");
        Equipe equipe = null;
        CEOBD.Criar_Equipe(equipe);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ProcurarID_Equipe method, of class CEOBD.
     */
    @Test
    public void testProcurarID_Equipe() {
        System.out.println("ProcurarID_Equipe");
        String nomeE = "";
        String ID_departamento = "";
        int expResult = 0;
        int result = CEOBD.ProcurarID_Equipe(nomeE, ID_departamento);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Atribuir_Funcionario_Equipe method, of class CEOBD.
     */
    @Test
    public void testAtribuir_Funcionario_Equipe() {
        System.out.println("Atribuir_Funcionario_Equipe");
        Funcionario fun = null;
        Equipe equipe = null;
        CEOBD.Atribuir_Funcionario_Equipe(fun, equipe);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Criar_Projeto method, of class CEOBD.
     */
    @Test
    public void testCriar_Projeto() {
        System.out.println("Criar_Projeto");
        Projeto p = null;
        CEOBD.Criar_Projeto(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ProcurarIDProjeto method, of class CEOBD.
     */
    @Test
    public void testProcurarIDProjeto() {
        System.out.println("ProcurarIDProjeto");
        String nomeP = "";
        String ID_departamento = "";
        int expResult = 0;
        int result = CEOBD.ProcurarIDProjeto(nomeP, ID_departamento);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Atribuir_Projeto_Equipe method, of class CEOBD.
     */
    @Test
    public void testAtribuir_Projeto_Equipe() {
        System.out.println("Atribuir_Projeto_Equipe");
        Projeto p = null;
        Equipe e = null;
        CEOBD.Atribuir_Projeto_Equipe(p, e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Atribuir_Tarefa_Projeto method, of class CEOBD.
     */
    @Test
    public void testAtribuir_Tarefa_Projeto() {
        System.out.println("Atribuir_Tarefa_Projeto");
        int ID_Projeto = 0;
        String Tarefa = "";
        CEOBD.Atribuir_Tarefa_Projeto(ID_Projeto, Tarefa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ProcurarFuncionario method, of class CEOBD.
     */
    @Test
    public void testProcurarFuncionario() {
        System.out.println("ProcurarFuncionario");
        String email = "";
        String senha = "";
        Funcionario expResult = null;
        Funcionario result = CEOBD.ProcurarFuncionario(email, senha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Deletar_Departamento method, of class CEOBD.
     */
    @Test
    public void testDeletar_Departamento() {
        System.out.println("Deletar_Departamento");
        String id = "";
        CEOBD.Deletar_Departamento(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Deletar_Tarefa method, of class CEOBD.
     */
    @Test
    public void testDeletar_Tarefa() {
        System.out.println("Deletar_Tarefa");
        int ID = 0;
        CEOBD.Deletar_Tarefa(ID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Deletar_Projeto_Equipe method, of class CEOBD.
     */
    @Test
    public void testDeletar_Projeto_Equipe() {
        System.out.println("Deletar_Projeto_Equipe");
        int ID = 0;
        CEOBD.Deletar_Projeto_Equipe(ID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Deletar_Projeto method, of class CEOBD.
     */
    @Test
    public void testDeletar_Projeto() {
        System.out.println("Deletar_Projeto");
        int id = 0;
        CEOBD.Deletar_Projeto(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Deletar_Equipe method, of class CEOBD.
     */
    @Test
    public void testDeletar_Equipe() {
        System.out.println("Deletar_Equipe");
        int id = 0;
        CEOBD.Deletar_Equipe(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ProcurarIDTarefa method, of class CEOBD.
     */
    @Test
    public void testProcurarIDTarefa() {
        System.out.println("ProcurarIDTarefa");
        String tarefa = "";
        int id_projeto = 0;
        int expResult = 0;
        int result = CEOBD.ProcurarIDTarefa(tarefa, id_projeto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Deletar_Funcionario_Equipe method, of class CEOBD.
     */
    @Test
    public void testDeletar_Funcionario_Equipe() {
        System.out.println("Deletar_Funcionario_Equipe");
        int ID = 0;
        CEOBD.Deletar_Funcionario_Equipe(ID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Deletar_Funcionario method, of class CEOBD.
     */
    @Test
    public void testDeletar_Funcionario() {
        System.out.println("Deletar_Funcionario");
        String email = "";
        CEOBD.Deletar_Funcionario(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class CEOBD.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        CEOBD.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
