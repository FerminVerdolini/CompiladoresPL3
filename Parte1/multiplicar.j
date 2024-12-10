.class public multiplicar
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
    .limit stack 10
    .limit locals 2

    ; Carga los dos números enteros que queremos multiplicar
    ldc 5          ; Primer número
    ldc 3          ; Segundo número

    ; Realiza la multiplicación
    imul           ; Multiplica los dos números en el stack

    ; Muestra el resultado en pantalla
    getstatic java/lang/System/out Ljava/io/PrintStream;
    swap           ; Intercambia el resultado de la multiplicación y el PrintStream
    invokevirtual java/io/PrintStream/println(I)V

    return
.end method
