public class Main
{
    public static void main (String[] args) throws Exception
    {
        Data natal = new Data ((byte)24,(byte)12,(short)2024);
        Data christmas = new Data ((byte)24,(byte)12,(short)2024);
        Data reveillon = new Data ((byte)31,(byte)12,(short)2024);
        Data meuNascimento = new Data ((byte)30,(byte)11,(short)2003);

        System.out.println("O natal é em: "+natal.getDia()+"/"+natal.getMes()+"/"+natal.getAno());

        // Avance um dia - Trocar de dia

        // Avance um dia -  Trocar de mes

        // Avance um dia - Trocar de ano
    }             
}
