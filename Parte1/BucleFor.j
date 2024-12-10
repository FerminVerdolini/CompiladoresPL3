.class public BucleFor
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
    .limit stack 2
    .limit locals 2

    ; Inicializar la variable de control del bucle (i = 0)
    iconst_0       ; Cargar el valor 0
    istore_0       ; Guardar en la variable local 0 (i)

inicio_bucle:
    ; Comprobar la condición del bucle (i < 5)
    iload_0        ; Cargar el valor de i
    iconst_5       ; Cargar el límite superior (5)
    if_icmpge fin_bucle ; Salir si i >= 5

    ; Imprimir el valor actual de i
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload_0        ; Cargar el valor de i
    invokevirtual java/io/PrintStream/println(I)V

    ; Incrementar la variable de control (i = i + 1)
    iload_0        ; Cargar el valor de i
    iconst_1       ; Cargar el valor 1
    iadd           ; Sumar i + 1
    istore_0       ; Guardar el nuevo valor en i

    ; Saltar al inicio del bucle
    goto inicio_bucle

fin_bucle:
    ; Finalizar el método
    return
.end method