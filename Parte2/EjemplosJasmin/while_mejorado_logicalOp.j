.class public while_mejorado_logicalOp
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
    .limit stack 100
    .limit locals 100

    ldc 0
    istore_0

    ldc 10
    istore_1

WHILE_START_0:
        iload_1

        iload_0

    if_icmplt  WHILE_END_0

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "x es par y menor que el límite"
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    iload_0
    ldc 2
    iadd
istore_0
    goto WHILE_START_0
WHILE_END_0: 

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "Fin del bucle"
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

return

.end method