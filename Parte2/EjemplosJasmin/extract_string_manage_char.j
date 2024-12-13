.class public extract_string_manage_char
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
    .limit stack 100
    .limit locals 100

    ldc "MiniB es genial"
    astore_0

    ldc "MiniB "
    astore_1

    ldc 101
    istore_0


    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload_1

    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload_0

    invokevirtual java/io/PrintStream/println(C)V

return

.end method