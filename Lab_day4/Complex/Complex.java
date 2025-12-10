package Lab_day4.Complex;

public class Complex<T> {
    T real;
    T imaginary;

    public Complex(T real, T imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public void setReal(T real) {
        this.real = real;
    }

    public void setImaginary(T imaginary) {
        this.imaginary = imaginary;
    }

    public Boolean addComplex(Complex other) {
        if (other.real instanceof Integer && this.real instanceof Integer) {
            Integer result = (Integer) this.real + (Integer) other.real;
            Integer resultImag = (Integer) this.imaginary + (Integer) other.imaginary;
            this.real = (T) result;
            this.imaginary = (T) resultImag;
            return true;
        } else if (other.real instanceof Double && this.real instanceof Double) {
            Double result = (Double) this.real + (Double) other.real;
            Double resultImag = (Double) this.imaginary + (Double) other.imaginary;
            this.real = (T) result;
            this.imaginary = (T) resultImag;
            return true;
        }
        return false;
    }

    public Boolean subtractComplex(Complex other) {
        if (other.real instanceof Integer && this.real instanceof Integer) {
            Integer result = (Integer) this.real - (Integer) other.real;
            Integer resultImag = (Integer) this.imaginary - (Integer) other.imaginary;
            this.real = (T) result;
            this.imaginary = (T) resultImag;

            return true;
        } else if (other.real instanceof Double && this.real instanceof Double) {
            Double result = (Double) this.real - (Double) other.real;
            Double resultImag = (Double) this.imaginary - (Double) other.imaginary;
            this.real = (T) result;
            this.imaginary = (T) resultImag;

            return true;
        }
        return false;
    }

    public Boolean multiplyComplex(Complex other) {
        if (other.real instanceof Integer && this.real instanceof Integer) {
            Integer result = (Integer) this.real * (Integer) other.real;
            Integer resultImag = (Integer) this.imaginary * (Integer) other.imaginary;
            this.real = (T) result;
            this.imaginary = (T) resultImag;

            return true;
        } else if (other.real instanceof Double && this.real instanceof Double) {
            Double result = (Double) this.real * (Double) other.real;
            Double resultImag = (Double) this.real * (Double) other.real;
            this.real = (T) result;
            this.imaginary = (T) resultImag;

            return true;
        }
        return false;
    }

    public Boolean divideComplex(Complex other) {
        if (other.real instanceof Integer && this.real instanceof Integer) {
            Integer denominator = (Integer) other.real * (Integer) other.real
                    + (Integer) other.imaginary * (Integer) other.imaginary;
            if (denominator == 0)
                return false;
            Integer result = ((Integer) this.real * (Integer) other.real
                    + (Integer) this.imaginary * (Integer) other.imaginary) / denominator;
            Integer resultImag = ((Integer) this.imaginary * (Integer) other.real
                    - (Integer) this.real * (Integer) other.imaginary) / denominator;
            this.real = (T) result;
            this.imaginary = (T) resultImag;
            return true;
        } else if (other.real instanceof Double && this.real instanceof Double) {
            Double denominator = (Double) other.real * (Double) other.real
                    + (Double) other.imaginary * (Double) other.imaginary;
            if (denominator == 0)
                return false;
            Double result = ((Double) this.real * (Double) other.real
                    + (Double) this.imaginary * (Double) other.imaginary) / denominator;
            Double resultImag = ((Double) this.imaginary * (Double) other.real
                    - (Double) this.real * (Double) other.imaginary) / denominator;
            this.real = (T) result;
            this.imaginary = (T) resultImag;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return real + " + " + imaginary + "i";
    }

}
