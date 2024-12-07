.class public FuncionVoid
.super java/lang/Object

; Método principal
.method public static main([Ljava/lang/String;)V
    .limit stack 2
    .limit locals 1

    ; Llamar a la función "funcion"
    invokestatic FuncionVoid/funcion()V

    ; Finalizar el programa
    return
.end method

; Definición de la función "funcion"
.method public static funcion()V
    .limit stack 2
    .limit locals 0

    ; Imprimir un mensaje
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "¡Hola! Esta es una función sin parámetros ni retorno."
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    ; Finalizar la función
    return
.end method
