package java10x.dev.CadastroDeNinjas.Missoes.Model;

import jakarta.persistence.*;
import java10x.dev.CadastroDeNinjas.Ninjas.Model.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table (name = "tb_missoes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MissoesModel {
    //TODO missão = id, String Nome, Enum Dificuldade

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String dificuldade;

    //Uma missao para muitos ninjasq
    // Chave estrangeira mapeia
    @OneToMany(mappedBy = "missoes")

    private List<NinjaModel> ninjas;



}
