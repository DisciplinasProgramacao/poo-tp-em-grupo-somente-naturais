public class Tanque {
    private static final double consumo = 8.2;
    private double capacidademax;
    private double capacidadeAtual;
    private ITipoCombustivel tipoCombustivel;

    public Tanque(double capacidademax, double capcacidadeAtual)
    {
        this.capacidademax = capacidademax;
        this.capacidadeAtual = capcacidadeAtual;
    }

    public double abastecer(double litros)
    {
        if (litros<0) {
            System.out.println("Quantidade de litros indisponível");
        }
        else if (litros+capacidadeAtual > capacidademax)
        {
            System.out.println("A quantidade de litros excede a capacidade máxima do tanque\nSendo assim o tanque foi completado e foram desperdiçados um total de: "+ (litros+capacidadeAtual-capacidademax) +" litros de combustível");
            capacidadeAtual = capacidademax;
        }
        else
        {
            capacidadeAtual+=litros;
            System.out.println("Tanque abastecido.");
        }

        return capacidadeAtual;
    }

    public double autonomiaMax()
    {
        return capacidademax * consumo;
    }

    public double autonomiaAtual()
    {
        return capacidadeAtual * consumo;
    }
}
