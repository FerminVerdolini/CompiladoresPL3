.class public if_mejorado_logicalOp
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
    .limit stack 10
    .limit locals 10

    ldc 5
    ldc 10
    if_icmpgt ELSE_BLOCK_0
    ldc 3
    ldc 5
    if_icmpgt ELSE_BLOCK_0    ; Bloque THEN

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "x es mayor que y, y y es mayor que 3"
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    goto END_BLOCK_0
ELSE_BLOCK_0:
END_BLOCK_0:

return

.end method