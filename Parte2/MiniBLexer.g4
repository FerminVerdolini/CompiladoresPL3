lexer grammar MiniBLexer;

// Palabras clave (insensibles a mayúsculas y minúsculas)
FOR:      [fF] [oO] [rR];
TO:       [tT] [oO];
NEXT:     [nN] [eE] [xX] [tT];
IF:       [iI] [fF];
THEN:     [tT] [hH] [eE] [nN];
ELSE:     [eE] [lL] [sS] [eE];
WHILE:    [wW] [hH] [iI] [lL] [eE];
DO:       [dD] [oO];
END:      [eE] [nN] [dD];
PRINT:    [pP] [rR] [iI] [nN] [tT];
INPUT:    [iI] [nN] [pP] [uU] [tT];
LET:      [lL] [eE] [tT];
MOD:      [mM] [oO] [dD];
CONTINUE: [cC] [oO] [nN] [tT] [iI] [nN] [uU] [eE];
EXIT:     [eE] [xX] [iI] [tT];
REPEAT:   [rR] [eE] [pP] [eE] [aA] [tT];
UNTIL:    [uU] [nN] [tT] [iI] [lL];

// Funciones
VAL:   [vV] [aA] [lL];
LEN:   [lL] [eE] [nN];
ISNAN: [iI] [sS] [nN] [aA] [nN];
COPY:      [cC] [oO] [pP] [yY];
CONCAT:    [cC] [oO] [nN] [cC] [aA] [tT];
SUBSTRING: [sS] [uU] [bB] [sS] [tT] [rR] [iI] [nN] [gG];
CHARAT:    [cC] [hH] [aA] [rR] [aA] [tT];
RESIZE:    [rR] [eE] [sS] [iI] [zZ] [eE];

//funciones y subrutinas
FUNCTION: [fF] [uU] [nN] [cC] [tT] [iI] [oO] [nN];
RETURN:   [rR] [eE] [tT] [uU] [rR] [nN];
SUB:      [sS] [uU] [bB];
CALL:     [cC] [aA] [lL] [lL];



// Operadores y símbolos
EQUAL: '=';
PLUS: '+';
MINUS: '-';
MULT: '*';
DIV: '/';
LT: '<';
LTE: '<=';
GT: '>';
GTE: '>=';
EQ: '==';
NEQ: '!=';
LPAREN: '(';
RPAREN: ')';
LBRACKET: '[';
RBRACKET: ']';
COMMA: ',';
QUOTE: '"';
AND: [Aa] [Nn] [Dd];
OR: [Oo] [Rr];
NOT: [Nn] [Oo] [Tt];
TRUE:  [tT] [rR] [uU] [eE];
FALSE: [fF] [aA] [lL] [sS] [eE];

// Identificadores y literales
IDENTIFIER: [a-zA-Z_][a-zA-Z0-9_]*; // Identificadores
NUMBER: (PLUS | MINUS)? [0-9]+;                    // Números enteros
STRING: '"' .*? '"';                // Cadenas
CHAR: '\'' . '\'';  // caracter
FLOAT: (PLUS | MINUS)? [0-9]+ '.' [0-9]+;  // Flotantes

// Ignorar espacios y saltos de línea
WS: [ \t\r\n]+ -> skip;             

// Ignorar comentarios estilo REM
COMMENT: 'REM' ~[\r\n]* -> skip;    

