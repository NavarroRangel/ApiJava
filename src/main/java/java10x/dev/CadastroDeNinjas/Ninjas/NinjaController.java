package java10x.dev.CadastroDeNinjas.Ninjas;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return  ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja Criada com sucesso " + novoNinja.getNome() + " (ID): " + novoNinja.getId());
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return  ResponseEntity.ok(ninjas);

    }


    // Mostrar ninja por id
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> lisarNinjasPorId(@PathVariable Long id){
        NinjaDTO ninja = ninjaService.listarNinjaPorId(id);
        if (ninja != null){
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrado ninja com ID: " + id);
        }
    }
    // Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){

        NinjaDTO ninja = ninjaService.listarNinjaPorId((id));

         if (ninja != null){
             NinjaDTO ninjaDTO = ninjaService.atualizarNinja(id, ninjaAtualizado);
             return ResponseEntity.ok("Ninja com id " + id + " atualizado com sucesso");
         } else {
             return ResponseEntity.status(HttpStatus.NOT_FOUND)
                     .body("ID " + id + " não encontrado");
         }

    }

    // Deletar Ninja (UPDATE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String>   deletarNinjaPorId(@PathVariable Long id){
         if (ninjaService.listarNinjaPorId(id) != null){
             ninjaService.deletarNinjaaPorId(id);
             return ResponseEntity.ok("Ninja com id " + id + " deletado com sucesso");
         } else {
             return ResponseEntity.status(HttpStatus.NOT_FOUND)
                     .body("O ninja com o id " + id + " não encontrado");
         }


    }
}
