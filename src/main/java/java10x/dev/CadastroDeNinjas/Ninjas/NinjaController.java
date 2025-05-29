package java10x.dev.CadastroDeNinjas.Ninjas;


import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/ninjas")

public class NinjaController {

//INJECAO DE DEPENDECIA VIA CONSTRUTOR
    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }
    //FIM DA INJECAO

    @GetMapping("/boasVindas")
    public String boasVindas (){
        return  " Essa é minha primeira mensagem nessa rota";
    }
    //CRUD
    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public NinjaModel criarNinja( @RequestBody NinjaModel ninja){
        return ninjaService.criarNinja(ninja);
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }


    // Mostrar ninja por id (READ)
    @GetMapping("/listar/{id}")
    public NinjaModel lisarNinjasPorId(@PathVariable Long id){
        return ninjaService.listarNinjaPorId(id);
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
