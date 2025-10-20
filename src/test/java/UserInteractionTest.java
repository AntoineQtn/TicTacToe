import org.example.display.UserInteraction;
import org.example.display.View;

public class UserInteractionTest extends UserInteraction {

    public UserInteractionTest() {
        super(new View());
    }

    @Override
    public String askForRepresentation() {
        return "X";
    }

    @Override
    public int[] askForPosition() {
        return new int[]{0, 0};
    }
}
