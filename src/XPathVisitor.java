// Generated from XPath.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link XPathParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface XPathVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code apImmediate}
	 * labeled alternative in {@link XPathParser#ap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApImmediate(XPathParser.ApImmediateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code apAll}
	 * labeled alternative in {@link XPathParser#ap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApAll(XPathParser.ApAllContext ctx);
	/**
	 * Visit a parse tree produced by the {@code document}
	 * labeled alternative in {@link XPathParser#doc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocument(XPathParser.DocumentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpText}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpText(XPathParser.RpTextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpCurr}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpCurr(XPathParser.RpCurrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpChildren}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpChildren(XPathParser.RpChildrenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpTag}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpTag(XPathParser.RpTagContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpParen}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpParen(XPathParser.RpParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpSlash}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpSlash(XPathParser.RpSlashContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpDoubleslash}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpDoubleslash(XPathParser.RpDoubleslashContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpBracket}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpBracket(XPathParser.RpBracketContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpParenthesis}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpParenthesis(XPathParser.RpParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpAttr}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpAttr(XPathParser.RpAttrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpComma}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpComma(XPathParser.RpCommaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code filterIs}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterIs(XPathParser.FilterIsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code filterRp}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterRp(XPathParser.FilterRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code filterConstStr}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterConstStr(XPathParser.FilterConstStrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code filterEq}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterEq(XPathParser.FilterEqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code filterOr}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterOr(XPathParser.FilterOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code filterAnd}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterAnd(XPathParser.FilterAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code filterParenthesis}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterParenthesis(XPathParser.FilterParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code filterNot}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterNot(XPathParser.FilterNotContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPathParser#fileName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFileName(XPathParser.FileNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPathParser#tagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagName(XPathParser.TagNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPathParser#attName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttName(XPathParser.AttNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPathParser#stringConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringConstant(XPathParser.StringConstantContext ctx);
}