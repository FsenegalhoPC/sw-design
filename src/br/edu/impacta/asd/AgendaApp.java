package br.edu.impacta.asd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.out;

public class AgendaApp {
private static Scanner entrada = new Scanner(System.in);
private static List<Contato> contatos = new ArrayList<>();
private static IContatoDao dao = new ContatoDao();
public static void main (String[] args) {
boolean sair = false;
while (!sair) {
int opcao = apresentarMenuPrincipal();
switch (opcao) {
case 1: inserirContato(); break;
case 2: buscarContato(); break;
case 3: sair = true; break;
default: out.println("ERRO: op��o inv�lida!!!");
}
}
out.println("\nFim do programa!");
}
private static int apresentarMenuPrincipal() {
boolean inteiro = false;
int opcao = 0;
while(!inteiro) {
out.println("\nAGENDA TELEF�NICA!");
out.println("(1) Inserir");
out.println("(2) Buscar");
out.println("(3) Sair");
out.println("Escolha uma op��o: ");
String s = entrada.nextLine();
try {
opcao = Integer.parseInt(s);
inteiro = true;
} catch(Exception e) {
out.prinln("ERRO: op��o deve ser um valor inteiro!");
}
}
return opcao;
}
private static void inserirContato() {
out.println ("\nINSER��O DE NOVO CONTATO:");
String nome = lerNome();
String telefone = lerTelefone();
Contato c = new Contato (nome, telefone);
if (contatos.contains(c)) {
out.println("Este contato j� est� cadastrado!");
}
if(dao.existe(c)){
	out.println("Este contato j� esta cadastrado");
}
else {
	dao.inserir(c);
	out.println("Contato Inserido");
contatos.add(c);
out.println("Contato inserido!");
}
}
private static String lerNome(){
boolean valido = false;
String nome = "";
while(!valido){
out.println("nome:  ");
nome = entrada.nextLine();
if(nome.length()==0|| nome.length()>200){
out.println("ERRO: nome de tamanho invalido!");
}else{valido = true;}
}
return nome;
}
private static String telefone = lerTelefone(){
	boolean valido = false;
	String telefone = "";
	while(!valido){
		out.println("telefone:  ");
		telefone = entrada.nextLine();
		if(telefone.length()==0 ||telefone.length()>25){
			out.println("ERRO:telefone de tamanho de Telefone invalido");
		}else{valido = true;}
	}
	return telefone;
}
private static void buscarContato(){
	out.println("\nBusca de Contatos");
	String nome = lerNome();
	List<Contato>resultado = dao.buscar(nome);
}
Contato c = new Contato(nome,telefone);
if(contatos.contains(c)){
out.println("Este contato j� cadastrado!");
else{
contatos.add("Continue daqui")
}
}
}
