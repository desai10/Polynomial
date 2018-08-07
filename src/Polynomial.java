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
    	List<Integer> p1array = this.coefficients;
    	  List<Integer> p2array = p2.coefficients;
    	  if(p1array.size()<p2array.size()) {
    	    for (int i=0;i<p2array.size()-p1array.size();i++) {
    	      p1array.add(0);
    	    }
    	  }
    	  else {
    	    for (int i=0;i<p1array.size()-p2array.size();i++) {
    	      p2array.add(0);
    	    }
    	  }
    	  Polynomial ans = multiplyRecursive(p2array,0,p1array.get(0));
    	  for (int i=1;i<p1array.size();i++) {
    	    ans = ans.add(multiplyRecursive(p2array,i,p1array.get(1)));
    	  }
    	  return ans;
    }
    Polynomial multiplyRecursive(List<Integer> p1, int index, int coeff) {

    	  for (int i=0;i<index;i++) {
    	    p1.add(0,0);
    	  }
    	  for (int i=0;i<p1.size();i++) {
    	    p1.set(i,p1.get(i)*coeff);
    	  }
    	  return new Polynomial(p1);
    	}

}
