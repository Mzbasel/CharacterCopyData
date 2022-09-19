import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

class CopierShould {

    @Test
    public void create_a_copy(){
        String characterList = "abc\n";
        IDestination destination = new DestinationMock();
        ISource source = new SourceMock(characterList);
        Copier copier = new Copier(destination, source);
        copier.Copy();

        Assertions.assertEquals("abc", destination.getResult());
    }

    @ParameterizedTest
    @CsvSource({
        "'abc\n', 'abc'",
            "'Hello there\n', 'Hello there'",
    })

    public void create_a_copy_from_source(String character, String expected) {
        IDestination destination = new DestinationMock();
        ISource source = new SourceMock(character);
        Copier copier = new Copier(destination, source);
        copier.Copy();

        Assertions.assertEquals(expected, destination.getResult());
    }


}