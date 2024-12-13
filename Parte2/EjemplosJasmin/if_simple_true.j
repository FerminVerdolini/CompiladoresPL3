.class public if_simple_true
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
    .limit stack 100
    .limit locals 100

    ldc 2
    ldc 1
    if_icmplt ELSE_BLOCK_0    ; Bloque THEN

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "one"
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    goto END_BLOCK_0
ELSE_BLOCK_0:
END_BLOCK_0:
   ldc 1
    ifeq ELSE_BLOCK_1    ; Bloque THEN

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "two"
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    goto END_BLOCK_1
ELSE_BLOCK_1:
END_BLOCK_1:

return

.end method