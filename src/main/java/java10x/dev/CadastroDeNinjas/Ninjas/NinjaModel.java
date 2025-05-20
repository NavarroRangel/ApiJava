package java10x.dev.CadastroDeNinjas.Ninjas;

import jakarta.persistence.*;
import java10x.dev.CadastroDeNinjas.Missoes.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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
    @Column(name = "id")
    private Long id;
    @Column(name = "nome")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "idade")
    private int idade;



    // @ManyToOne um ninja tem uma única missão muitos ninjas pra uma missao

    @ManyToOne
    @JoinColumn(name = "missoes_id") // Foreing key ou chave estrangeira
    private MissoesModel missoes;





}
