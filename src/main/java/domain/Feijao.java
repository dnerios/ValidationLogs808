package domain;

import exceptions.KabumException;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.SneakyThrows;

@Data
@Builder
@AllArgsConstructor
public class Feijao {

    @NotNull(message = "Feijão sem nome não vende.")
    @Max(3)
    private String nome;

    @NotNull(message = "UX ajuda a vender.")
    private String cor;

    private int tempoPreparo;

    @DecimalMin(value = "10.00", message = "Valor mínimo não atingido.")
    private float rendimento;

    /*public Feijao (String nome, String cor, int tempoPreparo, float rendimento) {
        if(nome == "" || nome == null) {
            System.out.println("Nome não pode estar em branco.");
        } else {
            this.nome = nome;
            this.cor = cor;
            this.tempoPreparo = tempoPreparo;
            this.rendimento = rendimento;
        }
    }*/

    @SneakyThrows
    public void cozinharFeijaoAssassino(int tempoCozinhando) {
        if(this.tempoPreparo < tempoCozinhando){
            throw new KabumException("Geraldo esqueceu o feijão no fogo, dnv...");
        }

    }
}
