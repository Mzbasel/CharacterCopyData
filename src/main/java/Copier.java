public class Copier {

    private final IDestination destination;
    private final ISource source;

    public Copier(IDestination destination, ISource source){
        this.destination = destination;
        this.source = source;
    }

    public void Copy() {
       destination.SetChar(source.GetChar());
    }

}
