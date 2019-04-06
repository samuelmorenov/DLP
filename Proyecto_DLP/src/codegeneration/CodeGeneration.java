package codegeneration;

import java.io.*;

import ast.*;

/**
 * Esta clase coordina las dos fases principales de la Generacion de Codigo:
 *  1. Gestion de Memoria (asignacion de direcciones).
 *  2. Seleccion de Codigo.
 *
 * No es necesario modificar esta clase. En su lugar hay que modificar las clases
 * que son llamadas desde aqui: "MemoryAllocation.java" y "CodeSelection.java".
 *
 * @author Raul Izquierdo
 *
 */
public class CodeGeneration {

    public void generate(String sourceFile, AST ast, Writer out) {
        MemoryAllocation allocator = new MemoryAllocation();
        ast.accept(allocator, null);

        CodeSelection selector = new CodeSelection(out, sourceFile);
        ast.accept(selector, null);
    }

}
