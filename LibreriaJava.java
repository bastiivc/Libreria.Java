import java.io.*;

public class LibreriaJava
{
    public static void main(String[] args) throws IOException
    {
        Integer[] codigoLibro = new Integer [100];
        String[] titulo = new String [100];
        String[] autor = new String [100];
        Integer [] vecesPrestado = new Integer [100];

        int opcion;
        int rentado;
        int pLibre = 0;
        int prestadoDecision;
        int libroEliminar;
        int vacio;
        boolean decision;

        do
        {
            System.out.println("\n--------------------------------------------------------------------------------------------\n");
            System.out.println("Bienvenido a Libreria.Java, por favor seleccione una opcion\n");
            System.out.println("Opcion 1: Agregar libro\nOpcion 2: Ver libros\nOpcion 3: Eliminar un libro\nOpcion 4: Salir del programa");

            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            opcion = Integer.parseInt(entrada.readLine());

            switch(opcion)
            {
                case 1:
                    int i = 0;
                    System.out.println("Usted eligio agregar un libro\n");
                    if (pLibre == 0)
                    {
                        codigoLibro[0] = 0;
                        System.out.println("Porfavor ingrese el titulo del libro");
                        BufferedReader tituloAgregado = new BufferedReader(new InputStreamReader(System.in));
                        titulo[0] = tituloAgregado.readLine();
                        System.out.println("Excelente, ahora ingrese el autor de: " + titulo[0]);
                        BufferedReader autorAgregado = new BufferedReader(new InputStreamReader(System.in));
                        autor[0] = autorAgregado.readLine();
                        vecesPrestado[0] = 0;
                        System.out.println("\nTitulo del libro agregado es: " + titulo[0] + "\n" + "Su autor es: " + autor[0] + "\n" + "Codigo de Identificacion Unico: " + codigoLibro[0] + "\n" + "Su numero de veces prestado es: " + vecesPrestado[0]);
                        pLibre++;
                    }
                    else
                    {
                        while (i < pLibre)
                        {
                            i++;
                        }
                        codigoLibro[i] = pLibre;
                        System.out.println("Porfavor ingrese el titulo del libro");
                        BufferedReader tituloAgregado = new BufferedReader(new InputStreamReader(System.in));
                        titulo[i] = tituloAgregado.readLine();
                        System.out.println("Excelente, ahora ingrese el autor de: " + titulo[i]);
                        BufferedReader autorAgregado = new BufferedReader(new InputStreamReader(System.in));
                        autor[i] = autorAgregado.readLine();
                        vecesPrestado[i] = 0;
                        System.out.println("\nTitulo del libro agregado es: " + titulo[i] + "\n" + "Su autor es: " + autor[i] + "\n" + "Codigo de Identificacion Unico: " + codigoLibro[i] + "\n" + "Su numero de veces prestado es: " + vecesPrestado[i]);
                        pLibre++;
                    }
                break;

                case 2:
                    vacio = 0;
                    System.out.println("Usted eligio Ver libros\n");
                    for(int p = 0; p < pLibre; p++)
                    {
                        if(titulo[p] != null)
                        {
                            vacio++;
                        }
                    }
                    if(vacio != 0)
                    {
                        System.out.println("Estos son los libros que hay disponibles dentro de nuestra biblioteca:\n");
                        for(int j = 0; j < pLibre; j++)
                        {
                            if(titulo[j] == null)
                            {
                                j++;
                            }
                            System.out.println(j + 1 +"." + "Titulo: " +titulo[j] + " " + "Autor: " + autor[j] + " " + "Cantidad de veces Prestado: " + vecesPrestado[j] + " " + "Codigo unico del libro: " + codigoLibro[j] +"\n");
                        }
                        System.out.println("¿Le gustaria tomar prestado uno de estos libros?\nPresione '1' para SI\nPresione '2' para NO");
                        BufferedReader prestado = new BufferedReader(new InputStreamReader(System.in));
                        prestadoDecision = Integer.parseInt(prestado.readLine());
                        if(prestadoDecision == 1)
                        {
                            decision = true;
                        }
                        else
                        {
                            decision = false;
                            System.out.println("Entiendo lo dirigire de vuelta al menu principal");
                        }
                        if(decision == true)
                        {
                            System.out.println("Ingrese codigo unico del libro deseado");
                            BufferedReader elegido = new BufferedReader(new InputStreamReader(System.in));
                            rentado = Integer.parseInt(elegido.readLine());
                            for(int k = 0 ; k < pLibre ; k++)
                            {
                                if(k == rentado)
                                {
                                    vecesPrestado[k]++;
                                }
                            }
                        }
                    }
                    else
                    {
                        System.out.println("Lo lamentamos, no tenemos libros disponibles dentro de nuestro sistema.");
                    }
                break;

                case 3:
                    System.out.println("Usted ha elegido Eliminar un libro\n");
                    System.out.println("Ingrese el codigo unico del libro que se desea eliminar");
                    BufferedReader elegido = new BufferedReader(new InputStreamReader(System.in));
                    libroEliminar = Integer.parseInt(elegido.readLine());
                    for(int h = 0; h < pLibre; h ++)
                    {
                        if(h == libroEliminar)
                        {
                            System.out.println("Libro Eliminado: " + titulo[h] + " " + "autor: " + autor[h] + "\n");
                            titulo[h] = null;
                            autor[h] = null;
                            vecesPrestado[h] = null;
                            codigoLibro[h] = null;
                            System.out.println("Libro eliminado exitosamente, redirigiendo a menu principal");
                        }
                    }
                break;
            }
        }while(opcion != 4);

        System.out.println("¡Gracias por usar Libreria.Java!, que tenga un buen dia, vuelva pronto :)\n");
        System.out.println("--------------------------------------------------------------------------------------------");
    }
}