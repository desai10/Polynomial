import java.util.ArrayList;
import java.util.List;

public class Polynomial {

    private ArrayList<Integer> coefficients;

    public Polynomial(String poly) {

    }

    public Polynomial add(Polynomial p2) {
        return new Polynomial("as");
    }

    public Polynomial subtract(Polynomial p2) {
        return new Polynomial("as");
    }

    public Polynomial multiply(Polynomial p2) {
    	ArrayList<Integer> p1array = this.coefficients;
    	  ArrayList<Integer> p2array = p2.coefficients;
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
    Polynomial multiplyRecursive(ArrayList<Integer> p1, int index, int coeff) {

    	  for (int i=0;i<index;i++) {
    	    p1.add(0,0);
    	  }
    	  for (int i=0;i<p1.size();i++) {
    	    p1.set(i,p1.get(i)*coeff);
    	  }
    	  return new Polynomial(p1);
    	}

}
