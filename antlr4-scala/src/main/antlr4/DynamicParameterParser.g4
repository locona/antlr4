parser grammar DynamicParameterParser;

options { tokenVocab=DynamicParameterLexer; }

root
    : functionCall
    ;

// Top Level Description
// Functions
functionCall
    : specificFunction
    | scalarFunctionName LR_BRACKET functionArgs? RR_BRACKET
    ;

specificFunction
    : ( CURRENT_DATE | CURRENT_TIME | CURRENT_TIMESTAMP | LOCALTIME )
    ;

scalarFunctionName
    : CURRENT_DATE | CURRENT_TIME | CURRENT_TIMESTAMP | LOCALTIME
    ;

functionArgs
    : (constant | functionCall)
    (
      COMMA
      (constant | functionCall)
    )*
    ;

// Literals
stringLiteral
    : (
        STRING_CHARSET_NAME? STRING_LITERAL
      ) STRING_LITERAL+
    | (
        STRING_CHARSET_NAME? STRING_LITERAL
      )
    ;

constant
    : stringLiteral
    ;
