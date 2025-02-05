grammar XPath;
//absolute path
ap : doc '/' rp                #apImmediate
    | doc '//' rp              #apAll
    ;
//document
doc : 'doc(“' fileName '”)'        #document
   ;

//relative path
rp : tagName                   #rpTag
   | '*'                       #rpChildren
   | '.'                       #rpCurr
   | '..'                      #rpParenthesis
   | 'text()'                  #rpText
   | '@' attName               #rpAttr
   | '(' rp ')'                #rpParen
   | rp '/' rp                 #rpSlash
   | rp '//' rp                #rpDoubleslash
   | rp '[' f ']'              #rpBracket
   | rp ',' rp                 #rpComma
   ;
//path filter
f : rp                         # filterRp
  | rp '=' rp                  # filterEq
  | rp 'eq' rp                 # filterEq
  | rp 'is' rp                 # filterIs
  | rp '==' rp                 # filterIs
  | rp '=' '“' stringConstant '”'      # filterConstStr
  | '(' f ')'                  # filterParenthesis
  | f 'and' f                  # filterAnd
  | f 'or' f                   # filterOr
  | 'not' f                    # filterNot
  ;

// other rules
fileName: StringConstant;
tagName:  PATTERN;
attName:  PATTERN;
stringConstant: StringConstant|PATTERN;
PATTERN: [a-zA-Z0-9_-]+;
StringConstant:  [a-zA-Z0-9_.!?;-]+;
WS : [ \t\r\n]+ -> skip;