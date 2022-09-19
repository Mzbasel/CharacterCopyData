public class Copier {

    private final IDestination destination;
    private final ISource source;

    public Copier(IDestination destination, ISource source){
        this.destination = destination;
        this.source = source;
    }

    public void Copy() {
        while (true) {
            char character = source.GetChar();
            if (character == '\n') {
                break;
            }
            destination.SetChar(character);
        }
    }
}
