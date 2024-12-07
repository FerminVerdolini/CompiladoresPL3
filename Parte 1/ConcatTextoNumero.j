.class public ConcatTextoNumero
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
    .limit stack 5
    .limit locals 2

    ; Crear una nueva instancia de StringBuilder
    new java/lang/StringBuilder
    dup
    invokespecial java/lang/StringBuilder/<init>()V ; Llamar al constructor de StringBuilder

    ; Agregar la cadena de texto
    ldc "El resultado es: "
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    ; Convertir el número a String y agregarlo
    ldc 42                   ; Número que queremos concatenar
    invokestatic java/lang/String/valueOf(I)Ljava/lang/String;
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    ; Convertir el resultado a String
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;

    ; Imprimir la cadena concatenada
    getstatic java/lang/System/out Ljava/io/PrintStream;
    swap
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    return
.end method
