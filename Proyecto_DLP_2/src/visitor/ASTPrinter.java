/**
 * @generated VGen (for ANTLR) 1.7.0
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
                raiz.accept(tracer, Integer.valueOf(0));
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
	//	class Program { List<Definicion> definicion; }
	public Object visit(Program node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Program", node, false);

		visit(indent + 1, "definicion", "List<Definicion>",node.getDefinicion());
		return null;
	}

	//	class Definicion_variable_global { Variable variable; }
	public Object visit(Definicion_variable_global node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Definicion_variable_global", node, false);

		visit(indent + 1, "variable", "Variable",node.getVariable());
		return null;
	}

	//	class Definicion_struct { String nombre;  List<Campo_struct> campo_struct; }
	public Object visit(Definicion_struct node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Definicion_struct", node, false);

		print(indent + 1, "nombre", "String", node.getNombre());
		visit(indent + 1, "campo_struct", "List<Campo_struct>",node.getCampo_struct());
		return null;
	}

	//	class Definicion_funcion { String nombre;  List<Variable> parametros;  Tipo retorno;  List<Variable> locales;  List<Sentencia> sentencias; }
	public Object visit(Definicion_funcion node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Definicion_funcion", node, false);

		print(indent + 1, "nombre", "String", node.getNombre());
		visit(indent + 1, "parametros", "List<Variable>",node.getParametros());
		visit(indent + 1, "retorno", "Tipo",node.getRetorno());
		visit(indent + 1, "locales", "List<Variable>",node.getLocales());
		visit(indent + 1, "sentencias", "List<Sentencia>",node.getSentencias());
		return null;
	}

	//	class Variable { String nombre;  Tipo tipo; }
	public Object visit(Variable node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Variable", node, false);

		print(indent + 1, "nombre", "String", node.getNombre());
		visit(indent + 1, "tipo", "Tipo",node.getTipo());
		return null;
	}

	//	class Campo_struct { String nombre;  Tipo tipo; }
	public Object visit(Campo_struct node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Campo_struct", node, false);

		print(indent + 1, "nombre", "String", node.getNombre());
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

	//	class Sentencia_print { Expr expresiones;  String fincadena; }
	public Object visit(Sentencia_print node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Sentencia_print", node, false);

		visit(indent + 1, "expresiones", "Expr",node.getExpresiones());
		print(indent + 1, "fincadena", "String", node.getFincadena());
		return null;
	}

	//	class Sentencia_read { Expr expresiones; }
	public Object visit(Sentencia_read node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Sentencia_read", node, false);

		visit(indent + 1, "expresiones", "Expr",node.getExpresiones());
		return null;
	}

	//	class Sentencia_if { Expr condicion;  List<Sentencia> sentencias;  List<Sentencia> sino; }
	public Object visit(Sentencia_if node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Sentencia_if", node, false);

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

	//	class Sentencia_llamada_funcion { String nombre;  List<Expr> parametros; }
	public Object visit(Sentencia_llamada_funcion node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Sentencia_llamada_funcion", node, false);

		print(indent + 1, "nombre", "String", node.getNombre());
		visit(indent + 1, "parametros", "List<Expr>",node.getParametros());
		return null;
	}

	//	class Sentencia_return { Expr expresion; }
	public Object visit(Sentencia_return node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Sentencia_return", node, false);

		visit(indent + 1, "expresion", "Expr",node.getExpresion());
		return null;
	}

	//	class Tipo_Int {  }
	public Object visit(Tipo_Int node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Tipo_Int", node, true);

		return null;
	}

	//	class Tipo_Float {  }
	public Object visit(Tipo_Float node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Tipo_Float", node, true);

		return null;
	}

	//	class Tipo_Char {  }
	public Object visit(Tipo_Char node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Tipo_Char", node, true);

		return null;
	}

	//	class Tipo_Void {  }
	public Object visit(Tipo_Void node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Tipo_Void", node, true);

		return null;
	}

	//	class Tipo_Struct { String nombre; }
	public Object visit(Tipo_Struct node, Object param) {
		int indent = ((Integer)param).intValue();

		printCompact(indent, "Tipo_Struct", node, "nombre", node.getNombre());
		return null;
	}

	//	class Tipo_Array { String tamanio;  Tipo tipoElementos; }
	public Object visit(Tipo_Array node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Tipo_Array", node, false);

		print(indent + 1, "tamanio", "String", node.getTamanio());
		visit(indent + 1, "tipoElementos", "Tipo",node.getTipoElementos());
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

	//	class Expr_negada { Operador operador;  Expr derecha; }
	public Object visit(Expr_negada node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Expr_negada", node, false);

		visit(indent + 1, "operador", "Operador",node.getOperador());
		visit(indent + 1, "derecha", "Expr",node.getDerecha());
		return null;
	}

	//	class Expr_cast { Tipo tipo_convertido;  Expr expr; }
	public Object visit(Expr_cast node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Expr_cast", node, false);

		visit(indent + 1, "tipo_convertido", "Tipo",node.getTipo_convertido());
		visit(indent + 1, "expr", "Expr",node.getExpr());
		return null;
	}

	//	class Expr_acceso_vector { Expr fuera;  Expr dentro; }
	public Object visit(Expr_acceso_vector node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Expr_acceso_vector", node, false);

		visit(indent + 1, "fuera", "Expr",node.getFuera());
		visit(indent + 1, "dentro", "Expr",node.getDentro());
		return null;
	}

	//	class Expr_acceso_struct { Expr izquierda;  Expr derecha; }
	public Object visit(Expr_acceso_struct node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Expr_acceso_struct", node, false);

		visit(indent + 1, "izquierda", "Expr",node.getIzquierda());
		visit(indent + 1, "derecha", "Expr",node.getDerecha());
		return null;
	}

	//	class Expr_llamada_funcion { String nombre;  List<Expr> parametros; }
	public Object visit(Expr_llamada_funcion node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Expr_llamada_funcion", node, false);

		print(indent + 1, "nombre", "String", node.getNombre());
		visit(indent + 1, "parametros", "List<Expr>",node.getParametros());
		return null;
	}

	//	class Operador_aritmetico { String string; }
	public Object visit(Operador_aritmetico node, Object param) {
		int indent = ((Integer)param).intValue();

		printCompact(indent, "Operador_aritmetico", node, "string", node.getString());
		return null;
	}

	//	class Operador_logico { String string; }
	public Object visit(Operador_logico node, Object param) {
		int indent = ((Integer)param).intValue();

		printCompact(indent, "Operador_logico", node, "string", node.getString());
		return null;
	}

	//	class Operador_comparacion { String string; }
	public Object visit(Operador_comparacion node, Object param) {
		int indent = ((Integer)param).intValue();

		printCompact(indent, "Operador_comparacion", node, "string", node.getString());
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
			child.accept(this, Integer.valueOf(indent));
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
