package main;

import java.io.*;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;

import ast.*;
import visitor.*;

import parser.*;
import semantic.*;
import codegeneration.*;
import myVisitors.PrintMemoryAllocation;

/**
 * Clase que inicia el compilador e invoca a todas sus fases.
 *
 * Normalmente, no es necesario modificar este fichero. En su lugar, modificar
 * los ficheros de cada fase (que son llamados desde aqui):
 * - Para Analisis Lexico: 'Lexico.g4'.
 * - Para Analisis Sintactico: 'Grammar.g4'.
 * - Para Analisis Semantico: 'Identification.java' y 'TypeChecking.java'.
 * - Para Generacion de Codigo: 'MemoryAllocation.java' y 'CodeSelection.java'.
 *
 * @author Raul Izquierdo
 *
 */
public class Main {
    public static final String program = "source.txt"; // Prueba a compilar durante el desarrollo

    public static void main(String[] args) throws Exception {
        ErrorManager errorManager = new ErrorManager();

        AST ast = compile(program, errorManager); // Poner args[0] en vez de "programa" en la version final
        if (errorManager.errorsCount() == 0)
            System.out.println("El programa se ha compilado correctamente.");

        ASTPrinter.toHtml(program, ast, "AST"); // Utilidad generada por VGen (opcional)

        
        PrintMemoryAllocation pma = new PrintMemoryAllocation();
        //ast.accept(pma, null); // TODO: Comentar cuando no se quiera ver la asignacion de memoria
        
        
    }

    /**
     * Metodo que coordina todas las fases del compilador
     */
    public static AST compile(String sourceName, ErrorManager errorManager) throws Exception {

        // 1. Fases de Analisis Lexico y Sintactico
        GrammarLexer lexer = new GrammarLexer(CharStreams.fromFileName(sourceName));

        GrammarParser parser = new GrammarParser(new CommonTokenStream(lexer));
        parser.addErrorListener(new DiagnosticErrorListener()); // Notificar entradas ambiguas
        parser.getInterpreter().setPredictionMode(PredictionMode.LL_EXACT_AMBIG_DETECTION);

        AST ast = null;

        // IMPORTANTE: Cuando se genere el AST, INTERCAMBIAR las dos lineas siguientes:
        //parser.start();
        ast = parser.start().ast;

        if (ast == null) // Hay errores o el AST no se ha implementado aun
            return null;

        // 2. Fase de Analisis Semantico
        SemanticAnalisys analyzer = new SemanticAnalisys(errorManager);
        analyzer.analize(ast);
        if (errorManager.errorsCount() > 0)
            return ast;

        // 3. Fase de Generacion de Codigo
        File sourceFile = new File(sourceName);
        Writer out = new FileWriter(new File(sourceFile.getParent(), "output.txt"));

        CodeGeneration generator = new CodeGeneration();
        generator.generate(sourceFile.getName(), ast, out);
        out.close();

        return ast;
    }
}
