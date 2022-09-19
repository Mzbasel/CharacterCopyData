import java.util.ArrayList;
import java.util.List;

public class SourceMock implements ISource{

    private char[] characters;
    public SourceMock(char[] characters){
        this.characters = characters;
    }
    @Override
    public char GetChar() {
        for (char character:
             characters) {
            return character;
        }
        return '\n';
    }
}
