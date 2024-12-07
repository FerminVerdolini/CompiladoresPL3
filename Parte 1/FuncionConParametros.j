.class public FuncionConVariosParametros
.super java/lang/Object

; Método principal
.method public static main([Ljava/lang/String;)V
    .limit stack 4
    .limit locals 3

    ; Cargar los valores de los parámetros (por ejemplo, 5 y 7)
    iconst_5       ; Cargar el valor 5 en el stack
    bipush 7       ; Cargar el valor 7 en el stack

    ; Llamar a la función "miFuncion" con los dos parámetros
    invokestatic FuncionConVariosParametros/miFuncion(II)I

    ; Guardar el resultado en la variable local 2
    istore_2

    ; Imprimir el resultado
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload_2        ; Cargar el valor de la variable local 2
    invokevirtual java/io/PrintStream/println(I)V

    ; Finalizar el programa
    return
.end method

; Definición de la función "miFuncion"
.method public static miFuncion(II)I
    .limit stack 2
    .limit locals 2

    ; Sumar los dos parámetros recibidos
    iload_0        ; Cargar el primer parámetro (en la variable local 0)
    iload_1        ; Cargar el segundo parámetro (en la variable local 1)
    iadd           ; Sumar los dos valores

    ; Devolver el resultado
    ireturn
.end method
