import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

class CopierShould {

    @BeforeEach
    void setUp() {
        //if we don't call below, we will get NullPointerException
        MockitoAnnotations.openMocks(this);
    }
    @Mock IDestination destination;
    @Mock ISource source;

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

    @Test
    public void verify_copy_run_once() {
        when(source.GetChar()).thenReturn(
                'a','b', 'c','\n'
        );

        doNothing().when(destination).SetChar(isA(Character.class));

        Copier copier = new Copier(destination, source);
        copier.Copy();


        verify(source, times(4)).GetChar();
        verify(destination, times(1)).SetChar('a');
    }


}