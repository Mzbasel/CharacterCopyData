import java.util.ArrayList;
import java.util.List;

public class SourceMock implements ISource{

    private String characters;
    private int index = 0;
    public SourceMock(String characters){
        this.characters = characters;
    }
    @Override
    public char GetChar() {
       return characters.charAt(index++) ;
    }
}
