.class public if_else_error_sintactico
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
    .limit stack 100
    .limit locals 100

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

return

.end method