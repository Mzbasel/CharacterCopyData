import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class CopierShould {

    @Test
    public void retrieve_characters_from_the_source(){
        char[] characterList = {'a', 'b', 'c'};
        IDestination destination = new DestinationMock();
        ISource source = new SourceMock(characterList);
        Copier copier = new Copier(destination, source);
        copier.Copy();
    }



}