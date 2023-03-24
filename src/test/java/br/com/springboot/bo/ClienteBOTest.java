package br.com.springboot.bo;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.springboot.model.Cliente;
import br.com.springboot.model.Sexo;

@SpringBootTest
@ExtendWith(SpringExtension.class) // falar pro JUnit que ta dentro do spring
@TestMethodOrder(OrderAnnotation.class)
final public class ClienteBOTest {

    @Autowired
    private ClienteBO bo;

    @Test
    @Order(value = 1)
    public void insere() {
        Cliente cliente = new Cliente();
        cliente.setNome("Jose da Silva");
        cliente.setCpf("1234567");
        cliente.setDataDeNascimento(LocalDate.of(2000, 1, 8));
        cliente.setSexo(Sexo.MACULINO);
        cliente.setTelefone("1231412");
        cliente.setTelefone("123141");
        cliente.setEmail("rafael.@email.com.br");
        cliente.setAtivo(true);
        bo.insere(cliente);
    }

    @Test
    @Order(value = 2)
    public void pesquisaPeloId() {
        Cliente cliente = bo.pesquisaPeloId(1L);
        System.out.println(cliente);
    }

    @Test
    @Order(value = 3)
    public void atualiza() {
        Cliente cliente = bo.pesquisaPeloId(1L);
        cliente.setCpf("8888883");
        bo.atualiza(cliente);

    }

    public void lista() {
        List<Cliente> clientes = bo.listaTodos();
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    public void inativa() {
        Cliente cliente = bo.pesquisaPeloId(1L);
        bo.inativa(cliente);
    }

    public void remove() {
        Cliente cliente = bo.pesquisaPeloId(1L);
        bo.remove(cliente);
    }
}
