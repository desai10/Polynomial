public class Main {

    public static void main(String []args) {
        Polynomial p = new Polynomial("4x^2 + 2x + 3");
        Polynomial p1 = new Polynomial("5x^4 - 2x^2 + 3");
        Polynomial p3 = p.subtract(p1);
    }

}
