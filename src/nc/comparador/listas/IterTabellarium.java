package nc.comparador.listas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class IterTabellarium {
	
	public static ArrayList<String> cargarListaEven(String ruta, String filter, int rep, boolean button){
		ArrayList<String> auxLista=new ArrayList<>();
		String[] aenil=null;
		int tope=0;
		
		try {
			BufferedReader br=new BufferedReader(new FileReader(ruta));
			String linea=br.readLine();//Leemos la primera linea del txt.
			linea=br.readLine(); //Leemos otra vez para hacerlo even.
			
			//Ejecutamos un bucle para cargar en el array el resto de categorias,
			while(linea!=null){
				if(button) {													//Bloque para filtrar lo innecesario por el usuario.
					aenil=linea.split(Pattern.quote(filter));					//Dividimos con filter usando Pattern.quote para evitar problemas de ruptura de filtrado.
					tope=Math.min(aenil.length, rep);							//Selecionamos el mínimo de ambos valores para proceder luego a unirlos.
					linea=String.join(filter, Arrays.copyOf(aenil, tope));		//Unimos después de haber rejuntado las partes que se han llegado a filtrar.
				}
				auxLista.add(linea);
				linea=br.readLine();
				linea=br.readLine();
			}
			br.close(); //Cerramos ya que no lo vamos a volver a necesitar.
		} catch (IOException e) {
			System.out.println("Error al cargar el archivo.");
		}
		return auxLista;
	}
	
	public static ArrayList<String> cargarListaOdd(String ruta, String filter, int rep, boolean button){
		ArrayList<String> auxLista=new ArrayList<>();
		String[] aenil=null;
		int tope=0;
		
		try {
			BufferedReader br=new BufferedReader(new FileReader(ruta));
			String linea=br.readLine();//Leemos la primera linea del txt.
			
			//Ejecutamos un bucle para cargar en el array el resto de categorias,
			while(linea!=null){
				if(button) {	//Bloque para filtrar lo innecesario por el usuario.
					aenil=linea.split(Pattern.quote(filter));
					tope=Math.min(aenil.length, rep);
					linea=String.join(filter, Arrays.copyOf(aenil, tope));
				}				
				auxLista.add(linea);
				linea=br.readLine();
				linea=br.readLine();	//Second time to read the next odd number.
			}
			br.close(); //Cerramos ya que no lo vamos a volver a necesitar.
		} catch (IOException e) {
			System.out.println("Error al cargar el archivo.");
		}
		return auxLista;
	}
	
	public static ArrayList<String> cargarListaFull(String ruta, String filter, int rep, boolean button){
		ArrayList<String> auxLista=new ArrayList<>();
		String[] aenil=null;
		int tope=0;
		
		try {
			BufferedReader br=new BufferedReader(new FileReader(ruta));
			String linea=br.readLine();//Leemos la primera linea del txt.
			
			//Ejecutamos un bucle para cargar en el array el resto de categorias,
			while(linea!=null){
				if(button) {	//Bloque para filtrar lo innecesario por el usuario.
					aenil=linea.split(Pattern.quote(filter));
					tope=Math.min(aenil.length, rep);
					linea=String.join(filter, Arrays.copyOf(aenil, tope));
				}
				auxLista.add(linea);
				linea=br.readLine();
			}
			br.close(); //Cerramos ya que no lo vamos a volver a necesitar.
		} catch (IOException e) {
			System.out.println("Error al cargar el archivo.");
		}
		return auxLista;
	}
	
	//Incorporar escritor de archivo en ruta nueva, donde se devuelva la lista de los valores comunes.
	public static void guardarLista(String ruta, ArrayList<String> resultado) {
		int auxNum=0;
		
		try {
			BufferedWriter bw=new BufferedWriter(new FileWriter(ruta,true));
			if(!resultado.isEmpty()) {
				while(auxNum<resultado.size()) {
					bw.write(resultado.get(auxNum));
					bw.newLine();
					auxNum++;
				}
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<String> listasComparadasElementosIguales(ArrayList<String> lista1, ArrayList<String> lista2) {
		ArrayList<String> listaFinal=new ArrayList<>();
		int contador=0;
		int recorrido=0;
		
		if(!lista1.isEmpty() && !lista2.isEmpty()) {
			while(contador<lista1.size()){
				while(recorrido<lista2.size()) {
					if(lista1.get(contador).equals(lista2.get(recorrido))) {
						listaFinal.add(lista1.get(contador));
					}
					recorrido++;
				}
				contador++;
				recorrido=0;
			}
		}
		return listaFinal;
	}
	
	public static ArrayList<String> listasComparadasElementosDiferentes(ArrayList<String> lista1, ArrayList<String> lista2) {
		ArrayList<String> listaFinal=new ArrayList<>();
		int contador=0;
		int recorrido=0;
		short comprobante=0;	//It will be use to know if there was an equal line between .txt files.
		
		if(!lista1.isEmpty() && !lista2.isEmpty()) {
			while(contador<lista1.size()){
				while(recorrido<lista2.size()) {
					if(lista1.get(contador).equals(lista2.get(recorrido))) {
						comprobante++;	//This is allows to know if there is at least one time that there are equals values.
					}
					recorrido++;
				}
				if(comprobante==0) {	//If there are not equal values "comprobante" will be 0, so we can add that value to our new list.
					listaFinal.add(lista1.get(contador));
				}
				contador++;
				recorrido=0;
				comprobante=0;
			}
			
			// Now we have to do the same the other way.
			contador=0;
			recorrido=0;
			while(contador<lista2.size()){
				while(recorrido<lista1.size()) {
					if(lista2.get(contador).equals(lista1.get(recorrido))) {
						comprobante++;	//This is allows to know if there is at least one time that there are equals values.
					}
					recorrido++;
				}
				if(comprobante==0) {	//If there are not equal values "comprobante" will be 0, so we can add that value to our new list.
					listaFinal.add(lista2.get(contador));
				}
				contador++;
				recorrido=0;
				comprobante=0;
			}
		} else if (lista1.isEmpty() && !lista2.isEmpty()) {
			listaFinal=lista2;
		} else if(lista2.isEmpty() && !lista1.isEmpty()) {
			listaFinal=lista1;
		}
		
		return listaFinal;
	}
	
	public static ArrayList<String> selectorCargar(String dir1, String dir2, int sec, int opt, String cadena, int veces, int exception){
		ArrayList<String> auxStr1=null;
		ArrayList<String> auxStr2=null;
		
		switch(sec) {
		case 0:	//All
			if(opt==0){	//None with filter.
				auxStr1=cargarListaFull(dir1, cadena, veces, false);
				auxStr2=cargarListaFull(dir2, cadena, veces, false);
			} else if(opt==1){	//Both with filter.
				auxStr1=cargarListaFull(dir1, cadena, veces, true);
				auxStr2=cargarListaFull(dir2, cadena, veces, true);
			} else if(opt==2){	//1º with filter.
				auxStr1=cargarListaFull(dir1, cadena, veces, true);
				auxStr2=cargarListaFull(dir2, cadena, veces, false);
			} else {	//2º with filter.
				auxStr1=cargarListaFull(dir1, cadena, veces, false);
				auxStr2=cargarListaFull(dir2, cadena, veces, true);
			}
			break;
		case 1:	//Even Both
			if(opt==0){	//None with filter.
				auxStr1=cargarListaEven(dir1, cadena, veces, false);
				auxStr2=cargarListaEven(dir2, cadena, veces, false);
			} else if(opt==1){	//Both with filter.
				auxStr1=cargarListaEven(dir1, cadena, veces, true);
				auxStr2=cargarListaEven(dir2, cadena, veces, true);
			} else if(opt==2){	//1º with filter.
				auxStr1=cargarListaEven(dir1, cadena, veces, true);
				auxStr2=cargarListaEven(dir2, cadena, veces, false);
			} else {	//2º with filter.
				auxStr1=cargarListaEven(dir1, cadena, veces, false);
				auxStr2=cargarListaEven(dir2, cadena, veces, true);
			}
			break;
		case 2:	//Odd Both
			if(opt==0){	//None with filter.
				auxStr1=cargarListaOdd(dir1, cadena, veces, false);
				auxStr2=cargarListaOdd(dir2, cadena, veces, false);
			} else if(opt==1){	//Both with filter.
				auxStr1=cargarListaOdd(dir1, cadena, veces, true);
				auxStr2=cargarListaOdd(dir2, cadena, veces, true);
			} else if(opt==2){	//1º with filter.
				auxStr1=cargarListaOdd(dir1, cadena, veces, true);
				auxStr2=cargarListaOdd(dir2, cadena, veces, false);
			} else {	//2º with filter.
				auxStr1=cargarListaOdd(dir1, cadena, veces, false);
				auxStr2=cargarListaOdd(dir2, cadena, veces, true);
			}
			break;
		case 3:	//Even R1
			if(opt==0){	//None with filter.
				auxStr1=cargarListaEven(dir1, cadena, veces, false);
				auxStr2=cargarListaFull(dir2, cadena, veces, false);
			} else if(opt==1){	//Both with filter.
				auxStr1=cargarListaEven(dir1, cadena, veces, true);
				auxStr2=cargarListaFull(dir2, cadena, veces, true);
			} else if(opt==2){	//1º with filter.
				auxStr1=cargarListaEven(dir1, cadena, veces, true);
				auxStr2=cargarListaFull(dir2, cadena, veces, false);
			} else {	//2º with filter.
				auxStr1=cargarListaEven(dir1, cadena, veces, false);
				auxStr2=cargarListaFull(dir2, cadena, veces, true);
			}
			break;
		case 4:	//Odd R1
			if(opt==0){	//None with filter.
				auxStr1=cargarListaOdd(dir1, cadena, veces, false);
				auxStr2=cargarListaFull(dir2, cadena, veces, false);
			} else if(opt==1){	//Both with filter.
				auxStr1=cargarListaOdd(dir1, cadena, veces, true);
				auxStr2=cargarListaFull(dir2, cadena, veces, true);
			} else if(opt==2){	//1º with filter.
				auxStr1=cargarListaOdd(dir1, cadena, veces, true);
				auxStr2=cargarListaFull(dir2, cadena, veces, false);
			} else {	//2º with filter.
				auxStr1=cargarListaOdd(dir1, cadena, veces, false);
				auxStr2=cargarListaFull(dir2, cadena, veces, true);
			}
			break;
		case 5:	//Even R2
			if(opt==0){	//None with filter.
				auxStr1=cargarListaFull(dir1, cadena, veces, false);
				auxStr2=cargarListaEven(dir2, cadena, veces, false);
			} else if(opt==1){	//Both with filter.
				auxStr1=cargarListaFull(dir1, cadena, veces, true);
				auxStr2=cargarListaEven(dir2, cadena, veces, true);
			} else if(opt==2){	//1º with filter.
				auxStr1=cargarListaFull(dir1, cadena, veces, true);
				auxStr2=cargarListaEven(dir2, cadena, veces, false);
			} else {	//2º with filter.
				auxStr1=cargarListaFull(dir1, cadena, veces, false);
				auxStr2=cargarListaEven(dir2, cadena, veces, true);
			}
			break;
		case 6:	//Odd R2
			if(opt==0){	//None with filter.
				auxStr1=cargarListaFull(dir1, cadena, veces, false);
				auxStr2=cargarListaOdd(dir2, cadena, veces, false);
			} else if(opt==1){	//Both with filter.
				auxStr1=cargarListaFull(dir1, cadena, veces, true);
				auxStr2=cargarListaOdd(dir2, cadena, veces, true);
			} else if(opt==2){	//1º with filter.
				auxStr1=cargarListaFull(dir1, cadena, veces, true);
				auxStr2=cargarListaOdd(dir2, cadena, veces, false);
			} else {	//2º with filter.
				auxStr1=cargarListaFull(dir1, cadena, veces, false);
				auxStr2=cargarListaOdd(dir2, cadena, veces, true);
			}
			break;
		case 7:	//Even R1 and odd R2
			if(opt==0){	//None with filter.
				auxStr1=cargarListaEven(dir1, cadena, veces, false);
				auxStr2=cargarListaOdd(dir2, cadena, veces, false);
			} else if(opt==1){	//Both with filter.
				auxStr1=cargarListaEven(dir1, cadena, veces, true);
				auxStr2=cargarListaOdd(dir2, cadena, veces, true);
			} else if(opt==2){	//1º with filter.
				auxStr1=cargarListaEven(dir1, cadena, veces, true);
				auxStr2=cargarListaOdd(dir2, cadena, veces, false);
			} else {	//2º with filter.
				auxStr1=cargarListaEven(dir1, cadena, veces, false);
				auxStr2=cargarListaOdd(dir2, cadena, veces, true);
			}
			break;
		case 8:	//Odd R1 and even R2
			if(opt==0){	//None with filter.
				auxStr1=cargarListaOdd(dir1, cadena, veces, false);
				auxStr2=cargarListaEven(dir2, cadena, veces, false);
			} else if(opt==1){	//Both with filter.
				auxStr1=cargarListaOdd(dir1, cadena, veces, true);
				auxStr2=cargarListaEven(dir2, cadena, veces, true);
			} else if(opt==2){	//1º with filter.
				auxStr1=cargarListaOdd(dir1, cadena, veces, true);
				auxStr2=cargarListaEven(dir2, cadena, veces, false);
			} else {	//2º with filter.
				auxStr1=cargarListaOdd(dir1, cadena, veces, false);
				auxStr2=cargarListaEven(dir2, cadena, veces, true);
			}
			break;
		}
		if(exception==0) {
			return listasComparadasElementosDiferentes(auxStr1, auxStr2); 
		} else {
			return listasComparadasElementosIguales(auxStr1, auxStr2); 
		}
	}
	
	//Solo version of the modification file, similar but simple than loading two files.
	public static ArrayList<String> cargarStandalone(String dir, int eLines, int mLines, String fLines, int rLines){
		ArrayList<String> auxiliarString=null;
		
		switch(eLines){
		case 0: //All lines.
			if(mLines==0) {
				auxiliarString=cargarListaFull(dir, fLines, rLines, false);
			} else {
				auxiliarString=cargarListaFull(dir, fLines, rLines, true);
			}
			break;
		case 1: //Even lines.
			if(mLines==0) {
				auxiliarString=cargarListaEven(dir, fLines, rLines, false);
			} else {
				auxiliarString=cargarListaEven(dir, fLines, rLines, true);
			}
			break;
		case 2: //Odd lines.
			if(mLines==0) {
				auxiliarString=cargarListaOdd(dir, fLines, rLines, false);
			} else {
				auxiliarString=cargarListaOdd(dir, fLines, rLines, true);
			}
			break;
		}
		
		return auxiliarString;
	}
}
