import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException {
        Extract objExtract = new Extract("Teste");
        System.out.println(objExtract.getStrTeste());
        Transform objTransform = new Transform("Teste2");
        System.out.println(objTransform.getStrTeste());
        Load objLoad = new Load("Teste5");
        System.out.println(objLoad.getStrTeste());
    }
}