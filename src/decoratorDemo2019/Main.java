package decoratorDemo2019;

interface Decoration {
    void basicOperation(String text);
}

class Text implements Decoration{
    public void basicOperation(String text){
        System.out.print(text);
    }
}

class CoolerText implements Decoration{
    private Decoration decoratedObject;

    public CoolerText(Decoration decoratedObject){
        this.decoratedObject = decoratedObject;
    }

    public void basicOperation(String text){
        System.out.print("~~---------");
        decoratedObject.basicOperation(text);
        System.out.print("-----------~~");
    }
}

class EvenCoolerText extends CoolerText{
    private Decoration decoratedObject;

    public EvenCoolerText(Decoration decoratedObject){
        super(decoratedObject);
    }

    public void basicOperation(String text){
        System.out.println("~~******************************~~");
        super.basicOperation(text);
        System.out.println();
        System.out.println("~~******************************~~");
    }
}

public class Main {

    public static void main(String[] args) {
        Decoration decoration = new Text();
        decoration.basicOperation("hello");
        System.out.print("\n\n\n");
        decoration = new CoolerText(decoration);
        decoration.basicOperation("hello");
        System.out.print("\n\n\n");
        decoration = new EvenCoolerText(decoration);
        decoration.basicOperation("hello");
    }
}
