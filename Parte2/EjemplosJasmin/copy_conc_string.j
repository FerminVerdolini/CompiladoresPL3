.class public copy_conc_string
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
    .limit stack 100
    .limit locals 100

    ldc "Hola"
    astore_0

    ldc " Mundo"
    astore_1

    ldc "Hola"
    astore_2

    ldc "Hola Mundo"
    astore_3


    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload_3

    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

return

.end method