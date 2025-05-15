package java10x.dev.CadastroDeNinjas.Ninjas.Model;

import jakarta.persistence.*;
import java10x.dev.CadastroDeNinjas.Missoes.Model.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


// Entity transforma uma classe em uma entidade do DB
// JPA = Java Persistance API
@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
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





}
