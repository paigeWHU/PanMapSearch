/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



grammar Sparql;


query
    : prologue (selectQuery | constructQuery | describeQuery | askQuery)? valuesClause EOF
    | updateCommand? EOF
    ;

prologue
    : (baseDecl | prefixDecl)*
    ;

baseDecl
    : BASE IRIREF
    ; 

prefixDecl
    : PREFIX PNAME_NS IRIREF
    ;

selectQuery
    : selectClause datasetClause* whereClause solutionModifier
    ;

subSelect
    : selectClause whereClause solutionModifier valuesClause
    ;
    	
selectClause
    : SELECT (DISTINCT | REDUCED)? (selectVariables+ | '*')
    ;

selectVariables
    : var
    | '(' expression AS var ')'
    ;

constructQuery
    : CONSTRUCT (constructTemplate datasetClause* whereClause solutionModifier | datasetClause* WHERE '{' triplesTemplate? '}' solutionModifier)
    ;

describeQuery
    : DESCRIBE (varOrIRI+ | '*') datasetClause* whereClause? solutionModifier
    ;

askQuery
    : ASK datasetClause* whereClause solutionModifier
    ;

datasetClause
    : FROM NAMED? iri
    ;

whereClause
    : WHERE? groupGraphPattern
    ;

solutionModifier
    : groupClause? havingClause? orderClause? limitOffsetClauses?
    ;

groupClause
    : GROUP BY groupCondition+
    ;
    		 
groupCondition
    : builtInCall | functionCall | '(' expression (AS var)? ')' | var
    ;
    
havingClause
    : HAVING havingCondition+
    ;
    
havingCondition
    : constraint
    ;
    
orderClause
    : ORDER BY orderCondition+
    ;

orderCondition
    : (ASC|DESC) '(' expression ')' 
    | constraint 
    | var
    ;
	    
limitOffsetClauses
    : limitClause offsetClause? | offsetClause limitClause?
    ;

limitClause
    : LIMIT INTEGER
    ;

offsetClause
    : OFFSET INTEGER
    ;

valuesClause
    : (VALUES dataBlock)?
    ;
    
updateCommand
    : prologue (update (';' prologue update)* (';' prologue)?)?
    ;

update
    : load | clear | drop | add | move | copy | create | insertData | deleteData | deleteWhere | modify
    ;   
    
load 	  
    : LOAD SILENT? iri (INTO graphRef)?
    ;
    
clear
    : CLEAR  SILENT? graphRefAll
    ;
    
drop
    : DROP SILENT? graphRefAll
    ; 

create
    : CREATE SILENT? graphRef
    ;
    
add
    : ADD SILENT? graphOrDefault TO graphOrDefault
    ;
    
move
    : MOVE SILENT? graphOrDefault TO graphOrDefault
    ;
    
copy
    : COPY SILENT? graphOrDefault TO graphOrDefault
    ;

insertData
    : INSERT DATA quadData
    ;

deleteData
    : DELETE DATA quadData
    ;

deleteWhere
    : DELETE WHERE quadPattern
    ;
    
modify
    : (WITH iri)? (deleteClause insertClause? | insertClause) usingClause* WHERE groupGraphPattern
    ;
  
deleteClause
    : DELETE quadPattern
    ;
      
insertClause
    : INSERT quadPattern
    ;

usingClause
    : USING NAMED? iri
    ;

graphOrDefault	  
    : DEFAULT | GRAPH? iri
    ;
    	    	
graphRef
    : GRAPH iri
    ;

graphRefAll
    : graphRef | DEFAULT | NAMED | ALL
    ;

quadPattern
    : '{' quads '}'
    ;
    
quadData
    : '{' quads '}'
    ;
    
quads
    : triplesTemplate? quadsDetails* 
    ;

quadsDetails
    : quadsNotTriples '.'? triplesTemplate?
    ;

quadsNotTriples
    : GRAPH varOrIRI '{' triplesTemplate? '}'
    ;
    
triplesTemplate
    : triplesSameSubject ('.' triplesSameSubject?)*
    ;
    	
groupGraphPattern
    : '{' (subSelect | groupGraphPatternSub) '}'
    ;
    
groupGraphPatternSub
    : triplesBlock?  groupGraphPatternSubList*
    ;
    
groupGraphPatternSubList
    : graphPatternNotTriples '.'? triplesBlock?
    ;
    
triplesBlock
    :  triplesSameSubjectPath ('.' triplesSameSubjectPath?)*
    ;

graphPatternNotTriples
    : groupOrUnionGraphPattern | optionalGraphPattern | minusGraphPattern | graphGraphPattern | serviceGraphPattern | filter | bind | inlineData
    ;

optionalGraphPattern
    : OPTIONAL groupGraphPattern
    ;

graphGraphPattern
    : GRAPH varOrIRI groupGraphPattern
    ;

serviceGraphPattern
    : SERVICE SILENT? varOrIRI groupGraphPattern
    ;
    
bind
    : BIND '(' expression AS var ')'
    ;
    	
inlineData
    : VALUES dataBlock
    ;

dataBlock
    : inlineDataOneVar | inlineDataFull
    ;

inlineDataOneVar
    : var '{' dataBlockValue* '}'
    ;

inlineDataFull
    : '(' var* ')' '{' dataBlockValues* '}'
    ;

dataBlockValues
    : '(' dataBlockValue* ')'
    ;

dataBlockValue
    : iri | rdfLiteral | numericLiteral | booleanLiteral | UNDEF
    ;

minusGraphPattern
    : MINUS groupGraphPattern
    ;

groupOrUnionGraphPattern
    : groupGraphPattern (UNION groupGraphPattern)*
    ;

filter
    : FILTER constraint
    ;

constraint
    : '('? functionList ')'?| '(' expression ')' | builtInCall | functionCall 
    ;

functionList
    :  function ( AND| OR function)*
    ;
 
function
    : ID OPEN_BRACE paramDeclList CLOSE_BRACE
    ;



paramDeclList
    : (expression (COMMA expression)*)?
    ;




   
functionCall
    : iri argList
    ;

argList
    : '(' (DISTINCT? expressionList| /* argList is allowed to be empty */) ')'
    ;

expressionList
    : expression (',' expression)*
    ;

constructTemplate
    : '{' constructTriples? '}'
    ;

constructTriples
    : triplesSameSubject ('.' constructTriples?)*
    ;

triplesSameSubject
    : varOrTerm propertyListNotEmpty | triplesNode propertyList 
    ;
 
propertyList
    : propertyListNotEmpty?
    ;

propertyListNotEmpty
    : verb objectList (';' (verb objectList)?)* 
    ;

verb
    : varOrIRI | A
    ;    

objectList
    : object (',' object)*
    ;

object
    : graphNode
    ;

triplesSameSubjectPath
    : varOrTerm propertyListPathNotEmpty | triplesNodePath propertyListPath
    ;
  
propertyListPath
    : propertyListPathNotEmpty?
    ;  

propertyListPathNotEmpty
    : (verbPath|verbSimple) objectListPath (';' propertyListPathNotEmptyList?)*
    ;

propertyListPathNotEmptyList
    : (verbPath|verbSimple) objectList
    ;

verbPath
    : path
    ;
    
verbSimple
    : var
    ;
    	
objectListPath
    : objectPath (',' objectPath)*
    ;

objectPath
    : graphNodePath
    ;

path
    : pathAlternative
    ; 

pathAlternative
    : pathSequence ('|' pathSequence)*
    ;
    
pathSequence
    : pathEltOrInverse ('/' pathEltOrInverse)*
    ;
       	  	
pathElt
    : pathPrimary pathMod?
    ;

pathEltOrInverse
    : INVERSE? pathElt
    ;

pathMod
    : op=('?'| '*' | '+') 
    ;

pathPrimary
    : iri | A | '!' pathNegatedPropertySet | '(' path ')'
    ;

pathNegatedPropertySet
    : pathOneInPropertySet | '(' (pathOneInPropertySet ('|' pathOneInPropertySet)*)? ')'
    ;  	

pathOneInPropertySet
    : INVERSE? (iri | A)
    ;
	
integer
    : INTEGER
    ;
    
triplesNode
    : collection | blankNodePropertyList
    ;

blankNodePropertyList
    : '[' propertyListNotEmpty ']'
    ;

triplesNodePath
    : collectionPath | blankNodePropertyListPath
    ;

blankNodePropertyListPath
    : '[' propertyListPathNotEmpty ']'
    ;

collection
    : '(' graphNode+ ')'
    ;

collectionPath
    : '(' graphNodePath+ ')'
    ;
    
graphNode
    : varOrTerm | triplesNode
    ;

graphNodePath
    : varOrTerm | triplesNodePath
    ;

varOrTerm
    : var | graphTerm
    ;

varOrIRI
    : var | iri
    ;

var
    : VAR1 | VAR2
    ;

graphTerm
    : iri | rdfLiteral | numericLiteral | booleanLiteral | blankNode | nil
    ;
    
nil
    : '(' ')'
    ;

/* ANTLR V4 branded expressions */
expression
    : primaryExpression                                     # baseExpression
    | op=('*'|'/') expression                               # unaryMultiplicativeExpression
    | op=('+'|'-') expression                               # unaryAdditiveExpression
    | '!' expression                                        # unaryNegationExpression
    | expression op=('*'|'/') expression                    # multiplicativeExpression
    | expression op=('+'|'-') expression                    # additiveExpression
    | expression unaryLiteralExpression                     # unarySignedLiteralExpression   
    | expression NOT? IN '(' expressionList? ')'            # relationalSetExpression
    | expression op=('='|'!='|'<'|'>'|'<='|'>=') expression # relationalExpression
    | expression ('&&' expression)                          # conditionalAndExpression
    | expression ('||' expression)                          # conditionalOrExpression
    ;

unaryLiteralExpression
    : (numericLiteralPositive|numericLiteralNegative) (op=('*'|'/') unaryExpression)? 
    ;

unaryExpression
    : op=('!'|'+'|'-')? primaryExpression
    ;

primaryExpression
    : '(' expression ')' | builtInCall | iriRefOrFunction | rdfLiteral | numericLiteral | booleanLiteral | var |function
    ;

builtInCall
    : aggregate
    | STR '(' expression ')'
    | LANG '(' expression ')'
    | LANGMATCHES '(' expression ',' expression ')'
    | DATATYPE '(' expression ')'
    | BOUND '(' var ')'
    | IRI '(' expression ')'
    | URI '(' expression ')'
    | BNODE '(' expression? ')'
    | RAND '(' ')'
    | ABS '(' expression ')'
    | CEIL '(' expression ')'
    | FLOOR '(' expression ')'
    | ROUND '(' expression ')'
    | CONCAT '(' expressionList? ')'
    | subStringExpression
    | STRLEN '(' expression ')'
    | strReplaceExpression
    | UCASE '(' expression ')'
    | LCASE '(' expression ')'
    | ENCODE_FOR_URI '(' expression ')'
    | CONTAINS '(' expression ',' expression ')'
    | STRSTARTS '(' expression ',' expression ')'
    | STRENDS '(' expression ',' expression ')'
    | STRBEFORE '(' expression ',' expression ')'
    | STRAFTER '(' expression ',' expression ')'
    | YEAR '(' expression ')'
    | MONTH '(' expression ')'
    | DAY '(' expression ')'
    | HOURS '(' expression ')'
    | MINUTES '(' expression ')'
    | SECONDS '(' expression ')'
    | TIMEZONE '(' expression ')'
    | TZ '(' expression ')'
    | NOW '(' ')'
    | UUID '(' ')'
    | STRUUID '(' ')'
    | MD5 '(' expression ')'
    | SHA1 '(' expression ')'
    | SHA256 '(' expression ')'
    | SHA384 '(' expression ')'
    | SHA512 '(' expression ')'
    | COALESCE '(' expressionList? ')'
    | IF '(' expression ',' expression ',' expression ')'
    | STRLANG '(' expression ',' expression ')'
    | STRDT '(' expression ',' expression ')'
    | SAMETERM '(' expression ',' expression ')'
    | ISIRI '(' expression ')'
    | ISURI '(' expression ')'
    | ISBLANK '(' expression ')'
    | ISLITERAL '(' expression ')'
    | ISNUMERIC '(' expression ')'
    | regexExpression
    | existsFunction
    | notExistsFunction
    ;

regexExpression
    : REGEX '(' expression ',' expression (',' expression)? ')'
    ;
    
subStringExpression
    : SUBSTR '(' expression ',' expression (',' expression)? ')'
    ;
    
strReplaceExpression
    : REPLACE '(' expression ',' expression ',' expression (',' expression)? ')'
    ;
    
existsFunction
    : EXISTS groupGraphPattern
    ;

notExistsFunction
    : NOT EXISTS groupGraphPattern
    ;

aggregate
    : COUNT '(' DISTINCT? (ASTERISK | expression) ')'
    | SUM '(' DISTINCT? expression ')'
    | MIN '(' DISTINCT? expression ')'
    | MAX '(' DISTINCT? expression ')'
    | AVG '(' DISTINCT? expression ')'
    | SAMPLE '(' DISTINCT? expression ')'
    | GROUP_CONCAT '(' DISTINCT? expression (';' SEPARATOR '=' string)? ')'
    ;
    
iriRefOrFunction
    : iri argList?
    ;

rdfLiteral
    : string (LANGTAG | ('^^' iri))?
    ;

numericLiteral
    : numericLiteralUnsigned | numericLiteralPositive | numericLiteralNegative
    ;

numericLiteralUnsigned
    : INTEGER | DECIMAL | DOUBLE
    ;

numericLiteralPositive
    : INTEGER_POSITIVE | DECIMAL_POSITIVE | DOUBLE_POSITIVE
    ;

numericLiteralNegative
    : INTEGER_NEGATIVE | DECIMAL_NEGATIVE | DOUBLE_NEGATIVE
    ;

booleanLiteral
    : TRUE | FALSE
    ;

string
    : STRING_LITERAL1 | STRING_LITERAL2 | STRING_LITERAL_LONG1 | STRING_LITERAL_LONG2
    ;

iri
    : IRIREF | prefixedName
    ;

prefixedName
    : PNAME_LN | PNAME_NS
    ;

blankNode
    : BLANK_NODE_LABEL | anon
    ;

anon
    : '[' ']'
    ;
// $>

WS : (' '| '\t'| EOL)+ -> channel(99);

BASE : ('B'|'b')('A'|'a')('S'|'s')('E'|'e');

PREFIX : ('P'|'p')('R'|'r')('E'|'e')('F'|'f')('I'|'i')('X'|'x');

SELECT : ('S'|'s')('E'|'e')('L'|'l')('E'|'e')('C'|'c')('T'|'t');

DISTINCT : ('D'|'d')('I'|'i')('S'|'s')('T'|'t')('I'|'i')('N'|'n')('C'|'c')('T'|'t');

REDUCED : ('R'|'r')('E'|'e')('D'|'d')('U'|'u')('C'|'c')('E'|'e')('D'|'d');

CONSTRUCT : ('C'|'c')('O'|'o')('N'|'n')('S'|'s')('T'|'t')('R'|'r')('U'|'u')('C'|'c')('T'|'t');

DESCRIBE : ('D'|'d')('E'|'e')('S'|'s')('C'|'c')('R'|'r')('I'|'i')('B'|'b')('E'|'e');

ASK : ('A'|'a')('S'|'s')('K'|'k');

FROM : ('F'|'f')('R'|'r')('O'|'o')('M'|'m');

NAMED : ('N'|'n')('A'|'a')('M'|'m')('E'|'e')('D'|'d');   

WHERE : ('W'|'w')('H'|'h')('E'|'e')('R'|'r')('E'|'e');

ORDER : ('O'|'o')('R'|'r')('D'|'d')('E'|'e')('R'|'r');

BY : ('B'|'b')('Y'|'y');

ASC : ('A'|'a')('S'|'s')('C'|'c');

DESC : ('D'|'d')('E'|'e')('S'|'s')('C'|'c');

LIMIT : ('L'|'l')('I'|'i')('M'|'m')('I'|'i')('T'|'t');

OFFSET : ('O'|'o')('F'|'f')('F'|'f')('S'|'s')('E'|'e')('T'|'t');

VALUES : ('V'|'v')('A'|'a')('L'|'l')('U'|'u')('E'|'e')('S'|'s');

OPTIONAL : ('O'|'o')('P'|'p')('T'|'t')('I'|'i')('O'|'o')('N'|'n')('A'|'a')('L'|'l');  

GRAPH : ('G'|'g')('R'|'r')('A'|'a')('P'|'p')('H'|'h');   

UNION : ('U'|'u')('N'|'n')('I'|'i')('O'|'o')('N'|'n');

FILTER : ('F'|'f')('I'|'i')('L'|'l')('T'|'t')('E'|'e')('R'|'r');

A : 'a';

STR : ('S'|'s')('T'|'t')('R'|'r');

LANG : ('L'|'l')('A'|'a')('N'|'n')('G'|'g');

LANGMATCHES : ('L'|'l')('A'|'a')('N'|'n')('G'|'g')('M'|'m')('A'|'a')('T'|'t')('C'|'c')('H'|'h')('E'|'e')('S'|'s');

DATATYPE : ('D'|'d')('A'|'a')('T'|'t')('A'|'a')('T'|'t')('Y'|'y')('P'|'p')('E'|'e');

BOUND : ('B'|'b')('O'|'o')('U'|'u')('N'|'n')('D'|'d');

SAMETERM : ('S'|'s')('A'|'a')('M'|'m')('E'|'e')('T'|'t')('E'|'e')('R'|'r')('M'|'m');

ISIRI : ('I'|'i')('S'|'s')('I'|'i')('R'|'r')('I'|'i');

ISURI : ('I'|'i')('S'|'s')('U'|'u')('R'|'r')('I'|'i');

ISBLANK : ('I'|'i')('S'|'s')('B'|'b')('L'|'l')('A'|'a')('N'|'n')('K'|'k');

ISLITERAL : ('I'|'i')('S'|'s')('L'|'l')('I'|'i')('T'|'t')('E'|'e')('R'|'r')('A'|'a')('L'|'l');

REGEX : ('R'|'r')('E'|'e')('G'|'g')('E'|'e')('X'|'x');

SUBSTR : ('S'|'s')('U'|'u')('B'|'b')('S'|'s')('T'|'t')('R'|'r');

TRUE : ('T'|'t')('R'|'r')('U'|'u')('E'|'e');

FALSE : ('F'|'f')('A'|'a')('L'|'l')('S'|'s')('E'|'e');

LOAD : ('L'|'l')('O'|'o')('A'|'a')('D'|'d');
    
CLEAR : ('C'|'c')('L'|'l')('E'|'e')('A'|'a')('R'|'r');
    
DROP : ('D'|'d')('R'|'r')('O'|'o')('P'|'p');

ADD : ('A'|'a')('D'|'d')('D'|'d');

MOVE : ('M'|'m')('O'|'o')('V'|'v')('E'|'e');

COPY : ('C'|'c')('O'|'o')('P'|'p')('Y'|'y');	
    
CREATE 	: ('C'|'c')('R'|'r')('E'|'e')('A'|'a')('T'|'t')('E'|'e');
    
DELETE : ('D'|'d')('E'|'e')('L'|'l')('E'|'e')('T'|'t')('E'|'e');
    	
INSERT : ('I'|'i')('N'|'n')('S'|'s')('E'|'e')('R'|'r')('T'|'t');
    
USING : ('U'|'u')('S'|'s')('I'|'i')('N'|'n')('G'|'g');	 
    
SILENT : ('S'|'s')('I'|'i')('L'|'l')('E'|'e')('N'|'n')('T'|'t'); 
    	
DEFAULT : ('D'|'d')('E'|'e')('F'|'f')('A'|'a')('U'|'u')('L'|'l')('T'|'t');  
    
ALL : ('A'|'a')('L'|'l')('L'|'l');

DATA : ('D'|'d')('A'|'a')('T'|'t')('A'|'a');
    
WITH : ('W'|'w')('I'|'i')('T'|'t')('H'|'h');
    
INTO : ('I'|'i')('N'|'n')('T'|'t')('O'|'o'); 

TO : ('T'|'t')('O'|'o'); 	 

AS : ('A'|'a')('S'|'s');

GROUP : ('G'|'g')('R'|'r')('O'|'o')('U'|'u')('P'|'p');
    
HAVING : ('H'|'h')('A'|'a')('V'|'v')('I'|'i')('N'|'n')('G'|'g');

UNDEF : ('U'|'u')('N'|'n')('D'|'d')('E'|'e')('F'|'f');
    
BINDINGS : ('B'|'b')('I'|'i')('N'|'n')('D'|'d')('I'|'i')('N'|'n')('G'|'g')('S'|'s');  

SERVICE : ('S'|'s')('E'|'e')('R'|'r')('V'|'v')('I'|'i')('C'|'c')('E'|'e');

BIND : ('B'|'b')('I'|'i')('N'|'n')('D'|'d');

MINUS : ('M'|'m')('I'|'i')('N'|'n')('U'|'u')('S'|'s');

IRI : ('I'|'i')('R'|'r')('I'|'i');
    	 
URI : ('U'|'u')('R'|'r')('I'|'i');
    		
BNODE : ('B'|'b')('N'|'n')('O'|'o')('D'|'d')('E'|'e');

RAND : ('R'|'r')('A'|'a')('N'|'n')('D'|'d');

ABS: ('A'|'a')('B'|'b')('S'|'s');

CEIL : ('C'|'c')('E'|'e')('I'|'i')('L'|'l');

FLOOR : ('F'|'f')('L'|'l')('O'|'o')('O'|'o')('R'|'r');

ROUND : ('R'|'r')('O'|'o')('U'|'u')('N'|'n')('D'|'d');

CONCAT 	: ('C'|'c')('O'|'o')('N'|'n')('C'|'c')('A'|'a')('T'|'t');

STRLEN : ('S'|'s')('T'|'t')('R'|'r')('L'|'l')('E'|'e')('N'|'n');

UCASE : ('U'|'u')('C'|'c')('A'|'a')('S'|'s')('E'|'e');

LCASE : ('L'|'l')('C'|'c')('A'|'a')('S'|'s')('E'|'e');	

ENCODE_FOR_URI : ('E'|'e')('N'|'n')('C'|'c')('O'|'o')('D'|'d')('E'|'e')'_'('F'|'f')('O'|'o')('R'|'r')'_'('U'|'u')('R'|'r')('I'|'i');

CONTAINS : ('C'|'c')('O'|'o')('N'|'n')('T'|'t')('A'|'a')('I'|'i')('N'|'n')('S'|'s');

STRSTARTS : ('S'|'s')('T'|'t')('R'|'r')('S'|'s')('T'|'t')('A'|'a')('R'|'r')('T'|'t')('S'|'s');

STRENDS : ('S'|'s')('T'|'t')('R'|'r')('E'|'e')('N'|'n')('D'|'d')('S'|'s');

STRBEFORE : ('S'|'s')('T'|'t')('R'|'r')('B'|'b')('E'|'e')('F'|'f')('O'|'o')('R'|'r')('E'|'e');

STRAFTER : ('S'|'s')('T'|'t')('R'|'r')('A'|'a')('F'|'f')('T'|'t')('E'|'e')('R'|'r');

REPLACE : ('R'|'r')('E'|'e')('P'|'p')('L'|'l')('A'|'a')('C'|'c')('E'|'e');

YEAR : ('Y'|'y')('E'|'e')('A'|'a')('R'|'r');

MONTH : ('M'|'m')('O'|'o')('N'|'n')('T'|'t')('H'|'h');

DAY : ('D'|'d')('A'|'a')('Y'|'y');

HOURS : ('H'|'h')('O'|'o')('U'|'u')('R'|'r')('S'|'s');

MINUTES : ('M'|'m')('I'|'i')('N'|'n')('U'|'u')('T'|'t')('E'|'e')('S'|'s');

SECONDS : ('S'|'s')('E'|'e')('C'|'c')('O'|'o')('N'|'n')('D'|'d')('S'|'s');	

TIMEZONE :  ('T'|'t')('I'|'i')('M'|'m')('E'|'e')('Z'|'z')('O'|'o')('N'|'n')('E'|'e');

TZ : ('T'|'t')('Z'|'z');

NOW : ('N'|'n')('O'|'o')('W'|'w');

UUID : ('U'|'u')('U'|'u')('I'|'i')('D'|'d');

STRUUID : ('S'|'s')('T'|'t')('R'|'r')('U'|'u')('U'|'u')('I'|'i')('D'|'d');

MD5 : ('M'|'m')('D'|'d')'5';

SHA1 : ('S'|'s')('H'|'h')('A'|'a')'1';

SHA256 : ('S'|'s')('H'|'h')('A'|'a')'256';	

SHA384 : ('S'|'s')('H'|'h')('A'|'a')'384'; 

SHA512 : ('S'|'s')('H'|'h')('A'|'a')'512';
    		 
COALESCE : ('C'|'c')('O'|'o')('A'|'a')('L'|'l')('E'|'e')('S'|'s')('C'|'c')('E'|'e');
    	 
IF : ('I'|'i')('F'|'f');

STRLANG : ('S'|'s')('T'|'t')('R'|'r')('L'|'l')('A'|'a')('N'|'n')('G'|'g');
    
STRDT : ('S'|'s')('T'|'t')('R'|'r')('D'|'d')('T'|'t');
    
ISNUMERIC : ('I'|'i')('S'|'s')('N'|'n')('U'|'u')('M'|'m')('E'|'e')('R'|'r')('I'|'i')('C'|'c');	

COUNT : ('C'|'c')('O'|'o')('U'|'u')('N'|'n')('T'|'t');
    
SUM : ('S'|'s')('U'|'u')('M'|'m');	  
    
MIN : ('M'|'m')('I'|'i')('N'|'n');  
    
MAX : ('M'|'m')('A'|'a')('X'|'x');
     
AVG : ('A'|'a')('V'|'v')('G'|'g');

SAMPLE : ('S'|'s')('A'|'a')('M'|'m')('P'|'p')('L'|'l')('E'|'e');    
 
GROUP_CONCAT  :	 ('G'|'g')('R'|'r')('O'|'o')('U'|'u')('P'|'p') '_' ('C'|'c')('O'|'o')('N'|'n')('C'|'c')('A'|'a')('T'|'t');

NOT : ('N'|'n')('O'|'o')('T'|'t');
    
IN : ('I'|'i')('N'|'n');

EXISTS : ('E'|'e')('X'|'x')('I'|'i')('S'|'s')('T'|'t')('S'|'s');
    
SEPARATOR : ('S'|'s')('E'|'e')('P'|'p')('A'|'a')('R'|'r')('A'|'a')('T'|'t')('O'|'o')('R'|'r');

IRIREF
    : '<' (~('<' | '>' | '"' | '{' | '}' | '|' | '^' | '`' | '\\' | '\u0000'..'\u0020'))* '>'
    ;

PNAME_NS : PN_PREFIX? ':';

PNAME_LN : PNAME_NS PN_LOCAL;
    
BLANK_NODE_LABEL : '_:' (PN_CHARS_U|DIGIT) ((PN_CHARS|DOT)* PN_CHARS)?;

VAR1 : '?' VARNAME;

VAR2 : '$' VARNAME;

LANGTAG : '@' ('A'..'Z'|'a'..'z')+ (MINUS_SIGN ('A'..'Z'|'a'..'z'|DIGIT)+)*;

INTEGER : DIGIT+;

DECIMAL
    : DIGIT+ DOT DIGIT* /* Allows decimal with no fraction: 1. */
    | DOT DIGIT+
    ;

DOUBLE
    : DIGIT+ DOT DIGIT* EXPONENT
    | DOT DIGIT+ EXPONENT
    | DIGIT+ EXPONENT
    ;

INTEGER_POSITIVE : PLUS_SIGN INTEGER;

DECIMAL_POSITIVE : PLUS_SIGN DECIMAL;

DOUBLE_POSITIVE : PLUS_SIGN DOUBLE;

INTEGER_NEGATIVE : MINUS_SIGN INTEGER;

DECIMAL_NEGATIVE : MINUS_SIGN DECIMAL;

DOUBLE_NEGATIVE : MINUS_SIGN DOUBLE;
    
fragment
EXPONENT : ('e'|'E') SIGN? DIGIT+;

STRING_LITERAL1 : '\'' (~('\'' | '\\' | '\n' | '\r') | ECHAR)* '\'';

STRING_LITERAL2 : '"' (~('"' | '\\' | '\n' | '\r') | ECHAR)* '"';

STRING_LITERAL_LONG1 : '\'\'\'' (('\'' | '\'\'')? (~('\''|'\\') | ECHAR))* '\'\'\'';

STRING_LITERAL_LONG2 : '"""' (('"' | '""')? (~('"'|'\\') | ECHAR))* '"""';

fragment
ECHAR : '\\' ('t' | 'b' | 'n' | 'r' | 'f' | '\\' | '"' | '\'');

fragment
PN_CHARS_BASE
    : 'A'..'Z'
    | 'a'..'z'
    | '\u00C0'..'\u00D6'
    | '\u00D8'..'\u00F6'
    | '\u00F8'..'\u02FF'
    | '\u0370'..'\u037D'
    | '\u037F'..'\u1FFF'
    | '\u200C'..'\u200D'
    | '\u2070'..'\u218F'
    | '\u2C00'..'\u2FEF'
    | '\u3001'..'\uD7FF'
    | '\uF900'..'\uFDCF'
    | '\uFDF0'..'\uFFFD'
    //| '\u10000'..'\uEFFFF'
    ;

fragment
PN_CHARS_U : PN_CHARS_BASE | '_';

fragment
VARNAME : (PN_CHARS_U | DIGIT) (PN_CHARS_U | DIGIT | '\u00B7' | '\u0300'..'\u036F' | '\u203F'..'\u2040')*;

fragment
PN_CHARS : PN_CHARS_U | MINUS_SIGN | DIGIT | '\u00B7' | '\u0300'..'\u036F' | '\u203F'..'\u2040';

fragment
PN_PREFIX : PN_CHARS_BASE ((PN_CHARS|DOT)* PN_CHARS)?;

fragment
PN_LOCAL : (PN_CHARS_U|':'|DIGIT|PLX) ((PN_CHARS|DOT|':'|PLX)* (PN_CHARS|':'|PLX))?;

fragment
PLX : PERCENT | PN_LOCAL_ESC;

fragment
PERCENT : '%' HEX HEX;

fragment
HEX : DIGIT | 'A'..'F' | 'a'..'z';

fragment
PN_LOCAL_ESC : '\\' ( '_' | '~' | '.' | '-' | '!' | '$' | '&' | '\'' | '(' | ')' | '*' | '+' | ',' | ';' | '=' | '/' | '?' | '#' | '@' | '%' );    	

fragment
DIGIT : '0'..'9';

COMMENT : '#' .*? (EOL|EOF) -> channel(99);

fragment
EOL : '\n' | '\r';

REFERENCE : '^^';

LESS_EQUAL : '<=';

GREATER_EQUAL : '>=';

NOT_EQUAL : '!=';

AND : '&&';

OR : '||';
    
INVERSE : '^';

OPEN_BRACE : '(';

CLOSE_BRACE : ')';

OPEN_CURLY_BRACE : '{';

CLOSE_CURLY_BRACE : '}';

OPEN_SQUARE_BRACKET : '[';

CLOSE_SQUARE_BRACKET : ']';

SEMICOLON : ';';

DOT : '.';

PLUS_SIGN : '+';

MINUS_SIGN : '-';

fragment
SIGN : (PLUS_SIGN|MINUS_SIGN);
	
ASTERISK : '*';

QUESTION_MARK : '?';
    	
COMMA : ',';

NEGATION : '!';

DIVIDE : '/';

EQUAL : '=';

LESS : '<';

GREATER : '>';

PIPE : '|';
    	
ANY : .;

ID : OPPOSITE | ADJACENT | VERTICAL | CONTAINED | CONTAIN | DISTANCE | DIRECTION;

OPPOSITE
    :('O'|'o')('P'|'p')('P'|'p')('O'|'o')('S'|'s')('I'|'i')('T'|'t')('E'|'e')
    ;
ADJACENT
    :('A'|'a')('D'|'d')('J'|'j')('A'|'a')('C'|'c')('E'|'e')('N'|'n')('T'|'t')
    ;
VERTICAL
    :('V'|'v')('E'|'e')('R'|'r')('T'|'t')('I'|'i')('C'|'c')('A'|'a')('L'|'l')
    ;
CONTAINED
    :('C'|'c')('O'|'o')('N'|'n')('T'|'t')('A'|'')(''|'')(''|'')(''|'')(''|'')
    ;
CONTAIN
    :('C'|'c')('O'|'o')('N'|'n')('T'|'t')('A'|'a')('I'|'n')('N'|'n')
    ;
DISTANCE
    :('D'|'d')('I'|'i')('S'|'s')('T'|'t')('A'|'a')('N'|'n')('C'|'c')('E'|'e')
    ;
DIRECTION
    :('D'|'d')('I'|'i')('R'|'r')('E'|'e')('C'|'c')('T'|'t')('I'|'i')('O'|'o')('N'|'n')
    ;
// $>

