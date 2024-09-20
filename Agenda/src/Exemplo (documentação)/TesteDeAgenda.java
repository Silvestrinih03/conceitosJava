import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import agenda.consultavel.*;

public class TesteDeAgenda
{
    public static void main (String[] args)
    {
        BufferedReader entrada = new BufferedReader
                                (new InputStreamReader
                                (System.in));

        AgendaConsultavel agenda = null;

        for (;;)
        {
            System.out.print ("Capacidade desejada para a Agenda: ");
            try
            {
                int cap = Integer.parseInt (entrada.readLine ());
                agenda  = new AgendaConsultavel (cap);
                break;
            }
            catch (IOException e)
            {}
            catch (NumberFormatException e)
            {
                System.err.println ("Nao foi digitado um numero inteiro\n\n");
            }
            catch (Exception e)
            {
                System.err.println (e.getMessage()+"\n\n");
            }
        }

        System.out.println ();

        String nome = null, telefone = null;

        char opcao = ' ';

        do
        {
            System.out.println ();

            System.out.print ("Digite sua Opcao (" +
                              "I=Incluir/" +
                              "E=Excluir/" +
                              "C=Consultar/" +
                              "L=Listar/" +
                              "S=Sair)" +
                              ": ");

            try
            {
                String str = entrada.readLine ();

                if (str.length()==1)
                    opcao = str.charAt(0);
                else
                    opcao = 'A'; // for�ando op��o inv�lida
            }
            catch (IOException e)
            {}

            switch (opcao)
            {
                case 'i':
                case 'I':
                    try
                    {
                        System.out.print ("Nome....: ");
                        nome = entrada.readLine ();
                    }
                    catch (IOException e)
                    {}

                    try
                    {
                        System.out.print ("Telefone: ");
                        telefone = entrada.readLine ();
                    }
                    catch (IOException e)
                    {}

                    try
                    {
                        agenda.registreContato (nome, telefone);
                    }
                    catch (Exception e)
                    {
                        System.err.println (e.getMessage());
                    }

                    System.out.println ();
                    break;


                case 'e':
                case 'E':
                    System.out.print ("Nome: ");
                    try
                    {
                        nome = entrada.readLine ();
                    }
                    catch (IOException e)
                    {}

                    try
                    {
                        agenda.descarteContato (nome);
                    }
                    catch (Exception e)
                    {
                        System.err.println (e.getMessage ());
                    }

                    System.out.println ();
                    break;


                case 'c':
                case 'C':
                    try
                    {
                        System.out.print ("Nome....: ");
                        nome = entrada.readLine ();
                    }
                    catch (IOException e)
                    {}

                    try
                    {
                        telefone = agenda.getTelefone (nome);
                    }
                    catch (Exception e)
                    {
                        System.err.println (e.getMessage());
                        System.err.println ();
                        break;
                    }

                    System.out.println ("Telefone: " + telefone);
                    System.out.println ();
                    break;


                case 'l':
                case 'L':
                    System.out.println (agenda);
                    break;



                case 's':
                case 'S':
                    break;


                default :
                    System.err.println ("Opcao invalida");
                    System.err.println ();
            }
        }
        while ((opcao != 's') && (opcao != 'S'));
    }
}