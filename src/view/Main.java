package view;

import javax.swing.JOptionPane;

import controller.ControllerProcessos;

public class Main {

	public static void main(String[] args) {
		int escolha = 0;
		ControllerProcessos Pcontrol = new ControllerProcessos();
		String so = Pcontrol.so();
		while(escolha!=3){
			escolha = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opcao:\n\n1 - Lista de Processos\n2 - Matar Processo com PID ou Nome\n3 - Sair")); 
			switch(escolha){
				case 1: Pcontrol.ListaProcessos(so); break;
				case 2: String processo = JOptionPane.showInputDialog(null, "Qual o Nome ou PID do processo que deseja matar?");
				Pcontrol.MatarProcesso(so, processo); break;
				case 3: JOptionPane.showMessageDialog(null, "Aplicacao finalizada"); break;
				default: JOptionPane.showMessageDialog(null, "Opcao Invalida"); break;
			}
		}
	}

}
