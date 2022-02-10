import domain.Feijao;
import exceptions.KabumException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.validator.internal.metadata.facets.Validatable;

import java.util.Set;

public class PeFeijaoApplication {

    private static final Logger LOGGER = LogManager.getLogger(PeFeijaoApplication.class);

    public static void main(String[] args) {
        LOGGER.info("Iniciou o cozimento...");

        Feijao feijao = new Feijao("Fava",
                "Vermelho",
                45,
                10F);

        Feijao feijao2 = Feijao.builder()
                .nome("Geraldo")
                .cor(null)
                .tempoPreparo(45)
                .rendimento(9F)
                .build();

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        //Set<ConstraintViolation<Feijao>> constraintViolations = validator.validate(feijao);
        Set<ConstraintViolation<Feijao>> constraintViolations = validator.validate(feijao2);

        try {
            feijao2.cozinharFeijaoAssassino(100);
        } catch(Exception e) {
            LOGGER.fatal(e.getMessage());
        }

        constraintViolations.forEach(x -> LOGGER.error("Atributo: " + x.getPropertyPath() + " - " + x.getMessage()));
    }
}
