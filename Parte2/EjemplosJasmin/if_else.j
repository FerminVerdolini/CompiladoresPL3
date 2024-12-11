.class public if_else
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
    .limit stack 10
    .limit locals 10

    ldc 2
    ldc 1
    if_icmplt ELSE_BLOCK_0    ; Bloque THEN

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "true"
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    goto END_BLOCK_0
ELSE_BLOCK_0:
    ; Bloque ELSE

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "false"
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
END_BLOCK_0:
    ldc 3
    ldc 2
    if_icmpgt ELSE_BLOCK_1    ; Bloque THEN

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "true"
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    goto END_BLOCK_1
ELSE_BLOCK_1:
    ; Bloque ELSE

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "false"
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
END_BLOCK_1:

return

.end method