import javafx.util.Pair;

import java.util.*;


public class Polynomial {

    private List<Integer> coefficients;

    public Polynomial(String poly) {
        coefficients = new ArrayList<>();
        poly = poly.replace(" ", "");
        poly = poly.replace("-", " -");
        poly = poly.replace("+", " +");
        if(poly.charAt(0) != '+' || poly.charAt(0) != '-') {
            poly = "+" + poly;
        }
        String [] exps = poly.split(" ");
        Map<Integer, Integer> ma = new HashMap<>();
        for(int i=0;i<exps.length;i++) {
            char sign = exps[i].charAt(0);
            exps[i] = exps[i].replace("" + sign, "");
            exps[i] = exps[i].replace("^", "");
            int coeff = 0;
            int pow = 0;
            if(exps[i].contains("x")) {
                String [] parts = exps[i].split("x");
                if(parts.length == 1) {
                    coeff = Integer.parseInt(parts[0]);
                    pow = 1;
                }
                else {
                    coeff = Integer.parseInt(parts[0]);
                    pow = Integer.parseInt(parts[1]);
                }
            }
            else {
                pow = 0;
                coeff = Integer.parseInt(exps[i]);
            }
            if(sign == '-') {
                coeff = coeff * -1;
            }
            ma.put(pow, coeff);
        }

        int max = Collections.max(ma.keySet());

        for(int i=0;i<=max;i++) {
            coefficients.add(0);
        }

        for(Map.Entry<Integer, Integer> entry : ma.entrySet()) {
            coefficients.set(entry.getKey(), entry.getValue());
        }

        System.out.println(coefficients);
    }

    public Polynomial(List<Integer> polyCoeffs) {
        coefficients = polyCoeffs;
    }

    public Polynomial add(Polynomial p2) {
        return new Polynomial("as");
    }

    public Polynomial subtract(Polynomial p2) {
        return new Polynomial("as");
    }

    public Polynomial multiply(Polynomial p2) {
        return new Polynomial("as");
    }

}
