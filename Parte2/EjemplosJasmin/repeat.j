.class public repeat
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
    .limit stack 100
    .limit locals 100

    ldc 1
    istore_0

REPEAT_START_0:

    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload_0

    invokevirtual java/io/PrintStream/println(I)V
    iload_0
    ldc 1
    iadd
istore_0

    ; UNTIL 
    ldc 5
    iload_0
    if_icmpeq  END
    goto REPEAT_START_0
END:

return

.end method