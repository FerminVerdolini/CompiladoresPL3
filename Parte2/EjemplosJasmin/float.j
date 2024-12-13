.class public float
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
    .limit stack 100
    .limit locals 100

    ldc 3.14159
    fstore_0


    getstatic java/lang/System/out Ljava/io/PrintStream;
    fload_0
    ldc 1.1
    fadd

    invokevirtual java/io/PrintStream/println(F)V

return

.end method