package semantic;

import main.*;
import ast.*;

/**
 * Esta clase coordina las dos fases del Analisis Semantico:
 *  1. Fase de Identificacion.
 *  2. Fase de Comprobacion de Tipos (Type Checking).
 *
 * No es necesario modificar esta clase. En su lugar hay que modificar las clases
 * que son llamadas desde aquí: "Identification.java" y "TypeChecking.java"
 *
 * @author Raúl Izquierdo
 *
 */
public class SemanticAnalisys {

    public SemanticAnalisys(ErrorManager errorManager) {
        this.errorManager = errorManager;
    }

    public void analize(AST ast) {
        Identification identification = new Identification(errorManager);
        ast.accept(identification, null);

        if (errorManager.errorsCount() > 0)
            return;

        TypeChecking checking = new TypeChecking(errorManager);
        ast.accept(checking, null);
    }

    private ErrorManager errorManager;
}
