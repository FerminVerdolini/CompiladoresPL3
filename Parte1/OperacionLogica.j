.class public OperacionLogica
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
    .limit stack 3
    .limit locals 2

    ; Carga dos números al stack
    ldc 10          ; Primer número
    ldc 10          ; Segundo número

    ; Compara los dos números (igualdad)
    if_icmpeq son_iguales  ; Salta si son iguales

    ; Si no son iguales
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "Los números NO son iguales."
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    goto fin

son_iguales:
    ; Si son iguales
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "Los números SON iguales."
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

fin:
    ; Finaliza el programa
    return
.end method
