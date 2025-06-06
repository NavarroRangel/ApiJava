package java10x.dev.CadastroDeNinjas.Missoes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java10x.dev.CadastroDeNinjas.Ninjas.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
//Layered arch = arquitetura por camadas
// Apresentação = Camada mais proxima do usuário CONTROLLER
// Serviço = Camada de lógica da aplicação SERVICE
// Persistência = Persistir dados REPOSITORY --> conecta com o banco
// Banco de dados = Dados ficam guardados aqui

// Model fica entre service e Repository assim como DTO
@Entity
@Table (name = "tb_missoes")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString

public class MissoesModel {

    //NAO MEXER

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String dificuldade;

    //Uma missao para muitos ninjasq
    // Chave estrangeira mapeia
    @OneToMany(mappedBy = "missoes")
    @JsonIgnore
    private List<NinjaModel> ninjas;



}
