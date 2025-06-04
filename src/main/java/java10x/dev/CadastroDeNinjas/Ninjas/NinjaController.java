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
    public NinjaDTO criarNinja( @RequestBody NinjaDTO ninja){
        return ninjaService.criarNinja(ninja);
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaDTO> listarNinjas(){
        return ninjaService.listarNinjas();
    }


    // Mostrar ninja por id
    @GetMapping("/listar/{id}")
    public NinjaDTO lisarNinjasPorId(@PathVariable Long id){
        return ninjaService.listarNinjaPorId(id);
    }
    // Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterar/{id}")
    public NinjaDTO alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        return ninjaService.atualizarNinja(id, ninjaAtualizado);
    }

    // Deletar Ninja (UPDATE)
    @DeleteMapping("/deletar/{id}")
    public String  deletarNinjaPorId(@PathVariable Long id){
         ninjaService.deletarNinjaaPorId(id);
         return ("Ninja id  " + id + " deletado");

    }
}
