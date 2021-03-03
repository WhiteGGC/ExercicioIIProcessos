package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ControllerProcessos {

	public ControllerProcessos(){
		super();
	}
	
	public String so(){
		String so = System.getProperty("os.name");
		return so;
	}
	
	public void ListaProcessos(String so){
		if(so.contains("Windows")){
			try {
				Process p = Runtime.getRuntime().exec("TASKLIST /FO TABLE");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha!=null){
					System.out.println(linha);
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(so.contains("Linux")){
			try {
				Process p = Runtime.getRuntime().exec("ps -ef");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha!=null){
					System.out.println(linha);
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void MatarProcesso(String so, String processo){
		if(so.contains("Windows")){
			String cmdPid = "TASKKILL /PID";
			String cmdNome = "TASKKILL /IM";
			int pid = 0;
			StringBuffer buffer = new StringBuffer();
			try{
				pid = Integer.parseInt(processo);
				buffer.append(cmdPid);
				buffer.append(" ");
				buffer.append(pid);
			}catch(NumberFormatException e){
				buffer.append(cmdNome);
				buffer.append(" ");
				buffer.append(processo);
			}
			
			try{
				Runtime.getRuntime().exec(buffer.toString());
			} catch(IOException e){
				String msgErro = e.getMessage();
				System.err.println(msgErro);
			}
		}else if(so.contains("Linux")){
			String cmdPid = "kill -9";
			String cmdNome = "pkill -f";
			int pid = 0;
			StringBuffer buffer = new StringBuffer();
			try{
				pid = Integer.parseInt(processo);
				buffer.append(cmdPid);
				buffer.append(" ");
				buffer.append(pid);
			}catch(NumberFormatException e){
				buffer.append(cmdNome);
				buffer.append(" ");
				buffer.append(processo);
			}
			
			try{
				Runtime.getRuntime().exec(buffer.toString());
			} catch(IOException e){
				String msgErro = e.getMessage();
				System.err.println(msgErro);
			}
		}
	}
}
