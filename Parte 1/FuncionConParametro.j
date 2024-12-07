.class public FuncionConParametro
.super java/lang/Object

; Método principal
.method public static main([Ljava/lang/String;)V
    .limit stack 3
    .limit locals 2

    ; Cargar el valor del parámetro (por ejemplo, 10)
    bipush 10      ; Cargar el valor 10 en el stack

    ; Llamar a la función "miFuncion" con el parámetro
    invokestatic FuncionConParametro/miFuncion(I)I

    ; Guardar el resultado en la variable local 1
    istore_1       

    ; Imprimir el resultado
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload_1        ; Cargar el valor de la variable local 1
    invokevirtual java/io/PrintStream/println(I)V

    ; Finalizar el programa
    return
.end method

; Definición de la función "miFuncion"
.method public static miFuncion(I)I
    .limit stack 2
    .limit locals 1

    ; Multiplicar el parámetro recibido por 2
    iload_0        ; Cargar el parámetro (en la variable local 0)
    iconst_2       ; Cargar el valor 2
    imul           ; Multiplicar el parámetro por 2

    ; Devolver el resultado
    ireturn
.end method
