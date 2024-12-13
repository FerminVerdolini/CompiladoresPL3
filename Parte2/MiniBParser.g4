parser grammar MiniBParser;

options { tokenVocab=MiniBLexer; }

// Regla principal del programa
programa: statement+;

// Declaraciones posibles en MiniB
statement: forStatement
         | ifStatement
         | whileStatement
         | printStatement
         | inputStatement
         | letStatement
         | repeatStatement
         | resizeArrayStatemen
         | functionDeclaration
         | subroutineDeclaration
         | functionCall
         | subroutineCall
         ;

// Bucle FOR
forStatement: FOR IDENTIFIER EQUAL expression TO expression bloqueControl NEXT;

// Declaración condicional IF-ELSE
ifStatement: IF condition THEN bloqueControl (ELSE bloqueControl)? END;

// Bucle WHILE
whileStatement: WHILE condition bloqueControl END;

// Declaración de impresión
printStatement: PRINT expression;

// Declaración de entrada de usuario
inputStatement: INPUT STRING IDENTIFIER;

// Declaración LET (asignación de variable)
letStatement: (LET)? IDENTIFIER EQUAL expression;

// Declaración REPEAT-UNTIL
repeatStatement: REPEAT statement+ UNTIL condition;

resizeArrayStatemen: RESIZE LPAREN IDENTIFIER COMMA expression (COMMA expression)? RPAREN;

// Declaración de función
functionDeclaration: FUNCTION IDENTIFIER LPAREN parameterList? RPAREN bloqueControl RETURN expression END FUNCTION;

// Declaración de subrutina
subroutineDeclaration: SUB IDENTIFIER LPAREN parameterList? RPAREN bloqueControl END SUB;

// Llamada a función
functionCall: IDENTIFIER LPAREN argumentList? RPAREN;

// Llamada a subrutina
subroutineCall: CALL IDENTIFIER LPAREN argumentList? RPAREN;

// Lista de parámetros
parameterList: IDENTIFIER (COMMA IDENTIFIER)*;

// Lista de argumentos
argumentList: expression (COMMA expression)*;

// Operadores Lógicos
logicalOp: AND | OR | NOT;

// Bloque de código reutilizable (para funciones y estructuras de control)
bloqueControl: (statement+ | CONTINUE | EXIT);

// Expresiones y condiciones
condition: expression ((LT | LTE | GT | GTE | EQ | NEQ) expression)? (logicalOp condition)?;

expression: term (expOperations term)*;
term: factor (factorOperations factor)*;

factor: NUMBER                      #Numb
      | FLOAT                       #Flotante
      | IDENTIFIER                  #Ident
      | LPAREN expression RPAREN    #Parent
      | STRING                      #Cadena
      | CHAR                        #Car
      | boolean                     #Bool
      | valFunc                     #Val
      | lenFunc                     #Len
      | isNanFunc                   #Isnan
      | copyFunct                   #Copy
      | concatFunc                  #Concat
      | subStringFunc               #SubStr
      | charAtFunct                 #CharAt
      | arrayLiteral                #ArrayLit
      | arrayAccess                 #ArrayAcc
      ;


boolean: TRUE | FALSE;

valFunc: VAL LPAREN expression RPAREN;
lenFunc:LEN LPAREN expression RPAREN;
isNanFunc:ISNAN LPAREN expression RPAREN;
copyFunct:COPY LPAREN expression RPAREN;
concatFunc: CONCAT LPAREN expression (COMMA expression)+ RPAREN;

subStringFunc: SUBSTRING LPAREN expression COMMA expression COMMA expression RPAREN;
charAtFunct: CHARAT LPAREN expression COMMA expression RPAREN;

arrayLiteral: LBRACKET (expression (COMMA expression)*)? RBRACKET;
arrayAccess: IDENTIFIER LBRACKET expression RBRACKET;

factorOperations:  MULT #mult 
                  | DIV #div
                  | MOD #mod
                  ;
expOperations:     PLUS   #plus
                  | MINUS #minus
                  ;

