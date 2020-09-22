package br.gov.sp.fatec.springbootapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springbootapp.entity.Autorizacao;
import br.gov.sp.fatec.springbootapp.entity.Doenca;
import br.gov.sp.fatec.springbootapp.entity.Usuario;
import br.gov.sp.fatec.springbootapp.repository.AutorizacaoRepository;
import br.gov.sp.fatec.springbootapp.repository.DoencaRepository;
import br.gov.sp.fatec.springbootapp.repository.UsuarioRepository;
import br.gov.sp.fatec.springbootapp.service.SegurancaService;

@SpringBootTest
@Transactional
@Rollback
class SpringBootAppApplicationTests {

    

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private AutorizacaoRepository autRepo;

    @Autowired
    private DoencaRepository doeRepo;


    @Autowired
    private SegurancaService segService;

	@Test
	void contextLoads() {
	}

    @Test
    void testaInsercao(){
        Usuario usuario = new Usuario();
        usuario.setNome("Usuario");
        usuario.setSenha("senha123");
        usuario.setAutorizacoes(new HashSet<Autorizacao>());
        Autorizacao aut = new Autorizacao();
        aut.setNome("ROLE_USUARIO");
        usuario.getAutorizacoes().add(aut);
        usuarioRepo.save(usuario);
        assertNotNull(usuario.getId());
    }

    @Test
    void testaAutorizacao(){
        Usuario usuario = usuarioRepo.findById(1L).get();
        assertEquals("ROLE_ADMIN", usuario.getAutorizacoes().iterator().next().getNome());
    }
   
    @Test
    void testaUsuario(){
        Autorizacao autorizacao = autRepo.findById(1L).get();
        assertEquals("victor", autorizacao.getUsuarios().iterator().next().getNome());
    }

    @Test
    void testaBuscaUsuarioNomeContains(){
        List<Usuario> usuarios = usuarioRepo.findByNomeContainsIgnoreCase("i");
        assertFalse(usuarios.isEmpty());
        
    }

    @Test
    void testaBuscaUsuarioNome(){
        Usuario usuario = usuarioRepo.findByNome("victor");
        assertNotNull(usuario);
        
    }

    @Test
    void testaBuscaUsuarioNomeAndSenha(){
        Usuario usuario = usuarioRepo.findByNomeAndSenha("victor", "senha123");
        assertNotNull(usuario);
        
    }

    @Test
    void testaBuscaUsuarioNomeAutorizacao(){
        List<Usuario> usuarios = usuarioRepo.findByAutorizacoesNome("ROLE_ADMIN");
        assertFalse(usuarios.isEmpty());;
        
    }

    @Test
    void testaBuscaUsuarioNomeQuery(){
        Usuario usuario = usuarioRepo.buscaUsuarioPorNome("victor");
        assertNotNull(usuario);

    }

    @Test
    void testaBuscaUsuarioNomeAndSenhaQuery(){
        Usuario usuario = usuarioRepo.buscaUsuarioPorNomeESenha("victor", "senha123");
        assertNotNull(usuario);

    }

    @Test
    void testaBuscaUsuarioNomeAutorizacaoQuery(){
        List<Usuario> usuarios = usuarioRepo.buscaPorNomeAutorizacao("ROLE_ADMIN");
        assertFalse(usuarios.isEmpty());;
        
    }

    @Test
    void testaServicioCriaUsuario(){
        Usuario usuario = segService.criarUsuario("normal", "123", "ROLE_USUARIO");
        assertNotNull(usuario);
    }

    @Test
    void testaBuscaDoencaNomeContains(){
        List<Doenca> doencas = doeRepo.findByNomeContainsIgnoreCase("i");
        assertFalse(doencas.isEmpty());
    }



    @Test
    void testaBuscaDoencaNomeImagemQuery(){
        List<Doenca> doencas = doeRepo.buscaPorNomeImagem("covid19");
        assertFalse(doencas.isEmpty());;
    }

     @Test
    void testaBuscaDoencaNomeAndDesc(){
        Doenca doenca = doeRepo.findByNomeAndDescricao("teste", "teste");
        assertNotNull(doenca);
        
    }
}
