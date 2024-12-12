.class public for_continue
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
    .limit stack 100
    .limit locals 100

   ; Inicializar las variables locales: 
    ldc 1        ; Cargar el valor inicial
    istore_0          ; Guardar en la variable local 1

    ldc 5        ; Cargar el valor final
    istore_2      ; Guardar en la variable local 2

LOOP_START_0:
    iload_0       ; Cargar i
    iload_2       ; Cargar end
    if_icmpgt LOOP_END_0

    ; Cuerpo del bucle 
    ldc 3
        iload_0

    if_icmplt ELSE_BLOCK_0    ; Bloque THEN
    goto INCREMENTAR
    goto END_BLOCK_0
ELSE_BLOCK_0:
END_BLOCK_0:

    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload_0

    invokevirtual java/io/PrintStream/println(I)V
INCREMENTAR: 
    ; Incrementar i: 1 = 1 + i 
    iload_0           ; Cargar i
    iconst_1      ; Cargar el incremento 
    iadd          ; Sumar i + 1
    istore_0          ; Guardar el nuevo valor de i

    goto LOOP_START_0
    LOOP_END_0:

return

.end method