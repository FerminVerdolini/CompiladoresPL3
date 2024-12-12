.class public if_mejorado_logicalOp
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
    .limit stack 100
    .limit locals 100

    ldc 10
    istore_0

    ldc 5
    istore_1

        iload_1

        iload_0

    if_icmpgt ELSE_BLOCK_0
    ldc 3
        iload_1

    if_icmpgt ELSE_BLOCK_0    ; Bloque THEN

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "x es mayor que y, y y es mayor que 3"
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    goto END_BLOCK_0
ELSE_BLOCK_0:
END_BLOCK_0:

return

.end method