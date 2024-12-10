.class public IfAnidados
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
    .limit stack 2
    .limit locals 1

    ; Declarar un número (modifica este valor para probar diferentes casos)
    ldc 15           ; Número a evaluar
    istore_0         ; Guardar en la variable local 0

    ; Comprobar si el número es mayor que 10
    iload_0          ; Cargar el número
    bipush 10        ; Cargar el valor 10
    if_icmple menor_o_igual_10 ; Salta si el número <= 10

    ; Si el número es mayor que 10, comprobar si es menor que 20
    iload_0
    bipush 20
    if_icmpge mayor_o_igual_20 ; Salta si el número >= 20

    ; Bloque para números entre 10 y 20
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "El número es mayor que 10 y menor que 20."
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    goto fin

mayor_o_igual_20:
    ; Bloque para números mayores o iguales a 20
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "El número es mayor o igual a 20."
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    goto fin

menor_o_igual_10:
    ; Bloque para números menores o iguales a 10
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "El número es menor o igual a 10."
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

fin:
    ; Finalizar el programa
    return
.end method
