class Complex(_real: Double, _image: Double) {
    private var real = 0.0
    private var image = 0.0

    init {
        real = _real
        image = _image
    }

    fun add(second: Complex) {
        real += second.real
        image += second.image
    }

    fun subtract(second: Complex) {
        real -= second.real
        image -= second.image
    }

    fun multiply(second: Complex) {
        real = real * second.real - image * second.image
        image = real * second.image + second.real * image
    }

    fun divide(second: Complex) {
        real = (real * second.real - image * second.image) / (second.real * second.real + second.image * second.image)
        image = (second.real * image - real * second.image) / (second.real * second.real + second.image * second.image)
    }

    fun addNew(second: Complex): Complex {
        var realNew = real + second.real
        var imageNew = image +second.image
        return Complex(realNew, imageNew)
    }

    fun subtractNew(second: Complex): Complex {
        var realNew = real - second.real
        var imageNew = image - second.image
        return Complex(realNew, imageNew)
    }

    fun multiplyNew(second: Complex): Complex {
        var realNew = real * second.real - image * second.image
        var imageNew = real * second.image + second.real * image
        return Complex(realNew, imageNew)
    }

    fun divideNew(second: Complex): Complex {
        var realNew = (real * second.real - image * second.image) / (second.real * second.real + second.image * second.image)
        var imageNew = (second.real * image - real * second.image) / (second.real * second.real + second.image * second.image)
        return Complex(realNew, imageNew)
    }

    fun isReal(): Boolean {
        return image == 0.0
    }

    fun isImaginary(): Boolean {
        return real == 0.0
    }

    fun conjugate(): Complex {
        return Complex(real, -image)
    }


//    public MyComplex multiply(MyComplex second) {
//        MyComplex result = new MyComplex();
//
//        result.setReal(real * second.real - image * second.image);
//        result.setImage(real * second.image + second.real * image);
//
//        return result;
//    }
}