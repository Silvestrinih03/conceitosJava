public class Triangulo {
    private float x1, y1, x2, y2, x3, y3;

    // Maior lado deve ser menor que a soma dos dois lados
    // Soma do angulo deve dar 180

    public Triangulo(float x1, float y1, float x2, float y2, float x3, float y3) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
    }
}


// Distancia entre dois pontos = ( (x2-x1)^2 + (y2-y1)^2 )^1/2
// Criar classe Triangulo
// Construtor que recebe 6 números reais
// getLado() >> recebe 