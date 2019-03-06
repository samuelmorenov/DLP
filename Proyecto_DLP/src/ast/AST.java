package ast;

import visitor.*;

/*
 *  Esta clase se completara en la fase de Analisis Sintactico
 */
public interface AST {
    Position getStart();

    Position getEnd();

    public Object accept(Visitor visitor, Object param);
}
