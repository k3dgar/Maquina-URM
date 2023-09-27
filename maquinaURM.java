import java.util.ArrayList;

public class maquinaURM {
    public static void main(String[] args) {
       ArrayList<String> listaInstrucciones = new ArrayList<String>();//Aqui agaurdare todas las instruciones que me ingresara el usuario de la maquina URM.
        int[][] registros = new int[30][5];// Esta matriz es para ver los registros de la maquina urm y como se van modificando paso por paso con cada instruccion
        int registrosAOcupar;
        for (int i = 0; i < 30; i++) {//llenado de toda la matriz con 0 como una maquina URM al iniciar cualquier programa
            for (int j = 0; j < 5; j++) {
                registros[i][j] = 0;
            }
        }

        //Aqui podria poner un letrero para que ingresaran el codigo del programa y las entradas
        //Las instrucciones siguientes no es solo para muestras de prueba, se quitaran y se implementaran de otra forma para el usuario.
        listaInstrucciones.add("J(2,3,5)");
        listaInstrucciones.add("S(1)");
        listaInstrucciones.add("S(3)");
        listaInstrucciones.add("J(1,1,1)");
        registros[0][1]=5;
        registros[0][2]=2;
        registrosAOcupar=3;
        //continuacion
        int numeroInstruccion=0;//Es para saber en que instruccion de el programa voy
        int filaApuntada=1;//Esto es para el actualizado de los registros de la maquina URM ya que en mi caso lo hice paso por paso.
        int registroUtilizado=0;
        while (numeroInstruccion<listaInstrucciones.size()) {//la condicion de paro es hasta que ya no tenga instruciones que hacer
            switch (listaInstrucciones.get(numeroInstruccion).charAt(0)) {//El switch es para ver que instruccion de las 4 puso para poder ejecutarla.
                case 'Z':
                    System.out.println("Z");
                    registroUtilizado=Character.getNumericValue(listaInstrucciones.get(numeroInstruccion).charAt(2));
                    registros[filaApuntada][registroUtilizado]=0;
                    numeroInstruccion++;
                    break;
                case 'S':
                     System.out.println("S");
                    registroUtilizado=Character.getNumericValue(listaInstrucciones.get(numeroInstruccion).charAt(2));
                    registros[filaApuntada][registroUtilizado]=1+registros[filaApuntada-1][registroUtilizado];
                    numeroInstruccion++;
                    break;
                case 'T':
                     System.out.println("T");
                    registroUtilizado=Character.getNumericValue(listaInstrucciones.get(numeroInstruccion).charAt(4));
                    registros[filaApuntada][registroUtilizado]=registros[filaApuntada-1][registroUtilizado];
                    numeroInstruccion++;
                    break;
                case 'J':
                     System.out.println("J");
                    if(registros[filaApuntada-1][Character.getNumericValue(listaInstrucciones.get(numeroInstruccion).charAt(2))]==registros[filaApuntada-1][Character.getNumericValue(listaInstrucciones.get(numeroInstruccion).charAt(4))]){
                        numeroInstruccion=(Character.getNumericValue(listaInstrucciones.get(numeroInstruccion).charAt(6)))-1;
                    }else{
                        numeroInstruccion++;
                    }
                    registroUtilizado=0;
                    break;
                default:
                    break;
            }
            for (int i = 1; i<=registrosAOcupar; i++) {
               if(registroUtilizado!=i){
                    registros[filaApuntada][i]=registros[filaApuntada-1][i];
               }
            }
            filaApuntada++;
        }
        //Impresion de la tabla de los registros
        System.out.print("| R1 | R2 | R3 | R4 | R5 |\n");
        for (int j = 1; j < filaApuntada; j++) {
            for (int k = 1; k <= registrosAOcupar; k++) {
                System.out.print("  "+registros[j][k]+"  ");
            }
             System.out.println();
        }

    }
}