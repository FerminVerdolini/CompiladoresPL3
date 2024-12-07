.class public FuncionConResultado
.super java/lang/Object

; Método principal
.method public static main([Ljava/lang/String;)V
    .limit stack 2
    .limit locals 1

    ; Llamar a la función "miFuncion" y guardar el resultado
    invokestatic FuncionConResultado/miFuncion()I
    istore_0       ; Guardar el resultado en la variable local 0

    ; Imprimir el resultado
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload_0        ; Cargar el valor de la variable local 0
    invokevirtual java/io/PrintStream/println(I)V

    ; Finalizar el programa
    return
.end method

; Definición de la función "miFuncion"
.method public static miFuncion()I
    .limit stack 1
    .limit locals 0

    ; Devolver un valor entero (por ejemplo, 42)
    bipush 42      ; Cargar el valor 42 en el stack
    ireturn        ; Devolver el valor
.end method
