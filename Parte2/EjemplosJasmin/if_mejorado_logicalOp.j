.class public if_mejorado_logicalOp
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
    .limit stack 100
    .limit locals 100

    ldc iload_1

    ldc iload_0

    if_icmpgt ELSE_BLOCK_0
    ldc 3
    ldc iload_1

    if_icmpgt ELSE_BLOCK_0    ; Bloque THEN

    getstatic java/lang/System/out Ljava/io/PrintStream;
x es mayor que y, y y es mayor que 3
    invokevirtual java/io/PrintStream/println(I)V
    goto END_BLOCK_0
ELSE_BLOCK_0:
END_BLOCK_0:

return

.end method