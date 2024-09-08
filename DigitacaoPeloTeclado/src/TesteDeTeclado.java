class TesteDeTeclado
{
	public static void main (String[] args)
	{
			char opcao;
			do
			{
					try
					{
							System.out.println();
							System.out.println("(a) Digitar uma string");
							System.out.println("(b) Digitar uma byte");
							System.out.println("(c) Digitar uma short");
							System.out.println("(d) Digitar uma int");
							System.out.println("(e) Digitar uma long");
							System.out.println("(f) Digitar uma float");
							System.out.println("(g) Digitar uma double");
							System.out.println("(h) Digitar uma char");
							System.out.println("(i) Digitar uma boolean");
							System.out.println("(j) Sair");
							System.out.print("Sua opção: ");
							// toLowerCase() transforma em letra minúscula - método da classe Character
							opcao = Character.toLowerCase(Teclado.getUmChar());
					}
					// Quando for digitado um valor inválido, ou seja, diferente de char, vai cair na exception e vai virar 'z'
					catch (Exception erro)
					{
							opcao = 'z';
					}
					try
					{
							switch (opcao)
							{
									case 'a':
									System.out.print("Digite o valor para um String: ");
									String str = Teclado.getUmString();
									System.out.println("O valor digitado foi: "+str);
									break;
									
									case 'b':
									System.out.print("Digite o valor para um Byte: ");
									byte b = Teclado.getUmByte();
									System.out.println("O valor digitado foi: "+b);
									break;
									
									case 'c':
									System.out.print("Digite o valor para um Short: ");
									short  s = Teclado.getUmShort();
									System.out.println("O valor digitado foi: "+s);
									break;
									
									case 'd':
									System.out.print("Digite o valor para um Int: ");
									int i = Teclado.getUmInt();
									System.out.println("O valor digitado foi: "+i);
									break;
									
									case 'e':
									System.out.print("Digite o valor para um Long: ");
									long l = Teclado.getUmLong();
									System.out.println("O valor digitado foi: "+l);
									break;
									
									case 'f':
									System.out.print("Digite o valor para um Float: ");
									float f = Teclado.getUmFloat();
									System.out.println("O valor digitado foi: "+f);
									break;
									
									case 'g':
									System.out.print("Digite o valor para um Double: ");
									double d = Teclado.getUmDouble();
									System.out.println("O valor digitado foi: "+d);
									break;
									
									case 'h':
									System.out.print("Digite o valor para um Char: ");
									char c = Teclado.getUmChar();
									System.out.println("O valor digitado foi: "+c);
									break;
									
									case 'i':
									System.out.print("Digite o valor para um Boolean: ");
									boolean boo = Teclado.getUmBoolean();
									System.out.println("O valor digitado foi: "+boo);
									break;
									
									case 'j':
									break;
									
									default:
									System.err.println("Opção inválida! Tente novamente...");
							}
					}
					catch (Exception erro)
					{
							System.err.println(erro.getMessage());
					}
			}
			while (opcao != 'j');
	}
}