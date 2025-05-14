package java10x.dev.CadastroDeNinjas.Ninjas.Model;

import jakarta.persistence.*;
import java10x.dev.CadastroDeNinjas.Missoes.Model.MissoesModel;

import java.util.List;


// Entity transforma uma classe em uma entidade do DB
// JPA = Java Persistance API
@Entity
@Table(name = "tb_cadastro")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private int idade;

    // @ManyToOne um ninja tem uma única missão muitos ninjas pra uma missao

    @ManyToOne
    @JoinColumn(name = "missoes_id") // Foreing key ou chave estrangeira
    private MissoesModel missoes;

    //Teste commit ammend

    public NinjaModel() {
    }

    public NinjaModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }



}
