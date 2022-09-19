import java.util.ArrayList;

public class DestinationMock implements IDestination{

    String result = "";

    @Override
    public void SetChar(char character) {
        this.result += character;
    }

    public String getResult() {
        return this.result;
    }
}
