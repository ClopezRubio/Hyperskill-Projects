class Complex {

    double real;
    double image;

    // write methods here

    void add(Complex number) {
        this.real = this.real + number.real;
        this.image = this.image + number.image;
    }

    void subtract(Complex number) {
        this.real = this.real - number.real;
        this.image = this.image - number.image;
    }
}