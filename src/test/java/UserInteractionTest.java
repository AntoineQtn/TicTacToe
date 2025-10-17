import org.example.game.UserInteraction;
import org.junit.jupiter.api.Test;

public class UserInteractionTest extends UserInteraction {

    @Override
    public String askForRepresentation() {
        return "X";
    }

}
