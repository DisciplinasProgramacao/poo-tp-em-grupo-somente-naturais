public enum TipoTanque {
    //#region
    /*
     * Enumerado Tipo Tanque para armazenar a capacidade máxima dos
     * veículos
     */
    //#endregionendregion
    CARRO(50),
    VAN(60),
    FURGAO(80),
    CAMINHAO(250);

    //#region
    /*
     * Atributo do tipo int, final para não alterar os valores do tanque
     */
    //#endregion
    private int capacidademaxima;

    TipoTanque(int capacidademaxima)
    {
        this.capacidademaxima = capacidademaxima;
    }
    /**
     * Obtém a capacidade máxima do tanque para o tipo específico.
     *
     * @return A capacidade máxima do tanque.
     */
    public int getCapacidade(){
        return capacidademaxima;
    }

}
