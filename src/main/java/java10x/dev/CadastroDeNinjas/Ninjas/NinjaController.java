package java10x.dev.CadastroDeNinjas.Ninjas;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/ninjas")

public class NinjaController {

//INJECAO DE DEPENDECIA VIA CONSTRUTOR
    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }
    //FIM DA INJECAO


    @GetMapping("/boasVindas")
    @Operation(summary = "Mensagem de boas vindas", description = "Essa rota da uma mensagem de boas vindas para quem acessa ela")
    public String boasVindas (){
        return  " Essa é minha primeira mensagem nessa rota";
    }
    //CRUD
    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
    @Operation(summary = "Cria um novo Ninja", description = "Rota cria um novo ninja e insere no banco de dados")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação do ninja")
    })

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
    @Operation(summary = "Lista o ninja por ID", description = "Rota lista um ninja pelo seu ID")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
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
    @Operation(summary = "Altera o ninja por id", description = "Rota altera um ninja pelo seu ID")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado,não foi possível alterar")
    })
    public ResponseEntity<String> alterarNinjaPorId(
            @Parameter(description = "Usuário manda o id no caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuário manda os dados do ninja a ser atualizado no corpo da requisição")
            @RequestBody NinjaDTO ninjaAtualizado){

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
