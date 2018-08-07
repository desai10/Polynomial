public class Main {

    public static void main(String []args) {
        Polynomial p = new Polynomial("4x^2 + 2x + 3");
        Polynomial p1 = new Polynomial("1x + 1");
        Polynomial p3 = p.multiply(p1);
    }

}
