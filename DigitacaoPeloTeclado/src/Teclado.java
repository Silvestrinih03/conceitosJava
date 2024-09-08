// public class App {
//     public static void main(String[] args) throws Exception {
//         System.out.println("Hello, World!");
//     }
// }

import java.io.*;

// Classe teclado
public class Teclado
{
	// Objeto BufferedReader 
	private static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
	
	// Método String
    public static String getUmString() throws IOException
    {
        String ret = null;
        try
        {
            ret = teclado.readLine();
        }
        catch (IOException erro)
        {
            throw erro;
        }
        return ret;
    }
	
	// Método Byte
	public static byte getUmByte() throws Exception
	{
			byte ret = (byte)0;
	
			try
			{
				ret = Byte.parseByte(teclado.readLine());
			}
			catch (IOException erro)
			{} //sei que não vai dar erro
			catch (NumberFormatException erro)
			{
				throw new Exception ("Byte inválido!");
			}
				return ret;		
	}
	
	// Método short
	public static short getUmShort() throws Exception
	{
			short ret = (short)0;
	
			try
			{
				ret = Short.parseShort(teclado.readLine());
			}
			catch (IOException erro)
			{} //sei que não vai dar erro
			catch (NumberFormatException erro)
			{
				throw new Exception ("Short inválido!");
			}
				return ret;		
	}
	
	// Método int
	public static int getUmInt() throws Exception
	{
			int ret = 0;
	
			try
			{
				ret = Integer.parseInt(teclado.readLine());
			}
			catch (IOException erro)
			{} //sei que não vai dar erro
			catch (NumberFormatException erro)
			{
				throw new Exception ("Int inválido!");
			}
				return ret;		
	}
	
	// Método Long
	public static long getUmLong() throws Exception
	{
			long ret = 0L;
	
			try
			{
				ret = Long.parseLong(teclado.readLine());
			}
			catch (IOException erro)
			{} //sei que não vai dar erro
			catch (NumberFormatException erro)
			{
				throw new Exception ("Long inválido!");
			}
				return ret;		
	}
	
	// Método Float
	public static float getUmFloat() throws Exception
	{
			float ret = 0.0F;
	
			try
			{
				ret = Float.parseFloat(teclado.readLine());
			}
			catch (IOException erro)
			{} //sei que não vai dar erro
			catch (NumberFormatException erro)
			{
				throw new Exception ("Float inválido!");
			}
				return ret;		
	}
	
	// Método Double
	public static double getUmDouble() throws Exception
	{
			double ret = 0.0;
	
			try
			{
				ret = Double.parseDouble(teclado.readLine());
			}
			catch (IOException erro)
			{} //sei que não vai dar erro
			catch (NumberFormatException erro)
			{
				throw new Exception ("Double inválido!");
			}
				return ret;		
	}
	
	// Método Char
	public static char getUmChar() throws Exception
	{
			char ret = ' ';
	
			try
			{
				String str = teclado.readLine();
				if (str.length() != 1)
					throw new Exception ("Char inválido");
					
					ret = str.charAt(0);
			}
			catch (IOException erro)
			{} //sei que não vai dar erro
			
				return ret;		
	}
	
	// Método Boolean
	public static boolean getUmBoolean() throws Exception
	{
			boolean ret = false;
	
			try
			{
				String str = teclado.readLine();
				if (str == null)
					throw new Exception ("Valor inválido");
					
					if (!str.equals("true") && !str.equals("false"))
						throw new Exception ("Boolean inválido");
					
					ret = Boolean.parseBoolean(str);
			}
			catch (IOException erro)
			{} //sei que não vai dar erro
			
				return ret;		
	}
}