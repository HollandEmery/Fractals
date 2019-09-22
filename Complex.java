
public class Complex {
	public double real;
	public double imag;
	public Complex(double ex,double wy){
		this.imag=wy;
		this.real=ex;
	}
	public static Complex square(Complex toSquare){
		Complex toReturn=new Complex(0,0);
		toReturn.real=-toSquare.imag*toSquare.imag+toSquare.real*toSquare.real;
		toReturn.imag=2*toSquare.imag*toSquare.real;
		//System.out.println(toReturn.real);
		//System.out.println(toReturn.imag);
		return toReturn;
	}
	public static Complex addem(Complex arg1, Complex arg2){
		Complex toReturn=new Complex(arg1.real+arg2.real,arg1.imag+arg2.imag);
		return toReturn;
	}
	public static Complex multiply(Complex a,Complex b){
		return new Complex(a.real*b.real-a.imag*b.imag,a.real*b.imag+a.imag*b.real);
	}
}
