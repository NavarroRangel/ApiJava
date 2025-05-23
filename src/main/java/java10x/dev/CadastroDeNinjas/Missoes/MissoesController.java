package java10x.dev.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

// LOCALHOST:8080/...

@RestController
@RequestMapping("missoes")

public class MissoesController {

    @GetMapping("/listar")
    public String listarMissoes(){
        return "Lista de missoes";
    }

    @PostMapping("/criar")
    public String criarMissao() {
        return "Criado com sucesso!";
    }

    @PutMapping("/alterar")
    public String alterarMissao() {
        return "Alterado com sucesso!";
    }
    @DeleteMapping("/deletar")
    public String deletarMissao() {
        return "Deletado com sucesso!";
    }







}
