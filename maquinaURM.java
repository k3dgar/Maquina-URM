import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class maquinaURM {
    public static void main(String[] args) {
        ArrayList<String> listaInstrucciones = new ArrayList<String>();// Aqui agaurdare todas las instruciones que me
                                                                       // ingresara el usuario de la maquina URM.
        int[][] registros = new int[100][5];// Esta matriz es para ver los registros de la maquina urm y como se van
                                            // modificando paso por paso con cada instruccion
        int registrosAOcupar;
        for (int i = 0; i < 100; i++) {// llenado de toda la matriz con 0 como una maquina URM al iniciar cualquier
                                       // programa
            for (int j = 0; j < 5; j++) {
                registros[i][j] = 0;
            }
        }

        // Aqui podria poner un letrero para que ingresaran el codigo del programa y las
        // entradas
        // Las instrucciones siguientes no es solo para muestras de prueba, se quitaran
        // y se implementaran de otra forma para el usuario.
        listaInstrucciones.add("S(1)");
        listaInstrucciones.add("S(1)");
        listaInstrucciones.add("S(1)");
        listaInstrucciones.add("T(1,2)");
        listaInstrucciones.add("J(2,3,11)");
        listaInstrucciones.add("S(1)");
        listaInstrucciones.add("S(1)");
        listaInstrucciones.add("S(1)");
        listaInstrucciones.add("S(3)");
        listaInstrucciones.add("J(1,1,5)");

        registrosAOcupar = 3;
        // continuacion
        int numeroInstruccion = 0;// Es para saber en que instruccion de el programa voy
        int filaApuntada = 1;// Esto es para el actualizado de los registros de la maquina URM ya que en mi
                             // caso lo hice paso por paso.
        int registroUtilizado = 0;
        int auxiliarT = 0;// Sera utilizado para la Transferencia

        Pattern p;//Las siguientes 5 instrucciones son para el salto
        Matcher m ;
        int contador;
        int j1=0,j2=0;
        while (numeroInstruccion < listaInstrucciones.size()) {// la condicion de paro es hasta que ya no tenga instruciones que hacer
            switch (listaInstrucciones.get(numeroInstruccion).charAt(0)) {// El switch es para ver que instruccion de las 4 puso para poder ejecutarla.
                case 'Z':
                    System.out.println("Z");
                    p = Pattern.compile("\\b\\d{1,2}\\b");
                        m = p.matcher(listaInstrucciones.get(numeroInstruccion));

                        contador = 0;
                        while (m.find()) {
                            contador++;
                            if (contador == 1) {
                                registroUtilizado =  Integer.parseInt(m.group());
                                System.out.println(registroUtilizado);
                                break;
                            }
                        }
                    registros[filaApuntada][registroUtilizado] = 0;
                    numeroInstruccion++;
                    break;
                case 'S':
                    System.out.println("S");
                     p = Pattern.compile("\\b\\d{1,2}\\b");
                        m = p.matcher(listaInstrucciones.get(numeroInstruccion));

                        contador = 0;
                        while (m.find()) {
                            contador++;
                            if (contador == 1) {
                                registroUtilizado =  Integer.parseInt(m.group());
                                System.out.println(registroUtilizado);
                                break;
                            }
                        }
                    registros[filaApuntada][registroUtilizado] = 1 + registros[filaApuntada - 1][registroUtilizado];
                    numeroInstruccion++;
                    break;
                case 'T':
                    System.out.println("T");
                     p = Pattern.compile("\\b\\d{1,2}\\b");
                        m = p.matcher(listaInstrucciones.get(numeroInstruccion));

                        contador = 0;
                        while (m.find()) {
                            contador++;
                            if (contador == 1) {
                               auxiliarT =  Integer.parseInt(m.group());
                                System.out.println(registroUtilizado);
                                break;
                            }
                        }
                        contador = 0;
                        while (m.find()) {
                            contador++;
                            if (contador == 1) {
                               registroUtilizado=  Integer.parseInt(m.group());
                                System.out.println(registroUtilizado);
                                break;
                            }
                        }
                    registros[filaApuntada][registroUtilizado] = registros[filaApuntada - 1][auxiliarT];
                    numeroInstruccion++;
                    break;
                case 'J':
                    System.out.println("J");
                    p = Pattern.compile("\\b\\d{1,2}\\b");
                        m = p.matcher(listaInstrucciones.get(numeroInstruccion));

                        contador = 0;
                        while (m.find()) {
                            contador++;
                            if (contador == 1) {
                              j1=  Integer.parseInt(m.group());
                                System.out.println(j1);
                            }else if(contador == 2){
                                j2=  Integer.parseInt(m.group());
                                System.out.println(j2);
                                break;
                            }
                        }
                    if (registros[filaApuntada - 1][j1] == registros[filaApuntada - 1][j2]) {
                        p = Pattern.compile("\\b\\d{1,2}\\b");
                        m = p.matcher(listaInstrucciones.get(numeroInstruccion));

                        contador = 0;
                        while (m.find()) {
                            contador++;
                            if (contador == 3) {
                                numeroInstruccion =  Integer.parseInt(m.group())-1;
                                System.out.println(numeroInstruccion);
                                break;
                            }
                        }
                    } else {
                        numeroInstruccion++;
                    }
                    registroUtilizado = 0;
                    break;
                default:
                    break;
            }
            for (int i = 1; i <= registrosAOcupar; i++) {
                if (registroUtilizado != i) {
                    registros[filaApuntada][i] = registros[filaApuntada - 1][i];
                }
            }
            filaApuntada++;
        }
        // Impresion de la tabla de los registros
        System.out.print("| R1 | R2 | R3 | R4 | R5 |\n");
        for (int j = 1; j < filaApuntada; j++) {
            for (int k = 1; k <= registrosAOcupar; k++) {
                System.out.print("  " + registros[j][k] + "  ");
            }
            System.out.println();
        }

    }
}