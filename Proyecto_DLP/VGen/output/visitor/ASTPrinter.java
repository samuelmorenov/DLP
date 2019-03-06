/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package visitor;

import java.io.*;

import ast.*;
import java.util.*;

/**
 * ASTPrinter. Utilidad que ayuda a validar un arbol AST:
 * - Muestra la estructura del árbol en HTML.
 * - Destaca los hijos/propiedades a null.
 * - Muestra a qué texto apuntan las posiciones de cada nodo (linea/columna)
 *      ayudando a decidir cual de ellas usar en los errores y generación de código.
 *
 * Esta clase se genera con VGen. El uso de esta clase es opcional (puede eliminarse del proyecto).
 *
 */
public class ASTPrinter extends DefaultVisitor {

    /**
     * toHtml. Muestra la estructura del AST indicando qué hay en las posiciones
     * (línea y columna) de cada nodo.
     *
     * @param sourceFile El fichero del cual se ha obtenido el AST
     * @param raiz       El AST creado a partir de sourceFile
     * @param filename   Nombre del fichero HMTL a crear con la traza del AST
     */

    public static void toHtml(String sourceFile, AST raiz, String filename) {
        toHtml(sourceFile, raiz, filename, 4);
    }

    public static void toHtml(AST raiz, String filename) {
        toHtml(null, raiz, filename);
    }

    // tabWidth deberían ser los espacios correspondientes a un tabulador en eclipse.
    // Normalmente no sería necesario especificarlo. Usar mejor los dos métodos anteriores.

    public static void toHtml(String sourceFile, AST raiz, String filename, int tabWidth) {
        try {
            PrintWriter writer = new PrintWriter(
                    new FileWriter(filename.endsWith(".html") ? filename : filename + ".html"));
            generateHeader(writer);
            writer.println("[ASTPrinter] -------------------------------- line:col  line:col");
            if (raiz != null) {
                ASTPrinter tracer = new ASTPrinter(writer, loadLines(sourceFile, tabWidth));
                raiz.accept(tracer, new Integer(0));
            } else
                writer.println("raiz == null");
            writer.println(ls + ls + "[ASTPrinter] --------------------------------");
            generateFooter(writer);
            writer.close();
            System.out.println(ls + "ASTPrinter: Fichero '" + filename
                    + ".html' generado. Abra dicho fichero para validar el AST generado.");
        } catch (IOException e) {
            System.out.println(ls + "ASTPrinter: No se ha podido crear el fichero " + filename);
            e.printStackTrace();
        }
    }

    private static void generateHeader(PrintWriter writer) {
        writer.println("<html>\r\n"
            + "<head>\r\n"
            + "<meta charset=\"utf-8\" />\r\n"
            + "<style type=\"text/css\">\r\n"
            + ".value { font-weight: bold; }\r\n"
            + ".dots { color: #bebdbd; }\r\n"
            + ".type { color: #BBBBBB; }\r\n"
            + ".pos { color: #CCCCCC; }\r\n"
            + ".sourceText { color: #BBBBBB; }\r\n"
            + ".posText {\r\n" + "	color: #BBBBBB;\r\n"
            + "	text-decoration: underline; font-weight: bold;\r\n"
            + "}\r\n"
            + ".null {\r\n"
            + "	color: #FF0000;\r\n"
            + "	font-weight: bold;\r\n"
            + "	font-style: italic;\r\n" + "}\r\n"
            + "</style>\r\n" + "</head>\r\n" + "\r\n"
            + "<body><pre>");
    }

    private static void generateFooter(PrintWriter writer) {
        writer.println("</pre>\r\n" + "</body>\r\n" + "</html>");
    }

    private ASTPrinter(PrintWriter writer, List<String> sourceLines) {
        this.writer = writer;
        this.sourceLines = sourceLines;
    }

    // ----------------------------------------------
	//	class Program { List<Bloque> bloque; }
	public Object visit(Program node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Program", node, false);

		visit(indent + 1, "bloque", "List<Bloque>",node.getBloque());
		return null;
	}

	//	class Definicion_1 { String nombre;  List<Entero> entero;  Tipo tipo; }
	public Object visit(Definicion_1 node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Definicion_1", node, false);

		print(indent + 1, "nombre", "String", node.getNombre());
		visit(indent + 1, "entero", "List<Entero>",node.getEntero());
		visit(indent + 1, "tipo", "Tipo",node.getTipo());
		return null;
	}

	//	class Entero { int numero; }
	public Object visit(Entero node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Entero", node, false);

		print(indent + 1, "numero", "int", node.getNumero());
		return null;
	}

	//	class TipoInt {  }
	public Object visit(TipoInt node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "TipoInt", node, true);

		return null;
	}

	//	class TipoFloat {  }
	public Object visit(TipoFloat node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "TipoFloat", node, true);

		return null;
	}

	//	class TipoChar {  }
	public Object visit(TipoChar node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "TipoChar", node, true);

		return null;
	}

	//	class TipoVar { String string; }
	public Object visit(TipoVar node, Object param) {
		int indent = ((Integer)param).intValue();

		printCompact(indent, "TipoVar", node, "string", node.getString());
		return null;
	}

	//	class Struct { String nombre;  List<Definicion_2> definicion_2; }
	public Object visit(Struct node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Struct", node, false);

		print(indent + 1, "nombre", "String", node.getNombre());
		visit(indent + 1, "definicion_2", "List<Definicion_2>",node.getDefinicion_2());
		return null;
	}

	//	class Definicion_2 { String nombre;  List<Entero> entero;  Tipo tipo; }
	public Object visit(Definicion_2 node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Definicion_2", node, false);

		print(indent + 1, "nombre", "String", node.getNombre());
		visit(indent + 1, "entero", "List<Entero>",node.getEntero());
		visit(indent + 1, "tipo", "Tipo",node.getTipo());
		return null;
	}

	//	class Funcion { String nombre;  List<Parametro> parametros;  List<Tipo> retorno;  List<Sentencia> sentencia; }
	public Object visit(Funcion node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Funcion", node, false);

		print(indent + 1, "nombre", "String", node.getNombre());
		visit(indent + 1, "parametros", "List<Parametro>",node.getParametros());
		visit(indent + 1, "retorno", "List<Tipo>",node.getRetorno());
		visit(indent + 1, "sentencia", "List<Sentencia>",node.getSentencia());
		return null;
	}

	//	class Parametro { String nombre;  Tipo tipo; }
	public Object visit(Parametro node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Parametro", node, false);

		print(indent + 1, "nombre", "String", node.getNombre());
		visit(indent + 1, "tipo", "Tipo",node.getTipo());
		return null;
	}

	//	class Definicion_3 { String nombre;  List<Entero> entero;  Tipo tipo; }
	public Object visit(Definicion_3 node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Definicion_3", node, false);

		print(indent + 1, "nombre", "String", node.getNombre());
		visit(indent + 1, "entero", "List<Entero>",node.getEntero());
		visit(indent + 1, "tipo", "Tipo",node.getTipo());
		return null;
	}

	//	class Sentencia_asignacion { Expr izquierda;  Expr derecha; }
	public Object visit(Sentencia_asignacion node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Sentencia_asignacion", node, false);

		visit(indent + 1, "izquierda", "Expr",node.getIzquierda());
		visit(indent + 1, "derecha", "Expr",node.getDerecha());
		return null;
	}

	//	class Sentencia_print { Expr expresiones; }
	public Object visit(Sentencia_print node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Sentencia_print", node, false);

		visit(indent + 1, "expresiones", "Expr",node.getExpresiones());
		return null;
	}

	//	class Sentencia_printlnVacia {  }
	public Object visit(Sentencia_printlnVacia node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Sentencia_printlnVacia", node, true);

		return null;
	}

	//	class Sentencia_read { Expr expresiones; }
	public Object visit(Sentencia_read node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Sentencia_read", node, false);

		visit(indent + 1, "expresiones", "Expr",node.getExpresiones());
		return null;
	}

	//	class Sentencia_if { Expr condicion;  List<Sentencia> sentencias; }
	public Object visit(Sentencia_if node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Sentencia_if", node, false);

		visit(indent + 1, "condicion", "Expr",node.getCondicion());
		visit(indent + 1, "sentencias", "List<Sentencia>",node.getSentencias());
		return null;
	}

	//	class Sentencia_ifelse { Expr condicion;  List<Sentencia> sentencias;  List<Sentencia> sino; }
	public Object visit(Sentencia_ifelse node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Sentencia_ifelse", node, false);

		visit(indent + 1, "condicion", "Expr",node.getCondicion());
		visit(indent + 1, "sentencias", "List<Sentencia>",node.getSentencias());
		visit(indent + 1, "sino", "List<Sentencia>",node.getSino());
		return null;
	}

	//	class Sentencia_while { Expr condicion;  List<Sentencia> sentencias; }
	public Object visit(Sentencia_while node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Sentencia_while", node, false);

		visit(indent + 1, "condicion", "Expr",node.getCondicion());
		visit(indent + 1, "sentencias", "List<Sentencia>",node.getSentencias());
		return null;
	}

	//	class Sentencia_return { Expr expresion; }
	public Object visit(Sentencia_return node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Sentencia_return", node, false);

		visit(indent + 1, "expresion", "Expr",node.getExpresion());
		return null;
	}

	//	class Sentencia_returnVacia {  }
	public Object visit(Sentencia_returnVacia node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Sentencia_returnVacia", node, true);

		return null;
	}

	//	class Sentencia_expresion { Expr expresion; }
	public Object visit(Sentencia_expresion node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Sentencia_expresion", node, false);

		visit(indent + 1, "expresion", "Expr",node.getExpresion());
		return null;
	}

	//	class Expr_int { String string; }
	public Object visit(Expr_int node, Object param) {
		int indent = ((Integer)param).intValue();

		printCompact(indent, "Expr_int", node, "string", node.getString());
		return null;
	}

	//	class Expr_real { String string; }
	public Object visit(Expr_real node, Object param) {
		int indent = ((Integer)param).intValue();

		printCompact(indent, "Expr_real", node, "string", node.getString());
		return null;
	}

	//	class Expr_char { String string; }
	public Object visit(Expr_char node, Object param) {
		int indent = ((Integer)param).intValue();

		printCompact(indent, "Expr_char", node, "string", node.getString());
		return null;
	}

	//	class Expr_ident { String string; }
	public Object visit(Expr_ident node, Object param) {
		int indent = ((Integer)param).intValue();

		printCompact(indent, "Expr_ident", node, "string", node.getString());
		return null;
	}

	//	class Expr_binaria { Expr izquierda;  Operador operador;  Expr derecha; }
	public Object visit(Expr_binaria node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Expr_binaria", node, false);

		visit(indent + 1, "izquierda", "Expr",node.getIzquierda());
		visit(indent + 1, "operador", "Operador",node.getOperador());
		visit(indent + 1, "derecha", "Expr",node.getDerecha());
		return null;
	}

	//	class Expr_vector { Expr fuera;  Expr dentro; }
	public Object visit(Expr_vector node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Expr_vector", node, false);

		visit(indent + 1, "fuera", "Expr",node.getFuera());
		visit(indent + 1, "dentro", "Expr",node.getDentro());
		return null;
	}

	//	class Expr_punto { Expr izquierda;  Expr derecha; }
	public Object visit(Expr_punto node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Expr_punto", node, false);

		visit(indent + 1, "izquierda", "Expr",node.getIzquierda());
		visit(indent + 1, "derecha", "Expr",node.getDerecha());
		return null;
	}

	//	class Expr_parentesis { Expr expr; }
	public Object visit(Expr_parentesis node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Expr_parentesis", node, false);

		visit(indent + 1, "expr", "Expr",node.getExpr());
		return null;
	}

	//	class Expr_cast { Tipo tipo;  Expr expr; }
	public Object visit(Expr_cast node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Expr_cast", node, false);

		visit(indent + 1, "tipo", "Tipo",node.getTipo());
		visit(indent + 1, "expr", "Expr",node.getExpr());
		return null;
	}

	//	class Expr_llamada { String nombre;  List<Expr> parametros; }
	public Object visit(Expr_llamada node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Expr_llamada", node, false);

		print(indent + 1, "nombre", "String", node.getNombre());
		visit(indent + 1, "parametros", "List<Expr>",node.getParametros());
		return null;
	}

	//	class Operador { String operador; }
	public Object visit(Operador node, Object param) {
		int indent = ((Integer)param).intValue();

		printCompact(indent, "Operador", node, "operador", node.getOperador());
		return null;
	}


	// -----------------------------------------------------------------
	// Métodos invocados desde los métodos visit -----------------------

	private void printName(int indent, String name, AST node, boolean empty) {
		String text = ls + tabula(indent) + name + " &rarr;  ";
		text = String.format("%1$-" + 93 + "s", text);
		if (empty)
			text = text.replace(name, valueTag(name));
		writer.print(text + getPosition(node));
	}

	private void print(int indent, String name, String type, Object value) {
		write(indent, formatValue(value) + "  " + typeTag(type));
	}

	private void print(int indent, String attName, String type, List<? extends Object> children) {
		write(indent, attName + "  " + typeTag(type) + " = ");
		if (children != null)
			for (Object child : children)
				write(indent + 1, formatValue(child));
		else
			writer.print(" " + valueTag(null));
	}

	// Versión compacta de una linea para nodos que solo tienen un atributo String
	private void printCompact(int indent, String nodeName, AST node, String attName, Object value) {
		String fullName = nodeName + '.' + attName;
		String text = ls + tabula(indent) + '\"' + value + "\"  " + fullName;
		text = String.format("%1$-" + 88 + "s", text);
		// text = text.replace(value.toString(), valueTag(value));
		text = text.replace(fullName, typeTag(fullName));
		writer.print(text + getPosition(node));
	}

	private void visit(int indent, String attName, String type, List<? extends AST> children) {
		write(indent, attName + "  " + typeTag(type) + " = ");
		if (children != null)
			for (AST child : children)
				child.accept(this, indent + 1);
		else
			writer.print(" " + valueTag(null));
	}

	private void visit(int indent, String attName, String type, AST child) {
		if (child != null)
			child.accept(this, new Integer(indent));
		else
			write(indent, valueTag(null) + "  " + attName + ':' + typeTag(type));
	}

	// -----------------------------------------------------------------
	// Métodos auxiliares privados -------------------------------------

	private void write(int indent, String text) {
		writer.print(ls + tabula(indent) + text);
	}

	private static String tabula(int count) {
		StringBuffer cadena = new StringBuffer("<span class=\"dots\">");
		for (int i = 0; i < count; i++)
			cadena.append(i % 2 == 0 && i > 0 ? "|  " : ".  ");
		return cadena.toString() + "</span>";
	}

	private String typeTag(String type) {
		if (type.equals("String"))
			return "";
		return "<span class=\"type\">" + type.replace("<", "&lt;").replace(">", "&gt;") + "</span>";
	}

	private String valueTag(Object value) {
		if (value == null)
			return "<span class=\"null\">null</span>";
		return "<span class=\"value\">" + value + "</span>";
	}

	private String formatValue(Object value) {
		String text = valueTag(value);
		if (value instanceof String)
			text = "\"" + text + '"';
		return text;
	}


	// -----------------------------------------------------------------
	// Métodos para mostrar las Posiciones -----------------------------

	private String getPosition(AST node) {
		String text = node.getStart() + "  " + node.getEnd();
		text = "<span class=\"pos\">" + String.format("%1$-" + 13 + "s", text) + "</span>";
		text = text.replace("null", "<span class=\"null\">null</span>");
		String sourceText = findSourceText(node);
		if (sourceText != null)
			text += sourceText;
		return text;
	}

	private String findSourceText(AST node) {
		if (sourceLines == null)
			return null;

		Position start = node.getStart();
		Position end = node.getEnd();
		if (start == null || end == null)
			return null;

		String afterText, text, beforeText;
		if (start.getLine() == end.getLine()) {
			String line = sourceLines.get(start.getLine() - 1);
			afterText = line.substring(0, start.getColumn() - 1);
			text = line.substring(start.getColumn() - 1, end.getColumn());
			beforeText = line.substring(end.getColumn());
		} else {
			String firstLine = sourceLines.get(start.getLine() - 1);
			String lastLine = sourceLines.get(end.getLine() - 1);

			afterText = firstLine.substring(0, start.getColumn() - 1);

			text = firstLine.substring(start.getColumn() - 1);
			text += "</span><span class=\"sourceText\">" + " ... " + "</span><span class=\"posText\">";
			text += lastLine.substring(0, end.getColumn()).replaceAll("^\\s+", "");

			beforeText = lastLine.substring(end.getColumn());
		}
		return "<span class=\"sourceText\">" + afterText.replaceAll("^\\s+", "")
				+ "</span><span class=\"posText\">" + text
				+ "</span><span class=\"sourceText\">" + beforeText + "</span>";
	}

	private static List<String> loadLines(String sourceFile, int tabWidth) {
		if (sourceFile == null)
			return null;
		try {
			String spaces = new String(new char[tabWidth]).replace("\0", " ");

			List<String> lines = new ArrayList<String>();
			BufferedReader br = new BufferedReader(new FileReader(sourceFile));
			String line;
			while ((line = br.readLine()) != null) {
			//	lines.add(line.replace("\t", spaces)); // Si tab = 4 espaces (Eclipse)
				lines.add(line);
            }
			br.close();
			return lines;
		} catch (FileNotFoundException e) {
			System.out.println("Warning. No se pudo encontrar el fichero fuente '" + sourceFile + "'. No se mostrará informaicón de posición.");
			return null;
		} catch (IOException e) {
			System.out.println("Warning. Error al leer del fichero fuente '" + sourceFile + "'. No se mostrará informaicón de posición.");
			return null;
		}
	}


	private List<String> sourceLines;
	private static String ls = System.getProperty("line.separator");
	private PrintWriter writer;
}
