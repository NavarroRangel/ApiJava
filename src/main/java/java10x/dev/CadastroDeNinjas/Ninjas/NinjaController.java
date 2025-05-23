package java10x.dev.CadastroDeNinjas.Ninjas;


import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/ninjas")

public class NinjaController {

    @GetMapping("/boasVindas")
    public String boasVindas (){
        return  " Essa é minha primeira mensagem nessa rota";
    }
    //CRUD
    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja(){
        return ("Ninja Criado");
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public String mostrarTodosOsNinjas(){
        return "Mostrar todos ninjas";
    }

    // Mostrar ninja por id (READ)
    @GetMapping("/listarID")
    public String mostrarTodosOsNinjasPorId(){
        return "Mostrar ninja por ID";
    }
    // Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinjaPorId(){
        return ("Ninja Alterado");
    }

    // Deletar Ninja (UPDATE)
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId(){
        return ("Ninja Deletado");
    }
}
