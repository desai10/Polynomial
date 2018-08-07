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
    }

    public Polynomial(List<Integer> polyCoeffs) {
        coefficients = polyCoeffs;
    }

    public String toString() {
    	String st = "";
    	  List<Integer> parray = coefficients;
            if (parray.get(0) > 0) {
                st  = " + " + new Integer(parray.get(0)).toString() + st;
            }
            else if(parray.get(0) < 0) {
                st  = new Integer(parray.get(0)).toString() + st;
            }
    	  for (int i=1;i<parray.size();i++) {
    	    if (parray.get(i) > 0) {
    	        st = " + " + Integer.toString(parray.get(i)) + "x^" + Integer.toString(i) + st;
            }
            else if(parray.get(i) < 0) {
                st  = new Integer(parray.get(i)).toString()+ "x^"+ new Integer(i).toString() + st;
            }
    	  }
    	  return st;
    }
    public Polynomial add(Polynomial p2) {
        List<Integer> polylist1 = this.coefficients;
        List<Integer> polylist2 = p2.coefficients;
        List<Integer> newpoly = new ArrayList<>();
        int size1 = polylist1.size();
        int size2 = polylist2.size();
        int size = size1;
        int minS = size2;
        List<Integer> maxPoly = new ArrayList<>();
        maxPoly = polylist1;
        if(size1 < size2) {
            size = size2;
            minS = size1;
            maxPoly = polylist2;
        }
        for(int i=0;i<size;i++) {
            newpoly.add(0);
        }
        int value;
        for(int i=0; i<minS; i++){
            value = polylist1.get(i) + polylist2.get(i);
            newpoly.set(i,value);
        }
        for(int i=minS;i<size;i++) {
            newpoly.set(i, maxPoly.get(i));
        }
        //System.out.println(newpoly);
        return new Polynomial(newpoly);
    }

    public Polynomial subtract(Polynomial p2) {
        List<Integer> polylist1 = this.coefficients;
        List<Integer> polylist2 = p2.coefficients;
        List<Integer> newpoly = new ArrayList<>();
        List<Integer>  maxPoly;
        int size1 = polylist1.size();
        int size2 = polylist2.size();
        int size = size1;
        int minS = size2;
        maxPoly = polylist1;
        if(size1<size2){
            size=size2;
            minS = size1;
            maxPoly = polylist2;
        }

        for(int i=0;i<size;i++){
            newpoly.add(0);
        }
        int value;
        for(int i=0; i<minS; i++){
            value = polylist1.get(i) - polylist2.get(i);
            newpoly.set(i,value);
        }
        int multiplier = 1;
        if(maxPoly.equals(polylist2)) {
            multiplier = -1;
        }

        for(int i=minS; i<size; i++){
            newpoly.set(i,multiplier * maxPoly.get(i));
        }

        return new Polynomial(newpoly);
    }

    public Polynomial multiply(Polynomial p2) {
    	List<Integer> p1array = this.coefficients;
    	  List<Integer> p2array = p2.coefficients;
    	  System.out.println(p1array.size()-p2array.size());
    	  if(p1array.size()<p2array.size()) {
    	    for (int i=p1array.size();i<p2array.size();i++) {
    	      p1array.add(0);
    	    }
    	  }
    	  else {
    	    for (int i=p2array.size();i<p1array.size();i++) {
//    	    	System.out.println("diff: "+(p1array.size()-p2array.size()));
//    	    	System.out.println("ivalue: "+i);
    	    	p2array.add(0);
    	    }
    	  }
//    	  System.out.println(p1array.size()-p2array.size());
//    	  System.out.println(p1array);
//    	  System.out.println(p2array);
    	  Polynomial ans = multiplyRecursive(p2array,0,p1array.get(0));
    	  System.out.println("0: "+ans.coefficients);
    	  for (int i=1;i<p1array.size();i++) {
    	    ans = ans.add(multiplyRecursive(p2array,i,p1array.get(i)));
    	  }
    	  return ans;
    }
    Polynomial multiplyRecursive(List<Integer> p2, int index, int coeff) {
    	ArrayList<Integer> p1 = new ArrayList<>(p2);
    	  for (int i=0;i<index;i++) {
    	    p1.add(0,0);
    	  }
    	  for (int i=0;i<p1.size();i++) {
    	    p1.set(i,p1.get(i)*coeff);
    	  }
    	  
    	  return new Polynomial(p1);
    	}

}
