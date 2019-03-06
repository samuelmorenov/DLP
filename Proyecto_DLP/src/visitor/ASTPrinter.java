package visitor;

import ast.*;

/**
 * ASTPrinter. Utilidad que ayuda a validar un arbol AST:
 * 	-	Muestra la estructura del arbol en HTML.
 * 	-	Destaca los hijos/propiedades a null.
 * 	-	Muestra a qué texto apuntan las posiciones de cada nodo (linea/columna) ayudando así
 * 			a decidir cual de ellas usar en los errores y generacion de codigo.
 *
 * Esta clase se generara con VGen. El uso de esta clase es opcional (puede eliminarse del proyecto).
 *
 */
public class ASTPrinter extends DefaultVisitor {

    public static void toHtml(String sourceFile, AST raiz, String filename) {
        // Este método sera sera generado por VGen.
    }

}
