.class public error_tipo
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
    .limit stack 100
    .limit locals 100

    ldc "1"
    astore_0


    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload_0
    ldc 1
    isub

    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

return

.end method