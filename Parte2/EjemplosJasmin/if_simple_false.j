.class public if_simple_false
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
    .limit stack 100
    .limit locals 100

    ldc 2
    ldc 1
    if_icmpgt ELSE_BLOCK_0    ; Bloque THEN

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "one"
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    goto END_BLOCK_0
ELSE_BLOCK_0:
END_BLOCK_0:
   ldc 0
    ifeq ELSE_BLOCK_1    ; Bloque THEN

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "two"
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    goto END_BLOCK_1
ELSE_BLOCK_1:
END_BLOCK_1:

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "three"
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

return

.end method