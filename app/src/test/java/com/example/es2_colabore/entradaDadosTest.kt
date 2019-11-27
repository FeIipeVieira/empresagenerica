package com.example.es2_colabore

import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Test

class TestadorEntradaDadosMain{
    //Testes para a função checa_email
    @Test fun `Testa se checaemail  checa @`(){
        assertFalse(checa_email("checasemarroba"))
    }
    @Test fun `Testa se checaemail checa tamanho`(){
        assertFalse(checa_email("curto@"))
    }
    @Test fun `Testa  checaemail formato correto`(){
        assertTrue(checa_email("formato@correto.com"))
    }
    //Testes para a função checa_senha
    @Test fun `Testa checasenha correta`(){
        assertTrue(checa_senha("maiorqueseis"))
    }
    @Test fun `Testa checasenha errada`(){
        assertFalse(checa_senha("menor"))
    }

}