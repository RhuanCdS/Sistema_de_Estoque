package Enums;

public enum TipoMovimentacao {

    ENTRADA(1),
    SAIDA(0);

    private int num;

    TipoMovimentacao(int num){
        this.num = num;
    }

    public int getNum(){
        return this.num;
    }

    public static TipoMovimentacao fromCod(int num){

        for (TipoMovimentacao s : values()){
            if(s.num == num){
                return s;
            }
        }

        return null;
    }

}
