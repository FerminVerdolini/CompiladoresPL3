.class public char
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
    .limit stack 100
    .limit locals 100

    ldc 97
    istore_0

    ldc 90
    istore_1


    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload_0

    invokevirtual java/io/PrintStream/println(C)V

    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload_1

    invokevirtual java/io/PrintStream/println(C)V

return

.end method