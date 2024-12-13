.class public boolean
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
    .limit stack 100
    .limit locals 100

    ldc 1
    istore_0

    iload_0
    ifeq ELSE_BLOCK_0    ; Bloque THEN

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "Es verdadero"
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    goto END_BLOCK_0
ELSE_BLOCK_0:
    ; Bloque ELSE

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "Es falso"
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
END_BLOCK_0:

return

.end method